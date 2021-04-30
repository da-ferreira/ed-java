
package dictionary;

import java.util.Map;

/**
 * Interface para o TAD Dicionário onde as entradas são instâncias de 
 * AbstractMap.SimpleEntry<K,V> (classe que implementa a interface java.util.Map.Entry<K, V>).
 * 
 * @author david-ferreira
 */

public interface MultiMap<K, V> {
	/** @return A quantidade de entradas no dicionário. */
	public int size();
	
	/** @return true se o dicionário está vazio. */
	public boolean isEmpty();
	
	/** @return Uma entrada contendo uma dada chave (key) ou null caso a entrada não existir. */ 
	public Map.Entry<K, V> get(K key) throws IllegalArgumentException;
	
	/** @return Todas as entradas que tenha chave igual igual a key (parametro) em um iterador (java.util.LinkedList).
	 * 			Se entradas com tal chave não existir, retorna um iterador vazio. */
	public Iterable<Map.Entry<K, V>> getAll(K key) throws IllegalArgumentException;
	
	/** 
	 * Insere um item (par chave-valor) no dicionário.
	 * @return A entrada criada e inserida. 
	 */
	public Map.Entry<K, V> put(K key, V value) throws IllegalArgumentException;
	
	/**
	 * Remove um dada entrada no dicionário. 
	 * @return A entrada removida.
	 * @throws IllegalArgumentException Caso a entrada passada (entry) não esteja no dicionário.
	 */
	public Map.Entry<K, V> remove(Map.Entry<K, V> entry) throws IllegalArgumentException;
	
	/** @return Um iterador (java.util.LinkedList) com todas as entradas do dicionário. */
	public Iterable<Map.Entry<K, V>> entrySet();
}
