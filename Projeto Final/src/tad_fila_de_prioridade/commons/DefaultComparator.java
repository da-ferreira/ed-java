
package tad_fila_de_prioridade.commons;

import java.util.Comparator;

public class DefaultComparator<Type> implements Comparator<Type> {
	@SuppressWarnings("unchecked")
	public int compare(Type a, Type b) throws ClassCastException {
		return ((Comparable<Type>) a).compareTo(b);
	}
}
  