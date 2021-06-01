
package estruturas;

import java.util.Scanner;
import static source.Main.line;
import static source.Main.escolhaInvalida;

import tad_fila_de_prioridade.commons.Entry;
import tad_fila_de_prioridade.commons.PriorityQueue;
import tad_fila_de_prioridade.priority_queue.SortedListPriorityQueue;
import tad_fila_de_prioridade.priority_queue_heap.HeapPriorityQueue;

public class FilaDePrioridade {
	public static void filaDePrioridade() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Fila de Prioridade =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(123, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Fila de Prioridade ~\n"
					+ "\n"
					+ "Uma fila de prioridade P é uma estrutura de dados que armazena elementos conforme sua prioridade.\n"
					+ "Cada elemento está vinculada a uma chave, onde a chave é usada para classificar a prioridade de um elemento.\n"
					+ "Os elementos são removidos de acordo com a noção de prioridade, não com a noção de índice/posição.\n"
					+ "\n"
					+ "Há dois métodos fundamentais que configura a fila de prioridade P:\n"
					+ "\n"
					+ "insert(k, v) -> Insere um elemento v com chave k em P\n"
					+ "removeMin() -> Remove e retorna o elemento com menor chave em P\n"
					+ ""
					+ "\n~ Fila de Prioridade usando Lista de Nodos ~\n"
					+ "\n"
					+ "Implementa P usando uma lista de nodos T onde guarda todas as entradas (par chave-valor).\n"
					+ "O elemento com menor chave está na primeira posição da lista de nodos.\n"
					+ "A inserção em P é ineficiente, pois, no pior caso, onde a nova entrada teria uma chave maior que\n"
					+ "a entrada com maior chave de P, seria necessário percorrer T inteiro para inserir no final.\n"
					+ "A remoção em P é feito pela remoção do primeiro elemento de T.\n"
					+ "\n"
					+ "A visualização dos elementos de P, nesta implementação, fica da seguinte forma: [(3, B), (5, A), (7, D), (9, C)]\n"
					+ "onde o par chave-valor (3, B) tem a menor chave.\n"
					+ ""
					+ "\n~ Fila de Prioridade usando Heap ~\n"
					+ "\n"
					+ "Implementa P usando a estrutura de dados Heap, onde os pares chave-valor são armazenados em uma árvore binária completa.\n"
					+ "Cada nó dessa árvore binária completa é armazenado em um arranjo T, onde segue as seguintes regras:\n"
					+ "\n"
					+ "É desconsiderado o índice 0, armazenando o nó raíz no índice 1 de T.\n"
					+ "Um dado nó v de T com índice j, se tiver um filho esquerdo ele terá o índice 2 * j.\n"
					+ "Um dado nó v de T com índice j, se tiver um filho direito ele terá o índice 2 * j + 1.\n"
					+ "Um dado nó x de T, que não é a raíz, com índice k, seu pai terá o índice k / 2 (divisão inteira).\n"
					+ "\n"
					+ "A inserção é feita ao final de T, armazenando uma entrada par chave-valor.\n"
					+ "Após a inserção, a árvore pode estar violando a regra do heap (o filho é maior ou igual ao pai),\n"
					+ "sendo assim, é necessário que ocorra um up-Heap bubbling, onde o filho troca de lugar com o pai,\n"
					+ "sucessivamente, até que T esteja seguindo a regra do heap.\n"
					+ "\n"
					+ "A remoção é feita removendo-se a raíz (o par chave-valor com menor chave) e, em seu lugar,\n"
					+ "é colocado o último nó de T. Após a remocão e troca é possível que a árvore esteja estar violando\n"
					+ "a regra do heap, sendo assim, é necessário que occora um down-Heap bubbling, onde o pai troca de lugar\n"
					+ "com o menor dos filhos, sucessivamente, até que T esteja seguindo a regra do heap.\n"
					+ "\n"
					+ "A visualização dos elementos de P, nesta implementação, fica da seguinte forma: [[(4, C), 1], [(5, A), 2], [(6, Z), 3]]\n"
					+ "onde cada par chave-valor, que está dentro dos parênteses, é seguido por seu índice correspondente dentro do arranjo T.\n"
					+ "";
				
				System.out.println(s);
				line(123, 0, 1);
				Thread.sleep(5000);
			}

			else if (escolha == 2) {
				while (true) {
					System.out.println("\n1. Testar Fila de Prioridade usando Lista de Nodos");
					System.out.println("2. Testar Fila de Prioridade usando Heap");
					System.out.println("3. Sair");
					System.out.print("\n>>> ");
					int opcao_tipo_de_fila = in.nextInt();
					
					if (opcao_tipo_de_fila == 1 || opcao_tipo_de_fila == 2) {
						PriorityQueue<Integer, String> fila_de_prioridade;
						
						if (opcao_tipo_de_fila == 1) {
							fila_de_prioridade = new SortedListPriorityQueue<Integer, String>();
							System.out.println("\nFila de prioridade usando Lista de Nodos criada onde sua chave é um número inteiro e seu valor é uma String.");
						}
						else {
							fila_de_prioridade = new  HeapPriorityQueue<Integer, String>();
							System.out.println("\nFila de prioridade usando Heap criada onde sua chave é um número inteiro e seu valor é uma String.");
						}
						
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
								
								fila_de_prioridade.insert(chave, valor);
								System.out.printf("\nPar chave-valor (%d, %s) inserido com sucesso!\n", chave, valor);
							}
							
							else if (opcao == 2) {
								if (! fila_de_prioridade.isEmpty()) {
									Entry<Integer, String> removido = fila_de_prioridade.removeMin();
									System.out.println("\nPar chave-valor " + removido.toString() + " removido com sucesso!");
								}
								else {
									System.out.println("\nA fila de prioridade está vazia.");
									Thread.sleep(1000);
								}
							}
							
							else if (opcao == 3) {
								System.out.println("\n" + fila_de_prioridade.toString());
							}
							
							else if (opcao == 4) {
								break;
							}
							
							else {
								escolhaInvalida();
							}
						}
					}
					
					else if (opcao_tipo_de_fila == 3) {
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
 