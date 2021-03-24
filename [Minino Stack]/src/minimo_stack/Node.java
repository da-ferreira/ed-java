
package minimo_stack;

/**
 * Nó que fará as ligações entre os elementos da minimo stack,
 * guardando, também, seu campo de menor elemento da pilha. 
 * A pilha guardara apenas valores numericos (int, long, float, double etc).
 * @author david-ferreira
 */

public class Node<Type> {
	private Type element;     // Elemento armazenado no nó.
	private Node<Type> next;  // Próximo elemento.
	private Type smaller;     // Menor elemento da pilha (até o nó adicionado).
	
	public Node(Type element, Node<Type> next, Type smaller) {
		this.element = element;
		this.next = next;
		this.smaller = smaller;
	}

	public Type getElement() {
		return element;
	}

	public void setElement(Type element) {
		this.element = element;
	}

	public Node<Type> getNext() {
		return next;
	}

	public void setNext(Node<Type> next) {
		this.next = next;
	}

	public Type getSmaller() {
		return smaller;
	}

	public void setSmaller(Type smaller) {
		this.smaller = smaller;
	}	
}
