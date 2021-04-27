
package exceptions;

/** Exceção para quando a chave for inválida (ela não pode ser comparada). */

@SuppressWarnings("serial")
public class InvalidKeyException extends RuntimeException {
	public InvalidKeyException(String error) {
		super(error);
	}
}
