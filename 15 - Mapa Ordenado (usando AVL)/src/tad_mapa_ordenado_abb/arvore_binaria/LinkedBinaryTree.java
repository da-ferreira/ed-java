
package tad_mapa_ordenado_abb.arvore_binaria;

import java.util.Iterator;

import tad_mapa_ordenado_abb.commons.BTPosition;
import tad_mapa_ordenado_abb.commons.Position;
import tad_mapa_ordenado_abb.exceptions.BoundaryViolationException;
import tad_mapa_ordenado_abb.exceptions.EmptyTreeException;
import tad_mapa_ordenado_abb.exceptions.InvalidPositionException;
import tad_mapa_ordenado_abb.exceptions.NonEmptyTreeException;
import tad_mapa_ordenado_abb.lista_de_nodos.NodePositionList;

/**
 * Classe que implementa um árvore binária, onde cada nó da árvore pode ter até 2 filhos.
 * @author david-ferreira
 */

public class LinkedBinaryTree<Type> implements BinaryTree<Type> {
	protected Position<Type> root;  // Referencia para a raiz 
	protected int size;           // Numero de nodos na árvore.  
	
	public LinkedBinaryTree() {
		root = null;
		size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Type replace(Position<Type> node, Type newElement) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		Type toReturn = point.element();
		point.setElement(newElement);
		
		return toReturn;
	}
	
	public Position<Type> root() throws EmptyTreeException {
		if (size == 0)
			throw new EmptyTreeException("The binary tree is empty.");
		
		return root;
	}
	
	public Position<Type> parent(Position<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<Type> point = checkPosition(node);
		
		if (point == root)
			throw new BoundaryViolationException("The root has no father");
		
		return point.getParent();
	}
	
	public Iterable<Position<Type>> children(Position<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		NodePositionList<Position<Type>> children = new NodePositionList<Position<Type>>();
		
		if (hasLeft(point))
			children.addLast(point.getLeft());
		if (hasRight(point))
			children.addLast(point.getRight());
		
		return children;
	}
	
	public boolean isExternal(Position<Type> node) throws InvalidPositionException {
		Position<Type> point = checkPosition(node);
		return (! hasLeft(point) && ! hasRight(point));
	}
	
	public boolean isInternal(Position<Type> node) throws InvalidPositionException {
		return ! isExternal(node);
	}
	
	public boolean isRoot(Position<Type> node) throws InvalidPositionException {
		Position<Type> point = checkPosition(node);
		return point == root;
	}
	
	public Position<Type> left(Position<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<Type> point = checkPosition(node);
		Position<Type> leftPoint = (Position<Type>) point.getLeft();
		
		if (leftPoint == null)
			throw new BoundaryViolationException("The node has no child on the left");
		
		return leftPoint;
	}
	
	public Position<Type> right(Position<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<Type> point = checkPosition(node);
		Position<Type> rightPoint = (Position<Type>) point.getRight();
		
		if (rightPoint == null)
			throw new BoundaryViolationException("The node has no child on the right");
		
		return rightPoint;
	}
	
	public boolean hasLeft(Position<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		return point.getLeft() != null;
	}
	
	public boolean hasRight(Position<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		return point.getRight() != null;
	}
	
	/** Retorna uma coleção iterável (NodePositionList) contendo os nós da árvore em percurso pré-ordem. */
	public Iterable<Position<Type>> positions() {
		NodePositionList<Position<Type>> positions = new NodePositionList<Position<Type>>();
		
		if (this.size > 0)
			preOrderPosition(root(), positions);
		
		return positions;
	}
	
	/** Retorna uma coleção iterável (NodePositionList) contendo os nós da árvore em percurso em-ordem. */
	public Iterable<Position<Type>> positionsInOrder() {
		NodePositionList<Position<Type>> positions = new NodePositionList<Position<Type>>();
		
		if (this.size > 0)
			inOrderPosition(root(), positions);
		
		return positions;
	}
	
	/** Retorna uma coleção iterável (NodePositionList) contendo os nós da árvore em percurso pós-ordem. */
	public Iterable<Position<Type>> positionsPostOrder() {
		NodePositionList<Position<Type>> positions = new NodePositionList<Position<Type>>();
		
		if (this.size > 0)
			postOrderPosition(root(), positions);
		
		return positions;
	}
	
	public Iterator<Type> iterator() {
		Iterable<Position<Type>> positions = positions();
		NodePositionList<Type> elements = new NodePositionList<Type>();
		
		for (Position<Type> node : positions)
			elements.addLast(node.element());
		
		return elements.iterator();
	}
	
	/* MÉTODOS ADICIONAIS */
	
