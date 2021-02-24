
package arranjo;

public class Arranjo {
	public Object menor(int[] array) {
		int menor = array[0];  // coloca o primeiro valor do array na variavel "menor".
		
		for (int i=1; i < array.length; i++) {
			if (array[i] < menor)
				menor = array[i];
		}
		
		return menor;
	}

	public Object maior(int[] array) {
		int maior = array[0];
		
		for (int i=1; i < array.length; i++) {
			if (array[i] > maior)
				maior = array[i];
		}
		
		return maior;
	}

	public Object soma(int[] array) {
		int soma = 0;
		
		for (int i: array) {
			soma += i;
		}
		
		return soma;
	}

	public Object repeticoes(int[] array, int valor) {
		int quantidade = 0;
		
		for (int i: array) {
			if (i == valor)
				quantidade++;
		}
		
		return quantidade;
	}
}
 
