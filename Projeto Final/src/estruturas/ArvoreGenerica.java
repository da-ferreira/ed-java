
package estruturas;

import static source.Main.line;
import static source.Main.escolhaInvalida;
import java.util.Scanner;

public class ArvoreGenerica {
	public static void arvoreGenerica() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Árvore Genérica =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(111, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Árvore Genérica ~\n"
					+ "\n"
					+ "Uma árvore genérica T é uma estrutura de dados não linear, onde armazena elementos de maneira hierárquica,\n"
					+ "ou seja, segue o padrão de árvores genealógicas, com elementos pai, filho, ancestral e descendente.\n"
					+ "Os elementos dessa árvore estão armazenados em nós, onde cada nó armazena uma referência para seu nó pai\n"
					+ "outra referência para seus filhos (em uma coleção) e seu respectivo elemento.\n"
					+ "\n"
					+ "Propriedades e características da árvore T:\n"
					+ "\n"
					+ "O elemento mais alto da árvore é chamando de raíz.\n"
					+ "Cada elemento dessa árvore tem um pai (exceto a raíz) e zero ou mais filhos.\n"
					+ "Se um nó v é filho de w em T e um nó f também é filho de w, v e f são irmãos.\n"
					+ "Se um nó não possui filhos ele é chamado de nó externo (ou nó folha).\n"
					+ "Se um nó possui zero ou mais filhos, ele é chamado de nó interno.\n"
					+ "Os filhos de um dado nó são estruturados em uma coleção.\n"
					+ "A profundidade de uma dado nó x é o número de ancestrais de x excluindo ele mesmo.\n"
					+ "A altura de uma dado nó x é o descendente de x com maior profundidade.\n"
					+ "A altura de uma árvore é a altura de sua raíz.\n"
					+ ""
					+ "\n~ Inserção ~\n"
					+ "\n"
					+ "As inserções em T, segue uma lógica de ligações manuais entre nós, ou seja, quando um nó x é inserido como filho\n"
					+ "de um nó w é feita ligações para que w tenha a referência de seu novo filho e x tenha a referência de seu pai.\n"
					+ ""
					+ "\n~ Remoção ~\n"
					+ "\n"
					+ "N/A\n"
					+ ""
					+ "\n~ Visualização ~\n"
					+ "\n"
					+ "A visualização dos elementos de T, da melhor forma, seria igual no exemplo abaixo, onde 5 é a raíz de T:\n"
					+ "\n"
					+"               5           \n"
					+"              /            \n"
					+"         [1, 2, 3]         \n"
					+"         /   \\  \\        \n"
					+"        /     \\  \\       \n"
					+"     [9, 8]    7  \\       \n"
					+"                   \\      \n"
					+"              [70, 77, 15] \n"
					+ "\n"
					+ "Mas, nessa implementação, há duas formas de visualizar os elementos de T usando caminhamentos:\n"
					+ "\n"
					+ "Caminhamento pré-fixado -> Percorre a raíz depois seus filhos, recursivamente.\n"
					+ "                           No exemplo acima ficaria: [5, 1, 9, 8, 2, 7, 3, 70, 77, 15]\n"
					+ "\n"
					+ "Caminhamento pós-fixado -> Percorre recursivamente as subárvores filhas, depois visita a raíz.\n"
					+ "                           No exemplo acima ficaria: [9, 8, 1, 7, 2, 70, 77, 15, 3, 5]\n"
					+ "";
				
				System.out.println(s);
				line(111, 0, 1);
				Thread.sleep(5000);
			}

			else if (escolha == 2) {
				break;
			}
			
			else {
				escolhaInvalida();
			}
		}
	}
}
