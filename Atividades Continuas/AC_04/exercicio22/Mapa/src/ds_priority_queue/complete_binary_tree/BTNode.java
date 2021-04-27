
package ds_priority_queue.complete_binary_tree;

import ds_priority_queue.position.BTPos;

public class BTNode<Type> implements BTPos<Type> {
	private Type element;         // Elemento armazenado
	private BTNode<Type> left;    // Filho esquerdo
	private BTNode<Type> right;   // Filho direito
	private BTNode<Type> parent;  // Pai 
	
	public BTNode(Type element, BTNode<Type> left, BTNode<Type> right, BTNode<Type> parent) {
		this.element = element;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	public Type element() {
		return element;
	}

	public void setElement(Type element) {
		this.element = element;
	}

	public BTNode<Type> getLeft() {
		return left;
	}

	public void setLeft(BTNode<Type> left) {
		this.left = left;
	}

	public BTNode<Type> getRight() {
		return right;
	}

	public void setRight(BTNode<Type> right) {
		this.right = right;
	}

	public BTNode<Type> getParent() {
		return parent;
	}

	public void setParent(BTNode<Type> parent) {
		this.parent = parent;
	}
}
