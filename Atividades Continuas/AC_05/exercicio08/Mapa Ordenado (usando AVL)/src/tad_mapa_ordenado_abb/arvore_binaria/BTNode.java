
package tad_mapa_ordenado_abb.arvore_binaria;

import tad_mapa_ordenado_abb.commons.BTPosition;

public class BTNode<Type> implements BTPosition<Type> {
	private Type element;         // Elemento armazenado
	private BTPosition<Type> left;    // Filho esquerdo
	private BTPosition<Type> right;   // Filho direito
	private BTPosition<Type> parent;  // Pai 
	
	public BTNode(Type element, BTPosition<Type> left, BTPosition<Type> right, BTPosition<Type> parent) {
		this.element = element;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	public BTNode() {
	}
	
	public Type element() {
		return element;
	}

	public void setElement(Type element) {
		this.element = element;
	}

	public BTPosition<Type> getLeft() {
		return left;
	}

	public void setLeft(BTPosition<Type> left) {
		this.left = left;
	}

	public BTPosition<Type> getRight() {
		return right;
	}

	public void setRight(BTPosition<Type> right) {
		this.right = right;
	}

	public BTPosition<Type> getParent() {
		return parent;
	}

	public void setParent(BTPosition<Type> parent) {
		this.parent = parent;
	}
}
