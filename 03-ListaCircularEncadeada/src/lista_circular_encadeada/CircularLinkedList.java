
package lista_circular_encadeada;

/**
 * @author david-ferreira
 */

public class CircularLinkedList {
	protected Node cursor;  // cursor (uma espécie de cabeça da lista).
	protected Long size;
	
	public CircularLinkedList() {
		cursor = null;  // o cursor recebe null quando a lista fica vazia.
		size = (long) 0;
    }
	
	public Node getCursor() {
		return cursor;  // retorna o cursor atual da lista.
	}
	
	// move o curso adiante; se a listar so estiver ele, move pra ele mesmo (circular).
	public void advance() {
		cursor = cursor.getNext();
	}
	
	public void add(Node newElement) {
		if (size == 0) {
			cursor = newElement;
			cursor.setNext(cursor);
		}
		else {
			/*
			 * Insere um elemento logo após o cursor:
			 * 1. Liga o novo elemento com o elemento depois do cursor, ou seja,
			 * 	  ele fica no meio.
			 * 2. Liga o cursor com o novo elemento. 
			 */
			
			newElement.setNext(cursor.getNext());  // 1.
			cursor.setNext(newElement);  // 2.
		}
		
		size++;
	}
	
	public Node remove() {
		/*
		 * Remove o elemento depois do cursor.
		 * 1. Verifica se o cursor é o unico elemento da lista,
		 *    se for, coloca ele como null (a lista fica vazia).
		 * 2. Caso contrário, liga o cursor com o elemento depois do próximo do cursor, ou seja,
		 *    o cursor.getNext() e coloca o setNext do elemento removido como null (garbage collector).
		 */
		
		Node aux = cursor.getNext();
		
		if (aux == cursor) {
			cursor = null;  // 1.
		}
		else {
			cursor.setNext(aux.getNext());  // 2.
			aux.setNext(null);
		}
		
		size--;
		return aux;
	}
	
	public String toString() {  // retorna uma representacao da lista em string.		
		if (size == 0)
			return "[]";
		
		String lista = "[..." + cursor.getElement() + ", ";
		Node aux = cursor.getNext();
		
		while (aux != cursor) {
			lista += aux.getElement() + ", ";
			 aux = aux.getNext();
		}
		
		lista = lista.substring(0, lista.length() - 2);  // tirando o ", " do ultimo elemento da lista.
		return lista + "...]";
	}
	
	public Long size() {
		return size;
	}
}

