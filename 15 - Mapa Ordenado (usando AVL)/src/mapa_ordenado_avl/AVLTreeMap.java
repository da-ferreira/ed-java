
package mapa_ordenado_avl;

import java.util.Comparator;

import tad_mapa_ordenado_abb.BinarySearchTree;
import tad_mapa_ordenado_abb.arvore_binaria.BTNode;
import tad_mapa_ordenado_abb.commons.Entry;
import tad_mapa_ordenado_abb.commons.Map;

/**
 * Implementação do TAD Mapa usando Árvore AVL (sigla do nome dos autores: Georgy Adelson-Velsky e Evgenii Landis).
 * @author david-ferreira
 */

public class AVLTreeMap<Key, Value> extends BinarySearchTree<Key, Value> implements Map<Key, Value> {
	public AVLTreeMap(Comparator<Key> comparator) {
		super(comparator);
	}
	
	public AVLTreeMap() {
		super();
	}
	
	/** Classe aninhada para os nós de uma Árvore AVL. */
	protected static class AVLNode<Key, Value> extends BTNode<Entry<Key, Value>> {
		protected int height;  // altura do BTNode
		
		public AVLNode() {  // Construtor padrão
			super();
		}
		
		public AVLNode(Entry<Key, Value> element, AVLNode<Key, Value> left, AVLNode<Key, Value> right, AVLNode<Key, Value> parent) {
			super(element, left, right, parent);
			height = 0;
			
			if (left != null)
				height = Math.max(height, 1 + left.getHeight());
			if (right != null)
				height = Math.max(height, 1 + right.getHeight());
				
		}
		
		public void setHeight(int height) {
			this.height = height;
		}
		
		public int getHeight() {
			return height;
		}
	}
	
	
}
