
package game_entry;

public class Scores {
	protected int numberEntries;    // Numero real de jogadores no score.
	protected GameEntry entries[];  // Arranjo que sera usado para registrar os scores.
	
	public Scores() {
		entries = new GameEntry[10];  // O valor máximo de jogadores que entrará score será 10.
		numberEntries = 0;
	}
	
	public void add(GameEntry newScore) {
		/*
		 * Como o máximo de jogadores é 10, antes de adicionar verifica-se
		 * se já nao tem 10 jogadores. Se tiver, o novo score só será adicionado
		 * se ele for maior que o último score (o na posicao 10).
		 */
		
		if (numberEntries == 10) {
			if (newScore.getScore() <= entries[9].getScore()) {
				return;
			}
		}
		
		
		numberEntries = (numberEntries < 10) ? ++numberEntries : numberEntries;
		
		int i = numberEntries - 1;
		for (; i > 0; i--) {
			if (newScore.getScore() > entries[i - 1].getScore()) {
				entries[i] = entries[i - 1];  // Move os scores à direita.
			}
			else {
				break;  // Sai do loop
			}
		}
		
		entries[i] = newScore;  // Acrescenta o novo score na sua devida posicao.
	}
	
	public String toString() {
		String formatacao = "[";
		
		for (int i=0; i < numberEntries; i++)
			formatacao += String.format("%s, ", entries[i]);
		
		formatacao = formatacao.substring(0, formatacao.length() - 2);
		
		return formatacao + "]";
	}
	
	public static void main(String[] args) {
		Scores s = new Scores();
		GameEntry ge;

		ge = new GameEntry("Mike", 1105);
		s.add(ge);
		System.out.println(s.toString());
	}
}

