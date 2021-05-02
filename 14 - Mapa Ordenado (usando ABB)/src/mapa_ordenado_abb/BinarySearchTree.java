
package mapa_ordenado_abb;

import java.util.Comparator;

import arvore_binaria.LinkedBinaryTree;
import commons.DefaultComparator;
import commons.Entry;
import commons.Map;
import commons.Position;
import exceptions.InvalidEntryException;
import exceptions.InvalidKeyException;

/**
 * Implementação de um mapa usando uma árvore binária de busca (ABB).
 * @author david-ferreira
 */

public class BinarySearchTree<Key, Value> extends LinkedBinaryTree<Entry<Key, Value>> implements Map<Key, Value> {
	protected Position<Entry<Key, Value>> actionPosition;  // Armazena a posição onde a mais recente pesquisa, inserção ou remoção foi finalizada.
	protected Comparator<Key> comparator;
	protected int numEntries;  // Número de elementos.
	
	/** Mapa ordenado com comparador padrão. */
	public BinarySearchTree() {
		comparator = new DefaultComparator<Key>();
		numEntries = 0;
		addRoot(null);
	}

	/** Classe aninhada para as entradas da ABB. */
	protected static class BSTEntry<Key, Value> implements Entry<Key, Value> {
		protected Key key;
		protected Value value;
		protected Position<Entry<Key, Value>> position;  // Abstração para a posição onde se encontra esse par chave-valor.
		
		/** Construtor padrão. */
		public BSTEntry() { }

		public BSTEntry(Key key, Value value, Position<Entry<Key, Value>> position) {
			this.key = key;
			this.value = value;
			this.position = position;
		}

		public Key getKey() {
			return key;
		}

		public Value getValue() {
			return value;
		}
		
		/** Retorna a posição onde o par chave-valor esta. */
		public Position<Entry<Key, Value>> position() {
			return position;
		}
	}
	
	/* MÉTODOS AUXILIARES */
	
	/** Retorna a chave de um determinado nó da árvore. */
	protected Key key(Position<Entry<Key, Value>> position) {
		return position.element().getKey();
	}
	
	/** Retorna o valor de um determinado nó da árvore. */
	protected Value value(Position<Entry<Key, Value>> position) {
		return position.element().getValue();
	}
	
	/** Retorna o elemento (Entry) de um determinado nó da árvore. */
	protected Entry<Key, Value> entry(Position<Entry<Key, Value>> position) {
		return position.element();
	}
	
	/** Verifica se uma dada entrada (Entry<Key, Value> -> BSTEntry<Key, Value>) é válida. */
	protected void checkEntry(Entry<Key, Value> entry) throws InvalidEntryException {
		if (entry == null || !(entry instanceof BSTEntry))
			throw new InvalidEntryException("Entrada inválida");
	}
	
	protected void checkKey(Key key) throws InvalidKeyException {
		if (key == null)
			throw new InvalidKeyException("Chave nula");
	}
}
  
