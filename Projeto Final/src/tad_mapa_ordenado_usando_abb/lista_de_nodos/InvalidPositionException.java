
package tad_mapa_ordenado_usando_abb.lista_de_nodos;

@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException { 
	public InvalidPositionException(String error) {
		super(error);  // Exceçao para quando a posicao do elemento nao estiver na lista.
	}
}
