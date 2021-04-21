
package ds_priority_queue.person;

import java.util.Comparator;

/** Comparador externo baseado no nome da pessoa (lexicograficamente). */
public class PessoaComparator implements Comparator<Pessoa> {
	public int compare(Pessoa p1, Pessoa p2) {
		return p1.getNome().compareTo(p2.getNome());
	}
}
