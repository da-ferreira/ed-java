
package pilha;

/*
 * Uma interface é similar a um contrato, através dela podemos especificar
 * quais métodos as classes que implementam esta interface são obrigados a implementar.
 * 
 * O <Type> é um tipo (String, int, float, double etc) padrão que será passado na criação na stack.
 */

public interface Stack<Type> {
	/** @return a quantidade de elemento na pilha. */
	public int size();
	
	/** @return true se a pilha estiver vazia, caso contrário, false. */
	public boolean isEmpty();
	
	/**
	 * @return O elemento no topo da pilha.
	 * @throws EmptyStackException se a pilha estiver vazia.
	 */
	public Type top() throws EmptyStackException;
	
	/** @param element elemento a ser inserido na pilha. */
	public void push(Type element) throws FullStackException;  // insere um elemento na pilha.
	
	/**
	 * Remove o elemento no topo da pilha.
	 * @return o elemento removido.
	 * @throws EmptyStackException se a pilha estiver vazia.
	 */
	public Type pop() throws EmptyStackException;
}
