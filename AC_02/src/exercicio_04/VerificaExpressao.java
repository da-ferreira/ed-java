
package exercicio_04;

import tools.NodeStack;

/*
 * Ex 4c. Verifique se parênteses(), colchetes[] e chaves{} estão corretos numa expressão
 * matemática, por exemplo: [(5 + x)/4 – 2*(y + z)]
 * 
 * i.   Correto:   ()(( )){([( )])}
 * ii.  Correto:   ((( )(( )){([( )])}))
 * iii. Incorreto: )(( )){([( )])}
 * iv.  Incorreto: ({[])}
 * v.   Incorreto: (
 */

public class VerificaExpressao {
	public static boolean verificar(String expressao) {
		NodeStack<Character> pilha = new NodeStack<Character>();
		
		for (int i=0; i < expressao.length(); i++) {
			if (expressao.charAt(i) == '(') {
				pilha.push('(');
			}
			else if (expressao.charAt(i) == '[') {
				pilha.push('[');
			}
			else if (expressao.charAt(i) == '{') {
				pilha.push('{');
			}
			
			else if (expressao.charAt(i) == ')') {
				if (pilha.isEmpty()) {
					return false;
				}
				
				if (pilha.top() != '(') {
					return false;
				}
				
				pilha.pop();
			}
			
			else if (expressao.charAt(i) == ']') {
				if (pilha.isEmpty()) {
					return false;
				}
				
				if (pilha.top() != '[') {
					return false;
				}
				
				pilha.pop();
			}
			
			else if (expressao.charAt(i) == '}') {
				if (pilha.isEmpty()) {
					return false;
				}
				
				if (pilha.top() != '{') {
					return false;
				}
				
				pilha.pop();
			}	
		}
		
		// Testa se sobrou alguma abertura de (, [ ou {
		if (pilha.isEmpty())
			return true;
		
		return false;
	}
}
