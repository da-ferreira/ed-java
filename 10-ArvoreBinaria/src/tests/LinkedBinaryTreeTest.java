
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import arvore_binaria.LinkedBinaryTree;

class LinkedBinaryTreeTest {
	@Test
	void test() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree = tree.buildExpression("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))");
		
		assertEquals("[-, /, *, +, 3, 1, 3, +, -, 9, 5, 2, +, *, 3, -, 7, 4, 6]", tree.toStringPreOrder(), "Pré-ordem da árvore binária tree.");
		assertEquals("[3, +, 1, *, 3, /, 9, -, 5, +, 2, -, 3, *, 7, -, 4, +, 6]", tree.toStringInOrder(), "Em-ordem da árvore binária tree.");
		assertEquals("[3, 1, +, 3, *, 9, 5, -, 2, +, /, 3, 7, 4, -, *, 6, +, -]", tree.toStringPostOrder(), "Pós-ordem da árvore binária tree.");
		assertFalse(tree.isEmpty());
		
		assertEquals("-/*+333+111+*333*/+-999-555-+222+/-+*333*-777-444-*+666+-", tree.eulerTour(tree.root()), "Caminho de euler");
		assertEquals(4, tree.accountLeftExternalNodes(tree.root()), "Há 4 nós esquerdos e externos na árvore");
		assertEquals(6, tree.accountRightExternalNodes(tree.root()), "Há 6 nós direitos e externos na árvore");
		assertEquals("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))", tree.printExpression(tree.root()), "Expressão aritmética parentizada presente na árvore.");
	}
}
