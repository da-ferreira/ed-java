
package list_of_nodes;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Uma classe para iterar sobre a lista. Nenhuma cópia da lista é realizada
 */
public class ElementIterator<Type> implements Iterator<Type> {
	protected PositionList<Type> list;
	protected Position<Type> cursor;
	
	
	public ElementIterator(PositionList<Type> list) {
		/*
		 * Adiciona lista a sua variavel e coloca o cursor
		 * como null se a lista for vazia, caso contrario
		 * pega o primeiro elemento da lista.
		 */
		this.list = list;
		this.cursor = this.list.isEmpty() ? null : this.list.first();
	}
	
	public boolean hasNext() {  // Tem proximo?
		return cursor != null;
	}

	public Type next() throws NoSuchElementException {
		if (cursor == null)
			throw new NoSuchElementException("Cursor no next element");
		
		Type toReturn = cursor.element();
		
		// Se o cursor for o ultimo, recebe null, caso contrario, recebe o proximo cursor.
		cursor = (cursor == list.last()) ? null : list.next(cursor);  
		return toReturn;
	}
	
	 
	/*
	 * Lança um UnsupportedOperationException para todos os casos, porque
	 * a remoção não é suportada por este iterator.
	 */
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("removal is not supported");
	}
}
