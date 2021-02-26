
package pato_ganso_jogo;

import java.util.Random;

import lista_circular_encadeada.CircularLinkedList;
import lista_circular_encadeada.Node;

/**
 * @author ferreira
 */

public class Game {
	public static void main(String[] args) {
		CircularLinkedList jogo = new CircularLinkedList();
		final int RODADAS = 3;  // quantidade de rodadas
		
		Node pegador, ganso;  // jogador pegador e ganso.
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());  // usa o tempo Unix epoch como semente
		
		String jogadores[] = {"Bob", "Jen", "Pam", "Tom", "Ron", "Vic", "Sue", "Joe"};
		
		for (int i=0; i < jogadores.length; i++) {
			/* 
			 * Adicionando os jogadores na lista circular e avançando o cursor.
			 * Ao final o cursor fica no ultimo jogador, no caso o "Joe".
			 */
			jogo.add(new Node(jogadores[i], null));
			jogo.advance();  
		}
		
		for (int i=0; i < RODADAS; i++) {
			System.out.printf("Jogando pato, pato, ganso: %s\n", jogo.toString());
			pegador = jogo.remove();  // remove e coloca como pegador o elemento depois do cursor.
			System.out.printf("O pegador é %s\n", pegador.getElement());
			
			while (random.nextBoolean() ||random.nextBoolean()) {  // andando ao redor do circulo
				jogo.advance();  // andando no circulo.
				System.out.printf("%s é pato\n", jogo.getCursor().getElement());
			}
			
			ganso = jogo.remove();  // escolheu o ganso
			System.out.printf("%s é o ganso\n", ganso.getElement());
			
			// Aqui vai ser gerado um valor aleatorio para decidir quem ira ganhar a corrida (o pegador ou o ganso).
			// será gerado um valor entre true e false, se der true o ganso ganha, caso contrario o pegador ganha.
			
			if (random.nextBoolean()) {  // ganso ganha
				jogo.add(ganso);  // recoloca o ganso no jogo.
				jogo.advance();  // o curso avança para o ganso.
				
				// Um novo nó é colocado na frente do ganso,
				// então como o pegador perdeu para o ganso ele será o pegador
				// novamente na proxima rodada.
				jogo.add(pegador);
			}
			else {  // pegador ganha
				/*
				 * Aqui o pegador vence, ele é adicionado na frente do cursor.
				 * Em seguida ele é definido como cursor. Depois adiciona o ganso no jogo (depois do cursor),
				 * e na próxima rodada o ganso será o pegador (o pegador é sempre o depois do curso)
				 */
				jogo.add(pegador);
				jogo.advance();
				jogo.add(ganso);
				
			}
		}
		
		System.out.printf("Jogo acabado! Circulo final: %s\n", jogo.toString());
	}
}

