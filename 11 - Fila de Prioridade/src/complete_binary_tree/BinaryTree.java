
package complete_binary_tree;

import exceptions.BoundaryViolationException;
import exceptions.InvalidPositionException;
import position.Position;

/**
 * @author david-ferreira
 * Interface específica para uma árvore binária, herdando da interface Tree os métodos padrão de uma árvore.
 */

public interface BinaryTree<Type> extends Tree<Type> {
	/**
	 * Retorna o filho da esquerda do nó.
	 * @param node O nó que se deseja obter o filho da esquerda.
	 * @return O filho da esquerda.
	 * @throws InvalidPositionException: Caso a posição (node) seja inválida.
	 * @throws BoundaryViolationException: Caso node não tiver filho a esquerda.
	 */
	public Position<Type> left(Position<Type> node) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	 * Retorna o filho da direita do nó.
	 * @param node O nó que se deseja obter o filho da direita.
	 * @return O filho da direita.
	 * @throws InvalidPositionException: Caso a posição (node) seja inválida.
	 * @throws BoundaryViolationException: Caso node não tiver filho a direita.
	 */
	public Position<Type> right(Position<Type> node) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	 * @param node O nó que se deseja saber se tem filho a esquerda.
	 * @return Retorna true se node tiver filho a esquerda; do contrário, retorna false.
	 * @throws InvalidPositionException: Caso a posição (node) seja inválida.
	 */
	public boolean hasLeft(Position<Type> node) throws InvalidPositionException;
	
	/**
	 * @param node O nó que se deseja saber se tem filho a direita.
	 * @return Retorna true se node tiver filho a direita; do contrário, retorna false.
	 * @throws InvalidPositionException: Caso a posição (node) seja inválida.
	 */
	public boolean hasRight(Position<Type> node) throws InvalidPositionException;
}
