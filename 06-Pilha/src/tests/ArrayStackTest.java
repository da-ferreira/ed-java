
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pilha.ArrayStack;
import pilha.EmptyStackException;
import pilha.FullStackException;

class ArrayStackTest {
	@Test
	void pilhaInteiros() {  // Testa uma pilha de inteiros
		ArrayStack<Integer> pilha = new ArrayStack<Integer>(3);
		
		pilha.push(7);
		assertEquals("[7]", pilha.toString(), "Deve imprimir [7]");
	
		pilha.push(9);
		assertEquals("[7, 9]", pilha.toString(), "Deve imprimir [7, 9]");
	
		pilha.push(1);
		assertEquals("[7, 9, 1]", pilha.toString(), "Deve imprimir [7, 9, 1]");
	
		Assertions.assertThrows(FullStackException.class, () -> { pilha.push(2); });
		
		// se colocar pilha.pop() direto no assertEquals dá erro de ambiguidade
		int apagar = pilha.pop();
		assertEquals(1, apagar, "Deve ter desempilhado 1");
		assertEquals("[7, 9]", pilha.toString(), "Deve imprimir [7, 9]");
		
		apagar = pilha.pop();
		assertEquals(9, apagar, "Deve ter desempilhado 9");
		assertEquals("[7]", pilha.toString(), "Deve imprimir [7]");
		
		apagar = pilha.pop();
		assertEquals(7, apagar, "Deve ter desempilhado 7");
		assertEquals("[]", pilha.toString(), "Deve imprimir []");
				
		assertTrue(pilha.isEmpty());
	
		Assertions.assertThrows(EmptyStackException.class, () -> { pilha.pop(); });
	}
	
	@Test
	void pilhaStrings() {  // Testa uma pilha de Strings
		ArrayStack<String> pilha = new ArrayStack<String>(3);
		
		pilha.push("7");
		assertEquals("[7]", pilha.toString(), "Deve imprimir [7]");
	
		pilha.push("9");
		assertEquals("[7, 9]", pilha.toString(), "Deve imprimir [7, 9]");
	
		pilha.push("1");
		assertEquals("[7, 9, 1]", pilha.toString(), "Deve imprimir [7, 9, 1]");
	
		Assertions.assertThrows(FullStackException.class, () -> { pilha.push("2"); });
		
		assertEquals("1", pilha.pop(), "Deve ter desempilhado 1");
		assertEquals("[7, 9]", pilha.toString(), "Deve imprimir [7, 9]");
		
		assertEquals("9", pilha.pop(), "Deve ter desempilhado 9");
		assertEquals("[7]", pilha.toString(), "Deve imprimir [7]");
		
		assertEquals("7", pilha.pop(), "Deve ter desempilhado 7");
		assertEquals("[]", pilha.toString(), "Deve imprimir []");
				
		assertTrue(pilha.isEmpty());
	
		Assertions.assertThrows(EmptyStackException.class, () -> { pilha.pop(); });
	}
}
 
