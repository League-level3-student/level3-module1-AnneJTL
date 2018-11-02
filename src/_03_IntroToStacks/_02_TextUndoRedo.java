package _03_IntroToStacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */

    private JLabel enteredCharsLabel;
    private Stack<Character> deletedCharsStack = new Stack<>();
    private StringBuilder storeChars = new StringBuilder();

    public static void main(String[] args) {
        new _02_TextUndoRedo();
    }

    private _02_TextUndoRedo() {
        JFrame window;
        JPanel panel;
        window = new JFrame("Text Undo Redo");
        panel = new JPanel();
        enteredCharsLabel = new JLabel();

        //enteredCharsLabel.setPreferredSize(new Dimension(490, 30));
        enteredCharsLabel.setMaximumSize(new Dimension(490, 30));
        enteredCharsLabel.setBackground(Color.DARK_GRAY);
        enteredCharsLabel.setForeground(Color.RED);
        Font myFont = new Font(Font.MONOSPACED, Font.BOLD, 25);
        enteredCharsLabel.setFont(myFont);
        window.addKeyListener(this);
        panel.add(enteredCharsLabel);
        window.add(panel);
        window.setSize(500, 130);
        //window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        JOptionPane.showMessageDialog(null, "The \"Undo\" key is \"F1\"");
    }


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.isActionKey() + " e.getKeyCode(): " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            System.out.println("back space");
            if (storeChars.length() >= 1) {
                char lastChar = storeChars.charAt(storeChars.length() - 1);
                storeChars.deleteCharAt(storeChars.length() - 1);
                deletedCharsStack.push(lastChar);
                enteredCharsLabel.setText(storeChars.toString());
            }
        } else if (e.getKeyCode() == KeyEvent.VK_F1) {
            System.out.println("Undo");
            if (!deletedCharsStack.isEmpty()) {
                storeChars.append(deletedCharsStack.pop());
                enteredCharsLabel.setText(storeChars.toString());
            }

        } else {
            storeChars.append(e.getKeyChar());
            enteredCharsLabel.setText(storeChars.toString());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
