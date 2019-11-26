package edu.metrostate.ejz360.ics425.p5.model;

import java.io.Serializable;

public class Game implements Serializable {

	/**
	 * Version number for Game bean
	 */
	private static final long serialVersionUID = 20191125L;

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

}
