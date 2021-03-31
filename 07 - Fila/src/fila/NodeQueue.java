
package fila;

public class NodeQueue<Type> implements Queue<Type> {
	protected Node<Type> head;  // Referencia para a cabeça da lista. 
	protected Node<Type> tail;  // Referencia para a cauda da lista.
	protected int size;         // Tamanho da lista.
	
	public NodeQueue() {  // Construtor
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public Type front() throws EmptyQueueException {
		if (this.size == 0) {
			throw new EmptyQueueException("The queue is empty");
		}
		
		return head.getElement();
	}
	
	public void enqueue(Type element) {
		Node<Type> newElement = new Node<Type>();
		newElement.setElement(element);
		
		if (this.size == 0) {
			head = newElement;  // Caso especial, adiciona o novo elemento na cabeça.
		}
		else {
			tail.setNext(newElement);  // Adiciona depois do ultimo elemento (FILA).
		}
		
		tail = newElement;  // Coloca o elemento adicionado como o rabo (ultimo elemento).  
		size++;
	}
	
	public Type dequeue() throws EmptyQueueException {
		if (this.size == 0) {
			throw new EmptyQueueException("The queue is empty");
		}
		
		Type temp = head.getElement();
		
		head = head.getNext();  // Movendo a cabeça para a frente.
		size--;
		
		return temp;
	}
	
	public String toString() {
		if (this.size == 0) {
			return "[]";
		}
		
		String fila = "[";
		Node<Type> point = head;
		
		while (point != null) {
			fila += point.getElement() + ", ";
			point = point.getNext();
		}
		
		fila = fila.substring(0, fila.length() - 2) + "]";
		return fila;
	}
}
