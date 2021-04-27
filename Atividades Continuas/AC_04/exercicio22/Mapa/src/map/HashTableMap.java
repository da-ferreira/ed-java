
package map;

import java.util.Random;
import commons.Entry;
import exceptions.InvalidKeyException;
import list_of_nodes.NodePositionList;

/**
 * Tabela hash que usa teste linear para lidar com colisões.
 * A função hash usa o código hash padrão de cada objeto (hashCode) e a função de compressão método MAD (multiplicação-adição-divisão).
 * 
 * O método MAD mapeia um inteiro i para:
 * 
 * [(ai + b) mod P] mod N
 * 
 * N -> tamanho do arranjo de buckets.
 * p -> número primo maior que N.
 * a -> fator de escala.
 * b -> fator de deslocamento (shift)
 * 
 * Onde a e b são inteiros escolhidos aleatoriamente num intervalo [0, P - 1], com a > 0.
 * 
 * @author David Ferreira de Almeida
 * @author Eduardo de Oliveira Campos Junior
 * @author Iasmin Pinheiro Ribeiro
 * @author Lucas Cauan Pinheiro Costa
 */

public class HashTableMap<Key, Value> implements Map<Key, Value> {
	protected HashEntry<Key, Value> AVAILABLE = new HashEntry<Key, Value>(null, null);  // Sentinela para itens desativados (espaços vazios depois de remover uma entrada). 
	protected HashEntry<Key, Value> bucket[];  // Arranjo de buckets
	protected int capacity;  // Número da capacidade do arranjo de buckets
	protected int entrys;    // Número de entradas no mapa (par chave-valor)
	protected int prime;     // Fator primo > capacity
	protected long scale;    // Fator de escala.
	protected long shift;    // Fator de deslocamento (shift)
	
	/** Cria uma tabela hash com fator primo 109345121 e capacidade 1000 */
	public HashTableMap() {
		this(109345121, 1000);
	}
	
	/** Cria uma tabela hash com fator primo 109345121 e capacidade informada. */
	public HashTableMap(int capacity) {
		this(109345121, capacity);
	}
	
	@SuppressWarnings("unchecked")
	/** Cria uma tabela hash com fator primo e capacidade fornecida. */
	public HashTableMap(int prime, int capacity) {
		bucket = (HashEntry<Key, Value>[]) new HashEntry[capacity];  // cast
		this.prime = prime;
		this.capacity = capacity;
		entrys = 0;
		
		Random gerador = new Random();
		
		scale = gerador.nextInt(this.prime - 1) + 1;  // acrescenta +1, caso o número gerado for 0 (fator de escala não pode ser 0). 
		shift = gerador.nextInt(this.prime - 1);
	}
	
	/**
	 * Classe aninhada (interna, tem relacionamento especial com a externa, HashTableMap, 
	 * podendo acessar seus membros privados) para uma entrada na tabela hash (par chave-valor).
	 */
	public static class HashEntry<Key, Value> implements Entry<Key, Value> {
		protected Key key;
		protected Value value;
		
		public HashEntry(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
		
		public Key getKey() {
			return key;
		}
		
		public Value getValue() {
			return value;
		}
		
		public Value setValue(Value newValue) {
			Value oldValue = value;
			value = newValue;
			return oldValue;
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object o) {
			HashEntry<Key, Value> entry;
			
			try {
				entry = (HashEntry<Key, Value>) o;
			}
			catch (ClassCastException error) {
				return false;
			}
			
			return entry.getKey() == key && entry.getValue() == value; 
		}
		
		@Override
		public String toString() {
			return "(" + key + ", " + value + ")";  // "(key, value)"
		}
	}
	
	/** Aplica a função de compressão MAD para o código hash padrão de cada objeto (hashCode). 
	    método MAD converte um inteiro i para: [(ai + b) mod P] mod N */
	public int hashValue(Key key) {
		return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
	}
	
	public int size() {
		return entrys;
	}
	
	public boolean isEmpty() {
		return entrys == 0;
	}
	
	public Value get(Key key) throws InvalidKeyException {
		int index = findEntry(key);
		
		if (index < 0)
			return null;  // não existe essa chave no mapa
		
		return bucket[index].getValue();
	}
	
	public Value put(Key key, Value value) throws InvalidKeyException {
		int index = findEntry(key);
		
		if (index > 0)  // A entrada com essa chave já existe
			return bucket[index].setValue(value);
		
		if (entrys >= (capacity / 2)) {  
			rehash();  // o fator de carga do mapa deve estar abaixo de 0.5; dobra o tamanho do vetor do mapa
			index = findEntry(key);  // busca o indice apropriado para a entrada (o mapa teve seu tamanho dobrado)
		}
		
		bucket[-1 -index] = new HashEntry<Key, Value>(key, value);  // findEntry retorna -(i + 1)
		entrys++;
		return null;  // a entrada com a chave informada não existia
	}
	
