
package exceptions;

@SuppressWarnings("serial")

/** Exceção para quando o deque estiver vazio e aconteça alguma tentativa de remoção. */
public class EmptyDequeException extends RuntimeException {
	public EmptyDequeException(String error) {
		super(error);
	}
}
