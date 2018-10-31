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
	    String winner = "";
	    double longuestChipSize = -1.0;
		_05_LongChipCompetition lcc = new _05_LongChipCompetition();

		lcc.initializeBeatles();
		// We test all the singers
        for (Beatle aSinger: lcc.getTheBand()) {
            // We check each chip
            for (Chip aParticulatChip : aSinger.getChips())
            {
                if (aParticulatChip.getLength() > longuestChipSize){
                    longuestChipSize = aParticulatChip.getLength();
                    winner = aSinger.getName();
                }
            }
        }
        System.out.println("The winner is " + winner + ", his largest chip is " + longuestChipSize + " cms.");
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

    private ArrayList<Beatle> getTheBand() {
		return theBeatles;
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

    Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
		}
	}

    ArrayList<Chip> getChips() {
		return this.chips;
	}

    String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

    double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
