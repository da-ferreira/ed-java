
package source;

import java.util.Scanner;

import static estruturas.ListaArranjo.listaArranjo;
import static estruturas.Pilha.pilha;
import static estruturas.Fila.fila;
import static estruturas.ListaDeNodos.listaDeNodos;
import static estruturas.ArvoreGenerica.arvoreGenerica;
import static estruturas.ArvoreBinaria.arvoreBinaria;
import static estruturas.FilaDePrioridade.filaDePrioridade;
import static estruturas.Mapa.mapa;
import static estruturas.Dicionario.dicionario;
import static estruturas.MapaOrdenadoUsandoAbb.mapaOrdenadoUsandoAbb;
import static estruturas.MapaOrdenadoUsandoAvl.mapaOrdenadoUsandoAvl;
import static estruturas.Grafos.grafos;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("\n		-=-=-=-=- Estrutura de Dados -=-=-=-=-");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		boolean sair = false;
		
		while (!sair) {
			System.out.println("\nEscolha uma opção:\n");
			System.out.println(
				   " 1. TAD Lista Arranjo\n" +
				   " 2. TAD Pilha\n" + 
				   " 3. TAD Fila\n" + 
				   " 4. TAD Lista de Nodos\n" + 
				   " 5. TAD Árvore Genérica\n" + 
				   " 6. TAD Árvore Binária\n" + 
				   " 7. TAD Fila de Prioridade\n" + 
				   " 8. TAD Mapa\n" + 
				   " 9. TAD Dicionário\n" + 
				   "10. TAD Mapa Ordenado usando ABB\n" + 
				   "11. TAD Mapa Ordenado usando AVL\n" + 
				   "12. TAD Grafos\n" +
				   "13. Sair");

			System.out.print("\n>>> ");
			int escolha = in.nextInt();
			
			switch (escolha) {
				case 1:
					listaArranjo();
					break;
				case 2:
					pilha();
					break;
				case 3:
					fila();
					break;
				case 4:
					listaDeNodos();
					break;
				case 5:
					arvoreGenerica();
					break;
				case 6:
					arvoreBinaria();
					break;
				case 7:
					filaDePrioridade();
					break;
				case 8:
					mapa();
					break;
				case 9:
					dicionario();
					break;
				case 10:
					mapaOrdenadoUsandoAbb();
					break;
				case 11:
					mapaOrdenadoUsandoAvl();
					break;
				case 12:
					grafos();
					break;
				case 13:
					sair = true;
					break;
				default:
					escolhaInvalida();
			}
		}
	}
	
	/**
	 * Escreve uma linha na tela no formato "...-=-=-...".
	 * jumpLineStart -> número de linhas para pular antes de escrever a linha na tela. 
	 * jumpLineEnd -> número de linhas para pulhar depois de escrever a linha na tela. 
	 */
	public static void line(int size, int jumpLineStart, int jumpLineEnd) {
		for (int i=0; i < jumpLineStart; i++)
			System.out.println();
		
		for (int i=0; i < size; i++) {
			if (i % 2 == 0) {
				System.out.print("-");
			}
			else {
				System.out.print("=");
			}
		}
		
		for (int i=0; i < jumpLineEnd; i++)
			System.out.println();
	}
	
	/** Quando o usuário informar uma opção inválida. */
	public static void escolhaInvalida() throws InterruptedException {
		System.out.println("\nOpção inválida! Por favor, informe a opção corretamente.");
		Thread.sleep(1500);
	}
}
