
package estruturas;

import java.util.Scanner;
import tad_lista_arranjo.ArrayIndexList;
import static source.Main.escolhaInvalida;
import static source.Main.line;

public class ListaArranjo {
	public static void listaArranjo() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Lista Arranjo =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(137, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Lista Arranjo ~\n"
					+ "\n"
					+ "Uma lista arranjo é uma coleção/vetor L de N elementos, onde cada elemento é acessado/armazenado\n"
					+ "no intervalo [0, N - 1], de modo que o primeiro elemento está no índice 0, o segundo no índice 1,\n"
					+ "o terceiro no índice 2 e assim por diante. O último elemento tem índice N-1.\n"
					+ ""
					+ "\n~ Inserção ~\n"
					+ "\n"
					+ "A inserção em L é feita pelo método add(x, i), onde adiciona-se um elemento x no índice i de L, tal que i >= 0 e i <= N.\n"
					+ ""
					+ "\n~ Remoção ~\n"
					+ "\n"
					+ "A remoção em L é feita pelo método método remove(i), onde i é o índice do elemento que se deseja remover em L, tal que i >= 0 e i <= N.\n"
					+ ""
					+ "\n~ Visualização ~\n"
					+ "\n"
					+ "A visualização dos elementos de L é feito dentro de parênteses e separando cada elemento por vírgula.\n"
					+ "Ex: [1, 2, 3, 4, 5]\n"
					+ "";
				
				System.out.println(s);
				line(137, 0, 1);
				Thread.sleep(5000);
			}
			
			else if (escolha == 2) {
				ArrayIndexList<Integer> list = new ArrayIndexList<Integer>();
				
				while (true) {
					System.out.println("\n1. Inserir um elemento");
					System.out.println("2. Remover um elemento");
					System.out.println("3. Visualizar elementos");
					System.out.println("4. Sair");
					System.out.print("\n>>> ");
					int opcao = in.nextInt();
					
					if (opcao == 1) {
						System.out.print("\nDigite um número inteiro: ");
						int elemento = in.nextInt();
						System.out.print("Digite a posição de inserção desse elemento na lista arranjo: ");
						int posicao = in.nextInt();
						
						list.add(elemento, posicao);
						
						System.out.printf("\nElemento %d adicionado com sucesso!\n", elemento);
					}
					
					else if (opcao == 2) {
						if (! list.isEmpty()) {
							System.out.print("\nDigite o índice do elemento a ser removido: ");
							int indice = in.nextInt();
						
							int removido = list.remove(indice);
							System.out.printf("\nElemento %d removido com sucesso!\n", removido);
						}
						else {
							System.out.println("\nA lista está vazia.");
							Thread.sleep(1000);
						}
					}
					
					else if (opcao == 3) {
						System.out.println("\n" + list.toString());
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
