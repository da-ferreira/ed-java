
package list_of_nodes;

import java.util.Iterator;

public interface PositionList<Type> extends Iterable<Type> {
	/** @return O numero de elementos da lista */
	public int size();
	
	/** @return true se lista estiver vazia, falso do contrario */
	public boolean isEmpty();
	
	/** @return O primeiro nó da lista */
	public Position<Type> first();
	
	/** @return O ultimo nó da lista */
	public Position<Type> last();
	
	/**
	 * @param position: A posicao do nó que estará depois do nó retornado.
	 * @return O nó que segue antes da posicao passada
	 * @throws InvalidPositionException: Caso o nó passado esteja numa posicao inválida.
	 * @throws BoundaryViolationException: Caso o nó passado seja o primeiro.
	 */
	public Position<Type> previous(Position<Type> position) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	 * @param position: A posicao do nó que estará antes do nó retornado.
	 * @return O nó que segue depois da posicao passada
	 * @throws InvalidPositionException: Caso o nó passado esteja numa posicao inválida. 
	 * @throws BoundaryViolationException: Caso o nó passado seja ao ultimo.
	 */
	public Position<Type> next(Position<Type> position) throws InvalidPositionException, BoundaryViolationException;
	
	/** @param element: Elemento a ser adicionado na primeira posicao da lista */
	public void addFirst(Type element);
	
	/** @param element: Elemento a ser adicionado na ultima posicao da lista */
	public void addLast(Type element);
	
	/**
	 * Adiciona um elemento antes de um dados nó.
	 * @param position: Posicao do nó que estará depois do nó adicionado.
	 * @param element: Elemento a ser adicionado
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public void addBefore(Position<Type> position, Type element) throws InvalidPositionException;
	
	/**
	 * Adiciona um elemento depois de um dados nó.
	 * @param position: Posicao do nó que estará antes do nó adicionado
	 * @param element: Elemento a ser adicionado
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public void addAfter(Position<Type> position, Type element) throws InvalidPositionException;
	
	/**
	 * @param position: Posicao do elemento a ser removido.
	 * @return O elemento removido
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public Type remove(Position<Type> position) throws InvalidPositionException;
	
	/**
	 * @param position: Posicao do elemento a ser modificado.
	 * @param newElement: Novo elemento.
	 * @return Elemento anterior ao que será colocado
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public Type set(Position<Type> position, Type newElement) throws InvalidPositionException;
	
	/**
	 * Move o elemento na posição "position" para o inicio da lista, mantendo a ordem relativa dos demais elementos.
	 * @param position: posição do elemento.
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public void makeFirst(Position<Type> position) throws InvalidPositionException;
	
	/** Retorna um iterador sobre todos os elementos da lista. */
	public Iterator<Type> iterator();
}
