
package pilha;

@SuppressWarnings("serial")

// Erro para quando a pilha ultrapassar seu limite de tamanho.
public class FullStackException extends RuntimeException {
	public FullStackException(String error) {
		super(error);
	}
}
