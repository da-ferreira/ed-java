
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import lista_de_nodos.NodePositionList;
import lista_de_nodos.Position;

class NodePositionListTest {
	@Test
	void test() {
		NodePositionList<Integer> l = new NodePositionList<Integer>();
	
		assertEquals("[]", l.toString(), "[]");
	
		l.addFirst(8);
		assertEquals("[8]", l.toString(), "[8]");
	
		Position<Integer> p1 = l.first();
		assertEquals(new Integer(8), p1.element(), "8");
		assertEquals("[8]", l.toString(), "[8]");
	
		l.addAfter(p1, 5);
		assertEquals("[8, 5]", l.toString(), "[8, 5]");
	
		Position<Integer> p2 = l.next(p1);
		assertEquals(new Integer(5), p2.element(), "5");
		assertEquals("[8, 5]", l.toString(), "[8, 5]");
	
		l.addBefore(p2, 3);
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
	
		Position<Integer> p3 = l.previous(p2);
		assertEquals(new Integer(3), p3.element(), "3");
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
	
		l.addFirst(9);
		assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");
	
		p2 = l.last();
		assertEquals(new Integer(5), p2.element(), "5");
		assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");
	
		assertEquals(new Integer(9), l.remove(l.first()), "9");
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
	
		assertEquals(new Integer(3), l.set(p3, 7), "3");
		assertEquals("[8, 7, 5]", l.toString(), "[8, 7, 5]");
	
		l.addAfter(l.first(), 2);
		assertEquals("[8, 2, 7, 5]", l.toString(), "[8, 2, 7, 5]");
	}
}
