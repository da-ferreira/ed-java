
package exercicio_04b;

public class NodeStack<Type> implements Stack<Type> {
	protected Node<Type> top;  // Referencia para o topo da pilha (cabeça da lista).
	protected int size;       // Tamanho da pilha.
	
	
	public NodeStack() {  // Construtor
		top = null;
		size = 0;
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public Type top() throws EmptyStackException {
		if (this.size == 0)
			throw new EmptyStackException("The stack is empty");
		
		return top.getElement();
	}

	public void push(Type newElement) {
		Node<Type> temp = new Node<Type>(newElement, top);
		
		top = temp;
		size++;
	}

	public Type pop() throws EmptyStackException {
		if (this.size == 0)
			throw new EmptyStackException("The stack is empty");
		
		Node<Type> temp = top;
		//Type auxiliar = temp.getElement();
		
		top = top.getNext();  // Passando o topo para o proximo elemento depois do antigo topo.
		temp.setNext(null);
		size--;
		
		return temp.getElement();	
	}
	
	public String toString() {
		if (this.size == 0)
			return "[]";
		
		String pilha = "[";		
		Node<Type> point = top;
		
		while (point != null) {
			pilha += point.getElement() + ", ";
			point = point.getNext();
		}
		
		pilha = pilha.substring(0, pilha.length() - 2);
		
		return pilha + "]";
	}
}


