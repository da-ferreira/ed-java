
package pilha;

public class ArrayStack<Type> implements Stack<Type> {
	protected int size;  // tamanho da pilha que podera ser passada pelo usuário.
	protected Type stack[];  // arranjo que será usado para implementar a pilha.
	protected int top = -1;  // indice do topo da pilha (quando ela estiver vazia top == -1).
	
	public ArrayStack() {
		/*
		 * Se o usuário criar a pilha sem um valor de tamanho (size)
		 * determinado, a pilha será criada com tamanho igual a 1000.
		 * 
		 * this() chama o construtor com parametros.
		 * sobrecargas (um pilar do polimorfismo)
		 */
		this(1000);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int size_stack) {
		size = size_stack;
		stack = (Type[]) new Object[size];  // (Type[]) é o cast, o arranjo tem que ser considerado como seu tipo passado. 
	}
	
	/** @return a quantidade de elemento na pilha. */
	public int size() {
		return top + 1;
	}
	
	/** @return true se a pilha estiver vazia, caso contrário, false. */
	public boolean isEmpty() {
		return top == -1;
	}
	
	/**
	 * @return O elemento no topo da pilha.
	 * @throws EmptyStackException se a pilha estiver vazia.
	 */
	public Type top() throws EmptyStackException {
		if (top == -1)
			throw new EmptyStackException("The stack is empty");
		
		return stack[top];
	}
	
	/** @param element elemento a ser inserido na pilha. */
	public void push(Type element) throws FullStackException {
		if (size() == size)
			throw new FullStackException("The stack is full");
		
		top++;
		stack[top] = element;
	}
	
	/**
	 * Remove o elemento no topo da pilha.
	 * @return o elemento removido.
	 * @throws EmptyStackException se a pilha estiver vazia.
	 */
	public Type pop() throws EmptyStackException {
		if (top == -1)
			throw new EmptyStackException("The stack is empty");
		
		Type temp = (Type) stack[top];
		stack[top] = null;  // garbage collector.
		top--;
		
		return temp;
	}
	
	public String toString() {
		if (top == -1)
			return "[]";
		
		String stack_to_string = "[";
		
		for (int i=0; i <= top; i++) {
			stack_to_string += stack[i] + ", ";
		}
		
		stack_to_string = stack_to_string.substring(0, stack_to_string.length() - 2);  // tirando o ", " do final.
		
		return stack_to_string + "]";
	}
}


