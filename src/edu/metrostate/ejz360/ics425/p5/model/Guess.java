package edu.metrostate.ejz360.ics425.p5.model;

import java.io.Serializable;
import java.util.Random;

import edu.metrostate.ejz360.ics425.p5.model.Guess.CodePeg;

public class Guess implements Serializable {

	private static final long serialVersionUID = 20191207L;
	private static final int GUESS_SIZE = 4;
	private CodePeg[] guessPegs = new CodePeg[GUESS_SIZE];

	public Guess() {
		super();
	}

	public CodePeg[] getGuessPegs() {
		return guessPegs;
	}

	public void setGuessPegs(CodePeg one, CodePeg two, CodePeg three, CodePeg four) {
		guessPegs[0] = one;
		guessPegs[1] = two;
		guessPegs[2] = three;
		guessPegs[3] = four;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;

		if (obj instanceof Guess) {
			CodePeg[] objGuessPegs = ((Guess) obj).getGuessPegs().clone();
			for (int i = 0; i < this.guessPegs.length; i++) {
				equal = this.guessPegs[i].equals(objGuessPegs[i]);
				if (!equal) {
					break;
				}
			}
		}
		return equal;
	}
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s", guessPegs[0], guessPegs[1], guessPegs[2], guessPegs[3]);
	}
	
	public static CodePeg getRandomCodePeg() {
		Random rnd = new Random();
		return CodePeg.values()[(int) Math.floor(rnd.nextInt(6))];
	}

	public enum CodePeg {
		RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE

	}

	public enum KeyPeg {
		WHITE, BLACK
	}

}