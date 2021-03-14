
package exercicio_04;

import tools.NodeStack;

/*
 * Ex 4b. Inverta os dados de um arranjo usando o TAD Pilha usando LSE.
 */

public class InverteArranjo {
	public static void inverter(int lista[]) {
		NodeStack<Integer> pilha = new NodeStack<Integer>();
		
		for (int i=0; i < lista.length; i++) {
			pilha.push(lista[i]);
		}
		
		for (int i=0; i < lista.length; i++) {
			lista[i] = pilha.pop();
		}
	}
}		
