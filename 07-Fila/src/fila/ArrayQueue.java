
package fila;

public class ArrayQueue<Type> implements Queue<Type> {
	protected Type queue[];   // Array onde será armazenado os elemento da fila.
	protected int front;      // Indice do primeiro elemento da fila.
	protected int nextEmpty;  // Indice para a proxima posicao livre na fila.
	protected int capacity;   // Tamanho da lista que será passado pelo usuario.
	
	public ArrayQueue() {
		/*
		 * Se o usuário criar uma fila sem tamanho fixo (capacity),
		 * a fila será criada com tamanho 1000.
		 */
		this(1000);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		queue = (Type[]) new Object[this.capacity]; // (Type[]) Cast unchecked.
	}
	
	public int size() {
		// Modo de calcular a quantidade de elementos, visto que a fila se comportar, internamente, de modo circular.
		return (capacity - front + nextEmpty) % capacity;   
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Type front() throws EmptyQueueException {
		if (size() == 0) {
			throw new EmptyQueueException("The queue is empty");
		}
		
		return queue[front];
	}
	
	public void enqueue(Type element) {
	   /* 
		* Lança uma exceção caso a fila já esteja cheia.
		* A fila nao deve atingir sua capacidade máxima, indo de até N - 1 elementos.
		* Caso atinja, ocorre erro, porque o nextEmpty vai parar na posicao 0, corroendo a fila.
		*/
		
		if (size() == this.capacity - 1) {
			throw new FullQueueException("The queue is full");
		}
		
		// Adicionando o novo elemento e incrementando o nextEmpty (proxima posicao livre).
		queue[nextEmpty] = element;  
		nextEmpty = (nextEmpty + 1) % capacity;
	}
	
	public Type dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("The queue is empty");
		}
		
		Type temp = queue[front];
		queue[front] = null;
		front = (front + 1) % capacity;
		
		return temp;
	}
	
	public String toString() {
		if (isEmpty())
			return "[]";
		
		String fila = "[";
		
		for (int i=front; i < nextEmpty; i++) {
			fila += this.queue[i] + ", ";
		}
		
		fila = fila.substring(0, fila.length() - 2) + "]";  // Tirando o ", " do final.		
		return fila;
	}
}
 
