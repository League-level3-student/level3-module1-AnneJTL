package _04_HangMan;

import javax.swing.*;

public class HangManGame {
    static boolean continueGame = false;

    public static void main(String[] args) {
        // STEP 1
        //System.out.println("nb Tot words: " + NB_WORDS);

        do {
            HangMan aHangMan = new HangMan();
            aHangMan.initializeGame();
            // STEP 2
            aHangMan.initializeGUI();
            // initPlay = 1: You Win!!!
            int retour = aHangMan.initPlay();
            System.out.println("retour initPlay(): " + retour);
            if (retour == 8) {
                JOptionPane.showMessageDialog(null, "You find all the words");
                int answer = JOptionPane.showConfirmDialog(null,
                        "Do you want to play another time?", "You WIN!",
                        JOptionPane.YES_NO_OPTION);

                if (answer == 0) {
                    System.out.println("on continue");
                    continueGame = true;
                } else {
                    System.out.println("On arrete");
                }
                System.out.println("oui ou non: " + continueGame);
            }
        } while (continueGame);

    }
}
