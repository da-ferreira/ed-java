
package estruturas;

import java.util.Scanner;
import static source.Main.line;
import static source.Main.escolhaInvalida;
import tad_mapa_ordenado_usando_abb.source.BinarySearchTree;

public class MapaOrdenadoUsandoAbb {
	public static void mapaOrdenadoUsandoAbb() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Mapa Ordenado usando ABB =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(125, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Mapa Ordenado usando ABB ~\n"
					+ "\n"
					+ "Uma árvore binária de busca (ABB) é uma estrutura de dados que permite armazenar os elementos numa relação de ordem.\n"
					+ "Usando uma ABB, é possível implementar um mapa M, onde a relação de ordem é feito pelas chaves de cada elemento: as chaves\n"
					+ "da sub-árvore à esquerda é menor ou igual ao seu nó pai e as chaves da sub-árvore à direita é maior ou igual ao seu nó pai,\n"
					+ "para todo nó da ABB, exceto a raíz.\n"
					+ "\n"
					+ "Nesta implementação do mapa usando ABB, armazenam-se elementos somente em nós internos da árvore, com os nós extenos\n"
					+ "servindo como placeholders (marcadores de posição), sendo uma forma de facilitar os algoritmos de pesquisa/alteração.\n"
					+ "\n~ Inserção ~\n"
					+ "\n"
					+ "A inserção no mapa M é feita pelo método put(k, v) onde k é a chave e v é o valor da entrada.\n"
					+ "É percorrido a árvore ABB, partindo da raíz, até um nó externo, em busca do lugar ideal de inserção\n"
					+ "da nova entrada, seguindo a relação de ordem da árvore binária de busca.\n"
					+ ""
					+ "\n~ Remoção ~\n"
					+ "\n"
					+ "A remoção em M é feita pelo método remove(k), onde k é uma chave contida em alguma entrada de M.\n"
					+ "Internamente, a remoção na árvore é mais complexa, uma vez que não pode criar buracos na árvore.\n"
					+ "Dessa forma, há dois casos de remoção de um nó w na árvore binária de busca:\n"
					+ "\n"
					+ "Caso 1:\n"
					+ "     Se um dos filhos de w for um nó externo, por exemplo z, remove-se w e z, substituindo w pelo irmão de z.\n"
					+ "\n"
					+ "Caso 2:\n"
					+ "     Se os dois filhos de w forem internos, busca-se o primeiro nó interno y que segue w no percurso em-ordem.\n"
					+ "     O nó y será encontrado visitando o filho da direita de w e descendo a árvore seguindo o filho da esquerda\n"
					+ "     até encontrar um nó externo. Em seguida, pega x, que é o filho da esquerda de y. Salva-se w numa váriável\n"
					+ "     temporária t e coloca o elemento de y em w. É removido os nós x e y, substituindo y pelo irmão de x.\n"
					+ ""
					+ "\n~ Visualização ~\n"
					+ "\n"
					+ "Usando a representação de uma árvore ABB abaixo, com pares (chave, valor), onde [] representa um placeholder,\n"
					+ "há três forma de visualizar os elementos do mapa M:\n"
					+ "\n"
					+"           (7, A)     \n"
					+"            / \\      \n" 
					+"           /   \\     \n"
					+"       (6, B) (8, C)  \n"
					+"         / \\    / \\ \n"
					+"        [] []  [] []  \n"
					+"\n"
					+ "keySet() -> Retorna uma coleção com todas as chaves de M. No exemplo acima: [6, 7, 8].\n"
					+ "values() -> Retorna uma coleção com todos os valores de M. No exemplo acima: [B, A, C].\n"
					+ "entrySets() -> Retorna uma coleção com todas as entradas (par chave-valor) de M. No exemplo acima: [(6, B), (7, A), (8, C)].\n"
					+ "\n"
					+ "É usando o percurso em-ordem para as três formas, onde as chaves ficam em ordem crescente.\n"
					+ "";
				
				System.out.println(s);
				line(125, 0, 1);
				Thread.sleep(5000);
			}

			else if (escolha == 2) {
				BinarySearchTree<Integer, String> mapa_usando_abb = new BinarySearchTree<>();
				System.out.println("\nMapa ordenado usando ABB criado, onde a chave é um número inteiro e o valor é uma String.");
				Thread.sleep(1500);
				
				while (true) {
					System.out.println("\n1. Inserir um elemento");
					System.out.println("2. Remover um elemento");
					System.out.println("3. Visualizar elementos");
					System.out.println("4. Sair");
					System.out.print("\n>>> ");
					int opcao = in.nextInt();
					
					if (opcao == 1) {
						System.out.print("\nDigite um número inteiro para a chave: ");
						int chave = in.nextInt();
						in = new Scanner(System.in);
						System.out.print("Digite uma String para o valor: ");
						String valor = in.nextLine();
						
						String adicao = mapa_usando_abb.put(chave, valor);
						
						if (adicao == null) {
							System.out.printf("\nPar chave-valor (%d, %s) inserido com sucesso!\n", chave, valor);
						}
						else {
							System.out.printf("\nEntrada com par chave-valor (%d, %s) atualizada com sucesso para (%d, %s)!\n", chave, adicao, chave, valor);
						}
					}

					else if (opcao == 2) {
						if (! mapa_usando_abb.isEmpty()) {
							System.out.print("\nDigite a chave da entrada a ser removida (número inteiro): ");
							int chave_remover = in.nextInt();
							
							String removido = mapa_usando_abb.remove(chave_remover);
							
							if (removido != null) {
								System.out.printf("\nEntrada (%d, %s) removida com sucesso!\n", chave_remover, removido);
							}
							else {
								System.out.printf("\nNão há entrada com chave igual a %d! Tente novamente.\n", chave_remover);
								Thread.sleep(1000);
							}
						}
						else {
							System.out.println("\nO mapa ordenado usando ABB está vázio.");
							Thread.sleep(1000);
						}
					}

					else if (opcao == 3) {
						System.out.println("\nEntradas: " + mapa_usando_abb.entrySet().toString());
						System.out.println("Chaves:   " + mapa_usando_abb.keySet().toString());
						System.out.println("Valores:  " + mapa_usando_abb.values().toString());
					}

					else if (opcao == 4) {
						break;
					}

					else {
						escolhaInvalida();
					}
				}
			}

			else if (escolha == 3) {
				break;
			}
			
			else {
				escolhaInvalida();
			}
		}
	}
}
 