	/**
	 * @param node Nó que se deseja saber seu irmão (esquerdo ou direito).
	 * @return Retorna um irmão de um dado nó.
	 * @throws InvalidPositionException: Caso a posição (node) seja inválida.
	 * @throws BoundaryViolationException: Caso o nó não tenha irmão.
	 */
	public Position<Type> sibling(Position<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<Type> point = checkPosition(node);
		BTPosition<Type> parentPoint = point.getParent();
		
		if (parentPoint != null) {
			Position<Type> sibling;
			
			if (point == parentPoint.getLeft()) {
				sibling = parentPoint.getRight();
			}
			else {
				sibling = parentPoint.getLeft();
			}
			
			if (sibling != null)
				return sibling;
		}
		
		throw new BoundaryViolationException("The node has no sibling");
	}
	
	/**
	 * Adiciona uma raíz em uma árvore binária vazia.
	 * @param element Raíz
	 * @return O nó que contem a raíz.
	 * @throws NonEmptyTreeException: Caso a árvore não esteja vazia.
	 */
	public Position<Type> addRoot(Type element) throws NonEmptyTreeException {
		if (this.size != 0)
			throw new NonEmptyTreeException("The tree is not empty!");
		
		root = createNode(element, null, null, null);
		size = 1;
		return root;
	}
	
	/**
	 * Insere um elemento na esquerda de uma dado nó.
	 * @param node O nó que se deseja inserir o elemento a esquerda.
	 * @param element O elemento que se deseja inserir.
	 * @return O nó do elemento inserido.
	 * @throws InvalidPositionException: Caso o nó passado já tenha um filho a esquerda.
	 */
	public Position<Type> insertLeft(Position<Type> node, Type element) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		
		if (point.getLeft() != null)
			throw new InvalidPositionException("The node already has a child on the left");
		
