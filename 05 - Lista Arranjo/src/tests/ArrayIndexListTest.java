
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lista_arranjo.ArrayIndexList;

class ArrayIndexListTest {
	@Test
	void test() {
		ArrayIndexList<Integer> A = new ArrayIndexList<Integer>();
	
		assertEquals("()", A.toString());
		A.add(7, 0);
		assertEquals("(7)", A.toString());
		
		A.add(4, 0);
		assertEquals("(4, 7)", A.toString());
		assertEquals(new Integer(7), A.get(1));
	
		A.add(2, 2);
		assertEquals("(4, 7, 2)", A.toString());
	
		assertThrows(IndexOutOfBoundsException.class, () -> { A.get(3);});
	
		assertEquals(new Integer(7), A.remove(1));
		assertEquals("(4, 2)", A.toString());
	
		A.add(5, 1);
		assertEquals("(4, 5, 2)", A.toString());
	
		A.add(3, 1);
		assertEquals("(4, 3, 5, 2)", A.toString());
	
		A.add(9, 4);
		assertEquals("(4, 3, 5, 2, 9)", A.toString());
	
		assertEquals(new Integer(5), A.get(2));
		assertEquals("(4, 3, 5, 2, 9)", A.toString());
	
		assertEquals(new Integer(2), A.set(8, 3));
		assertEquals("(4, 3, 5, 8, 9)", A.toString());
	}
}
