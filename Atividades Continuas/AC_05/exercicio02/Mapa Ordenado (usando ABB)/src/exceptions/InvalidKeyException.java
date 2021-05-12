
package exceptions;

@SuppressWarnings("serial")
public class InvalidKeyException extends RuntimeException {
	public InvalidKeyException(String error) {
		super(error);
	}
}
  