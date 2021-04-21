
package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/** Número de colisões numa lista de 5163 nomes usando o hashCode polinominal com deslocamento ciclico. */

public class DeslocamentoCiclicoColisoes {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Home\\Documents\\programação\\project euler\\022-names.txt"));  // 5163 de nomes
				
		String dados[] = reader.readLine().split(",");
		
		for (int i=0; i < dados.length; i++) {
			dados[i] = dados[i].substring(1, dados[i].length() - 1);
		}
		
		int total[] = new int[17]; 
		
		for (int i=0; i <= 16; i++) {
			ArrayList<Integer> array = new ArrayList<>();
			int total_i = 0;
			
			for (int j=0; j < dados.length; j++) {
				int hash = hashCode(dados[j], i);
				
				if (array.contains(hash)) {
					total_i++;
				}
				else {
					array.add(hash);
				}
			}
			
			total[i] = total_i;
		}
		
		for (int i=0; i < total.length; i++) {
			System.out.println("shift " + i + " colisões = " + total[i]);
		}
	}
	
   /** Outra forma de calcuar o código hash polinomial, substituindo a multiplicação por "a" pelo deslocamento ciclico. */
   public static int hashCode(String str, int shift) {
       int hash = 0;
               
       for (int i=0; i < str.length(); i++) {
           hash = (hash << shift) | (hash >>> 27);  // cyclic shift (deslocamento cíclico)
           hash += (int) str.charAt(i);             // Pega o código no caracter na tabela ASCII
       } 
       
       return hash;
   }
}
