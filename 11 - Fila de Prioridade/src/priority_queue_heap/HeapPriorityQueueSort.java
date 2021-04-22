
package priority_queue_heap;

import java.util.Arrays;

/** Método que ordena uma lista de números inteiros usando Fila de Prioridade usando Heap. */

public class HeapPriorityQueueSort {
	public static int[] sort(int vetor[]) {
		HeapPriorityQueue<Integer, Integer> fila = new HeapPriorityQueue<Integer, Integer>();
		
		for (int i=0; i < vetor.length; i++) {
			fila.insert(vetor[i], vetor[i]);
		}
		
		vetor = new int [vetor.length];
		
		for (int i=0; i < vetor.length; i++) {
			vetor[i] = fila.removeMin().getValue();
		}
		
		return vetor;
	}
	
	public static void main(String[] args) {
		int a[] = {5, 4, 3, 2, 1, 6};
		System.out.println(Arrays.toString(a));
		
		int b[] = sort(a);
		System.out.println(Arrays.toString(b));
	}
}
