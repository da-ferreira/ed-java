
package fila;

public class Node<Type> {
	private Type element;         // Elemento do nó.
	private Node<Type> previous;  // Nó do elemento anterior.
	private Node<Type> next;      // Nó do próximo elemento.
	
	// Cria um nó com element = previous = next = null.
	public Node() {
		this(null, null, null);  
	}
	
	public Node(Type element, Node<Type> previous, Node<Type> next) {
		this.element = element;
		this.previous = previous;
		this.next = next;
	}
	
	// Métodos de acesso:
	public Type getElement() {
		return this.element;
	}
	
	public Node<Type> getPrevious() {
		return this.previous;
	}
	
	public Node<Type> getNext() {
		return this.next;
	}
	
	// Métodos modificadores:
	public void setElement(Type newElement) {
		this.element = newElement;
	}
	
	public void setPrevious(Node<Type> newPrevious) {
		this.previous = newPrevious;
	}
	
	public void setNext(Node<Type> newNext) {
		this.next = newNext;
	}
}
