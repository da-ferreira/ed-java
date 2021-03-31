
package game_entry;

public class GameEntry {
	protected String name;  // Nome do jogador.
	protected int score;   // Score do jogador.
	
	public GameEntry(String namePlayer, int scorePlayer) {  // construtor
		name = namePlayer;
		score = scorePlayer;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public String toString() {
		return String.format("(%s, %d)", name, score);
	}
}
