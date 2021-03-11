
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fila.EmptyQueueException;
import fila.NodeQueue;

class NodeQueueTest {
	Object o;
	static final NodeQueue<Integer> a = new NodeQueue<Integer>();

	@Test
	void test() throws EmptyQueueException {
		assertEquals("[]", a.toString(), "Fila vazia");
	
		a.enqueue(1);
		assertEquals("[1]", a.toString(), "Deve resultar [1]");
	
		a.enqueue(2);
		assertEquals("[1, 2]", a.toString(), "Deve resultar [1, 2]");
	
		assertEquals(new Integer(1), a.dequeue(), "Deve resultar 1");
		assertEquals("[2]", a.toString(), "Deve resultar [2]");
	
		assertEquals(new Integer(2), a.dequeue(), "Deve resultar 2");
		assertEquals("[]", a.toString(), "Deve resultar []");
	
		assertThrows(EmptyQueueException.class, () -> { a.dequeue(); });
	}
}

