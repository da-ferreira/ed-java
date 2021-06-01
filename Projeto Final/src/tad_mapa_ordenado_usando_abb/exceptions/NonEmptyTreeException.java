
package tad_mapa_ordenado_usando_abb.exceptions;

/** Retorna uma exceção quando se tenta criar uma raíz de uma árvore que não está vazia. */

@SuppressWarnings("serial")
public class NonEmptyTreeException extends RuntimeException {
	public NonEmptyTreeException(String error) {
		super(error);  
	}
}
