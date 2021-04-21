
package ds_priority_queue.complete_binary_tree;

import java.util.Iterator;
import ds_priority_queue.exceptions.InvalidPositionException;
import ds_priority_queue.position.Position;
import ds_priority_queue.exceptions.BoundaryViolationException;
import ds_priority_queue.exceptions.EmptyTreeException;

/**
 * @author david-ferreira
 * Interface básica e padrão para uma árvore binária.
 */

public interface Tree<Type> extends Iterable<Type> {
	/** @return A quantidade de nodos da árvore. */
	public int size();
	
	/** @return true se a árvore está vazia, do contrário, retorna false. */
	public boolean isEmpty();
	
	/**
	 * Substitui um elemento armazenado em um dado nó.
	 * @param node A posição do nó
	 * @param newElement O elemento.
	 * @return O antigo elemento do nó.
	 * @throws InvalidPositionException: Caso a posicao do elemento (node) seja inválida.
	 */
	public Type replace(Position<Type> node, Type newElement) throws InvalidPositionException;
	
	/**
	 * @return A raíz da árvore.
	 * @throws EmptyTreeException: Caso a árvore esteja vazia.
	 */
	public Position<Type> root() throws EmptyTreeException;
	
	/**
	 * @param node A posição do nó que que se deseja obter o pai.
	 * @return O pai do nó passado (node).
	 * @throws InvalidPositionException: Caso a posicao do elemento (node) seja inválida.
	 * @throws BoundaryViolationException: Caso a posição do nó passado seja a raíz da árvore.
	 */
	public Position<Type> parent(Position<Type> node) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	 * @param node A posição do nó que que se deseja obter os filhos. 
	 * @return Uma coleção iterável dos filhos de um dado nó.
	 * @throws InvalidPositionException: Caso a posicao do elemento (node) seja inválida.
	 */
	public Iterable<Position<Type>> children(Position<Type> node) throws InvalidPositionException;
	
	/**
	 * @param node A posição do nó que que se deseja saber se é folha (externo).
	 * @return true se um dado nó é externo (folha), do contrário, retorna false.
	 * @throws InvalidPositionException: Caso a posicao do elemento (node) seja inválida.
	 */
	public boolean isExternal(Position<Type> node) throws InvalidPositionException;
	
	/**
	 * @param node A posição do nó que que se deseja saber se não é folha (interno).
	 * @return true se um dado nó é interno (não é folha), do contrário, retorna false.
	 * @throws InvalidPositionException: Caso a posicao do elemento (node) seja inválida.
	 */
	public boolean isInternal(Position<Type> node) throws InvalidPositionException;
	
	/**
	 * @param node A posição do nó que que se deseja saber se é raiz da arvore.
	 * @return true se um dado nó é raiz, do contrário, retorna false.
	 * @throws InvalidPositionException: Caso a posicao do elemento (node) seja inválida.
	 */
	public boolean isRoot(Position<Type> node) throws InvalidPositionException;
	
	/** @return Retorna uma coleção iterável dos nodos. */
	public Iterable<Position<Type>> positions();
	
	/** @return Retorna um iterador sobre os elementos armazenados na árvore. */
	public Iterator<Type> iterator();
}
  