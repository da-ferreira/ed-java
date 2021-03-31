
package source;

/**
 * @author ferreira
 */

public class Fatorial {
	public static int recursiveFactorial(int numero) {
		if (numero == 0) {
			return 1;
		}
		else {
			return numero * recursiveFactorial(numero - 1);
		}
	}
}
