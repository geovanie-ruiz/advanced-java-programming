package cop2805;

import java.util.*;

/**
 * @author Geovanie Ruiz
 */
public class Output {
	/**
	 * Iterates over a Character ArrayList to print each one
	 * 
	 * @param list collection of Characters to print out
	 */
	public static void output(ArrayList<Character> charList) {
		for (char character : charList) {
			System.out.print(character + " ");
		}
		System.out.println();
	}

	/**
	 * Flex Java Collection methods
	 * 1. Create and output a list of three characters.
	 * 2. Reverse and output the list.
	 * 3. Create copy list from an array of the three Characters. Copy the contents of list in step one 
	 *        into copy list of the step three, output the copied list.
	 * 4. Fill the initial list with the letter 'R' and output the list.
	 */
	public static void main(String[] args) {
		// Create a list with initials, using my nickname "Geo"
		ArrayList<Character> myList = new ArrayList<Character>();
		myList.add('G');
		myList.add('E');
		myList.add('O');
	
		// Create a duplicate of the original list to allocate capacity and size
		// Collections.copy requires size matching not just space allocation
		ArrayList<Character> myListCopy = new ArrayList<Character>(myList);
		
		// Output list per step 1
		System.out.println("Initial List");
		output(myList);
		
		// Reverse the list and output per step 2
		System.out.println("Reversed List");
		Collections.reverse(myList);
		output(myList);
		
		// Output copy of original list per step 3
		System.out.println("Copied List");
		Collections.copy(myListCopy, myList);
		output(myListCopy);
		
		// Fill original list with 'R' and output per step 4
		System.out.println("R Filled List");
		Collections.fill(myList, 'R');
		output(myList);
	}
}
