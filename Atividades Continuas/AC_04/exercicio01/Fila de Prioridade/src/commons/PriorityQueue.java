
package commons;

import exceptions.EmptyPriorityQueueException;
import exceptions.InvalidKeyException;

/** Interface para a fila de prioridade (TAD) */

public interface PriorityQueue<Key, Value> {
	/** @return A quantidade de elementos na fila de prioridade. */
	public int size();
	
	/** @return Se a fila de prioridade está vazia. */
	public boolean isEmpty();
	
	/**
	 * @return A menor chave na fila de prioridade sem remove-la.
	 * @throws EmptyPriorityQueueException: Caso a fila de prioridade esteja vazia.
	 */
	public Entry<Key, Value> min() throws EmptyPriorityQueueException;
	
	/**
	 * Insere um par (chave, valor) e retorna a entrada criada.
	 * @param key Chave
	 * @param value Valor
	 * @return A entrada criada.
	 * @throws InvalidKeyException: Caso a chave seja invalida (ela não pode ser comparada).
	 */
	public Entry<Key, Value> insert(Key key, Value value) throws InvalidKeyException;
	
	/**
	 * Remove a entrada com menor chave.
	 * @return A entrada removida.
	 * @throws EmptyPriorityQueueException: Caso a fila de prioridade esteja vazia.
	 */
	public Entry<Key, Value> removeMin() throws EmptyPriorityQueueException;
}
