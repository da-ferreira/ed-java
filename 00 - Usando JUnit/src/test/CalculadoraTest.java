
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import calculadora.Calculadora;

class CalculadoraTest {
	@Test
	void test() {
		Calculadora	calc = new Calculadora();
		
		// TDD: Desenvolvimento Orientado por Testes (Test Driven Development)
		assertEquals(2.0, calc.soma(1.0, 1.0), "Deve resultar em 2.0"); 
		assertEquals(1.0, calc.subtracao(2.0, 1.0), "Deve resultar em 1");
		assertEquals(4.0, calc.multiplicacao(2.0, 2.0), "Deve resultar em 4");
		assertEquals(4.0, calc.divisao(8.0, 2.0), "Deve resultar em 4");
		assertEquals(8.0, calc.exponenciacao(2.0, 3.0), "Deve resultar em 8");
	}
}
