
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import arvore_generica.LinkedTree;
import arvore_generica.TreePosition;
import arvore_generica.TreeNode;
import position.NodePositionList;
import position.Position;
import position.PositionList;

/**
 * @author David Ferreira de Almeida
 * @author Eduardo de Oliveira Campos Junior
 * @author Iasmin Pinheiro Ribeiro
 * @author Lucas Cauan Pinheiro Costa
 */

class LinkedTreeTest {
	@Test
	void test() {
		TreePosition<String> raiz;
	
		Position<Position<String>> p, s;
		PositionList<Position<String>> filhos;
	
		LinkedTree<String> T = criarArvoreT();

		assertEquals("Eletronics R'Us(P&D, Vendas(Internacional(Canadá, América do Sul, Ultramar(África, Europa, Ásia, Austrália)), Nacional),"
				+ " Compras, Manufatura(TV, CD, Tuner))", T.parentheticRepresentation(T.root()),  "Representação em parenteses da Árvore T.");
		
		assertEquals("[P&D, Canadá, América do Sul, África, Europa, Ásia, Austrália, Ultramar, Internacional, Nacional,"
				+ " Vendas, Compras, TV, CD, Tuner, Manufatura, Eletronics R'Us]", T.toStringPostOrder(), "Pós-ordem da Árvore T.");
		
		assertFalse(T.isEmpty());
	
		assertEquals(4, T.height1(), "Altura da Árvore T");
		assertEquals(4, T.height2(T, T.root()), "Altura da Árvore T");
	
		assertEquals("[Eletronics R'Us, P&D, Vendas, Internacional, Canadá, América do Sul, "
		+ "Ultramar, África, Europa, Ásia, Austrália, Nacional, Compras, Manufatura, TV, CD, Tuner]",
		T.toStringPreOrder(), "Pré-ordem da Árvore T ");
	
		raiz = T.root();
		filhos = raiz.getChildren();
		p = filhos.first();
	
		assertEquals("P&D", p.element().element(), "P&D");
		assertTrue(T.isExternal(p.element()));
		assertEquals(raiz, T.parent(p.element()), "Deve ser a raiz");
	
		s = filhos.next(p);
	
		assertEquals("Vendas", s.element().element(), "Vendas");
		assertTrue(T.isInternal(s.element()));
		assertEquals(1, T.depth(s.element()), "");
	
		T.replace(p.element(), "Pesquisa e Desenvolvimento");
	
		assertEquals("[Eletronics R'Us, Pesquisa e Desenvolvimento, Vendas, Internacional, Canadá, América do Sul,"
				+ " Ultramar, África, Europa, Ásia, Austrália, Nacional, Compras, Manufatura, TV, CD, Tuner]", T.toStringPreOrder(), "Pré-ordem da Árvore T ");
		
		assertTrue(T.isRoot(raiz));
		
		T.swapElements(p.element(), s.element());

		assertEquals("[Eletronics R'Us, Vendas, Pesquisa e Desenvolvimento, Internacional, Canadá, América do Sul, "
		+ "Ultramar, África, Europa, Ásia, Austrália, Nacional, Compras, Manufatura, TV, CD, Tuner]",
		T.toStringPreOrder(), "Pré-ordem da Árvore T ");
	}
	
	private TreeNode<String> criarFilho(TreeNode<String> p, String n) {
		PositionList<Position<String>> filhos;
		TreeNode<String> aux;

		filhos = p.getChildren();      // Obtém os Filhos de p
		aux = new TreeNode<String>();  // Cria um novo filho

		aux.setElement(n);
		aux.setParent(p);
		aux.setChildren(new NodePositionList<Position<String>>());
		filhos.addLast(aux);

		return aux;
	}
	
	/** Implementação da árvore que está no Slide da Tarefa 15, pág. 33 */
	public LinkedTree<String> criarArvoreT() {
		LinkedTree<String> T = new LinkedTree<String>();
		TreeNode<String> raiz, v, m, i, u;

		T.addRoot("Eletronics R'Us");
		raiz = (TreeNode<String>) T.root();
		raiz.setChildren(new NodePositionList<Position<String>>());

		// Filhos da raiz: Eletronic R'Us
		criarFilho(raiz, "P&D");
		v = criarFilho(raiz, "Vendas");
		criarFilho(raiz, "Compras");
		m = criarFilho(raiz, "Manufatura");

		// Filhos de Vendas
		i = criarFilho(v, "Internacional");
		criarFilho(v, "Nacional");

		// Filhos de Internacional
		criarFilho(i, "Canadá");
		criarFilho(i, "América do Sul");
		u = criarFilho(i, "Ultramar");

		// Filhos de Ultramar
		criarFilho(u, "África");
		criarFilho(u, "Europa");
		criarFilho(u, "Ásia");
		criarFilho(u, "Austrália");

		// Filhos de Manufatura
		criarFilho(m, "TV");
		criarFilho(m, "CD");
		criarFilho(m, "Tuner");
		
		return T;
	}
}
   
      
