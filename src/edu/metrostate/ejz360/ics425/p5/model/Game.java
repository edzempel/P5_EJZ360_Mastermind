package edu.metrostate.ejz360.ics425.p5.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Game implements Serializable {
	/**
	 * Version number for Game bean
	 */
	private static final long serialVersionUID = 20191125L;
	public static final int NUM_GUESSES = 12;
	private ArrayList<Guess> gameboard = new ArrayList<Guess>();
	private boolean[] winningSpaces;
	private int turn = 0;

	public enum CodePeg {
		RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE

	}

	public enum KeyPeg {
		WHITE, BLACK
	}
	
	private class Guess{
		private static final int GUESS_SIZE = 4;
		private CodePeg[] guess = new CodePeg[GUESS_SIZE];
		
		public Guess(CodePeg one, CodePeg two, CodePeg three, CodePeg four) {
			guess[0] = one;
			guess[1] = two;
			guess[2] = three;
			guess[3] = four;
		}
		
	}
	

	public Game() {
		reset();
	}

	/**
	 * Initializes new game
	 */
	public void reset() {
		// TODO: create game initializer
	}

	public String getHello() {
		return "Hello Mastermind";
	}
	
	public boolean isOver() {
		return turn >= NUM_GUESSES;
	}
	
	public void addGuess(Guess guess) {
		if( !isOver()) {
			gameboard.add(guess);
		}
	}
	

}
