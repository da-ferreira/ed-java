
package lista_circular_encadeada;

public class Node {
	private String element;  // A lista ser� homogenea, os elementos sao strings
	private Node next;
	
	
	// Em java o metodo construtor eh representado pelo nome da classe.
	// Cria um nó com o elemento e o proximo nó.
	public Node(String dado, Node nodo) {
		element = dado;
		next = nodo;
	}
	
	public String getElement() {
		return element;  // retorna o elemento do nó
	}
	
	public Node getNext() {
		return next;  // retorna o proximo elemento do nó
	}
	
	public void setElement(String newElement) {
		element = newElement;  // modifica o elemento do nó
	}
	
	public void setNext(Node newNext) {
		next = newNext;  // modifica o next do nó.
	}
}

