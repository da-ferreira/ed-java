
package tad_mapa_ordenado_abb.lista_de_nodos;

// Excecao lançada se tentar acessar um elemento cujo indice está fora do intervalo de posicoes da lista.

@SuppressWarnings("serial")
public class BoundaryViolationException extends RuntimeException {
	public BoundaryViolationException(String error) {
		super(error);  
	}
}
