
package arvore_binaria;

import exceptions.InvalidPositionException;

/**
 * Classe que implementa um árvore binária, onde cada nó da árvore pode ter até 2 filhos.
 * @author david-ferreira
 */

public class LinkedBinaryTree<Type> implements BinaryTree<Type> {
	protected BTNode<Type> root;  // Referencia para a raiz 
	protected int size;           // Numero de nodos na árvore.  
	
	public LinkedBinaryTree() {
		root = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Type replace(BTNode<Type> node, Type newElement) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		return null;
		
	}
	
	/* MÉTODOS ADICIONAIS */
	
	/**
	 * Verifica se a posição de um dado BTNode é válida
	 * @param node: O nó a ser verificado
	 * @return O nó (em BTNode)
	 * @throws InvalidPositionException: Caso a posição, de fato, for inválida.
	 */
	protected BTNode<Type> checkPosition(BTNode<Type> node) throws InvalidPositionException {
		return null;
	}
}
