
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import arvore_binaria.BTNode;
import arvore_binaria.LinkedBinaryTree;
import arvore_binaria_de_pesquisa.LinkedBTSearch;

/**
 * @author David Ferreira de Almeida
 * @author Eduardo de Oliveira Campos Junior
 * @author Iasmin Pinheiro Ribeiro
 * @author Lucas Cauan Pinheiro Costa
 */

class LinkedBinaryTreeTest {
	@Test
	void test() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree = tree.buildExpression("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))");
		
		assertEquals("[-, /, *, +, 3, 1, 3, +, -, 9, 5, 2, +, *, 3, -, 7, 4, 6]", tree.toStringPreOrder(), "Pré-ordem da árvore binária tree.");
		assertEquals("[3, +, 1, *, 3, /, 9, -, 5, +, 2, -, 3, *, 7, -, 4, +, 6]", tree.toStringInOrder(), "Em-ordem da árvore binária tree.");
		assertEquals("[3, 1, +, 3, *, 9, 5, -, 2, +, /, 3, 7, 4, -, *, 6, +, -]", tree.toStringPostOrder(), "Pós-ordem da árvore binária tree.");
		
		assertFalse(tree.isEmpty());
		
		assertEquals(19, tree.size(), "A árvore tem 19 nós");
		
		assertEquals("-/*+333+111+*333*/+-999-555-+222+/-+*333*-777-444-*+666+-", tree.eulerTour(tree.root()), "Caminho de euler");
		assertEquals(4, tree.accountLeftExternalNodes(tree.root()), "Há 4 nós esquerdos e externos na árvore");
		assertEquals(6, tree.accountRightExternalNodes(tree.root()), "Há 6 nós direitos e externos na árvore");
		
		assertEquals("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))", tree.printExpression(tree.root()), "Expressão aritmética parentizada presente na árvore.");
		
		BTNode<String> raiz = tree.root();
		BTNode<String> esquerdaRaiz = tree.left(raiz); 
		BTNode<String> direitaRaiz = tree.right(raiz);
		
		assertEquals("-", raiz.element());
		assertEquals("/", esquerdaRaiz.element());
		assertEquals("+", direitaRaiz.element());
		
		String apagado = tree.remove(direitaRaiz.getRight());
		assertEquals("6", apagado, "Apagando o nó com elemento 6 da árvore");
		
		apagado = tree.remove(direitaRaiz.getLeft().getLeft());
		assertEquals("3", apagado, "Apagando o nó com elemento 3 da árvore");
		
		assertEquals(17, tree.size(), "A árvore tem 17 nós");
		
		assertEquals("[-, /, *, +, 3, 1, 3, +, -, 9, 5, 2, +, *, -, 7, 4]", tree.toStringPreOrder(), "Pré-ordem da árvore binária tree.");
		assertEquals("[3, +, 1, *, 3, /, 9, -, 5, +, 2, -, *, 7, -, 4, +]", tree.toStringInOrder(), "Em-ordem da árvore binária tree.");
		assertEquals("[3, 1, +, 3, *, 9, 5, -, 2, +, /, 7, 4, -, *, +, -]", tree.toStringPostOrder(), "Pós-ordem da árvore binária tree.");
		
		/* Testando a Árvore Binária de Pesquisa (ou busca) */
		
		LinkedBTSearch treeSearch = new LinkedBTSearch(); 
		int arranjo[] = {58, 31, 90, 25, 12, 42, 36, 62, 75};
		treeSearch.makerBTSearch(arranjo);
		
		System.out.println("Percurso em nível na árvore binária de busca, com seus elementos em ordem crescente:");
		treeSearch.InOrder(treeSearch.root());		
	}
}
