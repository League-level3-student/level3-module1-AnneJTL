package _01_IntroToArrayLists;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class _02_GuestBook implements ActionListener {
    // Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names".
    // When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
    // that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
    // all the names added to the list. Format the list as follows:
    // Guest #1: Bob Banders
    // Guest #2: Sandy Summers
    // Guest #3: Greg Ganders
    // Guest #4: Donny Doners
    private JFrame window = new JFrame("Guest Book");
    private JPanel panel = new JPanel();
    private JButton addButton = new JButton("Add Name");
    private JButton viewButton = new JButton("View Names");
    private List<String> guests = new ArrayList<>();

    public static void main(String[] args) {
        _02_GuestBook guest = new _02_GuestBook();
        guest.initGUI();

    }

    private void initGUI(){
        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        panel.add(addButton);
        panel.add(viewButton);
        window.add(panel);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private void addButtonBehavior(){
        String newGuest = JOptionPane.showInputDialog("Enter a new guest name");
        guests.add(newGuest);
    }

    private void viewButtonBehavior(){
        String allNames = "";
        for (String name:guests) {
            allNames += name + "\n";
        }
        JOptionPane.showMessageDialog(null, allNames);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton){
            viewButtonBehavior();
        } else if (e.getSource() == addButton){
            addButtonBehavior();
        }
    }
}
