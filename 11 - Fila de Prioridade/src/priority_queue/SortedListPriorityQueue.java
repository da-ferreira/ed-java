
package priority_queue;

import java.util.Comparator;

import commons.DefaultComparator;
import commons.Entry;
import commons.PriorityQueue;
import list_of_nodes.NodePositionList;

public class SortedListPriorityQueue<Key, Value> implements PriorityQueue<Key, Value> {
	protected NodePositionList<MyEntry<Key, Value>> entries;  // Lista de nós que guardará as entradas.
	protected Comparator<Key> comparator;
	
	/** Classe interna definida dentro de outra classe externa (SortedListPriorityQueue),
	 *  onde a classe interna tem relacionamento especial com a externa, podendo acessar
	 *  seus membros privados. */
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
	
	/** Cria uma fila de prioridades com um comparador padrão e uma lista de nós. */
	public SortedListPriorityQueue() {
		entries = new NodePositionList<MyEntry<Key, Value>>();
		comparator = new DefaultComparator<Key>();
	}
	
	/** Cria uma fila de prioridades com um comparador informado no parametro. */
	public SortedListPriorityQueue(Comparator<Key> comparator) {
		entries = new NodePositionList<MyEntry<Key, Value>>();
		this.comparator = comparator;
	}
	
	/** Cria uma fila de prioridades com uma lista de nós e comparador informados no parametro. */
	public SortedListPriorityQueue(NodePositionList<MyEntry<Key, Value>> list, Comparator<Key> comparator) {
		entries = list;
		this.comparator = comparator;
	}
	
	/*
	 
	 ve se a exceção deve ser criada.
	 
	public void setComparator(Comparator<Key> comparator) throws IllegalStateException {
		
	}
	
	*/
	
	public int size() {
		return entries.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
}
     
  