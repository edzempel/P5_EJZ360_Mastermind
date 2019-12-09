package edu.metrostate.ejz360.ics425.p5.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.metrostate.ejz360.ics425.p5.model.Guess.CodePeg;
import edu.metrostate.ejz360.ics425.p5.model.Guess;

class GameTest {
	Game game;
	Guess guess1;
	Guess guess2;
	Guess guess3;
	Guess guess4;
	Guess makerCode;

	@BeforeEach
	void setUp() throws Exception {
		game = new Game();
		guess1 = new Guess();
		guess1.setGuessPegs(CodePeg.BLUE, CodePeg.GREEN, CodePeg.ORANGE, CodePeg.PURPLE);
		guess2 = new Guess();
		guess2.setGuessPegs(CodePeg.RED, CodePeg.YELLOW, CodePeg.BLUE, CodePeg.BLUE);
		guess3 = new Guess();
		guess3.setGuessPegs(CodePeg.GREEN, CodePeg.RED, CodePeg.YELLOW, CodePeg.ORANGE);
		guess4 = new Guess();
		guess4.setGuessPegs(CodePeg.BLUE, CodePeg.GREEN, CodePeg.PURPLE, CodePeg.RED);
		makerCode = new Guess();
		makerCode.setGuessPegs(CodePeg.BLUE, CodePeg.GREEN, CodePeg.PURPLE, CodePeg.RED);
	}

	@Test
	void testDefaults() {
		assertTrue(game.getGuesses().isEmpty());
		assertEquals(12, Game.NUM_GUESSES);
		assertTrue(game instanceof Game);
		assertFalse(game.isOver());
	}

	@Test
	void testAddGuess() {
		game.addGuess(guess1);
		game.addGuess(guess2);
		game.addGuess(guess3);

		assertEquals(guess1, game.getGuesses().get(0));
		assertEquals(guess2, game.getGuesses().get(1));
		assertEquals(guess3, game.getGuesses().get(2));
		assertNotEquals(guess4, game.getGuesses().get(2));
	}

	@Test
	void testIsWinner() {
		assertNotEquals(makerCode, guess3);
		assertEquals(makerCode, guess4);
	}
	
	@Test
	void testGetMakerCode() {
		System.out.println(game.getMakerCode());
	}
	
	@Test
	void testIsOver() {
		for (int i = 0; i < 14; i++) {
			game.addGuess(guess1);
			if(game.getTurn() < Game.NUM_GUESSES)
				assertFalse(game.isOver(), "on turn " + game.getTurn());
			else
				assertTrue(game.isOver(), "on turn " + game.getTurn());
		}
	}

}
