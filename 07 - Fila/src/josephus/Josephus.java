
package josephus;

import fila.EmptyQueueException;
import fila.ArrayQueue;

/**
 * @author david-ferreira
 */

public class Josephus {
	public static <Type> Type gameJosephus(ArrayQueue<Type> queue, int k) {
		if (queue.isEmpty())
			throw new EmptyQueueException("The queue is empty");
		
		while (queue.size() > 1) {
			System.out.printf("Fila: %s, k: %d\n", queue.toString(), k);
			
			for (int i=0; i < k; i++) {
				// Jogando o elemento no começo para o final da fila.
				Type auxiliar = queue.dequeue();
				queue.enqueue(auxiliar); 
			}
			
			Type temp = queue.dequeue();  // Jogador removido na rodada.
			System.out.printf("%s foi removido.\n", temp.toString());
		}
		
		return queue.dequeue();  // Vencedor (unico jogador restante).
	}
	
	public static <Type> ArrayQueue<Type> buildQueue(Type array[]) {  // Preenche a fila.
		ArrayQueue<Type> queue = new ArrayQueue<Type>();
		
		for (int i=0; i < array.length; i++) {
			queue.enqueue(array[i]);
		}		
		
		return queue;
	}
	
	public static void main(String[] args) throws EmptyQueueException {
		String jogo1[] = { "Alice", "Bob", "Cindy", "Doug", "Ed", "Fred" };
		String jogo2[] = { "Gene", "Hope", "Irene", "Jack", "Kim", "Lance" };
		String jogo3[] = { "Mike", "Roberto" };
		
		System.out.println("Primeiro vencedor: " + gameJosephus(buildQueue(jogo1), 3) + "\n");
		System.out.println("Segundo vencedor: " + gameJosephus(buildQueue(jogo2), 10) + "\n");
		System.out.println("Terceiro vencedor: " + gameJosephus(buildQueue(jogo3), 7) + "\n");
	}
}
