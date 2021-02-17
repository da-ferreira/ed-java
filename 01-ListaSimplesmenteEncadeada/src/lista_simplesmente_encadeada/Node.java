
package lista_simplesmente_encadeada;

public class Node {
	private String element;  // A lista ser� homogenea, os elementos s�o strings
	private Node next;
	
	
	// Em java o m�todo construtor � representado pelo nome da classe.
	// Cria um n� com o elemento e o proximo n�.
	public Node(String dado, Node nodo) {
		element = dado;
		next = nodo;
	}
	
	public String getElement() {
		return element;  // retorna o elemento do n�
	}
	
	public Node getNext() {
		return next;  // retorna o proximo elemento do n�
	}
	
	public void setElement(String newElement) {
		element = newElement;  // modifica o elemento do n�
	}
	
	public void setNext(Node newNext) {
		next = newNext;  // modifica o next do n�.
	}
}
