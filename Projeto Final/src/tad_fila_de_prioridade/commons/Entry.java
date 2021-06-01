
package tad_fila_de_prioridade.commons;

/** Interface para a entrada do par (chave, valor) da fila de prioridade. */

public interface Entry<Key, Value> {
	/** @return A chave armazenada nesta entrada. */
	public Key getKey();
	
	/** @return O valor armazenado nesta entrada. */
	public Value getValue();
}
