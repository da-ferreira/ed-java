
package priority_queue;

import java.util.Comparator;

import commons.DefaultComparator;
import commons.Entry;
import commons.PriorityQueue;
import exceptions.EmptyPriorityQueueException;
import exceptions.InvalidKeyException;
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
	
	/**
	 * Define o comparador para fila de prioridades.
	 * @throws IllegalStateException: Caso a fila de prioridades não estiver vazia.
	 */
	public void setComparator(Comparator<Key> comparator) throws IllegalStateException {
		if (! isEmpty())
			throw new IllegalStateException("Priority queue is not empty");
		
		this.comparator = comparator;
	}
	
	public int size() {
		return entries.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public MyEntry<Key, Value> min() throws EmptyPriorityQueueException {
		if (size() == 0)
			throw new EmptyPriorityQueueException("The priority queue is empty");
		
		return entries.first().element();  // A menor chave está na primeira posição na lista de nós
	}
	
	public MyEntry<Key, Value> insert(Key key, Value value) throws InvalidKeyException {
		return null;
		/* --------- FAZER --------- */
	}
	
	protected void insertEntry(MyEntry<Key, Value> entry) {
		/* --------- FAZER --------- */
	}
	
	public MyEntry<Key, Value> removeMin() throws EmptyPriorityQueueException {
		if (size() == 0)
			throw new EmptyPriorityQueueException("The priority queue is empty");
		
		return entries.remove(entries.first());   // A menor chave está na primeira posição na lista de nós
	}
	
	protected boolean checkKey(Key key) throws InvalidKeyException {
		return true;
		/* --------- FAZER --------- */
	}
	
	@Override
	public String toString() {
		return entries.toString();
	}
}
     
  