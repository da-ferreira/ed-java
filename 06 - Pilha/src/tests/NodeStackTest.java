
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import pilha.EmptyStackException;
import pilha.NodeStack;

class NodeStackTest {
	Object o;
	static final NodeStack<Integer> a = new NodeStack<Integer>();

	@Test
	void pilhaInteiros() {
		a.push(7);
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");
	
		a.push(9);
		assertEquals("[9, 7]", a.toString(), "Deve imprimir [9, 7]");
	
		a.push(1);
		assertEquals("[1, 9, 7]", a.toString(), "Deve imprimir [1, 9, 7]");
	
		assertEquals(new Integer(1), a.pop(), "Deve ter desempilhado 1");
		assertEquals("[9, 7]", a.toString(), "Deve imprimir [9, 7]");
	
		assertEquals(new Integer(9), a.pop(), "Deve ter desempilhado 9");
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");
	
		assertEquals(new Integer(7), a.pop(), "Deve ter desempilhado 7");
		assertEquals("[]", a.toString(), "Deve imprimir []");
	
		assertTrue(a.isEmpty());
	
		assertThrows(EmptyStackException.class, () -> { a.pop(); });
	}
}
