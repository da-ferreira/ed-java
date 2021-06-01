
package estruturas;

import java.util.Scanner;
import static source.Main.line;
import static source.Main.escolhaInvalida;
import tad_mapa_ordenado_usando_avl.source.AVLTreeMap;

public class MapaOrdenadoUsandoAvl {
	public static void mapaOrdenadoUsandoAvl() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Mapa Ordenado usando AVL =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(129, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Mapa Ordenado usando AVL ~\n"
					+ "\n"
					+ "Uma árvore AVL é uma árvore binária de busca, porém, tem mecanismos que mantém a árvore balanceada, evitando, conforme\n"
					+ "os elementos que estão numa relação de ordem são inseridos (as chaves no caso do mapa), que a estrutura da árvore fique\n"
					+ "linear, para que a busca/alteração dos elementos não seja similiar à uma estrutura de dados linear (como a lista).\n"
					+ "\n"
					+ "A regra principal para manter equilibrada a árvore AVL é a propriedade altura/balanceamento: para cada nó interno v de\n"
					+ "uma árvore AVL T, o valor absoluto da diferença entre as alturas dos filhos de v seja no máximo 1.\n"
					+ "\n"
					+ "Quando acontece uma inserção/remoção na árvore, algum nó pode estar violando a propriedade altura/balanceamento.\n"
					+ "Neste caso, é usado um método para reestruturar a árvore, ou seja, para rebalancear a árvore, de forma que todos os\n"
					+ "nós estejam respeitando a propriedade. O método usado é o restructure(x), onde x é um nó desbalanceado da árvore.\n"
					+ "\n"
					+ "restructure(x) -> faz se y o nó pai de x e z o nó pai de y. Depois disso, segue os 4 passos abaixo:\n"
					+ "\n"
					+ "                1. Faça (a, b, c), da esquerda para direita (em-ordem) a lista de nós x, y, z, e faça (T0 , T1, T2, T3),\n"
					+ "                   da esquerda para a direita (em-ordem), a lista das quatro subárvores de x, y e z não enraizadas em x, y ou z.\n"
					+ "\n"
					+ "                2. Substitua a subárvore enraizada em z por uma nova subárvore enraizada em b.\n"
					+ "\n"
					+ "                3. Faça a o filho esquerdo de b e T0 e T1 as subárvores esquerda e direita de a, respectivamente.\n"
					+ "\n"
					+ "                4. Faça c o filho direito de b e T2 e T3 as subárvores esquerda e direita de c, respectivamente.\n"
					+ "\n"
					+ "Com essa estrutura é possível implementar um mapa M, mantendo um bom balaceamento da árvore binária.\n"
					+ ""
					+ "\n~ Inserção ~\n"
					+ "\n"
					+ "A inserção no mapa M é feita pelo método put(k, v) onde k é a chave e v é o valor da entrada.\n"
					+ "É percorrido a árvore AVL, partindo da raíz, até um nó externo, em busca do lugar ideal para a inserção,\n"
					+ "seguindo a relação de ordem da árvore binária de busca. Após a inserção é percorrido a árvore, do nó pai do\n"
					+ "nó inserido até a raíz da árvore, em busca de nós desbalanceados. Se encontrar, usa-se o método restructure(x).\n"
					+ ""
					+ "\n~ Remoção ~\n"
					+ "\n"
					+ "A remoção em M é feita pelo método remove(k), onde k é uma chave contida em alguma entrada de M.\n"
					+ "Internamente, na árvore, segue-se o mesmo modelo de remoção da árvore binária de busca, onde tem dois\n"
					+ "casos de remoção de um determinado nó w:\n"
					+ "\n"
					+ "Caso 1:\n"
					+ "     Se um dos filhos de w for um nó externo, por exemplo z, remove-se w e z, substituindo w pelo irmão de z.\n"
					+ "\n"
					+ "Caso 2:\n"
					+ "     Se os dois filhos de w forem internos, busca-se o primeiro nó interno y que segue w no percurso em-ordem.\n"
					+ "     O nó y será encontrado visitando o filho da direita de w e descendo a árvore seguindo o filho da esquerda\n"
					+ "     até encontrar um nó externo. Em seguida, pega x, que é o filho da esquerda de y. Salva-se w numa váriável\n"
					+ "     temporária t e coloca o elemento de y em w. É removido os nós x e y, substituindo y pelo irmão de x.\n"
					+ "\n"
					+ "Após a remoção, é percorrido a árvore, do nó pai do nó removido, até a raíz, em busca de\n"
					+ "nós desbalanceados. Se encontrar, usa-se o método restructure(x).\n"
					+ ""
					+ "\n~ Visualização ~\n"
					+ "\n"
					+ "Usando a representação de uma árvore AVL abaixo, com pares (chave, valor), onde [] representa um placeholder\n"
					+ "(marcador de posição), há três forma de visualizar os elementos do mapa M:\n"
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
				line(129, 0, 1);
				Thread.sleep(5000);
			}

			else if (escolha == 2) {
				AVLTreeMap<Integer, String> mapa_usando_avl = new AVLTreeMap<>();
				System.out.println("\nMapa ordenado usando AVL criado, onde a chave é um número inteiro e o valor é uma String.");
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
						
						String adicao = mapa_usando_avl.put(chave, valor);
						
						if (adicao == null) {
							System.out.printf("\nPar chave-valor (%d, %s) inserido com sucesso!\n", chave, valor);
						}
						else {
							System.out.printf("\nEntrada com par chave-valor (%d, %s) atualizada com sucesso para (%d, %s)!\n", chave, adicao, chave, valor);
						}
					}

					else if (opcao == 2) {
						if (! mapa_usando_avl.isEmpty()) {
							System.out.print("\nDigite a chave da entrada a ser removida (número inteiro): ");
							int chave_remover = in.nextInt();
							
							String removido = mapa_usando_avl.remove(chave_remover);
							
							if (removido != null) {
								System.out.printf("\nEntrada (%d, %s) removida com sucesso!\n", chave_remover, removido);
							}
							else {
								System.out.printf("\nNão há entrada com chave igual a %d! Tente novamente.\n", chave_remover);
								Thread.sleep(1000);
							}
						}
						else {
							System.out.println("\nO mapa ordenado usando AVL está vázio.");
							Thread.sleep(1000);
						}
					}

					else if (opcao == 3) {
						System.out.println("\nEntradas: " + mapa_usando_avl.entrySet().toString());
						System.out.println("Chaves:   " + mapa_usando_avl.keySet().toString());
						System.out.println("Valores:  " + mapa_usando_avl.values().toString());
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
 