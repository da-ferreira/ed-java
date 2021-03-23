
package deque;

import exceptions.EmptyDequeException;

/**
 * DEQUE: Double Ended Queue (fila duplamente terminada).
 * Permite adicionar e remover elementos no final e começo da fila.
 * @author david-ferreira
 */

public class Deque<Type> {
	private Node<Type> head;  // Sentinela a cabeça do deque. 
	private Node<Type> tail;  // Sentinela a cauda do deque.
	private int size;         // Quantidade de elementos no deque.
	
	public Deque() {
		head = new Node<Type>(null, null, null);  
		tail = new Node<Type>(null, head, null);
		head.setNext(tail);
		size = 0;
	}
	
	/** @return Retorna a quantidade de elementos no deque. */
	public int size() {
		return this.size;
	}
	
	/**
	 * Adiciona um elemento no começo do deque.
	 * @param element: elemento a ser adicionado.
	 */
	public void addFirst(Type element) {
		Node<Type> point = new Node<Type>(element, head, head.getNext());
		
		head.getNext().setPrevious(point);
		head.setNext(point);
		
		size++;
	}
	
	/**
	 * Adiciona um elemento no final do deque.
	 * @param element: elemento a ser adicionado.
	 */
	public void addEnd(Type element) {
		Node<Type> point = new Node<Type>(element, tail.getPrevious(), tail);
		
		tail.getPrevious().setNext(point);
		tail.setPrevious(point);
		
		size++;
	}
	
	/**
	 * Remove um elemento no inicio do deque.
	 * @return: o elemento removido.
	 * @throws EmptyDequeException: Caso o deque esteja vazio.
	 */
	public Type popFirst() throws EmptyDequeException {
		if (this.size == 0) {
			throw new EmptyDequeException("The deque is empty");
		}
		
		Node<Type> point = head.getNext();
		Type toReturn = point.getElement();
		
		head.setNext(point.getNext());
		point.getNext().setPrevious(head);
		
		point.setPrevious(null);  // Garbage collector
		point.setNext(null);      // Idem
		
		size--;
		return toReturn;
	}
	
	/**
	 * Remove um elemento no fim do deque.
	 * @return: o elemento removido.
	 * @throws EmptyDequeException: Caso o deque esteja vazio.
	 */
	public Type popEnd() throws EmptyDequeException {
		if (this.size == 0) {
			throw new EmptyDequeException("The deque is empty");
		}
		
		Node<Type> point = tail.getPrevious();
		Type toReturn =  point.getElement();
		
		tail.setPrevious(point.getPrevious());
		point.getPrevious().setNext(tail);
		
		point.setPrevious(null);
		point.setNext(null);
		
		size--;
		return toReturn;
	}
	
	/**
	 * Pega o primeiro elemento do deque
	 * @return o elemento
	 * @throws EmptyDequeException: Caso o deque esteja vazio.
	 */
	public Type peekFirst() throws EmptyDequeException {
		if (this.size == 0) {
			throw new EmptyDequeException("The deque is empty");
		}
		
		return head.getNext().getElement();
	}
	
	/**
	 * Pega o ultimo elemento do deque
	 * @return o elemento
	 * @throws EmptyDequeException: Caso o deque esteja vazio.
	 */
	public Type peekEnd() throws EmptyDequeException {
		if (this.size == 0) {
			throw new EmptyDequeException("The deque is empty");
		}
		
		return tail.getPrevious().getElement();
	}
	
	public String toString() {
		if (this.size == 0) {
			return "[]";
		}
		
		String deque_str = "[";
		Node<Type> point = head.getNext();
		
		while (point != tail) {
			deque_str += point.getElement() + ", ";
			point = point.getNext();
		}
		
		deque_str = deque_str.substring(0, deque_str.length() - 2) + "]";
		return deque_str;
	}
}
   