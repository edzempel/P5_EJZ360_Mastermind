package edu.metrostate.ejz360.ics425.p5.model;

import java.io.Serializable;
import java.util.ArrayList;

import edu.metrostate.ejz360.ics425.p5.model.Guess.CodePeg;

public class Game implements Serializable {
	/**
	 * Version number for Game bean
	 */
	private static final long serialVersionUID = 20191125L;
	public static final int NUM_GUESSES = 12;
	private ArrayList<Guess> guesses;
	private int turn;
	private Integer winningGuess;

	public Integer getWinningGuess() {
		return winningGuess;
	}

	private void setWinningGuess(Integer winningGuess) {
		this.winningGuess = winningGuess;
	}

	private Guess makerCode;

	private Guess getMakerCode() {
		return makerCode;
	}

	private void setMakerCode() {
		this.makerCode = new Guess();
		makerCode.setGuessPegs(CodePeg.BLUE, CodePeg.GREEN, CodePeg.PURPLE, CodePeg.RED);
	}

	public boolean isWinner(Guess breakerGuess) {
		return makerCode.equals(breakerGuess);
	}

	

	public Game() {
		reset();

	}

	/**
	 * Initializes new game
	 */
	public void reset() {
		winningGuess = null;
		turn = 0;
		guesses = new ArrayList<Guess>();
		setMakerCode();
	}

	public String getHello() {
		return "Hello Mastermind";
	}

	public boolean isOver() {
		return turn >= NUM_GUESSES || getWinningGuess() != null;
	}

	public void addGuess(Guess guess) {
		if (!isOver()) {
			guesses.add(guess);
			if (getMakerCode().equals(guess)) {
				setWinningGuess(turn);
			}
		}
		turn++;
	}

	public ArrayList<Guess> getGuesses() {
		return (ArrayList<Guess>) guesses.clone();
	}

}
