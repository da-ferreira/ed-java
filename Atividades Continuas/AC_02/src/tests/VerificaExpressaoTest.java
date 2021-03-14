package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exercicio_04.VerificaExpressao;

class VerificaExpressaoTest {
	@Test
	void testaVerificaExpressao() {
		assertTrue(VerificaExpressao.verificar("()(( )){([( )])}"));
		assertTrue(VerificaExpressao.verificar("((( )(( )){([( )])}))"));
		assertTrue(VerificaExpressao.verificar("[(5 + x)/4 – 2*(y + z)]"));
		
		assertFalse(VerificaExpressao.verificar(")(( )){([( )])}"));
		assertFalse(VerificaExpressao.verificar("({[])}"));
		assertFalse(VerificaExpressao.verificar("("));
		
		assertTrue(VerificaExpressao.verificar("((5 + 2) / 3) * 2"));
		assertTrue(VerificaExpressao.verificar("{[(10 / 2) * 3] + 14} * 15"));
		assertTrue(VerificaExpressao.verificar("([](){})"));
		
		assertFalse(VerificaExpressao.verificar("((({{{[[[]]]}}}))"));
		assertFalse(VerificaExpressao.verificar("{5 + 2) + 3}"));
		assertFalse(VerificaExpressao.verificar("())"));
	}
}
