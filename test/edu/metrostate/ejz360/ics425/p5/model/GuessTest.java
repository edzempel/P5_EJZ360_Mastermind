package edu.metrostate.ejz360.ics425.p5.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.metrostate.ejz360.ics425.p5.model.Guess.CodePeg;
import edu.metrostate.ejz360.ics425.p5.model.Guess.KeyPeg;

class GuessTest {
	Guess guess1;
	Guess guess2;
	Guess correctGuess;
	Guess makerCode;
	Guess guessNull;
	Random rnd;

	@BeforeEach
	void setUp() throws Exception {
		guess1 = new Guess();
		guess1.setGuessPegs(CodePeg.BLUE, CodePeg.GREEN, CodePeg.ORANGE, CodePeg.PURPLE);
		guess2 = new Guess();
		guess2.setGuessPegs(CodePeg.RED, CodePeg.YELLOW, CodePeg.BLUE, CodePeg.BLUE);
		correctGuess = new Guess();
		correctGuess.setGuessPegs(CodePeg.GREEN, CodePeg.RED, CodePeg.YELLOW, CodePeg.ORANGE);
		makerCode = new Guess();
		makerCode.setGuessPegs(CodePeg.GREEN, CodePeg.RED, CodePeg.YELLOW, CodePeg.ORANGE);
		rnd = new Random(20191208L);
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
		assertNotEquals(guess2, correctGuess);
		assertEquals(correctGuess, makerCode);
	}

	@Test
	void testToString() {
		assertEquals("BLUE,GREEN,ORANGE,PURPLE", guess1.toString());
	}

	@Test
	void testGetRandomCodePeg() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Guess.getRandomCodePeg(rnd)); // YELLOW,ORANGE,ORANGE,GREEN
		}

	}
	
	@Test
	void testGetKeys() {
		ArrayList<KeyPeg> allBlack = new ArrayList<KeyPeg>();
		allBlack.add(KeyPeg.BLACK);
		allBlack.add(KeyPeg.BLACK);
		allBlack.add(KeyPeg.BLACK);
		allBlack.add(KeyPeg.BLACK);
		ArrayList<KeyPeg> twoWhite = new ArrayList<KeyPeg>();
		twoWhite.add(KeyPeg.WHITE);
		twoWhite.add(KeyPeg.WHITE);
		ArrayList<KeyPeg> oneWhite = new ArrayList<KeyPeg>();
		oneWhite.add(KeyPeg.WHITE);
		assertEquals(allBlack,Guess.getKeys(correctGuess, makerCode));
		assertEquals(twoWhite,Guess.getKeys(guess2, makerCode));
		assertEquals(oneWhite,Guess.getKeys(guess1, guess2));
		
		
	}
	


}
