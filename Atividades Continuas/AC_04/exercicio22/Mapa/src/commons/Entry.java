
package commons;

/** Interface para a entrada do par (chave, valor) do mapa que aceita uma chave única para um valor. */

public interface Entry<Key, Value> {
	/** @return A chave armazenada nesta entrada. */
	public Key getKey();
	
	/** @return O valor armazenado nesta entrada. */
	public Value getValue();
}
