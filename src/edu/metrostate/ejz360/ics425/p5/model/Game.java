package edu.metrostate.ejz360.ics425.p5.model;

import java.io.Serializable;
import java.util.ArrayList;

import edu.metrostate.ejz360.ics425.p5.model.Guess.CodePeg;

public class Game implements Serializable {
	public static final int NUM_GUESSES = 12;
	/**
	 * Version number for Game bean
	 */
	private static final long serialVersionUID = 20191125L;
	private ArrayList<Guess> guesses;
	private Guess makerCode;

	private int turn;

	private Integer winningGuess;

	public Game() {
		reset();

	}

	public void addGuess(Guess guess) {
		if (!isOver()) {
			guesses.add(guess);
			if (isWinner(guess)) {
				setWinningGuess(turn);
			}
		}
		turn++;
	}

	public ArrayList<Guess> getGuesses() {
		return (ArrayList<Guess>) guesses.clone();
	}

	public Guess getMakerCode() {
		if (isOver())
			return makerCode;
		else
			return null;
	}

	public int getTurn() {
		return turn;
	}

	public Integer getWinningGuess() {
		return winningGuess;
	}

	public boolean isOver() {
		return turn >= NUM_GUESSES || getWinningGuess() != null;
	}

	public boolean isWinner(Guess breakerGuess) {
		return makerCode.equals(breakerGuess);
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

	private void setMakerCode() {
		this.makerCode = new Guess();
		makerCode.setGuessPegs(CodePeg.BLUE, CodePeg.GREEN, CodePeg.PURPLE, CodePeg.RED);
	}

	private void setWinningGuess(Integer winningGuess) {
		this.winningGuess = winningGuess;
	}

}
