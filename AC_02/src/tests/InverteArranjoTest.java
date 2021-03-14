package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import exercicio_04.InverteArranjo;

class InverteArranjoTest {
	@Test
	void testaInverterArranjo() {
		int array[] = {1, 2, 3, 4, 5};
		
		assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(array), "Deve imprimir [1, 2, 3, 4, 5]");
		InverteArranjo.inverter(array);
		assertEquals("[5, 4, 3, 2, 1]", Arrays.toString(array), "Deve imprimir [5, 4, 3, 2, 1]");
		assertEquals(5, array[0], "Deve imprimir 5");
		
		int array1[] = {15, 14, 13, 12, 11};
		
		assertEquals("[15, 14, 13, 12, 11]", Arrays.toString(array1), "Deve imprimir [15, 14, 13, 12, 11]");
		InverteArranjo.inverter(array1);
		assertEquals("[11, 12, 13, 14, 15]", Arrays.toString(array1), "Deve imprimir [11, 12, 13, 14, 15]");
		assertEquals(11, array1[0], "Deve imprimir 11");
		
		int array2[] = {2, 4, 6};
		
		assertEquals("[2, 4, 6]", Arrays.toString(array2), "Deve imprimir [2, 4, 6]");
		InverteArranjo.inverter(array2);
		assertEquals("[6, 4, 2]", Arrays.toString(array2), "Deve imprimir [6, 4, 2]");
		assertEquals(6, array2[0], "Deve imprimir 6");
	}

}
