
package exceptions;

/** Excecao lançada se a árvore estiver vazia e for feita alguma operação (ex: pegar a raiz da árvore). */

@SuppressWarnings("serial")
public class EmptyTreeException extends RuntimeException {
	public EmptyTreeException(String error) {
		super(error);
	}
}
