
package arvore_generica;

import java.util.Iterator;

import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.NonEmptyTreeException;
import position.Position;
import position.PositionList;
import position.NodePositionList;

/**
 * Uma classe para u árvore ligada (árvore genérica) onde os nodos têm um número arbitrário de filhos.
 * @author david-ferreira
 */

public class LinkedTree<Type> implements Tree<Type> {
	protected TreePosition<Type> root;  // Referencia para a raíz.
	protected int size;                 // Numero de nós na árvore.
	
	public LinkedTree() {  // Cria uma arvore vazia.
		root = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Type replace(Position<Type> position, Type newElement) throws InvalidPositionException {
		TreePosition<Type> point = checkPosition(position);
		
		Type toReturn = point.getElement();
		point.setElement(newElement);
		
		return toReturn;
	}
	
	public TreePosition<Type> root() throws EmptyTreeException {
		if (isEmpty()) {
			throw new EmptyTreeException("The tree is empty");
		}
		
		return root;
	}
	
	public TreePosition<Type> parent(Position<Type> node_position) throws InvalidPositionException, BoundaryViolationException {
		TreePosition<Type> point = checkPosition(node_position);
		
		if (point == root) {
			throw new BoundaryViolationException("the node position is root");
		}
		
		return point.getParent();
	}
	
	public Iterable<Position<Type>> children(Position<Type> node_position) throws InvalidPositionException {
		TreePosition<Type> point = checkPosition(node_position);
		return point.getChildren();
	}
	
	public boolean isExternal(Position<Type> node_position) throws InvalidPositionException {
		TreePosition<Type> point = checkPosition(node_position);
		
		/* É um nó externo (folha) se o campo children for nulo, ou, como pode ser uma quantidade
		 * arbitraria de filhos, se a lista de filhos está vazia.
		 */
		return point.getChildren() == null || point.getChildren().isEmpty();
	}
	
	public boolean isInternal(Position<Type> node_position) throws InvalidPositionException {
		return ! isExternal(node_position);
	}
	
	public boolean isRoot(Position<Type> node_position) throws InvalidPositionException {
		checkPosition(node_position);
		return node_position == root;
	}
	
	/** Troca os elementos de V com W */
	public void swapElements(Position<Type> V, Position<Type> W) throws InvalidPositionException {
		TreePosition<Type> point_v = checkPosition(V);
		TreePosition<Type> point_w = checkPosition(W);
		
		Type temp = point_v.getElement();
		point_v.setElement(point_w.getElement());
		point_w.setElement(temp);
		
	}
	
	/** Adiciona uma raíz em uma árvore vazia. */
	public TreePosition<Type> addRoot(Type element) throws NonEmptyTreeException {
		if (this.size > 0)
			throw new NonEmptyTreeException("The tree is not empty");
		
		root = new TreeNode<Type>(element, null, null);
		size++;
		return root;
	}
	
	public Iterable<Position<Type>> positions() {
		PositionList<Position<Type>> positions = new NodePositionList<Position<Type>>();
		
		// falta fazer o preOrderPosition
	}
	
	public Iterator<Type> iterator() {
		return null;
		// falta fazer o preOrderPosition
	}
	
	/** Testa se position é um nó da árvore, se for transforma (cast) em TreePosition<Type>,
	 * caso contrário, lança um InvalidPositionException */
	protected TreePosition<Type> checkPosition(Position<Type> position) throws InvalidPositionException {
		if (position == null || !(position instanceof TreePosition)) {
			throw new InvalidPositionException("Position invalid!");
		}
		
		return (TreePosition<Type>) position;  // Cast com TreePosition
	}
	
	/** Cria um nó para a arvore, com seu elemento, sua posição para o nó Pai,
	 *  e a lista contendo um ou mais referencias (posição) para seus filhos. */
	protected TreePosition<Type> createNode(Type element, TreePosition<Type> parent, PositionList<Position<Type>> children) {
		return new TreeNode<Type>(element, parent, children);
	}
}
          
