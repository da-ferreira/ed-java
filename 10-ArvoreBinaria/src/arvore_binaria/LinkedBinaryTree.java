
package arvore_binaria;

import java.util.Iterator;

import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.NonEmptyTreeException;
import lista_de_nodos.NodePositionList;

/**
 * Classe que implementa um árvore binária, onde cada nó da árvore pode ter até 2 filhos.
 * @author david-ferreira
 */

public class LinkedBinaryTree<Type> implements BinaryTree<Type> {
	protected BTNode<Type> root;  // Referencia para a raiz 
	protected int size;           // Numero de nodos na árvore.  
	
	public LinkedBinaryTree() {
		root = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Type replace(BTNode<Type> node, Type newElement) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		Type toReturn = point.element();
		point.setElement(newElement);
		
		return toReturn;
	}
	
	public BTNode<Type> root() throws EmptyTreeException {
		if (size == 0)
			throw new EmptyTreeException("The binary tree is empty.");
		
		return root;
	}
	
	public BTNode<Type> parent(BTNode<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTNode<Type> point = checkPosition(node);
		
		if (point == root)
			throw new BoundaryViolationException("The root has no father");
		
		return point.getParent();
	}
	
	public Iterable<BTNode<Type>> children(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		NodePositionList<BTNode<Type>> children = new NodePositionList<BTNode<Type>>();
		
		if (hasLeft(point))
			children.addLast(point.getLeft());
		if (hasRight(point))
			children.addLast(point.getRight());
		
		return children;
	}
	
	public boolean isExternal(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		return (! hasLeft(point) && ! hasRight(point));
	}
	
	public boolean isInternal(BTNode<Type> node) throws InvalidPositionException {
		return ! isExternal(node);
	}
	
	public boolean isRoot(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		return point == root;
	}
	
	public BTNode<Type> left(BTNode<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTNode<Type> point = checkPosition(node);
		BTNode<Type> leftPoint = point.getLeft();
		
		if (leftPoint == null)
			throw new BoundaryViolationException("The node has no child on the left");
		
		return leftPoint;
	}
	
	public BTNode<Type> right(BTNode<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTNode<Type> point = checkPosition(node);
		BTNode<Type> rightPoint = point.getRight();
		
		if (rightPoint == null)
			throw new BoundaryViolationException("The node has no child on the right");
		
		return rightPoint;
	}
	
	public boolean hasLeft(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		return point.getLeft() != null;
	}
	
	public boolean hasRight(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		return point.getRight() != null;
	}
	
	/** Retorna uma coleção iterável (NodePositionList) contendo os nós da árvore em percurso pré-ordem. */
	public Iterable<BTNode<Type>> positions() {
		NodePositionList<BTNode<Type>> positions = new NodePositionList<BTNode<Type>>();
		
		if (this.size > 0)
			preOrderPosition(root(), positions);
		
		return positions;
	}
	
	/** Retorna uma coleção iterável (NodePositionList) contendo os nós da árvore em percurso em-ordem. */
	public Iterable<BTNode<Type>> positionsInOrder() {
		NodePositionList<BTNode<Type>> positions = new NodePositionList<BTNode<Type>>();
		
		if (this.size > 0)
			inOrderPosition(root(), positions);
		
		return positions;
	}
	
	/** Retorna uma coleção iterável (NodePositionList) contendo os nós da árvore em percurso pós-ordem. */
	public Iterable<BTNode<Type>> positionsPostOrder() {
		NodePositionList<BTNode<Type>> positions = new NodePositionList<BTNode<Type>>();
		
		if (this.size > 0)
			postOrderPosition(root(), positions);
		
		return positions;
	}
	
