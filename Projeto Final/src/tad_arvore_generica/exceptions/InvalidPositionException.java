
package tad_arvore_generica.exceptions;

@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException { 
	public InvalidPositionException(String error) {
		super(error);  // Exceçao para quando a posicao do elemento nao estiver na lista.
	}
}
