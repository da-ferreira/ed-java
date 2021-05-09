
package tad_mapa_ordenado_abb;

import java.util.Comparator;

import tad_mapa_ordenado_abb.arvore_binaria.LinkedBinaryTree;
import tad_mapa_ordenado_abb.commons.BTPosition;
import tad_mapa_ordenado_abb.commons.DefaultComparator;
import tad_mapa_ordenado_abb.commons.Entry;
import tad_mapa_ordenado_abb.commons.Map;
import tad_mapa_ordenado_abb.commons.Position;
import tad_mapa_ordenado_abb.exceptions.InvalidEntryException;
import tad_mapa_ordenado_abb.exceptions.InvalidKeyException;
import tad_mapa_ordenado_abb.exceptions.InvalidPositionException;
import tad_mapa_ordenado_abb.lista_de_nodos.NodePositionList;

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
	
	public BinarySearchTree(Comparator<Key> comparator) {
		this.comparator = comparator;
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
	
	/** 
	 * Realiza a reestruturação trinode. Assume que os nós estão numa das 4 formas de mapeamento.
	 * @return A nova raiz da sub-árvore reestruturada.
	 * 
	 * Algoritmo restructure(x):
	 *	 Entrada: um nodo x de uma árvore de pesquisa binária T que tem um pai y e um avô z
	 *   Saída: árvore T depois de reestruturação trinodo (que corresponde a uma rotação simples ou dupla) envolvendo os nodos x, y e z
	 *	
	 *	 1: Faça (a,b,c), da esquerda para direita (inorder) a lista de nodos x, y, z, e faça (T0 , T1, T2, T3),
	 * 	    da esquerda para a direita (inorder), a lista das quatro subárvores de x, y e z não enraizadas em x, y ou z.
	 *	
	 * 	 2: Substitua a subárvore enraizada em z por uma nova subárvore enraizada em b.
	 *  	
	 * 	 3: Faça a o filho esquerdo de b e T0 e T1 as subárvores esquerda e direita de a, respectivamente.
	 *	 
	 *	 4: Faça c o filho direito de b e T2 e T3 as subárvores esquerda e direita de c, respectivamente.
	 */
	protected Position<Entry<Key, Value>> restructure(Position<Entry<Key, Value>> x) {
		BTPosition<Entry<Key, Value>> a;
		BTPosition<Entry<Key, Value>> b;
		BTPosition<Entry<Key, Value>> c;
		BTPosition<Entry<Key, Value>> t0;
		BTPosition<Entry<Key, Value>> t1;
		BTPosition<Entry<Key, Value>> t2;
		BTPosition<Entry<Key, Value>> t3;
		
		/* PASSO 1: Faça (a,b,c), da esquerda para direita (inorder) a lista de nodos x, y, z, e faça (T0 , T1, T2, T3),
	     * da esquerda para a direita (inorder), a lista das quatro subárvores de x, y e z não enraizadas em x, y ou z. */
		
		Position<Entry<Key, Value>> y = parent(x);
		Position<Entry<Key, Value>> z = parent(y);
		
		BTPosition<Entry<Key, Value>> xx = (BTPosition<Entry<Key, Value>>) x;
		BTPosition<Entry<Key, Value>> yy = (BTPosition<Entry<Key, Value>>) y;
		BTPosition<Entry<Key, Value>> zz = (BTPosition<Entry<Key, Value>>) z;
		
		boolean xLeft = (x == left(y));
		boolean yLeft = (y == left(z));
		
		// Identificando a forma correta de mapeamento dentre as 4:
		if (xLeft && yLeft) {  // forma b
			a = xx;
			b = yy;
			c = zz;
			t0 = a.getLeft();
			t1 = a.getRight();
			t2 = b.getRight();
			t3 = c.getRight();
		}
		else if (!xLeft && yLeft) {  // forma d
			a = yy;
			b = xx;
			c = zz;
			t0 = a.getLeft();
			t1 = b.getLeft();
			t2 = b.getRight();
			t3 = c.getRight();
		}
		else if (xLeft && !yLeft) {  // forma c
			a = zz;
			b = xx;
			c = yy;
			t0 = a.getLeft();
			t1 = b.getLeft();	
			t2 = b.getRight();
			t3 = c.getRight();
		}
		else {  // forma a
			a = zz;
			b = yy;
			c = xx;
			t0 = a.getLeft();
			t1 = b.getLeft();
			t2 = c.getLeft();
			t3 = c.getRight();
		}
		
		/* PASSO 2: Substitua a subárvore enraizada em z por uma nova subárvore enraizada em b. */
		
		if (isRoot(z)) {
			root = b;
			b.setParent(null);
		}
		else {
			BTPosition<Entry<Key, Value>> zParent = (BTPosition<Entry<Key, Value>>) parent(z);
			b.setParent(zParent);
			
			if (z == left(zParent)) {  // z é filho esquerdo
				zParent.setLeft(b);
			}
			else {  // z é filho direito
				zParent.setRight(b);
			}
		}
		
		/* PASSO 3: Faça a o filho esquerdo de b e T0 e T1 as subárvores esquerda e direita de a, respectivamente. */
		
		b.setLeft(a);
		a.setParent(b);
		a.setLeft(t0);
		a.setRight(t1);
		t0.setParent(a);
		t1.setParent(a);
		
		/* PASSO 4: Faça c o filho direito de b e T2 e T3 as subárvores esquerda e direita de c, respectivamente. */
		
		b.setRight(c);
		c.setParent(b);
		c.setLeft(t2);
		c.setRight(t3);
		t2.setParent(c);
		t3.setParent(c);
		
		// Redefinindo as posições dos nós depois da reestruturação:
		((BSTEntry<Key, Value>) a.element()).position = a;
		((BSTEntry<Key, Value>) b.element()).position = b;
		((BSTEntry<Key, Value>) c.element()).position = c;
		
        return b;
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
		
		if (isInternal(node_position))  // achou
			return value(node_position);
		
		return null;  // Não há par chave-valor no mapa com essa chave.
	}
	
	public Value put(Key key, Value value) throws InvalidKeyException {
		checkKey(key);
		
		Position<Entry<Key, Value>> node_position = treeSearch(key, root());
		BSTEntry<Key, Value> newEntry = new BSTEntry<Key, Value>(key, value, node_position);
		actionPosition = node_position;  // Nó onde a pesquisa finalizou e onde a entrada está sendo inserida.
		
		if (isExternal(node_position)) {  // O nó é externo, logo, a chave é nova, par chave-valor novo.
			insertAtExternal(node_position, newEntry);
			return null;
		}
		
		return replaceEntry(node_position, newEntry);  //  a chave já existe.
	}
	
	public Value remove(Key key) throws InvalidKeyException {
		checkKey(key);
		Position<Entry<Key, Value>> positionToRemove = treeSearch(key, root());
		
		if (isExternal(positionToRemove))  // não há par chave-valor com chave igual a key.
			return null;
		
		Entry<Key, Value> toReturn = entry(positionToRemove);  // A entrada com a chave existe.
		
		if (isExternal(left(positionToRemove))) {  // O nó a ser removido tem um filho externo à esquerda; facil de remover.
			positionToRemove = left(positionToRemove);
		}
		else if (isExternal(right(positionToRemove))) {  // O nó a ser removido tem um filho externo à direita; facil de remover.
			positionToRemove = right(positionToRemove);
		}
		else {
			/* O nó a ser removido NÃO tem um filho externo à esquerda nem à direita; mais complexo de remover.
			 * Neste caso, guarda a posição do nó a ser removido (swapPosition) e pega o nó seguinte (que agora é positionToRemove) 
			 * no percurso em ordem ao o nó que será removido (swapPosition). Este nó seguinte é encontrado visitando primeiro o filho
			 * da direita de swapPosition e, descendo a ABB pelo filho da esquerda até chegar em um nó externo. Em seguida, é feito a troca.
			 */
			Position<Entry<Key, Value>> swapPosition = positionToRemove;   // nó que será removido
			positionToRemove = right(swapPosition);
			
			do {
				positionToRemove = left(positionToRemove);
			} while (isInternal(positionToRemove));
			
			replaceEntry(swapPosition, parent(positionToRemove).element());
		}
		
		actionPosition = sibling(positionToRemove);
		removeExternal(positionToRemove);
		return toReturn.getValue();
	}
	
	/* MÉTODOS DA ABB */
	
	/** Expande um nó externo tornando-o interno e adicionando dois filhos (nós) externos a ele (left e right). */
	public void expandExternal(Position<Entry<Key, Value>> position, Entry<Key, Value> left, Entry<Key, Value> right) throws InvalidPositionException {
		if (!isExternal(position))
			throw new InvalidPositionException("The node is not external");
		
		insertLeft(position, left);
		insertRight(position, right);
	}
	
	/** Remove um nó externo (placeholder) e seu pai. */
	public void remobeAboveExternal(Position<Entry<Key, Value>> position) throws InvalidPositionException {
		if (!isExternal(position))
			throw new InvalidPositionException("The node is not external");
		
		if (isRoot(position)) {
			super.remove(position);
		}
		else {
			Position<Entry<Key, Value>> parentOfPosition = parent(position);
			super.remove(position);
			super.remove(parentOfPosition);
		}
	}
	
	/** Exibe a expressão parentizada da ABB. */
	public String printExpression(Position<Entry<Key, Value>> node) {
		String expression = "";
		
		if (isInternal(node))
			expression += "(";
		
		if (hasLeft(node))
			expression += printExpression(left(node));
		
		if (node.element() != null)
			expression += node.element().getKey().toString();
		
		if (hasRight(node))
			expression += printExpression(right(node));
		
		if (isInternal(node))
			expression += ")";
		
		return expression;
	}
	
	public Iterable<Key> keySet() {
		NodePositionList<Key> keys = new NodePositionList<Key>();
		Iterable<Position<Entry<Key, Value>>> position_inorder = positionsInOrder();
		
		for (Position<Entry<Key, Value>> node : position_inorder)
			if (isInternal(node))
				keys.addLast(key(node));
		
		return keys;
	}
	
	public Iterable<Value> values() {
		NodePositionList<Value> values = new NodePositionList<Value>();
		Iterable<Position<Entry<Key, Value>>> position_inorder = positionsInOrder();
		
		for (Position<Entry<Key, Value>> node : position_inorder)
			if (isInternal(node))
				values.addLast(value(node));
		
		return values;
	}
	
	public Iterable<Entry<Key, Value>> entrySet() {
		NodePositionList<Entry<Key, Value>> entries = new NodePositionList<Entry<Key, Value>>();
		Iterable<Position<Entry<Key, Value>>> position_inorder = positionsInOrder();
		
		for (Position<Entry<Key, Value>> node : position_inorder)
			if (isInternal(node))
				entries.addLast(node.element());
		
		return entries;
	}
		
	/* MÉTODOS AUXILIARES */
	
	/** Método auxiliar de busca onde busca uma chave (key) a partir de uma posicão (position).
	 *  Será usado nos métodos de inserção, remoção e pesquisa (get). */
	protected Position<Entry<Key, Value>> treeSearch(Key key, Position<Entry<Key, Value>> position) {
		if (isExternal(position)) {
			return position;  // Não achou, chegou em um nó externo (placeholder)
		}
		else {
			Key currentKey = key(position);  // chave da posição atual (position)
			int comparation = comparator.compare(key, currentKey);
			
			if (comparation < 0) {  
				return treeSearch(key, left(position));  // Segue descendo na sub-árvore da esquerda
			}
			else if (comparation > 0) {  
				return treeSearch(key, right(position));  // Segue descendo na sub-árvore da direita
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
		replace(position, entry);
		numEntries++;
		return entry;
	}
	
	/** Substitui um elemento numa posição por outro elemento, retornando seu valor novo (atualiza a posição do elemento também). */
	protected Value replaceEntry(Position<Entry<Key, Value>> position, Entry<Key, Value> entry) {
		((BSTEntry<Key, Value>) entry).position = position;
		return replace(position, entry).getValue();
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
  
