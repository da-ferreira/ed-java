
package complete_binary_tree;

import java.util.ArrayList;

import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import position.Position;

/**
 * Implementação da árvore binária completa (ou heap) usando um vetor.
 * O vetor começa a partir do índice 1 (o indice 0 fica como null), 
 * que guarda a raíz da árvore, com seu resto nos indices seguintes.
 * Se um nó da árvore tem indice j seu filho da esquerda terá o indice
 * 2 * j e o da direita 2 * j + 1. o filho esquerdo e direito com indice j e j + 1
 * terá seu pai com indice j / 2 (divisao inteira).
 * 
 * @author david-ferreira
 */

public class ArrayListCompleteBinaryTree<Type> implements CompleteBinaryTree<Type> {
	protected ArrayList<BTPosition<Type>> tree;  // Vetor que guardará a árvore.
	
	public ArrayListCompleteBinaryTree() {
		tree = new ArrayList<BTPosition<Type>>();
		tree.add(0, null);  // Um heap (arvore binaria completa) em um vetor não utiliza a posicao 0, começa a partir do indice 1.
	}
	
	/** Classe interna definida dentro de outra classe externa (ArrayListCompleteBinaryTree),
	 *  onde a classe interna tem relacionamento especial com a externa, podendo acessar
	 *  seus membros privados. */
	protected static class BTPosition<Type> implements Position<Type> {
		protected Type element;  // Elemento armazenado nesta posição.
		protected int index;     // Indice desta posição no ArrayList (tree)
		
		public BTPosition(Type element, int index) {
			this.element = element;
			this.index = index;
		}
		
		public Type element() {
			return element;
		}
		
		public int index() {
			return index;
		}
		
		public Type setElement(Type newElement) {
			Type toReturn = element;
			element = newElement;
			return toReturn;
		}
		
		@Override
		public String toString() {
			return "[" + element + ", " + index + "]";
		}
	}
	
	public int size() {
		return tree.size() - 1;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
		
	public boolean isInternal(BTPosition<Type> node) throws InvalidPositionException {
		return hasLeft(node);  // Se o nó tem um filho a esquerda, logo ele não é folha (interno).
	}
	
	public boolean isExternal(BTPosition<Type> node) throws InvalidPositionException {
		return ! isInternal(node);
	}
	
	public boolean isRoot(BTPosition<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		return point.index() == 1;
	}
	
	public boolean hasLeft(BTPosition<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		return 2 * point.index() <= size();  
	}
	
	public boolean hasRight(BTPosition<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		return (2 * point.index() + 1) <= size();  
	}
	
	public BTPosition<Type> root() throws EmptyTreeException {
		if (isEmpty())
			throw new EmptyTreeException("The tree is empty");
		
		return tree.get(1);
	}
	
	public BTPosition<Type> left(BTPosition<Type> node) throws InvalidPositionException, BoundaryViolationException {
		if (! hasLeft(node))
			throw new BoundaryViolationException("The node has no child on the left");
		
		BTPosition<Type> point = checkPosition(node);
		return tree.get(2 * point.index());
	}
	
	public BTPosition<Type> right(BTPosition<Type> node) throws InvalidPositionException, BoundaryViolationException {
		if (! hasLeft(node))
			throw new BoundaryViolationException("The node has no child on the right");
		
		BTPosition<Type> point = checkPosition(node);
		return tree.get(2 * point.index() + 1);
	}
	
	/* MÉTODOS AUXILIARES */
	
	/** Verifica se um dado nó é válido (se ele não é null e se é instancia de BTPosition) */
	protected BTPosition<Type> checkPosition(BTPosition<Type> node) throws InvalidPositionException {
		if (node == null || ! (node instanceof BTPosition))
			throw new InvalidPositionException("The node is invalid");
		
		return node;
	}
}
