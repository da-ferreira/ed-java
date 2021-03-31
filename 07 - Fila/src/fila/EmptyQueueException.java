
package fila;

@SuppressWarnings("serial")

//Erro para quando a fila estiver vazia.
public class EmptyQueueException extends RuntimeException {  // herdando da classe RuntimeException
	public EmptyQueueException(String error) {
		super(error);
	}
}
