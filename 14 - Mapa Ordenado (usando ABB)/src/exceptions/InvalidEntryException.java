
package exceptions;

@SuppressWarnings("serial")
public class InvalidEntryException extends RuntimeException {
	public InvalidEntryException(String error) {
		super(error);
	}
}
 