
package estruturas;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import tad_dicionario.HashTableMultiMap;
import static source.Main.line;
import static source.Main.escolhaInvalida;

public class Dicionario {
	public static void dicionario() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Dicionário =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(107, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Dicionário ~\n"
					+ "\n"
					+ "Um dicionário D é uma estrutura de dados, similiar ao TAD Mapa, com a diferença\n"
					+ "que permite armazenar pares chave-valor com chaves iguais.\n"
					+ ""
					+ "\n~ Inserção ~\n"
					+ "\n"
					+ "A inserção em D é feita pelo método put(k, v), onde k é uma chave e v é o valor da entrada.\n"
					+ ""
					+ "\n~ Remoção ~\n"
					+ "\n"
					+ "A remoção em D é feita pelo método remove(entry) onde entry é uma entrada válida de D.\n"
					+ "Como o dicionário permite chaves iguais, para a remoção é utilizado o método get(k), que retorna uma\n"
					+ "entrada com chave igual a k (é escolhida uma entrada arbitrária entre as disponíveis com chave igual a k).\n"
					+ ""
					+ "\n~ Visualização ~\n"
					+ "\n"
					+ "Há duas formas de visualização dos elementos de D pelos seguintes métodos:\n"
					+ "\n"
					+ "entrySet() -> Retorna uma coleção com todas as entradas dos pares chave-valor em D.\n"
					+ "getAll(k) -> Retorna uma coleção com todas as entradas dos pares chave-valor com chave igual a k em D.\n"
					+ "";
				
				System.out.println(s);
				line(107, 0, 1);
				Thread.sleep(5000);
			}

			else if (escolha == 2) {
				HashTableMultiMap<Integer, String> dicionario = new HashTableMultiMap<Integer, String>();
				System.out.println("\nDicionário criado, onde a chave é um número inteiro e o valor é uma String.");
				
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
						
						dicionario.put(chave, valor);
						System.out.printf("\nPar chave-valor (%d, %s) inserido com sucesso!\n", chave, valor);
					}

					else if (opcao == 2) {
						if (! dicionario.isEmpty()) {
							System.out.print("\nDigite a chave da entrada a ser removida (número inteiro): ");
							int chave_remover = in.nextInt();
							
							Entry<Integer, String> entradaParaRemover = dicionario.get(chave_remover);
							
							if (entradaParaRemover != null) {
								dicionario.remove(entradaParaRemover);
								System.out.printf("\nEntrada (%d, %s) removida com sucesso!\n", entradaParaRemover.getKey(), entradaParaRemover.getValue());
							}
							else {
								System.out.printf("\nNão há entrada com chave igual a %d! Tente novamente.\n", chave_remover);
								Thread.sleep(1000);
							}
						}
						else {
							System.out.println("\nO dicionário está vázio.");
							Thread.sleep(1000);
						}
					}

					else if (opcao == 3) {
						System.out.println("\n1. Visualizar todos os pares chave-valor do dicionário");
						System.out.println("2. Visualizar todos os pares chave-valor de uma determinada chave");
						System.out.print("\n>>> ");
						int escolha_visualizacao = in.nextInt();
						
						if (escolha_visualizacao == 1) {
							System.out.println("\n" + dicionario.entrySet().toString());
						}
						else if (escolha_visualizacao == 2) {
							System.out.print("\nDigite a chave (número inteiro): ");
							int numero_chave = in.nextInt(); 
							LinkedList<Map.Entry<Integer, String>> entradas = (LinkedList<Entry<Integer, String>>) dicionario.getAll(numero_chave); 
							
							if (entradas != null) {
								System.out.println("\n" + entradas.toString());
							}
							else {
								System.out.printf("\nNão há entradas com chave igual a %d no dicionário.\n", numero_chave);
								Thread.sleep(1500);
							}
							
						}
						else {
							escolhaInvalida();
						}
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
