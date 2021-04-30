
package dictionary;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Classe que implementa a interface MultiMap<K, V> que representa o TAD Dicionário.
 * @author david-ferreira
 */

public class HashTableMultiMap<K, V> implements MultiMap<K, V> {
	private Map<K, LinkedList<Map.Entry<K, V>>> map;  // Mapa de chaves, onde cada posição conterá uma chave e uma lista com as entradas de mesma chave.
	private int size;  // Número de entradas no dicionário.
	
	public HashTableMultiMap() {
		map = new HashMap<K, LinkedList<Map.Entry<K, V>>>();
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Map.Entry<K, V> get(K key) throws IllegalArgumentException {
		checkKey(key);
		LinkedList<Map.Entry<K, V>> list = map.get(key);
		
		if (list == null)
			return null;  // Não há entrada com esta chave.
		
		return list.peekFirst();
	}
	
	public Iterable<Map.Entry<K, V>> getAll(K key) throws IllegalArgumentException {
		checkKey(key);
		LinkedList<Map.Entry<K, V>> list = map.get(key);
		
		if (list == null)
			return null;  // Não há entrada com esta chave.
		
		return list;
	}
	
	public Map.Entry<K, V> put(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		LinkedList<Map.Entry<K, V>> list = map.get(key);
		
		if (list == null) {  // nenhuma entrada foi inserida com uma chave igual a key
			list = new LinkedList<Map.Entry<K, V>>();
			map.put(key, list);
		}
		
		Map.Entry<K, V> newEntry = new AbstractMap.SimpleEntry<K, V>(key, value);
		list.add(newEntry);
		size++;
		
		return newEntry;
	}
	
	/*
	public Map.Entry<K, V> remove(Map.Entry<K, V> entry) throws IllegalArgumentException {
		if (entry == null)
			throw new IllegalArgumentException();
		
		K key = entry.getKey();
		LinkedList<Map.Entry<K, V>> list = map.get(key);
		
		if (list == null)   
			throw new IllegalArgumentException();  // Não há essa entrada no dicionário
		
		if (list.remove())
		
	}
	*/
	
	public Iterable<Map.Entry<K, V>> entrySet() {
		LinkedList<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>();
		
		for (LinkedList<Map.Entry<K, V>> list_entries : map.values())
			list.addAll(list_entries);  // adiciona todos os valores das entradas contidas na LinkedList i do dicionário
		
		return list;
	}
	
	protected void checkKey(K key) throws IllegalArgumentException {
		if (key == null)
			throw new IllegalArgumentException();
	}
}
