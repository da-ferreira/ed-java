
package arvore_generica;

import java.util.Iterator;
import exceptions.InvalidPositionException;
import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import position.Position;

/**
 * @author david-ferreira
 * 
 * Interface para uma árvore onde os nodos podem ter uma quantidade arbitrária de filhos.
 */

public interface Tree<Type> extends Iterable<Type> {
	/** @return A quantidade de nodos da árvore. */
	public int size();
	
	/** @return true se a árvore está vazia, do contrário, retorna false. */
	public boolean isEmpty();
	
	/**
	 * Substitui um elemento armazenado em um dado nó.
	 * @param position: A posição do nó
	 * @param newElement: O elemento.
	 * @return O antigo elemento do nó.
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public Type replace(Position<Type> position, Type newElement) throws InvalidPositionException;
	
	/**
	 * @return A raíz da árvore.
	 * @throws EmptyTreeException: Caso a árvore esteja vazia.
	 */
	public TreePosition<Type> root() throws EmptyTreeException;
	
	/**
	 * @param node_position: A posição do nó que que se deseja obter o pai.
	 * @return O pai do nó passado (node_position).
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 * @throws BoundaryViolationException: Caso a posição do nó passado seja a raíz da árvore.
	 */
	public TreePosition<Type> parent(Position<Type> node_position) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	 * @param node_position: A posição do nó que que se deseja obter os filhos. 
	 * @return Uma coleção iterável dos filhos de um dado nó.
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public Iterable<Position<Type>> children(Position<Type> node_position) throws InvalidPositionException;
	
	/**
	 * @param node_position: A posição do nó que que se deseja saber se é folha (externo).
	 * @return true se um dado nó é externo (folha), do contrário, retorna false.
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public boolean isExternal(Position<Type> node_position) throws InvalidPositionException;
	
	/**
	 * @param node_position: A posição do nó que que se deseja saber se não é folha (interno).
	 * @return true se um dado nó é interno (não é folha), do contrário, retorna false.
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public boolean isInternal(Position<Type> node_position) throws InvalidPositionException;
	
	/**
	 * @param node_position: A posição do nó que que se deseja saber se é raiz da arvore.
	 * @return true se um dado nó é raiz, do contrário, retorna false.
	 * @throws InvalidPositionException: Caso a posicao do elemento (position) seja inválida.
	 */
	public boolean isRoot(Position<Type> node_position) throws InvalidPositionException;
	
	/** @return Retorna uma coleção iterável dos nodos. */
	public Iterable<Position<Type>> positions();
	
	/** @return Retorna um iterador sobre os elementos armazenados na árvore. */
	public Iterator<Type> iterator();
}
