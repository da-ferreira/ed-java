
package estruturas;

import static source.Main.line;
import static source.Main.escolhaInvalida;
import java.util.Scanner;

import tad_fila.ArrayQueue;
import tad_fila.NodeQueue;
import tad_fila.Queue;


public class Fila {
	public static void fila() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Fila  =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(137, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Fila ~\n"
					+ "\n"
					+ "Uma fila F é uma estrutura de dados básica, que segue o principio FIFO (First-In, First-Out -> Primeiro a entrar, Primeiro a sair).\n"
					+ "Suporta dois métodos principais:\n"
					+ "enqueue(x) -> Insere um elemento x no final da fila.\n"
					+ "dequeue() -> Remove o elemento no início da fila.\n"
					+ ""
					+ "\n~ Fila usando Array ~\n"
					+ "\n"
					+ "Implementa F usando um array T, uma variável f, que representa o início da fila, e r, que representa o próximo espaço disponivel em T.\n"
					+ "Inicialmente f e r são iniciados com 0 (se F está vazio, f == r).\n"
					+ "f é incrementado em 1 quando se remove um elemento de F; r é incrementado em 1 quando se adiciona um novo elemento em F.\n"
					+ "f e r é incrementado de forma 'circular' de modo que quando chegam ao final de T possam voltar ao começo, se T não estiver cheio:\n"
					+ "f <- (f + 1) mod N\n"
					+ "r <- (r + 1) mod N\n"
					+ "Onde N é a capacidade da fila determinada pelo usuário na sua criação.\n"
					+ "Visualização de F: [x, y, z], onde x é o elemento no inicío da fila e z o último elemento adicionado.\n"
					+ ""
					+ "\n~ Fila usando Lista Simplesmente Encadeada (LSE) ~\n"
					+ "\n"
					+ "Implementa F usando LSE usando uma variável para referenciar o inicio da fila e outra para referenciar o fim.\n"
					+ "Visualização de F: [x, y, z], onde x é o elemento no inicío da fila e z o último elemento adicionado.\n"
					+ "";
				
				System.out.println(s);
				line(137, 0, 1);
				Thread.sleep(5000);
			}

			else if (escolha == 2) {
				while (true) {
					System.out.println("\n1. Testar Fila usando Array");
					System.out.println("2. Testar Fila usando Lista Simplesmente Encadeada");
					System.out.println("3. Sair");
					System.out.print("\n>>> ");
					int opcao1 = in.nextInt();
					
					if (opcao1 == 1 || opcao1 == 2) {
						Queue<Integer> fila;
						
						if (opcao1 == 1) {
							fila = new ArrayQueue<Integer>(100);
							System.out.println("\nFila usando array criada com a capacidade de 100 elementos.");
						}
						else {
							fila = new NodeQueue<Integer>();
						}
						
						while (true) {
							System.out.println("\n1. Inserir um elemento");
							System.out.println("2. Remover um elemento");
							System.out.println("3. Visualizar elementos");
							System.out.println("4. Sair");
							System.out.print("\n>>> ");
							int opcao2 = in.nextInt();
							
							if (opcao2 == 1) {
								System.out.print("\nDigite um número inteiro: ");
								int elemento = in.nextInt();
								fila.enqueue(elemento);
								System.out.printf("\nElemento %d adicionado com sucesso!\n", elemento);
							}
							
							else if (opcao2 == 2) {
								if (! fila.isEmpty()) {
									int removido = fila.dequeue();
									System.out.printf("\nElemento %d removido com sucesso!\n", removido);
								}
								else {
									System.out.println("\nA fila está vazia.");
									Thread.sleep(1000);
								}
							}
							
							else if (opcao2 == 3) {
								if (! fila.isEmpty())
									System.out.printf("\nO elemento %d está no início da fila.", fila.front());
								
								System.out.println("\nFila: " + fila.toString());
							}
							
							else if (opcao2 == 4) {
								break;
							}
							
							else {
								escolhaInvalida();
							}
						}
					}
					
					else if (opcao1 == 3) {
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
