package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import deque.Deque;

class DequeTest {
	@Test
	void dequeInteiros() {
		Deque<Integer> deque = new Deque<Integer>();
		
		deque.addFirst(15);
		deque.addFirst(10);
		deque.addFirst(700);
		deque.addFirst(18);
		assertEquals("[18, 700, 10, 15]", deque.toString());
		
		deque.addEnd(88);
		deque.addEnd(-133);
		deque.addEnd(0);
		assertEquals("[18, 700, 10, 15, 88, -133, 0]", deque.toString());
		assertEquals(7, deque.size());
		
		assertEquals(new Integer(18), deque.peekFirst());
		assertEquals(new Integer(0), deque.peekEnd());
		
		deque.popEnd();
		assertEquals(new Integer(-133), deque.peekEnd());
		deque.popFirst();
		assertEquals(new Integer(700), deque.peekFirst());
		assertEquals(5, deque.size());
	}
}
