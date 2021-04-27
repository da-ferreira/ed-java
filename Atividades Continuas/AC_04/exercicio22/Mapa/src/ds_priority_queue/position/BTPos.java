
package ds_priority_queue.position;

import ds_priority_queue.complete_binary_tree.BTNode;

/** Inteface para a implementacao de BTNode: um nó que fará as ligações na árvore. */
public interface BTPos<Type> extends Position<Type> {
	/**
	 * Define o elemento desta posição.
	 * @param newElement o elemento
	 */
	public void setElement(Type newElement);
	
	/** @return Retorna o filho da esquerda desta posição. */
	public BTNode<Type> getLeft();
	
	/**
	 * Define o filho da esquerda dessa posição
	 * @param left o filho.
	 */
	public void setLeft(BTNode<Type> left);
	
	/** @return Retorna o filho da direita desta posição. */
	public BTNode<Type> getRight();
	
	/**
	 * Define o filho da direita dessa posição
	 * @param right o filho.
	 */
	public void setRight(BTNode<Type> right);
	
	/** @return Retorna o pai desta posição. */
	public BTNode<Type> getParent();
	
	/**
	 * Define o pai desta posição
	 * @param parent o filho.
	 */
	public void setParent(BTNode<Type> parent);
}
