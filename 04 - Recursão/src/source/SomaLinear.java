
package source;

/**
 * @author ferreira
 */

public class SomaLinear {
	public static int somaLinear(int array[], int size) {
		if (size == 1) {
			return array[0];
		}
		else {
			return somaLinear(array, size - 1) + array[size - 1];
		}
	}
}
