
package complete_binary_tree;

import exceptions.EmptyTreeException;
import position.Position;

/** Interface para  uma árvore binária completa. Uma árvore binária completa tem o máximo
 *  de nós possiveis em cada nivel da árvore. O nivel i tem 2 ^ i nós. */
public interface CompleteBinaryTree<Type> extends BinaryTree<Type> {
	/**
	 * Adiciona um novo elemento na árvore após o ultimo nó.
	 * @param element O elemento a ser adicionado
	 * @return Retorna a posição criada com o elemento (Position -> BTPosition)
	 */
	public Position<Type> add(Type element);
	
	/**
	 * Remove o elemento armazenado no último nó da árvore.
	 * @return O elemento removido.
	 * @throws EmptyTreeException: Caso a árvore esteja vazia.
	 */
	public Type remove() throws EmptyTreeException;
}
