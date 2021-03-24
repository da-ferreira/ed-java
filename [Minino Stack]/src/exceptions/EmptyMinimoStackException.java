
package exceptions;

@SuppressWarnings("serial")

/** Exceção para quando a pilha estiver vazia. */
public class EmptyMinimoStackException extends RuntimeException {
	public EmptyMinimoStackException(String error) {
		super(error);
	}
}
