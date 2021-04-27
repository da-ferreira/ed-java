
package ds_priority_queue.priority_queue_heap;

import java.util.Comparator;

import ds_priority_queue.commons.DefaultComparator;
import ds_priority_queue.commons.Entry;
import ds_priority_queue.commons.PriorityQueue;
import ds_priority_queue.complete_binary_tree.ArrayListCompleteBinaryTree;
import ds_priority_queue.exceptions.EmptyPriorityQueueException;
import ds_priority_queue.exceptions.InvalidKeyException;
import ds_priority_queue.position.Position;

public class HeapPriorityQueue<Key, Value> implements PriorityQueue<Key, Value> {
	protected ArrayListCompleteBinaryTree<MyEntry<Key, Value>> heap;  // Estrutura heap
	protected Comparator<Key> comparator;
	
	/** Cria um heap vazio com comparador padrão. */
	public HeapPriorityQueue() {
		heap = new ArrayListCompleteBinaryTree<MyEntry<Key, Value>>();
		comparator = new DefaultComparator<Key>();
	}
	
	/** Cria um heap vazio com comparador informado no parametro. */
	public HeapPriorityQueue(Comparator<Key> comparator) {
		heap = new ArrayListCompleteBinaryTree<MyEntry<Key, Value>>();
		this.comparator = comparator;
	}
	
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
	
	/**
	 * Define o comparador do heap
	 * @throws IllegalStateException Caso a fila de prioridades (heap) não esteja vazia.
	 */
	public void setComparator(Comparator<Key> comparator) throws IllegalStateException {
		if (! isEmpty())
			throw new IllegalStateException("Priority queue is not empty");
		
		this.comparator = comparator;
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		return heap.size() == 0;
	}
	
	public MyEntry<Key, Value> min() throws EmptyPriorityQueueException {
		if (isEmpty())
			throw new EmptyPriorityQueueException("The priority queue is empty");
		
		return heap.root().element();
	}
	
	public MyEntry<Key, Value> insert(Key key, Value value) throws InvalidKeyException {
		checkKey(key);
		
		MyEntry<Key, Value> newEntry = new MyEntry<Key, Value>(key, value);
		upHeap(heap.add(newEntry));
		
		return newEntry;
	}
	
	/** Realiza o up-Heap bubbling: Quando um elemento é inserido no final do heap
	 *  ele pode estar violando a regra do heap, regra: o filho é maior ou igual ao pai,
	 *  sendo assim, é necessário que ele troque de lugar com seu pai para respeitar a regra.
	 *  Repete o ciclo, agora com o pai e seu descendente, até que a violação acabe.
	 */  
	protected void upHeap(Position<MyEntry<Key, Value>> node) {
		Position<MyEntry<Key, Value>> parent;
		
		while (! heap.isRoot(node)) {
			parent = heap.parent(node);
			
			/* Se a chave do parent (nó pai do nó passado (node)) for menor ou igual a chave do nó passado (node)
			 * a regra do heap é respeitada (o pai é menor ou igual ao filho) e o loop é encerrado. Caso contrário,
			 * é feito uma troca (swap) entre o filho (node) e seu pai (parent). O ciclo se repete atribuindo ao nó node seu pai. 
			 * */
			if (comparator.compare(parent.element().getKey(), node.element().getKey()) <= 0)
				break;
			
			swap(parent, node);
			node = parent;
		}
	}
	
	public MyEntry<Key, Value> removeMin() throws EmptyPriorityQueueException {
		if (isEmpty())
			throw new EmptyPriorityQueueException("The priority queue is empty");
		
		MyEntry<Key, Value> min = heap.root().element();
		
		if (heap.size() == 1) {
			heap.remove();
		}
		else {
			heap.replace(heap.root(), heap.remove());  // Muda o elemento da raíz para o elemento do ultimo nó da lista, removendo o ultimo nó
			downHeap(heap.root()); 
		}
		
		return min;
	}
	
	/** Realiza o down-Heap bubbling: Quando acontece uma remoção em um heap (min-heap), é removido a raíz,
	 *  o menor elemento, e no lugar da raíz coloca-se o ultimo nó do heap (um swap entre a raíz e o ultimo nó).
	 *  Pode acontecer de a nova raíz violar a regra (o pai ser menor que o filho) do heap. Para resolver isso
	 *  basta trocar o pai com o menor dos filhos. */
	protected void downHeap(Position<MyEntry<Key, Value>> node) {
		while (heap.isInternal(node)) {  // Enquanto o nó (node) não for folha.
			Position<MyEntry<Key, Value>> smaller_son;
			
			if (! heap.hasRight(node)) {
				smaller_son = heap.left(node);
			}
			else if (comparator.compare(heap.left(node).element().getKey(), heap.right(node).element().getKey()) <= 0) {
				smaller_son = heap.left(node);  // A chave do filho da esquerda é menor ou igual a chave do filho da direita
			}
			else {
				smaller_son = heap.right(node);
			}
			
			/* Se o filho for menor que o pai, acontece uma troca (sawp) entre o filho e o pai */
			if (comparator.compare(smaller_son.element().getKey(), node.element().getKey()) < 0) {
				swap(smaller_son, node);
				node = smaller_son;
			}
			else {
				break;
			}
		}
	}
	
	/* MÉTODOS AUXILIARES */
	
	/** Troca os elementos de duas posições. */
	protected void swap(Position<MyEntry<Key, Value>> positionY, Position<MyEntry<Key, Value>> positionZ) {
		MyEntry<Key, Value> temp = positionY.element();
		
		heap.replace(positionY, positionZ.element());
		heap.replace(positionZ, temp);
	}
	
	/** Determina se uma chave é válida fazendo uma comparação com ela mesma,
	 *  se for possível compara-la, então nada acontece, caso contrario, é lançado uma InvalidKeyException. */
	protected void checkKey(Key key) throws InvalidKeyException {		
		try {
			comparator.compare(key, key); 
		}
		catch (ClassCastException error) {
			throw new InvalidKeyException("Invalid key: cannot be compared");
		}
	}
	
	@Override
	public String toString() {
		return heap.toString();
	}
}
