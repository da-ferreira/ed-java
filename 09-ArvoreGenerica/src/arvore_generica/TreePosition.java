
package arvore_generica;

import position.Position;
import position.PositionList;

/**
 * Interface para um nodo de uma árvore. 
 * O nodo da árvore mantêm um elemento, um nodo pai,
 * um nodo para os filhos como um Lista de Nodos.
 * 
 * @author david-ferreira	
 */

public interface TreePosition<Type> extends Position<Type> {
    /** 
	 * Define o elemento que será armazenado nesta posição
	 * @param element: O elemento. 
	 */
	public void setElement(Type element);
	
	/**
	 * Define os filhos que serão armazenados nesta posição
	 * @param children: Os filhos.
	 */
	public void setChildren(PositionList<Position<Type>> children);
	
	/**
	 * Define o pai que será armazenado nesta posição
	 * @param parent: O pai.
	 */
	public void setParent(TreePosition<Type> parent);
	
	/** @return O elemento armazenado nesta posição. */
	public Type getElement();
	
	/** @return Os filhos armazenados nesta posição. */
	public PositionList<Position<Type>> getChildren();
	
	/** @return O pai desta posição. */
	public TreePosition<Type> getParent();
}
