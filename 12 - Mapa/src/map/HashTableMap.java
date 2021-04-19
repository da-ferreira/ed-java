
package map;

import commons.Entry;

/**
 * Tabela hash que usa teste linear para lidar com colisões e o método MAD (multiplicação-adição-divisão)
 * para lidar com a função de compressão da função hash.
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
 * @author david-ferreira
 */

public class HashTableMap<Key, Value> implements Map<Key, Value> {
	protected HashEntry<Key, Value> AVAILABLE = new HashEntry<Key, Value>(null, null);  // Sentinela para itens desativados (espaços vazios depois de remover uma entrada). 
	protected int entry;
	
	
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
}
