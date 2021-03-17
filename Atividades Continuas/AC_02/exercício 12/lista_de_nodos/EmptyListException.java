
package lista_de_nodos;

//Excecao lançada se a lista estiver e for feita alguma operação (ex: pegar o primeiro elemento da lista).

@SuppressWarnings("serial")
public class EmptyListException extends RuntimeException {
	public EmptyListException(String error) {
		super(error);
	}
}
