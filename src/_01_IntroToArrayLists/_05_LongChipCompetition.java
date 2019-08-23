package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Random;


public class _05_LongChipCompetition {
	/**
	 * The Beatles are eating lunch and playing a game to see who has the longest
	 * chip. (In England, french fries are called "chips".) * Find the Beatle with
	 * the longest chip. You may not edit the Chip or Beatle classes. Make sure to
	 * initialize The Beatles before you start your search. *
	 **/
	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

	public static void main(String[] args) {
		_05_LongChipCompetition lcc = new _05_LongChipCompetition();
		lcc.findLongestChip();

	}

	private void initializeBeatles() {
		Beatle george = new Beatle("George");
		Beatle john = new Beatle("John");
		Beatle paul = new Beatle("Paul");
		Beatle ringo = new Beatle("Ringo");
		theBeatles.add(george);
		theBeatles.add(john);
		theBeatles.add(paul);
		theBeatles.add(ringo);
	}

	public ArrayList<Beatle> getTheBand() {
		return theBeatles;
	}

	public void findLongestChip() {
		initializeBeatles();
		double longestChipG = 0;
		double longestChipJ = 0;
		double longestChipP = 0;
		double longestChipR = 0;
		for (int i = 0; i < theBeatles.get(0).getChips().size(); i++) {
			if (theBeatles.get(0).getChips().get(i).getLength() > longestChipG) {
				longestChipG = theBeatles.get(0).getChips().get(i).getLength();
			}
		}
		for (int i = 0; i < theBeatles.get(1).getChips().size(); i++) {
			if (theBeatles.get(1).getChips().get(i).getLength() > longestChipJ) {
				longestChipG = theBeatles.get(1).getChips().get(i).getLength();
			}
		}
		for (int i = 0; i < theBeatles.get(2).getChips().size(); i++) {
			if (theBeatles.get(2).getChips().get(i).getLength() > longestChipP) {
				longestChipG = theBeatles.get(2).getChips().get(i).getLength();
			}
		}
		for (int i = 0; i < theBeatles.get(3).getChips().size(); i++) {
			if (theBeatles.get(3).getChips().get(i).getLength() > longestChipR) {
				longestChipG = theBeatles.get(3).getChips().get(i).getLength();
			}
		}
		if (longestChipG > longestChipJ && longestChipG > longestChipP && longestChipG > longestChipR) {
			System.out.println("George has the longest chip, at " + longestChipG + " cm.");
		}
		if (longestChipJ > longestChipG && longestChipJ > longestChipP && longestChipJ > longestChipR) {
			System.out.println("John has the longest chip, at " + longestChipJ + " cm.");
		}
		if (longestChipP > longestChipJ && longestChipP > longestChipG && longestChipP > longestChipR) {
			System.out.println("Paul has the longest chip, at " + longestChipP + " cm.");
		}
		if (longestChipR > longestChipJ && longestChipR > longestChipP && longestChipR > longestChipG) {
			System.out.println("Ringo has the longest chip, at " + longestChipR + " cm.");
		}
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
