
package list_of_nodes;

//Excecao lançada se a lista estiver vazia e for feita alguma operação (ex: pegar o primeiro elemento da lista).

@SuppressWarnings("serial")
public class EmptyListException extends RuntimeException {
	public EmptyListException(String error) {
		super(error);
	}
}
