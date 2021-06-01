
package tad_mapa_ordenado_usando_avl.tad_mapa_ordenado_abb.commons;

public interface BTPosition<Type> extends Position<Type> {
	/**
	 * Define o elemento desta posição.
	 * @param newElement o elemento
	 */
	public void setElement(Type newElement);
	
	/** @return Retorna o filho da esquerda desta posição. */
	public BTPosition<Type> getLeft();
	
	/**
	 * Define o filho da esquerda dessa posição
	 * @param left o filho.
	 */
	public void setLeft(BTPosition<Type> left);
	
	/** @return Retorna o filho da direita desta posição. */
	public BTPosition<Type> getRight();
	
	/**
	 * Define o filho da direita dessa posição
	 * @param right o filho.
	 */
	public void setRight(BTPosition<Type>right);
	
	/** @return Retorna o pai desta posição. */
	public BTPosition<Type> getParent();
	
	/**
	 * Define o pai desta posição
	 * @param parent o filho.
	 */
	public void setParent(BTPosition<Type> parent);
}
