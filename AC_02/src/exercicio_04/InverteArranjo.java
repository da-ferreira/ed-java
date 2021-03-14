
package exercicio_04;

import tools.NodeStack;

/*
 * Ex 4b. Inverta os dados de um arranjo usando o TAD Pilha usando LSE.
 */

public class InverteArranjo {
	public <Type> NodeStack<Type> inverter(NodeStack<Type> lista) {
		NodeStack<Type> newList = new NodeStack<Type>(); 
		
		for (int i=0; i < lista.size(); i++) {
			newList.push(lista.pop());
		}
		
		return newList;
	}
}
