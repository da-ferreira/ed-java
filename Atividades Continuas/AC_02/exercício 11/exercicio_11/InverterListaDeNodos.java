
package exercicio_11;

import tools.NodePositionList;
import tools.Position;

/**
 * @author david-ferreira
 */

public class InverterListaDeNodos {
	public static <Type> void inverter(NodePositionList<Type> lista) {
		Position<Type> position_ultimo_no = lista.last();
		Type ultimo_no = lista.remove(position_ultimo_no);  // removendo o ultimo nó  
		lista.addFirst(ultimo_no);
		
		Position<Type> point = lista.first();  // pegando o primeiro no da lista.
		
		for (int i=0; i < lista.size() - 1; i++) {
			position_ultimo_no = lista.last();
			ultimo_no = lista.remove(position_ultimo_no);
			lista.addAfter(point, ultimo_no);
			
			point = lista.next(point);  // Pega o elemento depois do point, e assim por diante.
		}
	}
}
