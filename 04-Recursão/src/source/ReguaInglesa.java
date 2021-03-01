
package source;

/**
 * @author ferreira
 */

public class ReguaInglesa {
	public static void main(String[] args) {
		drawRuler(3, 4);
		/*
		 * Regua de 3 polegadas com marca principal de tamanho 5:
		 *  ---- 0
		 *	-
		 * 	--
		 *	-
		 *	---
		 *	-
		 *	--
		 *	-
		 *	---- 1
		 *	-
		 *	--
		 *	-
		 *	---
		 *	-
		 *	--
		 *	-
		 *	---- 2
		 *	-
		 *	--
		 *	-
		 *	---
		 *	-
		 *	--
		 *	-
		 *	---- 3
		 */
	}

    /* Desenha uma quantidade length de traços, e se o numero passado for maior que 0
	 * desenha ele no final dos traços.
	 */
	public static void drawOneTick(int length, int number) {  
		for (int i=0; i < length; i++)
			System.out.print("-");
		
		if (number >= 0)
			System.out.printf(" %d", number);  // colocando os numeros na regua.
		
		System.out.println();  // pulando linha
	}
	
	public static void drawTicks(int length) {  // desenha uma marca (tick) com comprimento "length"
		if (length > 0) {
			drawTicks(length - 1);     // chama recursivamente as marcas da esquerda
			drawOneTick(length, -1);  // desenha a marca do meio
			drawTicks(length - 1);   // chama recursivamente as marcas da direita
		}
	}
	
	/*
	 * Desenha a regua.
	 * Recebe no primeiro parametro a quantidade de polegadas da regua, ou seja,
	 * quantas marcas principais terão.
	 * Recebe no segundo parametro o tamanho da marca principal, ou seja, da polegada.
	 */
	public static void drawRuler(int inch_size, int size_of_major_brand) {
		drawOneTick(size_of_major_brand, 0);  // desenha a primeira marca principal.
		
		for (int i=1; i <= inch_size; i++) {
			drawTicks(size_of_major_brand - 1);   // desenhando as marcas que ficam entre as polegadas.
			drawOneTick(size_of_major_brand, i);  // desenhando as marcas principais.
		}
	}
}
  
