
package complete_binary_tree;

import java.util.ArrayList;
import java.util.Iterator;

import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import list_of_nodes.NodePositionList;
import position.Position;

/**
 * Implementação da árvore binária completa (parece com heap) usando um vetor.
 * O vetor começa a partir do índice 1 (o indice 0 fica como null), 
 * que guarda a raíz da árvore, com seu resto nos indices seguintes.
 * Se um nó da árvore tem indice j seu filho da esquerda terá o indice
 * 2 * j e o da direita 2 * j + 1. o filho esquerdo e direito com indice j e j + 1
 * terá seu pai com indice j / 2 (divisao inteira).
 * 
 * @author David Ferreira de Almeida
 * @author Eduardo de Oliveira Campos Junior
 * @author Iasmin Pinheiro Ribeiro
 * @author Lucas Cauan Pinheiro Costa
 */

public class ArrayListCompleteBinaryTree<Type> implements CompleteBinaryTree<Type> {
	protected ArrayList<Position<Type>> tree;  // Vetor que guardará a árvore.
	
	public ArrayListCompleteBinaryTree() {
		tree = new ArrayList<Position<Type>>();  // Position<Type> -> BTPosition<Type>
		tree.add(0, null);  // Uma arvore binaria completa em um vetor não utiliza a posicao 0, começa a partir do indice 1.
	}
	
	/** Classe interna definida dentro de outra classe externa (ArrayListCompleteBinaryTree), onde
	 *  a classe interna tem relacionamento especial com a externa, podendo acessar seus membros privados. */
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
		
	public boolean isInternal(Position<Type> node) throws InvalidPositionException {
		return hasLeft(node);  // Se o nó tem um filho a esquerda, logo ele não é folha (interno).
	}
	
	public boolean isExternal(Position<Type> node) throws InvalidPositionException {
		return ! isInternal(node);
	}
	
	public boolean isRoot(Position<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		return point.index() == 1;
	}
	
	public boolean hasLeft(Position<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		return 2 * point.index() <= size();  
	}
	
	public boolean hasRight(Position<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		return (2 * point.index() + 1) <= size();  
	}
	
	public Position<Type> root() throws EmptyTreeException {
		if (isEmpty())
			throw new EmptyTreeException("The tree is empty");
		
		return tree.get(1);
	}
	
	public Position<Type> left(Position<Type> node) throws InvalidPositionException, BoundaryViolationException {
		if (! hasLeft(node))
			throw new BoundaryViolationException("The node has no child on the left");
		
		BTPosition<Type> point = checkPosition(node);
		return tree.get(2 * point.index());
	}
	
	public Position<Type> right(Position<Type> node) throws InvalidPositionException, BoundaryViolationException {
		if (! hasLeft(node))
			throw new BoundaryViolationException("The node has no child on the right");
		
		BTPosition<Type> point = checkPosition(node);
		return tree.get(2 * point.index() + 1);
	}
	
	public Position<Type> parent(Position<Type> node) throws InvalidPositionException, BoundaryViolationException {
		if (isRoot(node))
			throw new BoundaryViolationException("The node has no parent (root)");
		
		BTPosition<Type> point = checkPosition(node);
		return tree.get(point.index() / 2);
	}
	
	public Iterable<Position<Type>> children(Position<Type> node) throws InvalidPositionException {
		NodePositionList<Position<Type>> children = new NodePositionList<Position<Type>>();
		
		if (hasLeft(node))
			children.addLast(left(node));
		
		if (hasRight(node))
			children.addLast(right(node));
		
		return children;
	}
	
	public Type replace(Position<Type> node, Type newElement) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		return point.setElement(newElement);
	}
	
	public Position<Type> add(Type element) {
		int index = size() + 1;  // Indice do elemento depois do ultimo.
		BTPosition<Type> newElement = new BTPosition<Type>(element, index);
		tree.add(index, newElement);
		
		return newElement;
	}
	
	public Type remove() throws EmptyTreeException {
		if (isEmpty())
			throw new EmptyTreeException("The tree is empty");
		
		return tree.remove(size()).element();
	}
	
	/* MÉTODOS ADICIONAIS */
	
	/** Retorna o irmão de node (esquerdo ou direito). */
	public Position<Type> sibling(Position<Type> node) throws InvalidPositionException, BoundaryViolationException {
		try {
			Position<Type> parentNode = parent(node);
			Position<Type> leftNode = left(parentNode);
			
			if (node == leftNode)
				return right(node);
			
			return leftNode;
		}
		catch (BoundaryViolationException error) {
			throw new BoundaryViolationException("The node has no sibling");
		}
	}
	
	/** Troca os elementos de dois nós. */
	public void swapElements(Position<Type> nodeW, Position<Type> nodeZ) throws InvalidPositionException {
		BTPosition<Type> pointW = checkPosition(nodeW);
		BTPosition<Type> pointZ = checkPosition(nodeZ);
		
		Type temp = pointW.element();
		
		pointW.setElement(pointZ.element());
		pointZ.setElement(temp);
	}
	
	/* MÉTODOS ITERAVEIS */
	
	public Iterable<Position<Type>> positions() {
		ArrayList<Position<Type>> array = new ArrayList<Position<Type>>(); 
		
		for (int i=1; i < size(); i++) {
			array.add(tree.get(i));
		}
		
		return array;
	}
	
	public Iterator<Type> iterator() {
		ArrayList<Type> array = new ArrayList<Type>(); 
		
		for (int i=1; i < size(); i++) {
			array.add(tree.get(i).element());
		}	
		
		return array.iterator();
	}
	
	/* MÉTODOS AUXILIARES */
	
	/** Verifica se um dado nó (posicao) é válido (se ele não é null e se é instancia de BTPosition) */
	protected BTPosition<Type> checkPosition(Position<Type> node) throws InvalidPositionException {
		if (node == null || ! (node instanceof BTPosition))
			throw new InvalidPositionException("The node is invalid");
		
		return (BTPosition<Type>) node;
	}
	
	/** Representacão em string -> equivalente a um percurso em nivel pela arvore binaria completa*/
	@Override
	public String toString() {
		return tree.toString();
	}
}
