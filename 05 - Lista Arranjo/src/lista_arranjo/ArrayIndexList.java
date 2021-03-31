
package lista_arranjo;

/**
 * @author david-ferreira
 */

public class ArrayIndexList<Type> implements IndexList<Type> {
	private Type arranjo[];
	private int capacity = 16;  // ler linha 12.
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayIndexList() {  // Construtor
	   /* 
	    * Criando um arranjo inicial de 16 de tamanho, caso o usuario adicione
		* mais do que isso, o arranjo vai dobrando.
		* O "(Type[])" é um cast para que o arranjo "transforme" o objeto criado no Type passado.
		*/ 
		arranjo = (Type[]) new Object[capacity];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void add(Type element, int indice) throws IndexOutOfBoundsException {
		checkIndex(indice, size + 1);
		
		if (this.size == this.capacity) {
			capacity *= 2;  // Dobrando a capacidade da lista.
			
			@SuppressWarnings("unchecked")
			Type arranjo_2[] = (Type[]) new Object[capacity];
			
			for (int i=0; i < size; i++)
				arranjo_2[i] = arranjo[i];
			
			arranjo = arranjo_2;  // Passando a referencia do arranjo_2 para arranjo principal.
		}
		
		for (int i=size - 1; i >= indice; i--) {
			arranjo[i + 1] = arranjo[i];  // Deslocando os elemento para a direita.
		}
		
		arranjo[indice] = element;
		size++;
	}
	
	public Type get(int indice) throws IndexOutOfBoundsException {
		checkIndex(indice, size);
		return arranjo[indice];
	}
	
	public Type remove(int indice) throws IndexOutOfBoundsException {
		checkIndex(indice, size);
		
		Type removido = arranjo[indice];  // elemento que será removido.
		
		for (int i=indice; i < size - 1; i++)
			arranjo[i] = arranjo[i + 1];  // Jogando os elemento para a esquerda.
		
		size--;
		return removido;
	}
	
	public Type set(Type newElement, int indice) throws IndexOutOfBoundsException {
		checkIndex(indice, size);
		
		Type elemento_trocado = arranjo[indice];
		arranjo[indice] = newElement;
		
		return elemento_trocado;
	}
	
	protected void checkIndex(int indice, int tamanhoN) {  // Testa se um dado índice é válido, caso contrário, lança uma exceção.
		if (indice < 0 || indice >= tamanhoN)
			throw new IndexOutOfBoundsException("Indice inválido: " + indice);
	}
	
	public String toString() {
		if (size == 0)
			return "()";
		
		String lista_arranjo = "(";
		
		for (int i=0; i < size; i++)
			lista_arranjo += arranjo[i] + ", ";
		
		lista_arranjo = lista_arranjo.substring(0, lista_arranjo.length() - 2);  // Tirando ", " do final da string.
		
		return lista_arranjo + ")";
	}
}
  
