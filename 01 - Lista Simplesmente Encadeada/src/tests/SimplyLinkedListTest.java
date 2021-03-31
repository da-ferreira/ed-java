
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import lista_simplesmente_encadeada.EmptySimplyLinkedList;
import lista_simplesmente_encadeada.SimplyLinkedList;

class SimplyLinkedListTest {
	@Test
	void testAddHead() {
		SimplyLinkedList list = new SimplyLinkedList();

		assertEquals("[]", list.toString(), "Deve imprimir []");
		list.addHead("BOS");
		assertEquals("[BOS]", list.toString(), "Deve imprimir [BOS]");
		list.addHead("ATL");
		assertEquals("[ATL, BOS]", list.toString(), "Deve imprimir [ATL, BOS]");
		list.addHead("MSP");
		assertEquals("[MSP, ATL, BOS]", list.toString(), "Deve imprimir [MSP, ATL, BOS]");
		list.addHead("LAX");
		assertEquals("[LAX, MSP, ATL, BOS]", list.toString(), "Deve imprimir [LAX, MSP, ATL, BOS]");
	}
	
	@Test
	void testAddTail() {
		SimplyLinkedList list = new SimplyLinkedList();
		
		assertEquals("[]", list.toString(), "Deve imprimir []");
		list.addTail("MSP");
		assertEquals("[MSP]", list.toString(), "Deve imprimir [MSP]");
		list.addTail("ATL");
		assertEquals("[MSP, ATL]", list.toString(), "Deve imprimir [MSP, ATL]");
		list.addTail("BOS");
		assertEquals("[MSP, ATL, BOS]", list.toString(), "Deve imprimir [MSP, ATL, BOS]");
		list.addTail("MIA");
		assertEquals("[MSP, ATL, BOS, MIA]", list.toString(), "Deve imprimir [MSP, ATL, BOS, MIA]");

	}
	
	@Test
	void testRemoveFirst() {
		SimplyLinkedList list = new SimplyLinkedList();
	
		assertEquals("[]", list.toString(), "Deve imprimir []");
		list.addTail("MSP");
		assertEquals("[MSP]", list.toString(), "Deve imprimir [MSP]");
		list.addTail("BOS");
		assertEquals("[MSP, BOS]", list.toString(), "Deve imprimir [MSP, BOS]");
		list.removeFirst();
		assertEquals("[BOS]", list.toString(), "Deve imprimir [BOS]");
		list.removeFirst();
		assertEquals("[]", list.toString(), "Deve imprimir []");
		
		assertThrows(EmptySimplyLinkedList.class, () -> { list.removeFirst(); });
	}
}