	public Value remove(Key key) throws InvalidKeyException {
		int index = findEntry(key);
		
		if (index < 0)
			return null;  // a entrada com a chave informada não está no mapa
		
		Value toReturn = bucket[index].getValue();
		bucket[index] = AVAILABLE;
		entrys--;
		return toReturn;
	}
	
	/* MÉTODOS AUXILIARES */
	
	/** Método de busca auxiliar, retorna o indice i da chave encontrada no mapa ou -(a + 1),
	 *  onde a é o índice da primeira posição vazia ou disponivel (AVAILABLE) encontrada.
	 *  o negativo é pra indicar não foi encontrada uma chave igual a key. A soma de +1 é pra 
	 *  diferenciar de zero negativo, que é zero (return -0 == return 0). */
	protected int findEntry(Key key) throws InvalidKeyException {
		checkKey(key);
		
		int avail = -1;
		int index = hashValue(key);
		int j = index;
		
		do {
			HashEntry<Key, Value> point = bucket[index];
			
			if (point == null) {  // Não tem essa chave no mapa
				if (avail < 0)
					avail = index;
				break;
			}
			
			if (key.equals(point.getKey()))  // Chave encontrada
				return index;
			
			if (point == AVAILABLE)  // Indice no bucket está desativado
				if (avail < 0)
					avail = index;  // Guarda o primeiro indice disponivel (com AVAILABLE) e continua a busca abaixo.
			
			index = (index + 1) % capacity;  // Continua a busca caso tenha a chave nos próximos indices (teste linear).
			
		} while (index != j);  // Deu a volta no mapa é não achou
		
		return -(avail + 1);  // retornando o primeiro indice vazio ou disponivel.
	}
	
	@SuppressWarnings("unchecked")
	/** Quando o vetor do mapa (bucket) atinge sua capacidade, entrys < (capacity / 2), ou seja,
	 *  o fator de carga do mapa é o número de entradas do mapa ser menor que a capacidade total do vetor
	 *  dividido por dois. Gera um novo fator de escala e fator deslocamento (shift). */
	protected void rehash() {
		capacity *= 2;
		HashEntry<Key, Value> oldBucket[] = bucket;
		bucket = (HashEntry<Key, Value>[]) new HashEntry[capacity];  // Novo bucket duas vezes maior
		
		Random gerador = new Random();
		scale = gerador.nextInt(this.prime - 1) + 1;  // novo fator de escala do hash 
		shift = gerador.nextInt(this.prime - 1);      // novo fator de descalomento do hash (shift)
		
		for (int i=0; i < oldBucket.length; i++) {
			HashEntry<Key, Value> point = oldBucket[i];
			
			if (point != null && point != AVAILABLE) {  // uma entrada válida
				
				/* Toda busca que for feita resultará em chave não encontrada,
				 * porque o vetor bucket dobrou de tamanho e perdeu todos seus itens.
				 * O método findEntry sempre retornará -(i + 1), que é a primeira posição disponível no vetor bucket. 
				 */
				int j = -1 - findEntry(point.getKey());
				bucket[j] = point;
			}
		}
	}
	
	/** Verifica se uma chave é válida (é válida se não for null). */
	protected void checkKey(Key key) {
		if (key == null)
			throw new InvalidKeyException("Invalid key: key == null");
	}
	
	/* MÉTODOS ITERÁVEIS */
	
	public Iterable<Key> keySet() {
		NodePositionList<Key> keys = new NodePositionList<Key>();
		
		for (int i=0; i < capacity; i++)
			if (bucket[i] != null && bucket[i] != AVAILABLE)
				keys.addLast(bucket[i].getKey());
		
		return keys;
	}
	
	public Iterable<Value> values() {
		NodePositionList<Value> values = new NodePositionList<Value>();
		
		for (int i=0; i < capacity; i++)
			if (bucket[i] != null && bucket[i] != AVAILABLE)
				values.addLast(bucket[i].getValue());
		
		return values;
	}
	
	public Iterable<Entry<Key, Value>> entrySet() {
		NodePositionList<Entry<Key, Value>> entries = new NodePositionList<Entry<Key, Value>>();
		
		for (int i=0; i < capacity; i++)
			if (bucket[i] != null && bucket[i] != AVAILABLE)
				entries.addLast(bucket[i]);
		
		return entries;
	}
}
    
