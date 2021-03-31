
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import lista_duplamente_encadeada.DoublyLinkedList;
import lista_duplamente_encadeada.Node;

class DoublyLinkedListTest {
	@Test

	void test() {
		Node z, v;
		DoublyLinkedList list = new DoublyLinkedList();
		
		assertEquals("[]", list.toString(), "[]");
	
		z = new Node("BWI", null, null);
		list.addLast(z);
		assertEquals("[BWI]", list.toString(), "[BWI]");
	
		z = new Node("SFO", null, null);
		list.addLast(z);
		assertEquals("[BWI, SFO]", list.toString(), "[BWI, SFO]");
	
		z = new Node("JFK", null, null);
		list.addFirst(z);
		assertEquals("[JFK, BWI, SFO]", list.toString(), "[JFK, BWI, SFO]");
		
		v = list.getLast(); // Pega o último node.
		assertEquals("SFO", v.getElement(), "SFO");
	
		z = new Node("PVD", null, null);
		list.addBefore(v, z);
		assertEquals("[JFK, BWI, PVD, SFO]", list.toString(), "[JFK, BWI, PVD, SFO]");
	}
}
