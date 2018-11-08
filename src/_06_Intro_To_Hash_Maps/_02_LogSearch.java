package _06_Intro_To_Hash_Maps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class _02_LogSearch implements ActionListener {
    private JButton addButton, searchButton, viewButton, removeButton;

    /* Crate a HashMap of Integers for the keys and Strings for the values.*/
    private HashMap<Integer, String> logSearch = new HashMap<>();

    _02_LogSearch() {
        initializeGUI();
    }

    public static void main(String[] args) {
        new _02_LogSearch();
    }

    /* * Create a GUI with three buttons. */
    private void initializeGUI() {
        JFrame window;
        JPanel panel;

        window = new JFrame("LogSearch HashMap");
        panel = new JPanel();

        addButton = new JButton("Add");
        addButton.addActionListener(this);

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);

        viewButton = new JButton("View");
        viewButton.addActionListener(this);

        panel.add(addButton);
        panel.add(removeButton);
        panel.add(searchButton);
        panel.add(viewButton);

        window.add(panel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);

    }

    /* * Button 1: Add Entry
     * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
     * 				After an ID is entered, use another input dialog to ask the user to enter a name.
     * 				Add this information as a new entry to your HashMap.
     */
    private void addEntry() {
        String answer;
        answer = JOptionPane.showInputDialog("Enter an ID number");

        Integer ID = castID(answer);
        if (ID == -1) {
            return;
        }

        answer = JOptionPane.showInputDialog("Enter a name");
        logSearch.put(ID, answer);
        JOptionPane.showMessageDialog(null, ID + " with name " + answer + " is stored");
    }

    /* Button 2: Search by ID
     * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
     * 				If that ID exists, display that name to the user.
     * 				Otherwise, tell the user that that entry does not exist.
     */
    private Integer searchByID() {
        if (logSearch.isEmpty()) {
            JOptionPane.showMessageDialog(null, "there is no entry.");
            return -1;
        }
        String answer = JOptionPane.showInputDialog("Enter an ID number");
        Integer searchID = castID(answer);
        if (searchID != -1) {
            for (Integer ID : logSearch.keySet()) {
                if (ID.equals(searchID)) {
                    JOptionPane.showMessageDialog(null,
                            "The name of the ID " + ID + " is " + logSearch.get(ID));
                    return ID;
                }
            }
        }
        return -1;
    }

    /* Button 3: View List
     * 				When this button is clicked, display the entire list in a message dialog in the following format:
     * 				ID: 123  Name: Harry Howard
     * 				ID: 245  Name: Polly Powers
     * 				ID: 433  Name: Oliver Ortega
     * 				etc...
     *
     * When this is complete, add a fourth button to your window.*/
    private void viewList() {
        StringBuilder allvalues = new StringBuilder();

        if (logSearch.isEmpty()) {
            allvalues = new StringBuilder("There is no entry.");
        } else {
            for (Integer ID : logSearch.keySet()) {
                allvalues.append("ID: ").append(ID).append(" Name: ").append(logSearch.get(ID)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, allvalues.toString());
    }

    /* Button 4: Remove Entry
     * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
     * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
     * 				is not in the list.
     *
     * */
    private void removeEntry() {
        String allvalues;

        if (logSearch.isEmpty()) {
            allvalues = "There is no entry.";
        } else {
            Integer ID = searchByID();
            if (ID != -1) {
                logSearch.remove(ID);
                allvalues = ID + " removed";
            } else {
                allvalues = "This ID doesn't exist";
            }
        }
        JOptionPane.showMessageDialog(null, allvalues);
    }

    private Integer castID(String stringValue) {
        Integer enteredID;

        try {
            enteredID = Integer.parseInt(stringValue);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Incorrect ID");
            return -1;
        }
        return enteredID;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton) (e.getSource())).getText());

        if (addButton == e.getSource()) {
            addEntry();
        }

        if (searchButton == e.getSource()) {
            searchByID();
        }

        if (viewButton == e.getSource()) {
            viewList();
        }

        if (removeButton == e.getSource()) {
            removeEntry();
        }

    }
}
