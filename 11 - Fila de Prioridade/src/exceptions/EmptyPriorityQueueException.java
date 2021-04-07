
package exceptions;

/**
 * Exceção para quando a fila de prioridade estiver vazia, e operações 
 * de remover e pegar o elemento com a menor chave for utilizada.
 */

@SuppressWarnings("serial")
public class EmptyPriorityQueueException extends RuntimeException {
	public EmptyPriorityQueueException(String error) {
		super(error);
	}
}
