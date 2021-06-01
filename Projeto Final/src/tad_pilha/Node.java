
package tad_pilha;

public class Node<Type> {
	private Type element;      // Elemento do nó
	private Node<Type> next;  // Próximo elemento  
	
	public Node() {
		this(null, null);  // Cria um nó com element == null e next == null. 
	}
	
	public Node(Type element, Node<Type> next) {
		this.element = element;
		this.next = next;
	}
	
	// Métodos de acesso:
	public Type getElement() {
		return this.element;
	}
	
	public Node<Type> getNext() {
		return this.next;
	}
	
	// Métodos modificadores:
	public void setElement(Type newElement) {
		this.element = newElement;
	}
	
	public void setNext(Node<Type> newNext) {
		this.next = newNext;
	}
}
  