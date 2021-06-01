
package tad_arvore_generica.exceptions;

@SuppressWarnings("serial")
public class NonEmptyTreeException extends RuntimeException {
	public NonEmptyTreeException(String error) {
		super(error);  // Retorna uma exceção quando se tenta criar uma raíz de uma árvore que não está vazia.
	}
}
