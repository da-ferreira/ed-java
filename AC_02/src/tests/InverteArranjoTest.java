package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exercicio_04.InverteArranjo;
import tools.NodeStack;

class InverteArranjoTest {
	@Test
	void testaInverterArranjo() {
		NodeStack<Integer> arranjo = new NodeStack<Integer>();
		
		arranjo.push(7);
		arranjo.push(8);
		arranjo.push(9);
		arranjo.push(10);
		arranjo.push(11);
		arranjo.push(12);
		arranjo.push(13);
		
		assertEquals("[7, 8, 9, 10, 11, 12, 13]", arranjo.toString(), "Deve imprimir [7, 8, 9, 10, 11, 12, 13]");
	}

}
