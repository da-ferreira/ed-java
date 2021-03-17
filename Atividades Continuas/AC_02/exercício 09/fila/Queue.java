
package fila;

public interface Queue<Type> {
	/** @return a quantidade de elemento na fila. */
	public int size();
	
	/** @return true se a fila estiver vazia, senao retorna false. */
	public boolean isEmpty();
	
	/**
	 * @return o elemento que está no inicio da fila.
	 * @throws EmptyQueueException se a fila estiver vazia.
	 */
	public Type front() throws EmptyQueueException;
	
	/** @param element elemento que será adicionado no final da fila. */
	public void enqueue(Type element);
	
	/**
	 * Remove o elemento no inicio da fila.
	 * @return o elemento removido.
	 * @throws EmptyQueueException  se a fila estiver vazia.
	 */
	public Type dequeue() throws EmptyQueueException;
}
