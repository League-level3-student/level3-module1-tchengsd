package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> strings = new ArrayList<String>();
		//2. Add five Strings to your list
		strings.add("TOP TEXT");
		strings.add("Hello");
		strings.add("This is a string");
		strings.add("Filler line");
		strings.add("BOTTOM TEXT");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		//4. Print all the Strings using a for-each loop
		for(String each : strings) {
			System.out.println(each);
		}
		//5. Print only the even numbered elements in the list.
		for(int i = 0; i < strings.size(); i += 2) {
			System.out.println(strings.get(i));
		}
		//6. Print all the Strings in reverse order.
		for(int i = strings.size() - 1; i >= 0; i--) {
			System.out.println(strings.get(i));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for(String each : strings) {
			if(each.contains("e")) {
				System.out.println(each);
			}
		}
	}
}
