
package ds_priority_queue.priority_queue;

import java.util.Comparator;

import ds_priority_queue.commons.DefaultComparator;
import ds_priority_queue.commons.Entry;
import ds_priority_queue.commons.PriorityQueue;
import ds_priority_queue.exceptions.EmptyPriorityQueueException;
import ds_priority_queue.exceptions.InvalidKeyException;
import list_of_nodes.NodePositionList;
import list_of_nodes.Position;

public class SortedListPriorityQueue<Key, Value> implements PriorityQueue<Key, Value> {
	protected NodePositionList<MyEntry<Key, Value>> entries;  // Lista de nós que guardará as entradas.
	protected Comparator<Key> comparator;
	
	/** Classe interna definida dentro de outra classe externa (SortedListPriorityQueue), onde
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
		checkKey(key);
		
		MyEntry<Key, Value> newEntry = new MyEntry<Key, Value>(key, value);
		insertEntry(newEntry);
		return newEntry;
	}
	
	/** Método auxiliar usado na inserção. */
	protected void insertEntry(MyEntry<Key, Value> entry) {
		if (entries.isEmpty()) {
			entries.addFirst(entry);  // Se a fila estiver vazia, insere a primeira entrada.
		}
		else if (comparator.compare(entry.getKey(), entries.last().element().getKey()) > 0) {
			entries.addLast(entry);  // Se a nova entrada tiver a chave maior que a ultima chave da fila, insere no final.
		}
		else {
			Position<MyEntry<Key, Value>> point = entries.first(); 
			
			/* Compara se a chave da nova entrada (entry) é maior que a chave no primeiro elemento
			 * da fila (point), se for, point avança para o proximo elemento e repete o ciclo.
			 */
			while (comparator.compare(entry.getKey(), point.element().getKey()) > 0) {
				point = entries.next(point);
			}
			
			/* Insere antes de point, pois a condição do while deu false,
			 * logo, a chave do elemento é menor ou igual a chave de point.
			 */
			entries.addBefore(point, entry); 
		}
	}
	
	public MyEntry<Key, Value> removeMin() throws EmptyPriorityQueueException {
		if (size() == 0)
			throw new EmptyPriorityQueueException("The priority queue is empty");
		
		return entries.remove(entries.first());   // A menor chave está na primeira posição na lista de nós
	}
	
	/** Determina se uma chave é válida fazendo uma comparação com ela mesma,
	 *  se for possível compara-la, então é válida, caso contrario, é inválida. */
	protected boolean checkKey(Key key) throws InvalidKeyException {
		boolean check;
		
		try {
			check = comparator.compare(key, key) == 0; 
		}
		catch (ClassCastException error) {
			throw new InvalidKeyException("Invalid key: cannot be compared");
		}
		
		return check;
	}
	
	@Override
	public String toString() {
		return entries.toString();
	}
}
     
  