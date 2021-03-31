
package fila;

@SuppressWarnings("serial")

// Exceção para quando a fila estiver cheia.
public class FullQueueException extends RuntimeException {
	public FullQueueException(String error) {
		super(error);
	}
}
