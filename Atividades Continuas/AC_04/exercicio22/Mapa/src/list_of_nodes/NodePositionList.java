
package list_of_nodes;

import java.util.Iterator;

/**
 * @author david-ferreira
 */

public class NodePositionList<Type> implements PositionList<Type> {
	protected Node<Type> header;   // Sentinela para a cabeça da lista
	protected Node<Type> trailer;  // Sentinela para a cauda da lista
	protected int size;            // Numero de elementos na lista
	
	
	public NodePositionList() {  // Construtor: cria uma lista vazia.
		/*
		 * Fazendo a ligação de header com trailer.
		 * Trailer aponta o previous para header,
		 * depois header aponta o next para trailer.
		 */
		header = new Node<Type>(null, null, null);
		trailer = new Node<Type>(header, null, null);
		header.setNext(trailer);
		size = 0;
	}
	
	// Verifica se a posição é válida para esta lista e a converte para Node se for válida
	public Node<Type> checkPosition(Position<Type> position) throws InvalidPositionException {
		if (position == null)
			throw new InvalidPositionException("Null position passed to NodeList");
		
		if (position == header)
			throw new InvalidPositionException("The header node is not a valid position");
		
		if (position == trailer)
			throw new InvalidPositionException("The trailer node is not a valid position");
		
		try {
			Node<Type> temp = (Node<Type>) position;  // Transformando position em Node.
			
			if (temp.getPrevious() == null ||temp.getNext() == null)
				throw new InvalidPositionException("Position does not belong to a valid NodeList");
			
			return temp;
		} 
		catch (ClassCastException except) {
			throw new InvalidPositionException("Position is of wrong type for this list");
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public Position<Type> first() throws EmptyListException {
		if (this.size == 0)
			throw new EmptyListException("List is empty");
		
		return header.getNext();
	}
	
	public Position<Type> last() throws EmptyListException {
		if (this.size == 0)
			throw new EmptyListException("List is empty");
		
		return trailer.getPrevious();
	}
	
	public Position<Type> previous(Position<Type> position) throws InvalidPositionException, BoundaryViolationException {
		Node<Type> temp = checkPosition(position);
		
		if (temp.getPrevious() == this.header)  // Nao é possivel avançar para o inicio da lista (sentinela).
			throw new BoundaryViolationException("Cannot advance past the beginning of the list");
		
		return temp.getPrevious();
	}
	
	public Position<Type> next(Position<Type> position) throws InvalidPositionException, BoundaryViolationException {
		Node<Type> temp = checkPosition(position);
		
		if (temp.getNext() == this.trailer)  // Nao é possivel avançar para o fim da lista (sentinela).
			throw new BoundaryViolationException("Cannot advance past the end of the list");
		
		return temp.getNext();
	}
	
	public void addFirst(Type element) {
		Node<Type> newElement = new Node<Type>(header, header.getNext(), element);
		header.getNext().setPrevious(newElement);
		header.setNext(newElement);
		size++;
	}
	
	public void addLast(Type element) {
		Node<Type> newElement = new Node<Type>(trailer.getPrevious(), trailer, element);
		trailer.getPrevious().setNext(newElement);
		trailer.setPrevious(newElement);
		size++;
	}
	
	public void addBefore(Position<Type> position, Type element) throws InvalidPositionException {
		Node<Type> point = checkPosition(position);
		
		Node<Type> newElemet = new Node<Type>(point.getPrevious(), point, element);
		point.getPrevious().setNext(newElemet);  // Fazendo a ligacao entre o anterior ao position e o novo nó.
		point.setPrevious(newElemet);
		
		size++;
	}
	
	public void addAfter(Position<Type> position, Type element) throws InvalidPositionException {
		Node<Type> point = checkPosition(position);
		
		Node<Type> newElemet = new Node<Type>(point, point.getNext(), element);
		point.getNext().setPrevious(newElemet);
		point.setNext(newElemet);
		
		size++;
	}
	
	public Type remove(Position<Type> position) throws InvalidPositionException {
		Node<Type> point = checkPosition(position);
		
		Node<Type> pointPrevious = point.getPrevious();  // Pegando o elemento anterior ao da posicao
		Node<Type> pointNext = point.getNext();          // Pegando o proximo elemento ao da posicao
		pointPrevious.setNext(pointNext);
		pointNext.setPrevious(pointPrevious);
		
		Type pointElement = point.getElement();
		point.setPrevious(null);  // Desconectando
		point.setNext(null);      // Desconectando
		
		size--;
		return pointElement;
	}
	
	public Type set(Position<Type> position, Type newElement) throws InvalidPositionException {
		Node<Type> point = checkPosition(position);
		
		Type oldPointElement = point.getElement();
		point.setElement(newElement);
		
		return oldPointElement;
	}
	
	public void makeFirst(Position<Type> position) throws InvalidPositionException {
		Node<Type> point = checkPosition(position);
		
		Node<Type> pointPrevious = point.getPrevious();  // Pegando o elemento anterior ao da posicao
		Node<Type> pointNext = point.getNext();          // Pegando o proximo elemento ao da posicao
		pointPrevious.setNext(pointNext);
		pointNext.setPrevious(pointPrevious);
		
		header.getNext().setPrevious(point);
		point.setNext(header.getNext());
		header.setNext(point);
		point.setPrevious(header);
	}

	public static <Type> String toString(PositionList<Type> list) {
		String lista_string = "[";
		
		for (Type element : list) {
			lista_string += element + ", ";
		}
		
		if (list.size() > 0)
			lista_string = lista_string.substring(0, lista_string.length() - 2);
		
		return lista_string  + "]";
	}
	
	public String toString() {
		return toString(this);  // Chamando a outra funcao toString com parametro de quem chamou (implicito)
	}
	
	public Iterator<Type> iterator() {
		return new ElementIterator<Type>(this);  // Retorna o iterator a partir do ElementIterator.
	}
}
	