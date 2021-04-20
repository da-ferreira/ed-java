
package map;

import commons.Entry;
import exceptions.InvalidKeyException;

/** Interface para um mapa, com entradas de chave-valor, onde aceita uma chave única para um valor. */

public interface Map<Key, Value> {
	/** @return O número de itens (entradas chave-valor) no mapa. */
	public int size();
	
	/** @return true se o mapa está vazio, caso contrário, false. */
	public boolean isEmpty();
	
	/**
	 * Coloca um novo par chave-valor no mapa.
	 * @return 
	 *    Se não houver nenhuma chave no mapa igual a "key" insere e retorna null, caso contrário,
	 *    modifica o valor do par já adicionado e retorna o valor anterior.
	 * @throws InvalidKeyException Caso a chave for invalida.
	 */
	public Value put(Key key, Value value) throws InvalidKeyException;
	
	/**
	 * Retorna o valor associado com uma chave.
	 * @param key Chave a ser buscada.
	 * @return O valor associado, se o par chave-valor está no mapa, null se não tiver.
	 * @throws InvalidKeyException Caso a chave for invalida.
	 */
	public Value get(Key key) throws InvalidKeyException;
	
	/**
	 * Remove o par chave-valor de uma dada chave.
	 * @param key Chave do par chave-valor a ser removido.
	 * @return O valor do par, se ele existir, null se o par não estiver no mapa.
	 * @throws InvalidKeyException Caso a chave for invalida.
	 */
	public Value remove(Key key) throws InvalidKeyException;
	
	/** @return Um objeto iterable com todas as chaves do mapa. */
	public Iterable<Key> keySet();
	
	/** @return Um objeto iterable com todos os valores do mapa. */
	public Iterable<Value> values();
	
	/** @return Um objeto iterable com todas as entradas (par chave-valor) do mapa. */
	public Iterable<Entry<Key, Value>> entrySet();
}
