
package exceptions;

@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException {
	public InvalidPositionException(String error) {
		super(error);
	}
}
  