		point.setLeft(createNode(element, null, null, point));
		size++;
		return point.getLeft();
	}
	
	/**
	 * Insere um elemento na direita de uma dado nó.
	 * @param node O nó que se deseja inserir o elemento a direita.
	 * @param element O elemento que se deseja inserir.
	 * @return O nó do elemento inserido.
	 * @throws InvalidPositionException: Caso o nó passado já tenha um filho a direita.
	 */
	public Position<Type> insertRight(Position<Type> node, Type element) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		
		if (point.getRight() != null)
			throw new InvalidPositionException("The node already has a child on the right");
		
		point.setRight(createNode(element, null, null, point));
		size++;
		return point.getRight();
	}
	
	/**
	 * Remove um nó com zero ou um filho.
	 * @param node A posição do nó a ser removida.
	 * @return O elemento do nó removido.
	 * @throws InvalidPositionException: Caso o nó passado seja inválido ou ele tenha 2 filhos.
	 */
	public Type remove(Position<Type> node) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		
		if (point.getLeft() != null && point.getRight() != null)  // O nó tem dois filhos?
			throw new InvalidPositionException("It is not possible to remove a node with two children");
		
		BTPosition<Type> childrenPoint;  // filho de point, se houver
		
		if (point.getLeft() != null) {
			childrenPoint = point.getLeft();
		}
		else if (point.getRight() != null) {
			childrenPoint = point.getRight();
		}
		else {
			childrenPoint = null;  // point é folha.
		}
		
		/* Se o nó passado for a raíz, e se a raíz tiver algum filho,
		 * coloca como pai desse filho null, porque ele vai ocupar o lugar
		 * da raíz e a raíz nao tem pai.
		 * 
		 * Se o nó passado não for a raíz: 
		 * 1. Pega o pai desse nó (parentPoint).
		 * 2. Verifica se o nó passado é o filho esquerdo de parentPoint,
		 * 	  se for, coloca como filho de parentPoint o filho do nó passado (point). 
		 * 3. Se não é filho esquerdo, é filho direito, então faz o mesmo passo 2, 
		 *    só que do lado direito.
		 * 4. Se o nó passado tiver algum filho, ou seja, o filho dele for diferente de null,
		 *    coloca como seu pai o pai do nó passado (point).
		 */
		
		if (point == root) {
			if (childrenPoint != null)
				childrenPoint.setParent(null);
			
			root = childrenPoint;
		}
		else {
			BTPosition<Type> parentPoint = point.getParent();
			
			if (point == parentPoint.getLeft()) {
				parentPoint.setLeft(childrenPoint);
			}
			else {
				parentPoint.setRight(childrenPoint);
			}
			
			if (childrenPoint != null)
				childrenPoint.setParent(parentPoint);
		}
		
		size--;
		return point.element();
	}
	
	/**
	 * Conecta duas árvore para serem subárvores de um nodo externo.
	 * @param node Nó externo
	 * @param tree1 Primeira árvore (esquerda). 
	 * @param tree2 Segunda árvore (direita).
	 * @throws InvalidPositionException: Caso o nó passado seja inválido ou ele não seja externo (folha).
	 */
	public void attach(Position<Type> node, LinkedBinaryTree<Type> tree1, LinkedBinaryTree<Type> tree2) throws InvalidPositionException {
		BTPosition<Type> point = checkPosition(node);
		
		if (isInternal(point))
			throw new InvalidPositionException("The node is not external");
		
		if (tree1.size() > 0) {
			BTPosition<Type> root_tree1 = checkPosition(tree1.root());
			point.setLeft(root_tree1);
			root_tree1.setParent(point);
		}
		if (tree2.size() > 0) {
			BTPosition<Type> root_tree2 = checkPosition(tree2.root());
			point.setRight(root_tree2);
			root_tree2.setParent(point);
		}  
	}
	
	/* MÉTODOS DE CAMINHAMENTO */
	
	/** Adiciona em uma lista de nós (NodePositionList) os elementos da árvore em percurso pré-ordem, 
	 *  mostrando a raiz, o elemento a esquerda e depois o elemento a direita */
	protected void preOrderPosition(Position<Type> node, NodePositionList<Position<Type>> list) {
		list.addLast(node);
		
		if (hasLeft(node))
			preOrderPosition(left(node), list);  // Chama recursivamente o filho da esquerda
		if (hasRight(node))
			preOrderPosition(right(node), list);  // Chama recursivamente o filho da direita
	}
	
	/** Adiciona em uma lista de nós (NodePositionList) os elementos da árvore em percurso em-ordem, 
	 *  mostrando o elemento a esquerda, a raiz e depois o elemento a direita */
	protected void inOrderPosition(Position<Type> node, NodePositionList<Position<Type>> list) {
		if (hasLeft(node))
			inOrderPosition(left(node), list);  // Chama recursivamente a sub-arvore da esquerda
		
		list.addLast(node);  // Adiciona a raíz
		
		if (hasRight(node))
			inOrderPosition(right(node), list);  // Chama recursivamente a sub-arvore da direita
	}
	
	/** Adiciona em uma lista de nós (NodePositionList) os elementos da árvore em percurso pós-ordem, 
	 *  mostrando o elemento a esquerda, o elemento a direita e depois a raiz */
	protected void postOrderPosition(Position<Type> node, NodePositionList<Position<Type>> list) {
		if (hasLeft(node))
			postOrderPosition(left(node), list);
		
		if (hasRight(node))
			postOrderPosition(right(node), list);
		
		list.addLast(node);
	}
	
	/* MÉTODOS EXTRAS */
	
	/**
	 * Constroi uma árvore binária (a árvore que chama o método tem que estar vazia)
	 * que representa a expressão aritmética "expression", quando se caminha pela árvore em percurso em-ordem.
	 * @param expression A expressão aritmética totalmente parentizada, com variavel, operador e simbolo de parenteses.
	 * @return A árvore formada.
	 */
	public LinkedBinaryTree<String> buildExpression(String expression) {
		NodePositionList<LinkedBinaryTree<String>> pilha = new NodePositionList<LinkedBinaryTree<String>>();  // Pilha representada como uma lista de nós
		int sizeOfTree = 0;
		
		for (int i=0; i < expression.length(); i++) {
			if (isNumeric(expression.charAt(i)) || isOperator(expression.charAt(i))) {
				LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
				tree.addRoot("" + expression.charAt(i));
				pilha.addLast(tree);
				sizeOfTree++;
			}
			else if (expression.charAt(i) == ')') {
				LinkedBinaryTree<String> tree2 = pilha.remove(pilha.last());  // Representa a segunda variável numa expressão simples
				LinkedBinaryTree<String> tree = pilha.remove(pilha.last());   // Representa o operador numa expressão simples
				LinkedBinaryTree<String> tree1 = pilha.remove(pilha.last());  // Representa a primeira variável numa expressão simples
				
				tree.attach(tree.root(), tree1, tree2);
				pilha.addLast(tree);
			}
		}
		
		LinkedBinaryTree<String> treeReturn = pilha.remove(pilha.last());
		treeReturn.size = sizeOfTree;
		return treeReturn;
	}

	/** Avalia a expressão numa árvore binária, percorrendo ela em percurso pós-ordem,
	 *  fazendo as operações aritmeticas simples.
	 *  @return O resultado da expressão presente na árvore. */
	public int evaluateExpression(LinkedBinaryTree<String> tree, Position<String> node) {
		int result = 0;
		
		if (tree.isInternal(node)) {
			String operator = node.element();
			
			int x = evaluateExpression(tree, tree.left(node));
			int y = evaluateExpression(tree, tree.right(node));
			
			if (operator == "+") {
				result += (x + y);
				return result;
			}
			else if (operator == "-") {
				result +=  (x - y);
				return result;
			}
			else if (operator == "*") {
				result += (x * y);
				return result;
			}
			else {
				result += (x / y);
				return result;
			}
		}
		
		return Integer.parseInt(node.element());
	}
	
	/** Basicamente, o caminhamento de Euler é um passeio pela árvore binária, onde
	 *  cada nó da árvore é visitado 3 vezes, numa espécie de junção dos caminhamento pré, em e pós-ordem. 
	 *  @return A string com o caminho de Euler. */
	public String eulerTour(Position<Type> node) {
		String percurso = "";
		percurso += node.element();
		
		if (hasLeft(node))
			percurso += eulerTour(left(node));  // Chama recursivamente a sub-arvore da esquerda
		
		percurso += node.element();
		
		if (hasRight(node))
			percurso += eulerTour(right(node));  // Chama recursivamente a sub-arvore da direita
		
		percurso += node.element();
		
		return percurso;
	}
	
	/**
	 * @param node Nó que iniciará a contagem.
	 * @return A quantidade de nós que são esquerdos e externos em uma árvore binária. 
	 * @throws BoundaryViolationException: Caso a árvore esteja vazia ou com 1 elemento (raíz não é esquerdo nem direito).
	 */
	public int accountLeftExternalNodes(Position<Type> node) throws BoundaryViolationException {
		int cont = 0;
		
		if (hasLeft(node)) {
			if (isExternal(left(node))) {
				cont += 1;
			}
			else {
				cont += accountLeftExternalNodes(left(node));
			}
		}
		
		if (hasRight(node))
			cont += accountLeftExternalNodes(right(node));
		
		return cont;
	}
	
	/**
	 * @param node Nó que iniciará a contagem.
	 * @return A quantidade de nós que são direitos e externos em uma árvore binária. 
	 * @throws BoundaryViolationException: Caso a árvore esteja vazia ou com 1 elemento (raíz não é esquerdo nem direito).
	 */
	public int accountRightExternalNodes(Position<Type> node) throws BoundaryViolationException {
		int cont = 0;
		
		if (hasRight(node)) {
			if (isExternal(right(node))) {
				cont += 1;
			}
			else {
				cont += accountRightExternalNodes(right(node));
			}
		}
		
		if (hasLeft(node))
			cont += accountRightExternalNodes(left(node));
		
		return cont;
	}
	
	/** @return A expressão aritmérica parentizada que está presente na árvore binária. */
	public String printExpression(Position<Type> node) {
		String expressao = "";
		
		if (isInternal(node))
			expressao += "(";
		
		if (hasLeft(node))
			expressao += printExpression(left(node));
			
		if (isInternal(node)) {  // Pegando o operador.
			expressao += node.element();
		}
		else {  // Pegando a variavel.
			expressao += node.element();
		}
		
		if (hasRight(node))
			expressao += printExpression(right(node));
		
		if (isInternal(node))
			expressao += ")";
		
		return expressao;
	}
	
	/** Representacao de uma lista em String com o percurso pré-ordem. */
	public String toStringPreOrder() {
		Iterable<Position<Type>> positions = positions();		
		return toStringModel(positions);
	}

	/** Representacao de uma lista em String com o percurso em-ordem. */
	public String toStringInOrder() {
		Iterable<Position<Type>> positions = positionsInOrder();		
		return toStringModel(positions);
	}
	
	/** Representacao de uma lista em String com o percurso pós-ordem. */
	public String toStringPostOrder() {
		Iterable<Position<Type>> positions = positionsPostOrder();		
		return toStringModel(positions);
	}

	/* MÉTODOS AUXILIARES */
	
	/** Cria e retorna um BTNode */
	protected BTPosition<Type> createNode(Type element, BTPosition<Type> left, BTPosition<Type> right, BTPosition<Type> parent) {
		return new BTNode<Type>(element, left, right, parent);
	}

	/**
	 * Verifica se a posição de um dado BTNode é válida
	 * @param node O nó a ser verificado
	 * @return O nó (em BTNode)
	 * @throws InvalidPositionException: Caso a posição, de fato, for inválida.
	 */
	protected BTPosition<Type> checkPosition(Position<Type> node) throws InvalidPositionException {
		if (node == null || !(node instanceof Position))
			throw new InvalidPositionException("The node is invalid!");
		
		return (BTPosition<Type>) node;
	}
	
	private String toStringModel(Iterable<Position<Type>> positions) {
		if (isEmpty())
			return "[]";
		
		String represent = "[";
		
		for (Position<Type> element : positions)
			represent += element.element() + ", ";
		
		return represent.substring(0, represent.length() - 2) + "]";
	}
	
	/** Verifica se um String é um digito 0-9. */
	private boolean isNumeric(char digit) {
		String digit2 = Character.toString(digit);
		return digit2.matches("[0-9]");
	}
	
	/** Verifica se uma String é um operador (+, -, *, /)*/
	private boolean isOperator(char str) {
		return str == '+' || str == '-' || str == '*' || str == '/';
	}
}
      