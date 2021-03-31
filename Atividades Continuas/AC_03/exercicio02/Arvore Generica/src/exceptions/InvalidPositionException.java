
package exceptions;

@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException { 
	public InvalidPositionException(String error) {
		super(error);  // Exceçao para quando a posicao do elemento nao estiver na lista.
	}
}
