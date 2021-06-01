
package tad_mapa_ordenado_usando_avl.tad_mapa_ordenado_abb.commons;

import java.util.Comparator;

public class DefaultComparator<Type> implements Comparator<Type> {
	@SuppressWarnings("unchecked")
	public int compare(Type a, Type b) throws ClassCastException {
		return ((Comparable<Type>) a).compareTo(b);
	}
}
  