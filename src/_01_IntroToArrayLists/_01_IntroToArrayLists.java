package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.List;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		List<String > listString = new ArrayList<>();

		//2. Add five Strings to your list
		listString.add("Jean");
		listString.add("Pierre");
		listString.add("Michel");
		listString.add("Marie");
		listString.add("Jeanne");

		//3. Print all the Strings using a standard for-loop
		for (int i=0; i<listString.size(); i++){
			System.out.println("For: " + listString.get(i));
		}

		System.out.println("\n");
		//4. Print all the Strings using a for-each loop
		for(String name : listString){
			System.out.println("Foreach: " + name);
		}

		System.out.println("\n");
		//5. Print only the even numbered elements in the list.
		for(int i=0; i<listString.size(); i+=2){
			System.out.println("Even: " + listString.get(i));
		}

        System.out.println("\n");
        //6. Print all the Strings in reverse order.
        for(int i=listString.size()-1; i >=0; i--){
            System.out.println("Reverse: " + listString.get(i));
        }

        System.out.println("\n");
        //7. Print only the Strings that have the letter 'e' in them.
        for(String name : listString){
            if (name.contains("i")){
                System.out.println("Contains i: " + name);
            }
        }
	}
}
