
package arvore_generica;

import position.Position;
import position.PositionList;

/**
 * Classe que implementa um nodo de uma árvore. 
 * O nodo da árvore mantêm um elemento, um nodo pai,
 * um nodo para os filhos como um Lista de Nodos.
 */

public class TreeNode<Type> implements TreePosition<Type> {
	private Type element;                           // Elemento que será armazenado.
	private TreePosition<Type> parent;              // Nó para o pai.
	private PositionList<Position<Type>> children;  // Lista que armazenará os nós para os filhos.
	
	public TreeNode() {
	}

	public TreeNode(Type element, TreePosition<Type> parent, PositionList<Position<Type>> children) {
		this.element = element;
		this.parent = parent;
		this.children = children;
	}
	
	// Métodos de acesso:
	public void setElement(Type element) {
		this.element = element;
	}
	
	public void setChildren(PositionList<Position<Type>> children) {
		this.children = children;
	}
	
	public void setParent(TreePosition<Type> parent) {
		this.parent = parent;
	}
	
	// Métodos modificadores:
	public Type getElement() {
		return element;
	}
	
	public PositionList<Position<Type>> getChildren() {
		return children;
	}
	
	public TreePosition<Type> getParent() {
		return parent;
	}
	
	public String toString() {
		return "" + element; 
	}

	@Override
	public Type element() {
		return getElement();
	}
}
   
