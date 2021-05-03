
package mapa_ordenado_abb;

import java.util.Comparator;

import arvore_binaria.BTNode;
import arvore_binaria.LinkedBinaryTree;
import commons.DefaultComparator;
import commons.Entry;
import commons.Map;
import commons.Position;
import exceptions.InvalidEntryException;
import exceptions.InvalidKeyException;
import exceptions.InvalidPositionException;

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
	
	/* MÉTODOS DO TAD MAPA */
	
	public int size() {
		return numEntries;
	}
	
	public boolean isEmpty() {
		return numEntries == 0;
	}
	
	public Value get(Key key) throws InvalidKeyException {
		checkKey(key);
		
		Position<Entry<Key, Value>> node = treeSearch(key, root());
		actionPosition = node;  // Nó onde a pesquisa finalizou
		
		if (isInternal((BTNode<Entry<Key, Value>>) node))  // achou
			return value(node);
		
		return null;  // Não há par chave-valor no mapa com essa chave.
	}
	
	
	
	
	
	/* MÉTODOS DA ABB */
	
	/** Expande um nó externo tornando-o interno e adicionando dois filhos (nós) externos a ele (left e right). */
	public void expandExternal(Position<Entry<Key, Value>> position, Entry<Key, Value> left, Entry<Key, Value> right) throws InvalidPositionException {
		if (!isExternal((BTNode<Entry<Key, Value>>) position))
			throw new InvalidPositionException("The node is not external");
		
		insertLeft((BTNode<Entry<Key, Value>>) position, left);
		insertRight((BTNode<Entry<Key, Value>>) position, right);
	}
	
	/** Remove um nó externo (placeholder) e seu pai. */
	public void remobeAboveExternal(Position<Entry<Key, Value>> position) throws InvalidPositionException {
		if (!isExternal((BTNode<Entry<Key, Value>>) position))
			throw new InvalidPositionException("The node is not external");
		
		if (isRoot((BTNode<Entry<Key, Value>>) position)) {
			remove((BTNode<Entry<Key, Value>>) position);
		}
		else {
			Position<Entry<Key, Value>> parentOfPosition = parent((BTNode<Entry<Key, Value>>) position);
			remove((BTNode<Entry<Key, Value>>) position);
			remove((BTNode<Entry<Key, Value>>) parentOfPosition);
		}
	}
		
	/* MÉTODOS AUXILIARES */
	
	/** Remove um nó externo (placeholder) e seu pai. */
	protected void removeExternal(Position<Entry<Key, Value>> position) {
		remobeAboveExternal(position);
		numEntries--;
	}
	
	/** Expande uma posição externa da árvore (position) em dois filhos e insere entry em position. */
	protected Entry<Key, Value> insertAtExternal(Position<Entry<Key, Value>> position, Entry<Key, Value> entry) {
		
		/* A posição da árvore position, que é um nó externo, ganhará dois filhos externos.
		 * Em seguinda, como um nó externo não tem nada, ou seja, é um placeholder, o replace
		 * colocará a entrada "entry" em position.
		 */
		expandExternal(position, null, null);
		replace((BTNode<Entry<Key, Value>>) position, entry);
		numEntries++;
		return entry;
	}
	
	/** Substitui um elemento numa posição por outro elemento, retornando seu valor novo (atualiza a posição do elemento também). */
	protected Value replaceEntry(Position<Entry<Key, Value>> position, Entry<Key, Value> entry) {
		((BSTEntry<Key, Value>) entry).position = position;
		return replace((BTNode<Entry<Key, Value>>) position, entry).getValue();
	}
	
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
  
