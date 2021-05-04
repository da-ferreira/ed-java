
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
import lista_de_nodos.NodePositionList;

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
		
		Position<Entry<Key, Value>> node_position = treeSearch(key, root());
		actionPosition = node_position;  // Nó onde a pesquisa finalizou
		
		if (isInternal((BTNode<Entry<Key, Value>>) node_position))  // achou
			return value(node_position);
		
		return null;  // Não há par chave-valor no mapa com essa chave.
	}
	
	public Value put(Key key, Value value) throws InvalidKeyException {
		checkKey(key);
		
		Position<Entry<Key, Value>> node_position = treeSearch(key, root());
		BSTEntry<Key, Value> newEntry = new BSTEntry<Key, Value>(key, value, node_position);
		actionPosition = node_position;  // Nó onde a pesquisa finalizou e onde a entrada está sendo inserida.
		
		if (isExternal((BTNode<Entry<Key, Value>>) node_position)) {  // O nó é externo, logo, a chave é nova, par chave-valor novo.
			insertAtExternal(node_position, newEntry);
			return null;
		}
		
		return replaceEntry(node_position, newEntry);  //  a chave já existe.
	}
	
	public Value remove(Key key) throws InvalidKeyException {
		checkKey(key);
		Position<Entry<Key, Value>> positionToRemove = treeSearch(key, root());
		
		if (isExternal((BTNode<Entry<Key, Value>>) positionToRemove))  // não há par chave-valor com chave igual a key.
			return null;
		
		Entry<Key, Value> toReturn = entry(positionToRemove);  // A entrada com a chave existe.
		
		if (isExternal(left((BTNode<Entry<Key, Value>>) positionToRemove))) {  // O nó a ser removido tem um filho externo à esquerda; facil de remover.
			positionToRemove = left((BTNode<Entry<Key, Value>>) positionToRemove);
		}
		else if (isExternal(right((BTNode<Entry<Key, Value>>) positionToRemove))) {  // O nó a ser removido tem um filho externo à direita; facil de remover.
			positionToRemove = right((BTNode<Entry<Key, Value>>) positionToRemove);
		}
		else {
			/* O nó a ser removido NÃO tem um filho externo à esquerda nem à direita; mais complexo de remover.
			 * Neste caso, guarda a posição do nó a ser removido (swapPosition) e pega o nó seguinte (que agora é positionToRemove) 
			 * no percurso em ordem ao o nó que será removido (swapPosition). Este nó seguinte é encontrado visitando primeiro o filho
			 * da direita de swapPosition e, descendo a ABB pelo filho da esquerda até chegar em um nó externo. Em seguida, é feito a troca.
			 */
			Position<Entry<Key, Value>> swapPosition = positionToRemove;   // nó que será removido
			positionToRemove = right((BTNode<Entry<Key, Value>>) swapPosition);
			
			do {
				positionToRemove = left((BTNode<Entry<Key, Value>>) positionToRemove);
			} while (isInternal((BTNode<Entry<Key, Value>>) positionToRemove));
			
			replaceEntry(swapPosition, parent((BTNode<Entry<Key, Value>>) positionToRemove).element());
		}
		
		actionPosition = sibling((BTNode<Entry<Key, Value>>) positionToRemove);
		removeExternal(positionToRemove);
		return toReturn.getValue();
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
			super.remove((BTNode<Entry<Key, Value>>) position);
		}
		else {
			Position<Entry<Key, Value>> parentOfPosition = parent((BTNode<Entry<Key, Value>>) position);
			super.remove((BTNode<Entry<Key, Value>>) position);
			super.remove((BTNode<Entry<Key, Value>>) parentOfPosition);
		}
	}
	
	/** Exibe a expressão parentizada da ABB. */
	public String printExpression(Position<Entry<Key, Value>> node) {
		String expression = "";
		
		if (isInternal((BTNode<Entry<Key, Value>>) node))
			expression += "(";
		
		if (hasLeft((BTNode<Entry<Key, Value>>) node))
			expression += printExpression(left((BTNode<Entry<Key, Value>>) node));
		
		if (node.element() != null)
			expression += node.element().getKey().toString();
		
		if (hasRight((BTNode<Entry<Key, Value>>) node))
			expression += printExpression(right((BTNode<Entry<Key, Value>>) node));
		
		if (isInternal((BTNode<Entry<Key, Value>>) node))
			expression += ")";
		
		return expression;
	}
	
	public Iterable<Key> keySet() {
		NodePositionList<Key> keys = new NodePositionList<Key>();
		Iterable<BTNode<Entry<Key, Value>>> position_inorder = positionsInOrder();
		
		for (BTNode<Entry<Key, Value>> node : position_inorder)
			if (isInternal(node))
				keys.addLast(key(node));
		
		return keys;
	}
	
	public Iterable<Value> values() {
		NodePositionList<Value> values = new NodePositionList<Value>();
		Iterable<BTNode<Entry<Key, Value>>> position_inorder = positionsInOrder();
		
		for (BTNode<Entry<Key, Value>> node : position_inorder)
			if (isInternal(node))
				values.addLast(value(node));
		
		return values;
	}
	
	public Iterable<Entry<Key, Value>> entrySet() {
		NodePositionList<Entry<Key, Value>> entries = new NodePositionList<Entry<Key, Value>>();
		Iterable<BTNode<Entry<Key, Value>>> position_inorder = positionsInOrder();
		
		for (BTNode<Entry<Key, Value>> node : position_inorder)
			if (isInternal(node))
				entries.addLast(node.element());
		
		return entries;
	}
		
	/* MÉTODOS AUXILIARES */
	
	/** Método auxiliar de busca onde busca uma chave (key) a partir de uma posicão (position).
	 *  Será usado nos métodos de inserção, remoção e pesquisa (get). */
	protected Position<Entry<Key, Value>> treeSearch(Key key, Position<Entry<Key, Value>> position) {
		if (isExternal((BTNode<Entry<Key, Value>>) position)) {
			return position;  // Não achou, chegou em um nó externo (placeholder)
		}
		else {
			Key currentKey = key(position);  // chave da posição atual (position)
			int comparation = comparator.compare(key, currentKey);
			
			if (comparation < 0) {  
				return treeSearch(key, left((BTNode<Entry<Key, Value>>) position));  // Segue descendo na sub-árvore da esquerda
			}
			else if (comparation > 0) {  
				return treeSearch(key, right((BTNode<Entry<Key, Value>>) position));  // Segue descendo na sub-árvore da direita
			}
		
			return position;  // Achou a nó com a chave indicada
		}
	}
	
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
  
