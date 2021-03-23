
package deque;

/**
 * Nó que fará as ligações entres os elementos do deque.
 * @author david-ferreira
 */

public class Node<Type> {
	private Type element;         // Elemento armazenado neste nó.
	private Node<Type> previous;  // Elemento anterior.
	private Node<Type> next;      // Próximo elemento.
	
	/** Cria um nó com element, previous e next igual a null. */
	public Node() {
		this(null, null, null);
	}
	
	public Node(Type element, Node<Type> previous, Node<Type> next) {
		this.element = element;
		this.previous = previous;
		this.next = next;
	}

	public Type getElement() {
		return element;
	}

	public void setElement(Type element) {
		this.element = element;
	}

	public Node<Type> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<Type> previous) {
		this.previous = previous;
	}

	public Node<Type> getNext() {
		return next;
	}

	public void setNext(Node<Type> next) {
		this.next = next;
	}
}
