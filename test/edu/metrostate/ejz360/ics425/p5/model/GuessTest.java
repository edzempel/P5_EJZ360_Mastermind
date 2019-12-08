package edu.metrostate.ejz360.ics425.p5.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.metrostate.ejz360.ics425.p5.model.Guess.CodePeg;

class GuessTest {
	Guess guess1;
	Guess guess2;
	Guess guess3;
	Guess guess4;
	Guess guessNull;

	@BeforeEach
	void setUp() throws Exception {
		guess1 = new Guess();
		guess1.setGuessPegs(CodePeg.BLUE, CodePeg.GREEN, CodePeg.ORANGE, CodePeg.PURPLE);
		guess2 = new Guess();
		guess2.setGuessPegs(CodePeg.RED, CodePeg.YELLOW, CodePeg.BLUE, CodePeg.BLUE);
		guess3 = new Guess();
		guess3.setGuessPegs(CodePeg.GREEN, CodePeg.RED, CodePeg.YELLOW, CodePeg.ORANGE);
		guess4 = new Guess();
		guess4.setGuessPegs(CodePeg.GREEN, CodePeg.RED, CodePeg.YELLOW, CodePeg.ORANGE);
	}

	@Test
	void testGuess() {
		assertNull(guessNull);
	}

	@Test
	void testGetGuessPegs() {
		assertEquals(CodePeg.BLUE, guess1.getGuessPegs()[0]);
		assertEquals(CodePeg.GREEN, guess1.getGuessPegs()[1]);
		assertEquals(CodePeg.ORANGE, guess1.getGuessPegs()[2]);
		assertEquals(CodePeg.PURPLE, guess1.getGuessPegs()[3]);
	}

	@Test
	void testEqualsObject() {
		assertNotEquals(guess2, guess3);
		assertEquals(guess3, guess4);
	}

	@Test
	void testToString() {
		assertEquals("BLUE,GREEN,ORANGE,PURPLE", guess1.toString());
	}

	@Test
	void testGetRandomCodePeg() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Guess.getRandomCodePeg());
		}

	}

}
