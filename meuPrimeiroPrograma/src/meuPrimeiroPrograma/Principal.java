
package meuPrimeiroPrograma;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Ol�, amigo!\nQual � o seu nome? ");
		
		// Lendo uma string do console com a biblioteca Scanner.
		String nome = in.nextLine();
		
		// Exibindo o nome lido com printf (print formatado, %s � para string).
		System.out.printf("Ol�, %s!\n", nome);
		in.close();
	}
}
