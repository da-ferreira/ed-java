
package list_of_nodes;

public class Node<Type> implements Position<Type> {
	private Node<Type> previous;  // Referencia para o nó anterior
	private Node<Type> next;      // Referencia para o proximo nó
	private Type element;         // Elemento armazenado
	
	public Node(Node<Type> previous, Node<Type> next, Type element) {
		this.previous = previous;
		this.next = next;
		this.element = element;
	}
	
	public Type element() throws InvalidPositionException {  // Método da interface Position
		if (previous == null && next == null)
			throw new InvalidPositionException("Position is not in a list!");
		
		return element;
	}
	
	// Métodos de acesso:
	public Node<Type> getPrevious() {
		return previous;
	}
	
	public Node<Type> getNext() {
		return next;
	}
	
	public Type getElement() {
		return element;
	}

	// Métodos modificadores:
	public void setPrevious(Node<Type> previous) {
		this.previous = previous;
	}

	public void setNext(Node<Type> next) {
		this.next = next;
	}

	public void setElement(Type element) {
		this.element = element;
	}
}
