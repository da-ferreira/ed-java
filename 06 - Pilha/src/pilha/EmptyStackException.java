
package pilha;

@SuppressWarnings("serial")

// Erro para quando a pilha estiver vazia.
public class EmptyStackException extends RuntimeException {  // herdando da classe RuntimeException
	public EmptyStackException(String error) {
		super(error);
	}
}
