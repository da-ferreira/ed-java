
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import arvore_binaria.BTNode;
import arvore_binaria.LinkedBinaryTree;

class LinkedBinaryTreeTest {
	@Test
	void test() {
		LinkedBinaryTree<Character> tree = criarArvoreBinaria();
		
		System.out.println(tree.toStringPreOrder());
		System.out.println(tree.toStringInOrder());
		System.out.println(tree.toStringPostOrder());
	}
	
	/** Implementação da árvore binária que está no slide "Tarefa 16 - TAD-Árvore Binária.pptx", pág. 8. */
	public LinkedBinaryTree<Character> criarArvoreBinaria() {
		LinkedBinaryTree<Character> tree = new LinkedBinaryTree<Character>();
		
		// (elemento, esquerda, direita, pai)
		BTNode<Character> raiz;
		BTNode<Character> a = new BTNode<Character>('/', null, null, null);
		BTNode<Character> b = new BTNode<Character>('+', null, null, null);
		BTNode<Character> c = new BTNode<Character>('*', null, null, null);
		BTNode<Character> d = new BTNode<Character>('+', null, null, null);
		BTNode<Character> e = new BTNode<Character>('*', null, null, null);
		BTNode<Character> f = new BTNode<Character>('6', null, null, null);
		BTNode<Character> g = new BTNode<Character>('+', null, null, null);
		BTNode<Character> h = new BTNode<Character>('3', null, null, null); 
		BTNode<Character> i = new BTNode<Character>('-', null, null, null);
		BTNode<Character> j = new BTNode<Character>('2', null, null, null); 
		BTNode<Character> k = new BTNode<Character>('3', null, null, null);
		BTNode<Character> l = new BTNode<Character>('-', null, null, null);		
		BTNode<Character> m = new BTNode<Character>('3', null, null, null);
		BTNode<Character> n = new BTNode<Character>('1', null, null, null);
		BTNode<Character> o = new BTNode<Character>('9', null, null, null);
		BTNode<Character> p = new BTNode<Character>('5', null, null, null);
		BTNode<Character> q = new BTNode<Character>('7', null, null, null);
		BTNode<Character> r = new BTNode<Character>('4', null, null, null);

		tree.addRoot('-');
		raiz = tree.root();
		
		raiz.setLeft(a);
		raiz.setRight(b);
		
		a.setLeft(c);
		a.setRight(d);
		a.setParent(raiz);
		
		b.setLeft(e);
		b.setRight(f);
		b.setParent(raiz);
		
		c.setLeft(g);
		c.setRight(h);
		c.setParent(a);
		
		d.setLeft(i);
		d.setRight(j);
		d.setParent(a);
		
		e.setLeft(k);
		e.setRight(l);
		e.setParent(b);
		
		f.setParent(b);
		
		g.setLeft(m);
		g.setRight(n);
		g.setParent(c);
		
		h.setParent(c);
		
		i.setLeft(o);
		i.setRight(p);
		i.setParent(d);
		
		j.setParent(d);
		k.setParent(e);
		
		l.setLeft(q);
		l.setRight(r);
		l.setParent(e);
		
		m.setParent(g);
		n.setParent(g);
		o.setParent(i);
		p.setParent(i);
		q.setParent(l);
		r.setParent(l);
		
		return tree;
	}
}
