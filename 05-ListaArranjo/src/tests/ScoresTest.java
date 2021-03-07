package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import game_entry.GameEntry;
import game_entry.Scores;

class ScoresTest {
	
	@Test
	void test() {
		Scores s = new Scores();
		GameEntry ge;

		ge = new GameEntry("Mike", 1105);
		s.add(ge);
		assertEquals("[(Mike, 1105)]", s.toString(), "Deve sair: [(Mike, 1105)]");

		ge = new GameEntry("Rob", 750);
		s.add(ge);
		assertEquals("[(Mike, 1105), (Rob, 750)]", s.toString(), "Deve sair: [(Mike, 1105), (Rob, 750)]");
	
		ge = new GameEntry("Paul", 720);
		s.add(ge);
		assertEquals("[(Mike, 1105), (Rob, 750), (Paul, 720)]", s.toString(), "Deve sair: [(Mike, 1105), (Rob, 750), (Paul, 720)]");
	
		ge = new GameEntry("Anna", 660);
		s.add(ge);
		assertEquals("[(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660)]", s.toString(), 
				     "Deve sair: [(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660)]");
	
		ge = new GameEntry("Rose", 590);
		s.add(ge);
		assertEquals("[(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590)]", s.toString(), 
				     "Deve sair: [(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590)]");
	
		ge = new GameEntry("Jack", 510);
		s.add(ge);
		assertEquals("[(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", s.toString(),
					 "Deve sair: [(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]");
	
		ge = new GameEntry("Jill", 740);
		s.add(ge);
		assertEquals("[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", s.toString(),
					 "Deve sair: [(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]");
	}
}

