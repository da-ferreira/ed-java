
package testes;

import lista_circular_encadeada.CircularLinkedList;
import lista_circular_encadeada.Node;

public class Test {
	public static void main(String[] args) {
		Node um = new Node("CASA", null);
		Node dois = um;
		Node tres = new Node("CASA", null);
		
		// Testa-se as referencias de memorias, nao o conteudo de cada elemento.
		System.out.println(um == dois);  // true
		System.out.println(um == tres);  // false
		
		CircularLinkedList lista = new CircularLinkedList();
		
		lista.add(new Node("casa", null));
		lista.add(new Node("JOAO", null));
		lista.add(new Node("CORREIOS BOM", null));
		System.out.println(lista.toString());  // [...casa, CORREIOS BOM, JOAO...]
		System.out.println(lista.size());  // 3
		System.out.println(lista.getCursor().getElement());  // casa
		
		lista.remove();
		System.out.println(lista.toString());  // [...casa, JOAO...]
		System.out.println(lista.size());  // 2
		System.out.println(lista.getCursor().getElement());  // casa
		
		lista.advance();
		lista.remove();
		System.out.println(lista.toString());  // [...JOAO...]
		System.out.println(lista.size());  // 1
		System.out.println(lista.getCursor().getElement());  // JOAO
		
		lista.remove();
		System.out.println(lista.toString());  // []
		System.out.println(lista.size());  // 0
	}
}
