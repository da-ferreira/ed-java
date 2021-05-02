
package mapa_ordenado_abb;

import java.util.Comparator;

import arvore_binaria.LinkedBinaryTree;
import commons.Entry;
import commons.Map;
import commons.Position;

/**
 * Implementação de um mapa usando uma árvore binária de busca (ABB).
 * @author david-ferreira
 */

public class BinarySearchTree<Key, Value> extends LinkedBinaryTree<Entry<Key, Value>> implements Map<Key, Value> {
	protected Position<Entry<Key, Value>> actionPosition;  // Armazena a posição onde a mais recente pesquisa, inserção ou remoção foi finalizada.
	protected Comparator<Key> comparator;
	protected int numEntries;  // Número de elementos.
	
	public BinarySearchTree() {
		
	}
	
}
