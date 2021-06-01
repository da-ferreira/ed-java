
package estruturas;

import java.util.Scanner;
import static source.Main.line;
import static source.Main.escolhaInvalida;

import tad_mapa.commons.Entry;
import tad_mapa.source.HashTableMap;

public class Mapa {
	public static void mapa() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Mapa =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(111, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Mapa ~\n"
					+ "\n"
					+ "Um mapa M é uma estrutura de dados que armazena elementos que podem ser encontrados rapidamente usando chaves.\n"
					+ "Cada elemento de M está num par chave-valor chamado de entrada. O mapa permite somente chaves únicas.\n"
					+ "Todas as entradas do mapa M está num arranjo T de tamanho N (o valor de N é determinado pelo usuário).\n"
					+ "\n"
					+ "Para mapear uma chave K para seu devido lugar em T, é usado a Função Hash, que é composta de dois métodos:\n"
					+ "\n"
					+ "Código Hash: Mapeia a chave K para um número inteiro.\n"
					+ "Funçao de Compressão: Mapeia o código hash para um inteiro no intervalo [0, N-1].\n"
					+ "\n"
					+ "A implementação de M usa o código hash padrão de cada objeto no Java (hashCode)\n"
					+ "e a função de compressão usa o método MAD (multiplicação-adição-divisão):\n"
					+ "\n"
					+ "O método MAD mapeia um inteiro i para:\n"
					+ "\n"
					+ "[(ai + b) mod P] mod N, onde:\n"
					+ "\n"
					+ "N -> tamanho do arranjo de buckets.\n"
					+ "p -> número primo maior que N.\n"
					+ "a -> fator de escala.\n"
					+ "b -> fator de deslocamento (shift).\n"
					+ "\n"
					+ "Onde a e b são inteiros escolhidos aleatoriamente num intervalo [0, P - 1], com a > 0.\n"
					+ ""
					+ "\n~ Inserção ~\n"
					+ "\n"
					+ "A inserção em M é feita pelo método put(k, v), onde k é a chave e v é o valor da entrada.\n"
					+ "Se M já contém uma entrada com chave k, é substituido o valor da entrada pelo novo valor v.\n"
					+ ""
					+ "\n~ Remoção ~\n"
					+ "\n"
					+ "A remoção em M é feita pelo método remove(k), onde k é uma chave contida em alguma entrada de M.\n"
					+ ""
					+ "\n~ Visualização ~\n"
					+ "\n"
					+ "A visualização dos elementos de M é feito por 3 métodos:\n"
					+ "\n"
					+ "keySet() -> Retorna uma coleção com todas as chaves de M. Ex: {7, 8, 9}.\n"
					+ "values() -> Retorna uma coleção com todos os valores de M. Ex: {A, B, C}.\n"
					+ "entrySets() -> Retorna uma coleção com todas as entradas (par chave-valor) de M. Ex: {(7, A), (8, B), (9, C)}.\n"
					+ "";
				
				System.out.println(s);
				line(111, 0, 1);
				Thread.sleep(5000);
			}

			else if (escolha == 2) {
				HashTableMap<Integer, String> map = new HashTableMap<>();
				System.out.println("\nMapa criado com capacidade para 1000 entradas, onde a chave é um número inteiro e o valor é uma String.");
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
						
						String adicao = map.put(chave, valor);
						
						if (adicao == null) {
							System.out.printf("\nPar chave-valor (%d, %s) inserido com sucesso!\n", chave, valor);
						}
						else {
							System.out.printf("\nEntrada com par chave-valor (%d, %s) atualizada com sucesso para (%d, %s)!\n", chave, adicao, chave, valor);
						}
					}

					else if (opcao == 2) {
						if (! map.isEmpty()) {
							System.out.print("\nDigite a chave da entrada a ser removida (número inteiro): ");
							int chave_remover = in.nextInt();
							
							String removido = map.remove(chave_remover);
							
							if (removido != null) {
								System.out.printf("\nEntrada (%d, %s) removida com sucesso!\n", chave_remover, removido);
							}
							else {
								System.out.printf("\nNão há entrada com chave igual a %d! Tente novamente.\n", chave_remover);
								Thread.sleep(1000);
							}
						}
						else {
							System.out.println("\nO mapa está vázio.");
							Thread.sleep(1000);
						}
					}

					else if (opcao == 3) {
						System.out.println("\nEntradas: " + toStringentrySets(map));
						System.out.println("Chaves:   " + toStringkeySet(map));
						System.out.println("Valores:  " + toStringvalues(map));
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
	
	/** Retorna a string da coleção de entradas no mapa. */
	public static String toStringentrySets(HashTableMap<Integer, String> map) {
		Iterable<Entry<Integer, String>> entradas = map.entrySet();
		String format = "{";
		
		for (Entry<Integer, String> entry : entradas)
			format += entry.toString() + ", ";
		
		if (map.isEmpty())
			return "{}";
		
		return format.substring(0, format.length() - 2) + "}";
	}
	
	/** Retorna a string da coleção de chaves no mapa. */
	public static String toStringkeySet(HashTableMap<Integer, String> map) {
		Iterable<Entry<Integer, String>> chaves = map.entrySet();
		String format = "{";
		
		for (Entry<Integer, String> keys : chaves)
			format += keys.getKey().toString() + ", ";
		
		if (map.isEmpty())
			return "{}";
		
		return format.substring(0, format.length() - 2) + "}";
	}
	
	/** Retorna a string da coleção de valores no mapa. */
	public static String toStringvalues(HashTableMap<Integer, String> map) {
		Iterable<Entry<Integer, String>> valores = map.entrySet();
		String format = "{";
		
		for (Entry<Integer, String> values : valores)
			format += values.getValue().toString() + ", ";
		
		if (map.isEmpty())
			return "{}";
		
		return format.substring(0, format.length() - 2) + "}";
	}
}
 