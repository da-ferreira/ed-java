
package tad_mapa_ordenado_usando_avl.source;

import java.util.Comparator;

import tad_mapa_ordenado_usando_avl.tad_mapa_ordenado_abb.BinarySearchTree;
import tad_mapa_ordenado_usando_avl.tad_mapa_ordenado_abb.arvore_binaria.BTNode;
import tad_mapa_ordenado_usando_avl.tad_mapa_ordenado_abb.commons.BTPosition;
import tad_mapa_ordenado_usando_avl.tad_mapa_ordenado_abb.commons.Entry;
import tad_mapa_ordenado_usando_avl.tad_mapa_ordenado_abb.commons.Map;
import tad_mapa_ordenado_usando_avl.tad_mapa_ordenado_abb.commons.Position;
import tad_mapa_ordenado_usando_avl.tad_mapa_ordenado_abb.exceptions.InvalidKeyException;

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
		
		@SuppressWarnings("unchecked")
		public AVLNode(Entry<Key, Value> element, BTPosition<Entry<Key, Value>> left, BTPosition<Entry<Key, Value>> right, BTPosition<Entry<Key, Value>> parent) {
			super(element, left, right, parent);
			height = 0;
			
			if (left != null)
				height = Math.max(height, 1 + ((AVLNode<Key, Value>) left).getHeight());
			if (right != null)
				height = Math.max(height, 1 + ((AVLNode<Key, Value>) right).getHeight());
				
		}
		
		public void setHeight(int height) {
			this.height = height;
		}
		
		public int getHeight() {
			return height;
		}
	}
	
	public Value put(Key key, Value value) throws InvalidKeyException {
		Value toReturn = super.put(key, value);
		rebalance(actionPosition);  // Rebalanceia a árvore
		return toReturn;
	}
	
	public Value remove(Key key) throws InvalidKeyException {
		Value toReturn = super.remove(key);
		
		if (toReturn != null)  // Verifica se realmente foi removido.
			rebalance(actionPosition);
		
		return toReturn;
	}
	
	/** Cria um novo nó da árvore binaria de busca. */
	protected BTPosition<Entry<Key, Value>> createNode(Entry<Key, Value> element, BTPosition<Entry<Key, Value>> left, BTPosition<Entry<Key, Value>> right, BTPosition<Entry<Key, Value>> parent) {
		return new AVLNode<Key, Value>(element, left, right, parent);
	}
	
	/** Retorna a altura de um nó. */
	@SuppressWarnings("unchecked")
	protected int height(Position<Entry<Key, Value>> node) {
		return ((AVLNode<Key, Value>) node).getHeight();
	}
	
	/** Define a altura de um nó interno. */
	@SuppressWarnings("unchecked")
	protected void setHeight(Position<Entry<Key, Value>> node) {
		((AVLNode<Key, Value>) node).setHeight(1 + Math.max(height(left(node)), height(right(node))));
	}
	
	/** Verifica se um nó tem o fator de balanceamento entre -1 e 1, ou seja, a diferença absoluta da altura de 
	 *  seus filhos deve estar entre -1 e 1. */
	protected boolean isBalanced(Position<Entry<Key, Value>> node) {
		int fatorBalanceamento = height(left(node)) - height(right(node)); 
		return -1 <= fatorBalanceamento && fatorBalanceamento <= 1;
	}
	
	/** Retorna o filho mais alto de um dado nó. */
	protected Position<Entry<Key, Value>> tallerChild(Position<Entry<Key, Value>> node) {
		if (height(left(node)) > height(right(node))) {
			return left(node);
		}
		else if (height(right(node)) > height(left(node))) {
			return right(node);
		}
		
		// Altura dos filhos são iguais:
		
		if (isRoot(node)) {
			return left(node);  // se node for a raíz, retorna o filho esquerdo
		}
		else if (node == left(parent(node))) {  // se node for filho esquerdo de seu pai, retorna o filho esquerdo de node
			return left(node);
		}
		else {  // se node for filho direito de seu pai, retorna o filho direito de node
			return right(node);
		}
	}
	
	/** Percorre position até a raíz em busca de nós desbalanceados, caso encontrado algum, é balanceado
	 *  com a reestruturação trinode com o método reestructure(x). */
	protected void rebalance(Position<Entry<Key, Value>> zPosition) {
		if (isInternal(zPosition))
			setHeight(zPosition);
		
		while (! isRoot(zPosition)) {  // percore a árvore até a raíz
			zPosition = parent(zPosition);
			setHeight(zPosition);
			
			if (!isBalanced(zPosition)) {
				Position<Entry<Key, Value>> xPosition = tallerChild(tallerChild(zPosition));
				zPosition = super.restructure(xPosition);
				
				// Redefine as alturas
				setHeight(left(zPosition));
				setHeight(right(zPosition));
				setHeight(zPosition);
			}
		}
	}
}
