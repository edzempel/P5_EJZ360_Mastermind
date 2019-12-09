package edu.metrostate.ejz360.ics425.p5.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Guess implements Serializable {

	private static final long serialVersionUID = 20191207L;
	private static final int GUESS_SIZE = 4;
	private CodePeg[] guessPegs = new CodePeg[GUESS_SIZE];

	public Guess() {
		super();
	}

	public CodePeg[] getGuessPegs() {
		return guessPegs.clone();
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

	public static CodePeg getRandomCodePeg(Random rnd) {
		return CodePeg.values()[(int) Math.floor(rnd.nextInt(6))];
	}

	public static ArrayList<KeyPeg> getKeys(Guess codeBreaker, Guess codeMaker) {
		ArrayList<KeyPeg> keys = new ArrayList<KeyPeg>();
		if (codeMaker.equals(codeBreaker)) {
			keys.add(KeyPeg.BLACK);
			keys.add(KeyPeg.BLACK);
			keys.add(KeyPeg.BLACK);
			keys.add(KeyPeg.BLACK);
		} else {

			CodePeg[] breakerPegs = codeBreaker.getGuessPegs();
			CodePeg[] makerPegs = codeMaker.getGuessPegs();

			for (int i = 0; i < makerPegs.length; i++) {
				if (breakerPegs[i].equals(makerPegs[i])) {
					keys.add(KeyPeg.BLACK);
					makerPegs[i] = null;
				}
			}

			for (int i = 0; i < breakerPegs.length; i++) {
				int j = matchIndex(breakerPegs[i], makerPegs);
				if (j > -1) {
					keys.add(KeyPeg.WHITE);
					makerPegs[j] = null;
				}
			}
		}

		return keys;
	}

	private static int matchIndex(CodePeg target, CodePeg[] array) {
		int i = -1;
		for (int j = 0; j < array.length; j++) {
			if (target.equals(array[j])) {
				i = j;
				break;
			}
		}

		return i;
	}

	public enum CodePeg {
		RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE

	}

	public enum KeyPeg {
		WHITE, BLACK
	}

}