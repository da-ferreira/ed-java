
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import arvore_generica.LinkedTree;
import arvore_generica.TreePosition;
import arvore_generica.TreeNode;
import position.Position;
import position.PositionList;


class LinkedTreeTest {
	@Test
	void test() {
		TreePosition<String> raiz;
	
		Position<Position<String>> p, s;
		PositionList<Position<String>> filhos;
	
		LinkedTree<String> T = criarArvoreT();
	
		System.out.println(T.parentheticRepresentation(T, T.root()));
		System.out.println(T.toStringPostorder(T, T.root()));
	
		assertFalse(T.isEmpty());
	
		assertEquals(4, T.height1(T), "Altura da Árvore T");
		assertEquals(4, T.height2(T, T.root()), "Altura da Árvore T");
	
		assertEquals("[Eletronics R'Us, P&D, Vendas, Internacional, Canadá, América do Sul, "
		+ "Ultramar, África, Europa, Ásia, Austrália, Nacional, Compras, Manufatura, TV, CD, Tuner]",
		T.toString(), "Pré-ordem da Árvore T ");
	
		raiz = T.root();
		filhos = raiz.getChildren();
		p = filhos.first();
	
		assertEquals("P&D", p.element().element(), "P&D");
		assertTrue(T.isExternal(p.element()));
		assertEquals(raiz, T.parent(p.element()), "Deve ser a raiz");
	
		s = filhos.next(p);
	
		assertEquals("Vendas", s.element().element(), "Vendas");
		assertTrue(T.isInternal(s.element()));
		assertEquals(1, T.depth(T, s.element()), "");
	
		T.replace(p.element(), "Pesquisa e Desenvolvimento");
	
		assertEquals("[Eletronics R'Us, Pesquisa e Desenvolvimento, Vendas, Internacional, Canadá, América do Sul, "
		+ "Ultramar, África, Europa, Ásia, Austrália, Nacional, Compras, Manufatura, TV, CD, Tuner]",
		T.toString(), "Pré-ordem da Árvore T ");
		
		assertTrue(T.isRoot(raiz));
		
		T.swapElements(p.element(), s.element());

		assertEquals("[Eletronics R'Us, Vendas, Pesquisa e Desenvolvimento, Internacional, Canadá, América do Sul, "
		+ "Ultramar, África, Europa, Ásia, Austrália, Nacional, Compras, Manufatura, TV, CD, Tuner]",
		T.toString(), "Pré-ordem da Árvore T ");
	}
}
      