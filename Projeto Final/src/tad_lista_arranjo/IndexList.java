
package tad_lista_arranjo;

/*
 * Uma interface é similar a um contrato, através dela podemos especificar
 * quais métodos as classes que implementam esta interface são obrigados a implementar.
 * 
 * O <Type> é um tipo (String, int, float, double etc) padrão que será passado na criação da lista arranjo.
 */

public interface IndexList<Type> {
	public int size();
	
	public boolean isEmpty();
	
	// Insere um elemento (element) no indice "i", caso i < 0 OU i > n - 1, lança um IndexOutOfBoundsException.
	public void add(Type element, int i) throws IndexOutOfBoundsException;
	
	// Retorna o elemento no indice "i" sem remove-lo, caso i < 0 OU i > n - 1, lança um IndexOutOfBoundsException.
	public Type get(int i) throws IndexOutOfBoundsException;
	
	// Remove o elemento no indice "i", caso i < 0 OU i > n - 1, lança um IndexOutOfBoundsException.
	public Type remove(int i) throws IndexOutOfBoundsException;
	
	// Troca o elemento no indice "i" por "newElement", caso i < 0 OU i > n - 1, lança um IndexOutOfBoundsException.
	public Type set(Type newElement, int i) throws IndexOutOfBoundsException;
}
