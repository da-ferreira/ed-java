
package estruturas;

import java.util.Scanner;
import tad_lista_de_nodos.NodePositionList;
import static source.Main.escolhaInvalida;
import static source.Main.line;

public class ListaDeNodos {
	public static void listaDeNodos() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Lista de Nodos =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(119, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Lista de Nodos ~\n"
					+ "\n"
					+ "Uma lista de nodos (ou nós) L é uma coleção de nós, onde cada nó armazena um elemento, uma referência para\n"
					+ "o nó anterior e uma referência para o próximo nó. É usado a abstração de posição para representar um nó.\n"
					+ "Nesta implementação, é usada duas sentinelas, header e trailer, para representar o ínicio e o fim da lista.\n"
					+ ""
					+ "\n~ Inserção ~\n"
					+ "\n"
					+ "Há 4 formas de inserir um novo elemento em L:\n\n"
					+ "addFirst(x) -> Insere um elemento x no ínicio de L.\n"
					+ "addLast(x) -> Insere um elemeneto x no final de L.\n"
					+ "addBefore(p, x) -> Insere um elemento x antes da posição p de L.\n"
					+ "addAfter(p, x) -> Insere um elemento x depois da posição p de L.\n"
					+ ""
					+ "\n~ Remoção ~\n"
					+ "\n"
					+ "A remoção em L é feita pelo método remove(x), onde x é a posição de determinado elemento. Remove-se e retorna\n"
					+ "o elemento e anula a posição x, apontando a referência dos nós anterior e próximo de x para nulo (null).\n"
					+ ""
					+ "\n~ Visualização ~\n"
					+ "\n"
					+ "A visualização dos elementos de L é: [x, y, z], onde x, y, z são os elementos referentes as posições inseridas em L.\n"
					+ "";
				
				System.out.println(s);
				line(119, 0, 1);
				Thread.sleep(5000);
			}

			else if (escolha == 2) {
				NodePositionList<Integer> lista = new NodePositionList<Integer>();
				
				while (true) {
					System.out.println("\n1. Inserir um elemento");
					System.out.println("2. Remover um elemento");
					System.out.println("3. Visualizar elementos");
					System.out.println("4. Sair");
					System.out.print("\n>>> ");
					int opcao = in.nextInt();
					
					if (opcao == 1) {
						int insercao;
						
						do {
							System.out.println("\n1. Inserir no início da lista");
							System.out.println("2. Inserir no final da lista");
							System.out.print("\n>>> ");
							insercao = in.nextInt();
							
							if (insercao != 1 && insercao != 2) {
								escolhaInvalida();
							}
							
						} while (insercao != 1 && insercao != 2);
						
						System.out.print("\nDigite um número inteiro: ");
						int elemento = in.nextInt();
						
						if (insercao == 1) {
							lista.addFirst(elemento);
						}
						else {
							lista.addLast(elemento);
						}
						
						System.out.printf("\nElemento %d adicionado com sucesso!\n", elemento);
					}

					else if (opcao == 2) {
						if (! lista.isEmpty()) {
							int remocao;
							
							do {
								System.out.println("\n1. Remover no início da lista");
								System.out.println("2. Remover no final da lista");
								System.out.print("\n>>> ");
								remocao = in.nextInt();
								
								if (remocao != 1 && remocao != 2) {
									escolhaInvalida();
								}
								
							} while (remocao != 1 && remocao != 2);
							
							int removido;
							
							if (remocao == 1) {
								removido = lista.remove(lista.first());
							}
							else {
								removido = lista.remove(lista.last());
							}
							
							System.out.printf("\nElemento %d removido com sucesso!\n", removido);
						}
						else {
							System.out.println("\nA lista está vazia.");
							Thread.sleep(1000);
						}
					}

					else if (opcao == 3) {
						System.out.println("\n" + lista.toString());
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
