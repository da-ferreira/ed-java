
package teste;

import source.SomaLinear;

import java.util.Arrays;

import source.InverterArray;

public class Test {
	public static void main(String[] args) {
		int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println(SomaLinear.somaLinear(vetor, vetor.length));
		
		vetor = InverterArray.inverteArray(vetor, 0, vetor.length - 1);
		System.out.println(Arrays.toString(vetor));
	}
}
