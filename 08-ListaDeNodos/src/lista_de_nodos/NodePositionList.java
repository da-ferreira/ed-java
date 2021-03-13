
package lista_de_nodos;

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
			
			if (temp.getPrevious() == null ||temp.getNext() == null) {
				
			}
		}
	}
}
	