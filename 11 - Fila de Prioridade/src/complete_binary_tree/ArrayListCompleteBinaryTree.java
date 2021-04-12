
package complete_binary_tree;

import java.util.ArrayList;

/**
 * Implementação da árvore binária completa (ou heap) usando um vetor.
 * O vetor começa a partir do índice 1 (o indice 0 fica como null), 
 * que guarda a raíz da árvore, com seu resto nos indices seguintes.
 * Se um nó da árvore tem indice j seu filho da esquerda terá o indice
 * 2 * j e o da direita 2 * j + 1. o filho esquerdo e direito com indice j e j + 1
 * terá seu pai com indice j / 2 (divisao inteira).
 * 
 * @author david-ferreira
 */

public class ArrayListCompleteBinaryTree<Type> implements CompleteBinaryTree<Type> {
	protected ArrayList<Type> tree;  // Vetor que guarda a árvore.
	
	/* TESTE 
	 * casa*/
}
