package _04_HangMan;

public class HangManGame {
    static int continueGame = 0;

    public static void main(String[] args) {
        // STEP 1
        //System.out.println("nb Tot words: " + NB_WORDS);


        HangMan aHangMan = new HangMan();
        aHangMan.initializeGame();
        // STEP 2
        aHangMan.initializeGUI();
        aHangMan.initPlay();


    }
}
