package _04_HangMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class HangMan implements KeyListener {
    private int nbWordsToPlay;
    private static String fileName = "dictionary.txt";
    private static final int NB_WORDS = Utilities.getTotalWordsInFile(fileName);
    private Stack<String> listOfWords = new Stack<>();
    private JLabel incorrectCharsLabel = new JLabel();
    private JLabel theWordLabel = new JLabel();
    private JLabel incorrectCharsLabelTitle = new JLabel();
    private JLabel theWordLabelTitle = new JLabel();
    private JLabel nbLivesLabel = new JLabel();
    private JLabel nbLivesLabelTitle = new JLabel();
    private JLabel nbWordsLabel = new JLabel();
    private JLabel nbWordsLabelTitle = new JLabel();
    private String guessWord, wordToFind, allBadCharacters;
    private static final Character GUESS_CHAR = '*';
    //private boolean winGame = false;
    private int nbLives = 5;
    private int nbWordsFound = 0;

    void initializeGame() {
        nbWordsToPlay = nbWords();
        System.out.println("number of words for this game: " + nbWordsToPlay);
        ListOfWords();
        System.out.println("The stack contains " + listOfWords.size() + " words");
        System.out.println("nb Tot words: " + NB_WORDS);
    }

    void initializeGUI() {
        JFrame window = new JFrame("Hang Man");
        JPanel panel = new JPanel();

        incorrectCharsLabelTitle.setText("Incorrect characters");
        theWordLabelTitle.setText("Word to find");
        nbLivesLabelTitle.setText("Nb lives available");
        nbWordsLabelTitle.setText("Nb words found");

        incorrectCharsLabelTitle.setPreferredSize(new Dimension(350, 30));
        incorrectCharsLabel.setPreferredSize(new Dimension(100, 30));

        theWordLabelTitle.setPreferredSize(new Dimension(350, 30));
        theWordLabel.setPreferredSize(new Dimension(100, 30));

        nbLivesLabelTitle.setPreferredSize(new Dimension(400, 30));
        nbLivesLabel.setPreferredSize(new Dimension(50, 30));

        nbWordsLabelTitle.setPreferredSize(new Dimension(400, 30));
        nbWordsLabel.setPreferredSize(new Dimension(50, 30));

        panel.add(incorrectCharsLabelTitle);
        panel.add(incorrectCharsLabel);
        panel.add(theWordLabelTitle);
        panel.add(theWordLabel);
        panel.add(nbLivesLabelTitle);
        panel.add(nbLivesLabel);
        panel.add(nbWordsLabelTitle);
        panel.add(nbWordsLabel);

        window.add(panel);
        window.addKeyListener(this);
        window.setSize(new Dimension(600, 300));
        window.setVisible(true);

    }

    int initPlay() {
        // Return 0: Continue
        // Return 1: All words find- You win- Game over
        System.out.println("initPlay");
        guessWord = new String();
        allBadCharacters = new String();
        nbLivesLabel.setText(Integer.toString(nbLives));
        String found = nbWordsFound + " / " + nbWordsToPlay;
        nbWordsLabel.setText(found);

        if (!listOfWords.isEmpty()) {
            wordToFind = listOfWords.pop();
            System.out.println("The word is " + wordToFind);
        } else {
            // All words were find.
            // This HangMan is finished
            System.out.println("avant return 8");
            return 8;
        }


        for (int i = 0; i < wordToFind.length(); i++) {
            guessWord += GUESS_CHAR;
        }

        theWordLabel.setText(guessWord);
        incorrectCharsLabel.setText(allBadCharacters);
        return 0;
    }

    private void ListOfWords() {

        String aRandomWord;

        int i = 0;
        while (i < nbWordsToPlay) {
            aRandomWord = Utilities.readRandomLineFromFile(fileName);
            if (!listOfWords.contains(aRandomWord)) {
                listOfWords.push(aRandomWord);
                i++;
            } else {
                System.out.println("The word '" + aRandomWord + "' is already selected.");
            }
        }


    }


    private int nbWords() {
        // Selection of the words
        String nbWordsEntered = JOptionPane.showInputDialog("Enter a number less or equals to " + NB_WORDS);
        int nbWordsForPlaying;
        try {
            nbWordsForPlaying = Integer.parseInt(nbWordsEntered);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect value");
            return -1;
        }

        if (nbWordsForPlaying > NB_WORDS) {
            System.out.println("Incorrect value");
            return -1;
        }


        return nbWordsForPlaying;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        Character aChar = e.getKeyChar();
        System.out.println("keyPressed: " + aChar);

        if (allBadCharacters.contains(aChar.toString())
                || guessWord.contains(aChar.toString())) {
            System.out.println(aChar + " was already checked");
            return;
        }

        if (wordToFind.contains(aChar.toString())) {
            for (int i = 0; i < wordToFind.length(); i++) {
                if (wordToFind.charAt(i) == aChar) {
                    StringBuilder tempString = new StringBuilder(guessWord);
                    tempString.replace(i, i + 1, aChar.toString());
                    guessWord = tempString.toString();
                }
            }
            theWordLabel.setText(guessWord);

            // Test end of game
            if (!guessWord.contains(GUESS_CHAR.toString())) {
                JOptionPane.showMessageDialog(null, "You find the word. Now, find the next one!");
                nbWordsFound++;
                initPlay();
            }
        } else {
            allBadCharacters += aChar;
            incorrectCharsLabel.setText(allBadCharacters);
            nbLives--;
            nbLivesLabel.setText(Integer.toString(nbLives));
            if (nbLives == 0) {
                JOptionPane.showMessageDialog(null, "You loose all yours lives! GAME OVER");
                //return;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
