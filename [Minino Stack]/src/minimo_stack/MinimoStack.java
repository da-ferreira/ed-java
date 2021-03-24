
package minimo_stack;

/**
 * O objeto do algoritmo é modificar a estrutura de dados
 * stack (pilha) de modo que o menor elemento, o método push, o método pop
 * e o método peek possa ser acessado em O(1). 
 * O elementos são adicionados em pares: o elemento e o menor elemento da pilha.
 * A pilha guardara apenas valores numericos (int, long, float, double etc).
 * @author david-ferreira
 */

public class MinimoStack<Type> {
	private Node<Type> header;  // Sentinela para a pilha.
	private int size;
	
	
	protected Type min(Type elementA, Type elementB) {
		if (elementA <= elementB)
			return elementA;
		
		return elementB;
	}
}
