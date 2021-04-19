
package map;

/** Interface para um mapa, com entradas de chave-valor, onde aceita uma chave única para um valor. */

public interface Map<Key, Value> {
	/** @return O número de itens (entradas chave-valor) no mapa. */
	public int size();
	
	/** @return true se o mapa está vazio, caso contrário, false. */
	public boolean isEmpty();
	
	
}
