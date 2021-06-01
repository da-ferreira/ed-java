
package estruturas;

import static source.Main.line;
import static source.Main.escolhaInvalida;
import java.util.Scanner;

import tad_arvore_binaria.lista_de_nodos.NodePositionList;
import tad_arvore_binaria.source.BTNode;
import tad_arvore_binaria.source.LinkedBinaryTree;

public class ArvoreBinaria {
	public static void arvoreBinaria() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n-= TAD Árvore Binária =-");
			System.out.println("\n1. Definição");
			System.out.println("2. Testar");
			System.out.println("3. Sair");
			System.out.print("\n>>> ");
			int escolha = in.nextInt();
						
			if (escolha == 1) {
				line(111, 1, 0);
				
				String s = ""
				    + ""
					+ "\n\n~ Definição geral do TAD Árvore Binária ~\n"
					+ "\n"
					+ "Uma árvore binária T é uma estrutura de dados, onde cada nó de T possui no máximo 2 filhos.\n"
					+ "Cada nó filho é chamado de filho da esquerda ou filho da direita, seguindo uma ordem em que o\n"
					+ "filho da esquerda precede o da direita na ordenação dos filhos de um nó.\n"
					+ "\n"
					+ "Os nós dessa árvore tem um campo de referência para seu nó pai (nulo se for a raíz), outro para o\n"
					+ "filho da esquerda (nulo se não tiver filho à esquerda), outro para o filho da direita (nulo se não\n"
					+ "tiver filho à direita) e um espaço para armazenar seu elemento.\n"
					+ ""
					+ "\n~ Inserção ~\n"
					+ "\n"
					+ "A inserção em T é feita através de 2 métodos de inserções:\n"
					+ "\n"
					+ "insertLeft(x, y) -> Insere um elemento y à esquerda do nó x, onde x não tem filho à esquerda.\n"
					+ "insertRight(x, y) -> Insere um elemento y à direita do nó x, onde x não tem filho à direita.\n"
					+ ""
					+ "\n~ Remoção ~\n"
					+ "\n"
					+ "A remoção em T é feita através do método remove(x) onde x é um nó com zero ou um filho.\n"
					+ ""
					+ "\n~ Visualização ~\n"
					+ "\n"
					+ "Exemplo de árvore binária, onde 5 é a raíz:\n"
					+ "\n"
					+"                   5        \n"
					+"                  / \\      \n"
					+"                 /   \\     \n"
					+"                7     3     \n"
					+"               / \\   / \\  \n"
					+"              1   9 8  20   \n"
					+"                   /    \\  \n"
					+"                  6      4  \n"
					+ "\n"
					+ "Há três formas de visualizar os elementos da árvore binária T usando caminhamentos:\n"
					+ "\n"
					+ "Caminhamento pré-fixado -> Visita recursivamente a raíz, o filho à esquerda e o filho à direita.\n"
					+ "                           No exemplo acima ficaria: [5, 7, 1, 9, 3, 8, 6, 20, 4]\n"
					+ "\n"
					+ "Caminhamento interfixado -> Visita recursivamente o filho à esquerda, a raíz e o filho à direita.\n"
					+ "                            No exemplo acima ficaria: [1, 7, 9, 5, 6, 8, 3, 20, 4]\n"
					+ "\n"
					+ "Caminhamento pós-fixado -> Visita recursivamente o filho à esquerda, o filho à direita depois a raíz.\n"
					+ "                           No exemplo acima ficaria: [1, 9, 7, 6, 8, 4, 20, 3, 5]\n"
					+ "";
				
				System.out.println(s);
				line(111, 0, 1);
				Thread.sleep(5000);
			}

