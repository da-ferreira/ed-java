
package estruturas;

import java.util.Scanner;
import static source.Main.line;
import static source.Main.escolhaInvalida;

public class Grafos {
	public static void grafos() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Grafos =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(129, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Grafos ~\n"
					+ "\n"
					+ "Um grafo G é uma forma de representar objetos, chamados de vértices (ou nós), com ligações entre pares de vértices, chamados\n"
					+ "de arestas (ou arcos). As arestas de G pode ser dirigidas ou não. Quando, em uma aresta (u, v), existir uma ligação assimétrica\n"
					+ "de u para v, ou seja, a relação é somente de u para v, não o contrário, a aresta é dita dirigida. Se, em uma aresta (u, v),\n"
					+ "existir uma ligação simétrica de u para v, ou seja, a relação é de u para v e vice-versa, a aresta é dita não dirigida.\n"
					+ "\n"
					+ "Propriedades/características de um grafo:\n"
					+ "\n"
					+ "-> Se o grafo possui somente arestas dirigidas, é um grafo dirigido (ou um dígrafo)\n"
					+ "-> Se o grafo possui somente arestas não dirigidas, é uma grafo não dirigido\n"
					+ "-> Se o grafo possui arestas dirigidas e não dirigidas, é uma grafo misto\n"
					+ "-> Em uma aresta k com vértices (u, v), (u, v) é chamado de vértices finais (ou pontos finais) da aresta k\n"
					+ "-> Em uma aresta dirigida, seu primeiro vértice final é sua origem, e o outro é seu destino\n"
					+ "-> Dois vértices são adjacentes, se eles forem vértices finais da mesma aresta\n"
					+ "-> Uma aresta k é dita incidente de um vértice u se u for um dos vértices finais de k\n"
					+ "-> O grau de um vértice u é o número de vértices incidentes a u\n"
					+ "-> O grau de entrada de um vértice v é o número de arestas incidentes em v\n"
					+ "-> O grau de saída de um vértice v é o número de arestas incidentes de v\n"
					+ "-> Duas arestas podem ser paralelas se ambas tiverem o mesmo vértice final\n"
					+ "-> Uma aresta forma um laço self se seus vértices finais coincidirem\n"
					+ "-> Grafos que não contém arestas paralelas nem laços self são chamados de grafos simples\n"
					+ "";
				
				System.out.println(s);
				line(129, 0, 1);
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
 