	public Iterator<Type> iterator() {
		Iterable<BTNode<Type>> positions = positions();
		NodePositionList<Type> elements = new NodePositionList<Type>();
		
		for (BTNode<Type> node : positions)
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
	public BTNode<Type> sibling(BTNode<Type> node) throws InvalidPositionException, BoundaryViolationException {
		BTNode<Type> point = checkPosition(node);
		BTNode<Type> parentPoint = point.getParent();
		
		if (parentPoint != null) {
			BTNode<Type> sibling;
			
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
	public BTNode<Type> addRoot(Type element) throws NonEmptyTreeException {
		if (this.size != 0)
			throw new NonEmptyTreeException("The tree is not empty!");
		
		root = new BTNode<Type>(element, null, null, null);
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
	public BTNode<Type> insertLeft(BTNode<Type> node, Type element) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		
		if (point.getLeft() != null)
			throw new InvalidPositionException("The node already has a child on the left");
		
		point.setLeft(new BTNode<Type>(element, null, null, point));
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
	public BTNode<Type> insertRight(BTNode<Type> node, Type element) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		
		if (point.getRight() != null)
			throw new InvalidPositionException("The node already has a child on the right");
		
		point.setRight(new BTNode<Type>(element, null, null, point));
		size++;
		return point.getRight();
	}
	
	/**
	 * Remove um nó com zero ou um filho.
	 * @param node A posição do nó a ser removida.
	 * @return O elemento do nó removido.
	 * @throws InvalidPositionException: Caso o nó passado seja inválido ou ele tenha 2 filhos.
	 */
	public Type remove(BTNode<Type> node) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		
		if (point.getLeft() != null && point.getRight() != null)  // O nó tem dois filhos?
			throw new InvalidPositionException("It is not possible to remove a node with two children");
		
		BTNode<Type> childrenPoint;  // filho de point, se houver
		
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
			BTNode<Type> parentPoint = point.getParent();
			
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
	public void attach(BTNode<Type> node, LinkedBinaryTree<Type> tree1, LinkedBinaryTree<Type> tree2) throws InvalidPositionException {
		BTNode<Type> point = checkPosition(node);
		
		if (isInternal(point))
			throw new InvalidPositionException("The node is not external");
		
		if (tree1.size() > 0) {
			BTNode<Type> root_tree1 = checkPosition(tree1.root());
			point.setLeft(root_tree1);
			root_tree1.setParent(point);
		}
		if (tree2.size() > 0) {
			BTNode<Type> root_tree2 = checkPosition(tree2.root());
			point.setRight(root_tree2);
			root_tree2.setParent(point);
		}  
	}
	
	/* MÉTODOS DE CAMINHAMENTO */
	
	/** Adiciona em uma lista de nós (NodePositionList) os elementos da árvore em percurso pré-ordem, 
	 *  mostrando a raiz, o elemento a esquerda e depois o elemento a direita */
	protected void preOrderPosition(BTNode<Type> node, NodePositionList<BTNode<Type>> list) {
		list.addLast(node);
		
		if (hasLeft(node))
			preOrderPosition(left(node), list);  // Chama recursivamente o filho da esquerda
		if (hasRight(node))
			preOrderPosition(right(node), list);  // Chama recursivamente o filho da direita
	}
	
	/** Adiciona em uma lista de nós (NodePositionList) os elementos da árvore em percurso em-ordem, 
	 *  mostrando o elemento a esquerda, a raiz e depois o elemento a direita */
	protected void inOrderPosition(BTNode<Type> node, NodePositionList<BTNode<Type>> list) {
		if (hasLeft(node))
			inOrderPosition(left(node), list);  // Chama recursivamente a sub-arvore da esquerda
		
		list.addLast(node);  // Adiciona a raíz
		
		if (hasRight(node))
			inOrderPosition(right(node), list);  // Chama recursivamente a sub-arvore da direita
	}
	
	/** Adiciona em uma lista de nós (NodePositionList) os elementos da árvore em percurso pós-ordem, 
	 *  mostrando o elemento a esquerda, o elemento a direita e depois a raiz */
	protected void postOrderPosition(BTNode<Type> node, NodePositionList<BTNode<Type>> list) {
		if (hasLeft(node))
			postOrderPosition(left(node), list);
		
		if (hasRight(node))
			postOrderPosition(right(node), list);
		
		list.addLast(node);
	}
	
	/* MÉTODOS EXTRAS */
	
	/**
	 * Constroi uma árvore binária que representa a expressão aritmética "expression",
	 * quando se caminha pela árvore em percurso em-ordem.
	 * @param expression A expressão aritmética totalmente parentizada, com variavel, operador e simbolo de parenteses.
	 * @return A árvore binária que representa a expressão.
	 */
	@SuppressWarnings("unchecked")
	public LinkedBinaryTree<Type> buildExpression(String expression) {
		NodePositionList<LinkedBinaryTree<Character>> pilha = new NodePositionList<LinkedBinaryTree<Character>>();  // Pilha representada como uma lista de nós
		
		for (int i=0; i < expression.length(); i++) {
			if (isNumeric(expression.charAt(i)) || isOperator(expression.charAt(i))) {
				LinkedBinaryTree<Character> tree = new LinkedBinaryTree<Character>();
				tree.addRoot(expression.charAt(i));
				pilha.addLast(tree);
			}
			else if (expression.charAt(i) == ')') {
				LinkedBinaryTree<Character> tree2 = pilha.remove(pilha.last());  // Representa a segunda variável numa expressão simples
				LinkedBinaryTree<Character> tree = pilha.remove(pilha.last());   // Representa o operador numa expressão simples
				LinkedBinaryTree<Character> tree1 = pilha.remove(pilha.last());  // Representa a primeira variável numa expressão simples
				
				tree.attach(tree.root(), tree1, tree2);
				pilha.addLast(tree);
			}
		}
		
		return (LinkedBinaryTree<Type>) pilha.last();
	}

	/** Avalia a expressão numa árvore binária, percorrendo ela em percurso pós-ordem,
	 *  fazendo as operações aritmeticas simples.
	 *  @return Retorna o resultado da expressão presente na árvore. */
	public int evaluateExpression(LinkedBinaryTree<Type> tree, BTNode<Type> node) {
		return 0;
	}
	
	protected void eulerTour(LinkedBinaryTree<Type> tree, BTNode<Type> node) {
		System.out.print(node.element());
		
		if (hasLeft(node))
			eulerTour(tree, left(node));  // Chama recursivamente a sub-arvore da esquerda
		
		System.out.print(node.element());
		
		if (hasRight(node))
			eulerTour(tree, right(node));  // Chama recursivamente a sub-arvore da direita
		
		System.out.print(node.element());
	}
	

	/* MÉTODOS AUXILIARES */
	
	/** Cria e retorna um BTNode */
	protected BTNode<Type> createNode(Type element, BTNode<Type> left, BTNode<Type> right, BTNode<Type> parent) {
		return new BTNode<Type>(element, left, right, parent);
	}

	/**
	 * Verifica se a posição de um dado BTNode é válida
	 * @param node O nó a ser verificado
	 * @return O nó (em BTNode)
	 * @throws InvalidPositionException: Caso a posição, de fato, for inválida.
	 */
	protected BTNode<Type> checkPosition(BTNode<Type> node) throws InvalidPositionException {
		if (node == null || !(node instanceof BTNode))
			throw new InvalidPositionException("The node is invalid!");
		
		return (BTNode<Type>) node;
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
      