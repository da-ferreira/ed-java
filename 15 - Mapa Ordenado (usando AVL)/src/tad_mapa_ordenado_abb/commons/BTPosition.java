
package tad_mapa_ordenado_abb.commons;

import tad_mapa_ordenado_abb.arvore_binaria.BTNode;

public interface BTPosition<Type> extends Position<Type> {
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
