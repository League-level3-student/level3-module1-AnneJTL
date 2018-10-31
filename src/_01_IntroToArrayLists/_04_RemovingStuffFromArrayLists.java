package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Copyright The League of Amazing Programmers 2013-2017 Level 3 Two ArrayList
 * Cleaning Exercises Duration=.00 Platform=Eclipse Type=Recipe Objectives=
 */

public class _04_RemovingStuffFromArrayLists {

	public static void main(String[] args) {

		class Stuff {
			public String type;
		}
		class Worm extends Stuff {
			public Worm() {
				type = "worm";
			}
		}
		class Dirt extends Stuff {
			public Dirt() {
				type = "dirt";
			}
		}
		ArrayList<Stuff> stuffIFoundInTheYard = new ArrayList<Stuff>();
		stuffIFoundInTheYard.add(new Worm());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Worm());
		stuffIFoundInTheYard.add(new Dirt());

		System.out.println(stuffIFoundInTheYard.size());

		/* TODO 1 V1: Clean out the dirt but keep the delicious worms. */
        // Version 1: in the reverse order (if not, you miss some elements)
        /*
		for (int i=stuffIFoundInTheYard.size()-1; i>=0; i--){
		    Stuff thisStuff = stuffIFoundInTheYard.get(i);
            if (thisStuff instanceof Dirt) {
                stuffIFoundInTheYard.remove(i);
            }
        }
		*/

        /* TODO 1 V2: Clean out the dirt but keep the delicious worms. */
        // Version 2: with an iterator

        Iterator<Stuff> stuffIterator = stuffIFoundInTheYard.iterator();
        while (stuffIterator.hasNext()) {

            Stuff thisStuff = stuffIterator.next();
            if (thisStuff instanceof Dirt) {
                stuffIterator.remove();
            }
        }
		
		
		System.out.println(stuffIFoundInTheYard.size()); // should be 2

		ArrayList<Character> truth = new ArrayList<Character>();
		truth.add('c');
		truth.add('a');
		truth.add('#');
		truth.add('l');
		truth.add('#');
		truth.add('i');
		truth.add('f');
		truth.add('o');
		truth.add('#');
		truth.add('r');
		truth.add('n');
		truth.add('#');
		truth.add('i');
		truth.add('#');
		truth.add('a');
		truth.add('#');
		truth.add(' ');
		truth.add('i');
		truth.add('#');
		truth.add('s');
		truth.add('#');
		truth.add(' ');
		truth.add('w');
		truth.add('#');
		truth.add('a');
		truth.add('r');
		truth.add('#');
		truth.add('m');
		truth.add('e');
		truth.add('r');
		truth.add('#');
		/* TODO 2: Remove the hash symbols and print out the truth. */
        Iterator<Character> hashSymbolIterator = truth.iterator();
        while (hashSymbolIterator.hasNext()){
            Character symbole = hashSymbolIterator.next();
            if (symbole == '#')
                hashSymbolIterator.remove();
        }

        for (Character aCar: truth) {
            System.out.print(aCar);
        }
		
	}
}
