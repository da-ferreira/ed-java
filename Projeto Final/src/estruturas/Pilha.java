
package estruturas;

import java.util.Scanner;
import tad_pilha.ArrayStack;
import tad_pilha.NodeStack;
import tad_pilha.Stack;

import static source.Main.line;
import static source.Main.escolhaInvalida;

public class Pilha {
	public static void pilha() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Pilha  =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(129, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Pilha ~\n"
					+ "\n"
					+ "Uma pilha P é uma estrutura de dados básica, que segue o principio LIFO (First In, Last Out -> Primeiro a entrar, último a sair).\n"
					+ "Suporta dois métodos principais:\n"
					+ "push(x) -> insere um elemento x no topo da pilha.\n"
					+ "pop() -> remove o elemento do topo da pilha.\n"
					+ ""
					+ "\n~ Pilha usando Array ~\n"
					+ "\n"
					+ "Implementa P usando um array T e uma variável top para indicar o topo da pilha.\n"
					+ "Inicialmente top inicia com -1 para informar que a pilha está vazia. Conforme é adicionado elementos\n"
					+ "em P, top é incrementado em 1. Nesta implementação é necessário ter um limite pré-fixado da quantidade de elementos na piha.\n"
					+ "Caso esse limite não seja passado, é usado, por padrão, o limite de 1000 elementos.\n"
					+ "A visualização dos elementos de P, nesta implementação, fica da seguinte forma: [x, y, z],\n"
					+ "onde z é o elemento no topo da pilha, ou seja, o último a ser adicionado.\n"
					+ ""
					+ "\n~ Pilha usando Lista Simplesmente Encadeada (LSE) ~\n"
					+ "\n"
					+ "Implementa P usando LSE e uma váriavel top para indicar o topo da pilha.\n"
					+ "Inicialmente top aponta para null, indicando que a pilha está vazia.\n"
					+ "Numa inserção de um elemento x, cria-se um nó para x e faz top apontar para x.\n"
					+ "A visualização dos elementos de P, nesta implementação, fica da seguinte forma: [z, y, x],\n"
					+ "onde z é o elemento no topo da pilha, ou seja, o último a ser adicionado.\n"
					+ "";
				
				System.out.println(s);
				line(129, 0, 1);
				Thread.sleep(5000);
			}
			
			else if (escolha == 2) {
				while (true) {
					System.out.println("\n1. Testar Pilha usando Array");
					System.out.println("2. Testar Pilha usando Lista Simplesmente Encadeada");
					System.out.println("3. Sair");
					System.out.print("\n>>> ");
					int opcao1 = in.nextInt();
					
					if (opcao1 == 1 || opcao1 == 2) {
						Stack<Integer> pilha;
						
						if (opcao1 == 1) {
							pilha = new ArrayStack<Integer>(100);
							System.out.println("\nPilha usando array criada com a capacidade de 100 elementos.");
						}
						else {
							pilha = new NodeStack<Integer>();
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
								pilha.push(elemento);
								System.out.printf("\nElemento %d adicionado com sucesso!\n", elemento);
							}
							
							else if (opcao2 == 2) {
								if (! pilha.isEmpty()) {
									int removido = pilha.pop();
									System.out.printf("\nElemento %d removido com sucesso!\n", removido);
								}
								else {
									System.out.println("\nA pilha está vazia.");
									Thread.sleep(1000);
								}
							}
							
							else if (opcao2 == 3) {
								if (! pilha.isEmpty())
									System.out.printf("\nO elemento %d está no topo da pilha.", pilha.top());
								
								System.out.println("\nPilha: " + pilha.toString());
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
