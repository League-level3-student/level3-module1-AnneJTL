package _01_IntroToArrayLists;


/** Copyright The League of Amazing Programmers 2013-2017
 *    Level 3
 *    A Murder of Crows
 *    Duration=.00
 *    Platform=Eclipse
 *    Type=Recipe
 *    Objectives=n/a
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class _03_MurderOfCrows {

    ArrayList<Crow> theMurder = new ArrayList<Crow>();

    public static void main(String[] args) {
        _03_MurderOfCrows murderOfCrows = new _03_MurderOfCrows();
        murderOfCrows.initializeCrows();


        for (Crow aCrow:murderOfCrows.theMurder) {
            System.out.print(aCrow.getName() + "\t");
        }
        murderOfCrows.findTheDiamondBooleanVersion();
        murderOfCrows.findTheDiamondLabelsVersion();

    }

    private void findTheDiamondLabelsVersion() {
        /*
         * 1. One of the Crows has eaten the diamond. You need to search through the stomach of each Crow,
         * then print the name of the guilty Crow.
         */
        int innocent = 0;
         CROW: for (Crow aCrow:theMurder) {
            List<String> stomachCrow = aCrow.getStomachContents();
            STOMACH: for (String aStomachContent: stomachCrow) {
                if (aStomachContent.equalsIgnoreCase("diamond")){
                    System.out.println("The guilty crow is " + aCrow.getName());
                    break CROW;
                }
            }
            innocent++;
        }

        /* 2. How many innocent crows had to die before the diamond was found? */
        System.out.println(innocent + " is/are killed.");
    }

    private void findTheDiamondBooleanVersion() {
        /*
         * 1. One of the Crows has eaten the diamond. You need to search through the stomach of each Crow, 
         * then print the name of the guilty Crow.
         */
        int innocent = 0;
        boolean isFound = false;
        for (Crow aCrow:theMurder) {
            if (isFound){
                break;
            }
            List<String> stomachCrow = aCrow.getStomachContents();
            for (String aStomachContent: stomachCrow) {
                if (aStomachContent.equalsIgnoreCase("diamond")){
                    System.out.println("The guilty crow is " + aCrow.getName());
                    isFound = true;
                    break;
                }
            }
            if (!isFound)
                innocent++;
        }
        
        /* 2. How many innocent crows had to die before the diamond was found? */
        System.out.println(innocent + " is/are killed.");
    }

    private void initializeCrows() {
        theMurder.add(new Crow("Rok"));
        theMurder.add(new Crow("Merle"));
        theMurder.add(new Crow("Poe"));
        theMurder.add(new Crow("Grenwyn"));
        theMurder.add(new Crow("Crawford"));
        hideTheDiamond();
    }

    private void hideTheDiamond() {
        int randomness = new Random().nextInt(theMurder.size());
        theMurder.get(randomness).getStomachContents().add("diamond");
    }
}

class Crow {
    private String name;
    private ArrayList<String> stomachContents = new ArrayList<String>();

    public Crow(String name) {
        this.name = name;
        fillCrowsStomach();
    }

    private void fillCrowsStomach() {
        for (int i = 0; i < 10; i++)
            this.stomachContents.add(getRandomCrowFood());
    }

    private String getRandomCrowFood() {
        int randomness = new Random().nextInt(4);
        if (randomness == 0) return "carrion";
        else if (randomness == 1)return "snail";
        else if (randomness == 2)return "acorn";
        else if (randomness == 3)return "spider";
        else return "grub";
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStomachContents() {
        return stomachContents;
    }

}

