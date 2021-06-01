
package tad_fila_de_prioridade.exceptions;

/** Exceçao para quando a posicao do elemento nao estiver na lista. */

@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException { 
	public InvalidPositionException(String error) {
		super(error);  
	}
}
