
package lista_simplesmente_encadeada;

@SuppressWarnings("serial")

// A exce��o ser� o nome da classe, ou seja,
// quando a lista estiver vazia.
public class EmptySimplyLinkedList extends RuntimeException {  // est� herdando da classe RuntimeException
	public EmptySimplyLinkedList(String error) {
		super(error);
	}
}
