
package priority_queue_heap;

import java.util.Comparator;

import commons.Entry;
import commons.PriorityQueue;
import complete_binary_tree.ArrayListCompleteBinaryTree;

public class HeapPriorityQueue<Key, Value> implements PriorityQueue<Key, Value> {
	protected ArrayListCompleteBinaryTree<MyEntry<Key, Value>> heap;  // Estrutura heap
	protected Comparator<Key> comparator;
	
	/** Classe interna definida dentro de outra classe externa (HeapPriorityQueue), onde
	 *  a classe interna tem relacionamento especial com a externa, podendo acessar seus membros privados. */
	protected static class MyEntry<Key, Value> implements Entry<Key, Value> {
		protected Key key;
		protected Value value;
		
		public MyEntry(Key key, Value value) {
			this.key = key;	
			this.value = value;
		}
		
		/* Métodos de acesso da classe MyEntry */
		public Key getKey() {
			return key;
		}
		
		public Value getValue() {
			return value;
		}	
		
		@Override
		public String toString() {
			return "(" + key + ", " + value + ")";
		}
	}
	
	
}
