
package arvore_binaria;

import java.util.Iterator;

import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import lista_de_nodos.NodePositionList;

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
		Type toReturn = point.element();
		point.setElement(newElement);
		
		return toReturn;
	}
	
	public BTNode<Type> root() throws EmptyTreeException {
		if (size == 0)
			throw new EmptyTreeException("The binary tree is empty.");
		
		return root;
	}
	
	public BTNode<Type> parent(BTNode<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTNode<Type> point = checkPosition(node);
		
		if (point == root)
			throw new BoundaryViolationException("The root has no father");
		
		return point.getParent();
	}
	
	public Iterable<BTNode<Type>> children(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		NodePositionList<BTNode<Type>> children = new NodePositionList<BTNode<Type>>();
		
		if (hasLeft(point))
			children.addLast(point.getLeft());
		if (hasRight(point))
			children.addLast(point.getRight());
		
		return children;
	}
	
	public boolean isExternal(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		return (! hasLeft(point) && ! hasRight(point));
	}
	
	public boolean isInternal(BTNode<Type> node) throws InvalidPositionException {
		return ! isExternal(node);
	}
	
	public boolean isRoot(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		return point == root;
	}
	
	public BTNode<Type> left(BTNode<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTNode<Type> point = checkPosition(node);
		BTNode<Type> leftPoint = point.getLeft();
		
		if (leftPoint == null)
			throw new BoundaryViolationException("The node has no child on the left");
		
		return leftPoint;
	}
	
	public BTNode<Type> right(BTNode<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTNode<Type> point = checkPosition(node);
		BTNode<Type> rightPoint = point.getRight();
		
		if (rightPoint == null)
			throw new BoundaryViolationException("The node has no child on the right");
		
		return rightPoint;
	}
	
	public boolean hasLeft(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		return point.getLeft() != null;
	}
	
	public boolean hasRight(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		return point.getRight() != null;
	}
	
	public Iterable<BTNode<Type>> positions() {
		return null;
	}
	
	public Iterator<Type> iterator() {
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
		if (node == null || !(node instanceof BTNode))
			throw new InvalidPositionException("The node is invalid!");
		
		return (BTNode<Type>) node;
	}
}