			else if (escolha == 2) {
				LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
				System.out.println("\nÁrvore binária criada para testes com números inteiros! Tente não repeti-los :)");
				
				while (true) {
					System.out.println("\n1. Inserir um elemento");
					System.out.println("2. Remover um elemento");
					System.out.println("3. Visualizar elementos");
					System.out.println("4. Sair");
					System.out.print("\n>>> ");
					int opcao = in.nextInt();
					
					if (opcao == 1) {
						if (tree.size() == 0) {
							System.out.printf("\nA árvore binária está vazia. Digite um número inteiro para a raíz: ");
							int raiz = in.nextInt();
							tree.addRoot(raiz);
							System.out.printf("\nRaíz com elemento %d adicionada com sucesso!\n", raiz);
							
							continue;
						}
						
						System.out.println("\n1. À esquerda de um nó");
						System.out.println("2. À direita de um nó");
						System.out.print("\n>>> ");
						int posicao = in.nextInt();
						
						if (posicao == 1) {
							NodePositionList<BTNode<Integer>> nodes = nosExternosDaEsquerda(tree);
							
							System.out.print("\nEscolha o nó: ");
							mostrarNodes(nodes);
							System.out.print("\n>>> ");
							int no_escolhido = in.nextInt();
							
							BTNode<Integer> no_procurado = toTake(nodes, no_escolhido);
							
							if (no_procurado != null) {  // Nó achado, pegar o numero com o usuario para inserir e adiciná-lo a esquerda
								System.out.print("\nDigite um número inteiro: ");
								int elemento = in.nextInt();
								
								tree.insertLeft(no_procurado, elemento);
								System.out.printf("\nElemento %d adicionado com sucesso à esquerda do nó com elemento %d!\n", elemento, no_escolhido);
							}
							else {
								System.out.printf("\nNão há nó com valor %d disponível para inserção! Tente novamente\n", no_escolhido);
								Thread.sleep(1500);
							}
						}
						else if (posicao == 2){
							NodePositionList<BTNode<Integer>> nodes = nosExternosDaDireita(tree);
							
							System.out.print("\nEscolha o nó: ");
							mostrarNodes(nodes);
							System.out.print("\n>>> ");
							int no_escolhido = in.nextInt();
							
							BTNode<Integer> no_procurado = toTake(nodes, no_escolhido);
							
							if (no_procurado != null) {  // Nó achado, pegar o numero com o usuario para inserir e adiciná-lo a direita
								System.out.print("\nDigite um número inteiro: ");
								int elemento = in.nextInt();
								
								tree.insertRight(no_procurado, elemento);
								System.out.printf("\nElemento %d adicionado com sucesso à direita do nó com elemento %d!\n", elemento, no_escolhido);
							}
							else {
								System.out.printf("\nNão há nó com valor %d disponível para inserção! Tente novamente\n", no_escolhido);
								Thread.sleep(1500);
							}
						}
						else {
							escolhaInvalida();
						}
					}

					else if (opcao == 2) {
						if (! tree.isEmpty()) {
							NodePositionList<BTNode<Integer>> nosRemoviveis = nosParaRemover(tree);
							
							System.out.print("\nEscolha o nó: ");
							mostrarNodes(nosRemoviveis);
							System.out.print("\n>>> ");
							int no_escolhido = in.nextInt();
							
							BTNode<Integer> no_procurado = toTake(nosRemoviveis, no_escolhido);
							
							if (no_procurado != null) {
								tree.remove(no_procurado);
								System.out.printf("\nNó com elemento %d removido com sucesso!\n", no_escolhido);
							}
							else {
								System.out.printf("\nNão há nó com valor %d disponível para remoção! Tente novamente\n", no_escolhido);
								Thread.sleep(1500);
							}
						}
						else {
							System.out.println("\nA árvore binária está vazia.");
							Thread.sleep(1000);
						}
					}

					else if (opcao == 3) {
						System.out.println("\nCaminhamento pré-fixado:  " + tree.toStringPreOrder());
						System.out.println("Caminhamento interfixado: " + tree.toStringInOrder());
						System.out.println("Caminhamento pós-fixado:  " + tree.toStringPostOrder());
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
	
	/** Retorna todos os nós que não tem filho à esquerda. */
	public static NodePositionList<BTNode<Integer>> nosExternosDaEsquerda(LinkedBinaryTree<Integer> tree) {
		Iterable<BTNode<Integer>> nodes = tree.positionsInOrder();
		NodePositionList<BTNode<Integer>> nodesLeft = new NodePositionList<>();
		
		for (BTNode<Integer> node: nodes) {
			if (! tree.hasLeft(node))
				nodesLeft.addLast(node);
		}
		
		return nodesLeft;
	}
	
	/** Retorna todos os nós que não tem filho à direita. */
	public static NodePositionList<BTNode<Integer>> nosExternosDaDireita(LinkedBinaryTree<Integer> tree) {
		Iterable<BTNode<Integer>> nodes = tree.positionsInOrder();
		NodePositionList<BTNode<Integer>> nodesRight = new NodePositionList<>();
		
		for (BTNode<Integer> node: nodes) {
			if (! tree.hasRight(node))
				nodesRight.addLast(node);
		}
		
		return nodesRight;
	}
	
	/** Retorna todos os nós possiveis para remoção: nós com zero ou um filho. */
	public static NodePositionList<BTNode<Integer>> nosParaRemover(LinkedBinaryTree<Integer> tree) {
		Iterable<BTNode<Integer>> nodes = tree.positionsInOrder();
		NodePositionList<BTNode<Integer>> nodesToRemove = new NodePositionList<>();
		
		for (BTNode<Integer> node: nodes) {
			if ((tree.isExternal(node)) || (tree.hasLeft(node) && ! tree.hasRight(node)) || (!tree.hasLeft(node) && tree.hasRight(node)))
				nodesToRemove.addLast(node);
		}
		
		return nodesToRemove;
	}
	
	/** Retorna o nó, de uma lista, que tem seu valor igual a "value". Se não há o valor na lista, retorna null. */
	public static BTNode<Integer> toTake(NodePositionList<BTNode<Integer>> list, int value) {
		for (BTNode<Integer> node: list) {
			if (value == node.element())
				return node;
		}
		
		return null;
	}
	
	public static void mostrarNodes(NodePositionList<BTNode<Integer>> nodes) {
		String list = "[";
		
		for (BTNode<Integer> node: nodes) {
			list += node.element() + ", ";
		}
		
		System.out.println(list.substring(0, list.length() - 2) + "]");
	}
}
 