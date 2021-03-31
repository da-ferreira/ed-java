
package arvore_binaria_de_pesquisa;

import arvore_binaria.BTNode;
import arvore_binaria.LinkedBinaryTree;

/**
 * Classe que implementará a Árvore binária de busca, de forma simples,
 * que aceitara apenas tipos de dados inteiros (Integer). 
 * @author david-ferreira
 */

public class LinkedBTSearch extends LinkedBinaryTree<Integer> {
	protected BTNode<Integer> root;  // Referencia para a raiz.
	
	public LinkedBTSearch() {
		root = null;
		size = 0;
	}
	
	public BTNode<Integer> root() {
		return root;
	}
	
	public boolean hasLeftBTS(BTNode<Integer> node) {
		return node.getLeft() != null;
	}
	
	public boolean hasRightBTS(BTNode<Integer> node) {
		return node.getRight() != null;
	}
	
	public BTNode<Integer> leftBTS(BTNode<Integer> node) {
		return node.getLeft();
	}
	
	public BTNode<Integer> rightBTS(BTNode<Integer> node) {
		return node.getRight();
	}
	
	/**
	 * Insere um novo elemento na árvore, obedecendo a regra das árvores de busca,
	 * onde o nó à esquerda é menor ou igual que seu pai, e o nó à direita
	 * é maior que seu pai.
	 * @param element Elemento a ser inserido.
	 */
	public void insert(Integer element) {
		BTNode<Integer> newElement = new BTNode<Integer>(element, null, null, null);
		
		if (this.size == 0) {
			root = newElement;
		}
		else {
			BTNode<Integer> point = root;
			BTNode<Integer> father = point;
			
			while (point != null) {
				father = point;
				
				if (newElement.element() <= point.element()) { 
					point = point.getLeft();
				}
				else {
					point = point.getRight();
				}
			}
			
			if (newElement.element() <= father.element()) {
				father.setLeft(newElement);
			}
			else {
				father.setRight(newElement);
			}
		}
		
		size++;
	}
	
	/** Preenche uma árvore binária de busca com um arranjo de números passados. */
	public void makerBTSearch(int array[]) {
		for (int i=0; i < array.length; i++) {
			insert(array[i]);
		}
	}
	
	public void InOrder(BTNode<Integer> node) {
		if (hasLeftBTS(node))
			InOrder(leftBTS(node));  // Chama recursivamente a sub-arvore da esquerda
		
		System.out.print(node.element() + " -> ");
		
		if (hasRightBTS(node))
			InOrder(rightBTS(node));  // Chama recursivamente a sub-arvore da direita
	}
}
   
