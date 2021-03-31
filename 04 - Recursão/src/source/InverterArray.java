
package source;

/**
 * @author ferreira
 */

public class InverterArray {
	public static int[] inverteArray(int array[], int i, int j) {  // i = inicio, j = length
		if (i < j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			
			inverteArray(array, i + 1, j - 1);
		}
		
		return array;
	}
}
