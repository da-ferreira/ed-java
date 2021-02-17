
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import arranjo.Arranjo;

class ArranjoTest {

	@Test
	void test() {
		Arranjo array = new Arranjo();
		int[] numeros = {940, 880, 830, 790, 750, 660, 650, 590, 510, 940};  // array que sera usado nos testes.
		
		// Testa se o menor é 510
		assertEquals(510, array.menor(numeros), "O menor deve ser 510");
		
		// Testa se o maior é o 940
		assertEquals(940, array.maior(numeros), "O maior deve ser 940");
		
		// Testa se a soma é 7540
		assertEquals(7540, array.soma(numeros), "A soma é 7540");
		
		// Testa quantidade de vezes que o numero 3 aparece
		assertEquals(0, array.repeticoes(numeros, 3), "3 aparece 0 vezes");
		
		// Testa quantidade de vezes que o numero 790 aparece
		assertEquals(1, array.repeticoes(numeros, 790), "790 aparece 1 vezes");
		
		// Testa quantidade de vezes que o numero 940 aparece
		assertEquals(2, array.repeticoes(numeros, 940), "940 aparece 2 vezes");
	}
}
