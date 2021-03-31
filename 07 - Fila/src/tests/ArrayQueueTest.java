package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fila.ArrayQueue;
import fila.EmptyQueueException;

class ArrayQueueTest {
	@Test
	void filaInteiros() {  // Testa uma fila de numeros inteiros.
		ArrayQueue<Integer> fila = new ArrayQueue<Integer>(3);
		
		fila.enqueue(7);
		assertEquals("[7]", fila.toString(), "Deve imprimir [7]");
		
		fila.enqueue(10);
		assertEquals("[7, 10]", fila.toString(), "Deve imprimir [7, 10]");
		
		int apagar = fila.dequeue();
		assertEquals(7, apagar, "Deve desenfileirar 7");
		
		apagar = fila.dequeue();
		assertEquals(10, apagar, "Deve desenfileirar 10");
		assertEquals("[]", fila.toString(), "Deve imprimir []");
		
		assertTrue(fila.isEmpty());
		
		Assertions.assertThrows(EmptyQueueException.class, () -> { fila.dequeue(); });
	}
	
	@Test
	void filaStrings() {  // Testa uma fila de Strings.
		ArrayQueue<String> fila = new ArrayQueue<String>(3);
		
		fila.enqueue("7");
		assertEquals("[7]", fila.toString(), "Deve imprimir [7]");
		
		fila.enqueue("10");
		assertEquals("[7, 10]", fila.toString(), "Deve imprimir [7, 10]");
		
		assertEquals("7", fila.dequeue(), "Deve desenfileirar 7");
		
		assertEquals("10", fila.dequeue(), "Deve desenfileirar 10");
		assertEquals("[]", fila.toString(), "Deve imprimir []");
		
		assertTrue(fila.isEmpty());
		
		Assertions.assertThrows(EmptyQueueException.class, () -> { fila.dequeue(); });
	}
}

