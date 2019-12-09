package edu.metrostate.ejz360.ics425.p5.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import edu.metrostate.ejz360.ics425.p5.model.Guess.KeyPeg;

public class Game implements Serializable {
	public static final int NUM_GUESSES = 12;
	/**
	 * Version number for Game bean
	 */
	private static final long serialVersionUID = 20191125L;
	private ArrayList<Guess> guesses;
	private ArrayList<ArrayList<KeyPeg>> keys;
	private Guess makerCode;
	private Random rnd;

	private int turn;

	private Integer winningGuess;

	public Game() {
		reset();

	}

	public void addGuess(Guess guess) {
		if (!isOver()) {
			guesses.add(guess);
			keys.add(Guess.getKeys(guess, makerCode));
			if (isWinner(guess)) {
				setWinningGuess(turn);
			}
		}
		turn++;
	}

	public ArrayList<Guess> getGuesses() {
		return (ArrayList<Guess>) guesses.clone();
	}
	
	public ArrayList<Guess> getReverseGuesses(){
		ArrayList<Guess> revArrayList = new ArrayList<Guess>(); 
        for (int i = guesses.size() - 1; i >= 0; i--) { 
  
            // Append the elements in reverse order 
            revArrayList.add(guesses.get(i)); 
        } 
		return revArrayList;
	}

	public Guess getMakerCode() {
			return makerCode;
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
		keys = new ArrayList<ArrayList<KeyPeg>>();
		rnd = new Random();
		setMakerCode(rnd);
	}

	private void setMakerCode(Random rnd) {
		this.makerCode = new Guess();
//		makerCode.setGuessPegs(CodePeg.BLUE, CodePeg.GREEN, CodePeg.PURPLE, CodePeg.RED);
		makerCode.setGuessPegs(Guess.getRandomCodePeg(rnd), Guess.getRandomCodePeg(rnd), Guess.getRandomCodePeg(rnd), Guess.getRandomCodePeg(rnd));
		
	}

	

	private void setWinningGuess(Integer winningGuess) {
		this.winningGuess = winningGuess;
	}

}
