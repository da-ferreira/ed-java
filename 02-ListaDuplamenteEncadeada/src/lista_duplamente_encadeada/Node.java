
package lista_duplamente_encadeada;


public class Node {
	protected String element;
	private Node prev;  // elemento anterior.
	private Node next;  // elemento posterior.
	
	// m�todo construtor.
	public Node (String elemento, Node anterior, Node posterior) {  
		element = elemento;
		prev = anterior;
		next = posterior;
	}
	
	public String getElement() {
		return element;  // retorna o elemento do n�
	}
	
	public Node getPrev() {
		return prev;  // retorna o elemento anterior do n�.
	}
	
	public Node getNext() {
		return next;  // retorna o proximo elemento do n�
	}
	
	public void setElement(String newElement) {
		element = newElement;  // modifica o elemento do n�
	}
		
	public void setPrev(Node newPrev) {
		prev = newPrev;  // modifica o prev do n�.
	}
	
	public void setNext(Node newNext) {
		next = newNext;  // modifica o next do n�.
	}
}
