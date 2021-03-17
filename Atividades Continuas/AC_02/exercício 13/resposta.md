**13) A implementação de NodePositionList não faz verificações de erro para testar se uma dada posição p é realmente membro dessa lista em particular**    

  **a.  Por exemplo, se p é uma posição da lista S, a execução T.addAfter(p,e) deveria  
        lançar a exceção InvalidPositionException pois p não é uma posição de T.**  
  **b. Descreva como alterar a implementação de NodePositionList de uma forma eficiente que impeça esses maus usos.**    

RESPOSTA:  
  
Será feito um loop que passará por todos os itens (posições) de T,  
e testará, para cada posição de T, se p == i-ésima posição de T (o operador == em java não testa o conteúdo para objetos,  
ou seja, seu valor, mas sim a posição de memória desse objeto). Se p for igual a alguma posição de T, o código segue,  
caso contrário, lança uma exceção InvalidPositionException.
