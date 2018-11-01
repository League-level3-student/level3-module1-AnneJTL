package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
        Stack<Double> doubleStack = new Stack<>();
        int max = 50;
		
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
        for (int i = 0; i < max; i++) {
            doubleStack.push(max * new Random().nextDouble());
        }

        //3. Ask the user to enter in two numbers between 0 and 100, inclusive.
        JOptionPane.showMessageDialog(null, "Enter two numbers between 0 and " + max + ", inclusive");
        Double minRange = Double.parseDouble(JOptionPane.showInputDialog("Enter the base number (>0)"));
        Double maxRange = Double.parseDouble(JOptionPane.showInputDialog("Enter the roof number (<" + max + ")"));

        //4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
        while (!doubleStack.empty()) {
            Double numberToTest = doubleStack.pop();
            String toDisplay = numberToTest.toString();
            if (numberToTest >= minRange && numberToTest <= maxRange) {
                toDisplay += " - is in the range !!!";
            }
            System.out.println(toDisplay);
        }
		
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
