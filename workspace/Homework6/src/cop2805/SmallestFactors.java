package cop2805;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Geovanie Ruiz
 *
 */
public class SmallestFactors {
	/**
	 * Get smallest factors whose product is the original number
	 * 
	 * @param factored the integer that was factored
	 * @param factors factors of the factored integer
	 * @return List containing set of smallest factors
	 */
    private static List<Integer> GetSmallestFactors(int factored, List<Integer> factors) {
    	int diminishingFactored = factored;
    	int i = 1;
		boolean nextDivFound = false;
    	List<Integer> smallestFactors = new ArrayList<Integer>();

    	/*
    	 * Iterate until the original number to factor (factored) has been reduced to 1
    	 * factored should be cleanly divided by a factor and that quotient becomes the new number
    	 * The new number diminishes as this process repeats until it becomes 1, i.e. the
    	 * smallest factors have been found
    	 */
    	while(diminishingFactored != 1) {
    		i = 1;
    		nextDivFound = false;

    		/*
    		 * Iterate until a factor cleanly divides into the current value
    		 * of the diminishing factored number. That factor is then added
    		 * to the smallestFactors list and the factored number is reduced
    		 * to a new quotient using that same factor. The loop is exited at
    		 * this point to start again from the beginning of the factors list. 
    		 */
    		while (!nextDivFound) {
    			int factor = factors.get(i);

    			if (diminishingFactored % factor == 0) {
    				nextDivFound = true;
    				smallestFactors.add(factor);
    				diminishingFactored /= factor;
    			} else {
    				i++;
    			}
    		}
    	}

    	return smallestFactors;
    }

	/**
	 * Get factors of the user input integer
	 * 
	 * @param toFactor the integer to be factored
	 * @return List containing each factor
	 */
    private static List<Integer> GetFactors(int toFactor) {
    	List<Integer> factors = new ArrayList<Integer>();
    	
    	// Iterate over all number between 1 and toFactor
    	// If that number cleanly divides into toFactor it is a factor of it
		for (int i = 1; i <= toFactor; ++i) {
			if (toFactor % i == 0) {
				factors.add(i);
			}
		}
    	return factors;
    }
 
	/**
	 * Run interface for getting an integer and outputting smallest factors
	 */
	public static void main(String[] args) {
		System.out.print("Enter integer to factor: ");

		// Get an integer to evaluate factors and smallest factors
		Scanner scan = new Scanner(System.in);
		int integerToFactor = scan.nextInt();
		scan.close();

		// Get all of the factors of the entered integer
		List<Integer> factors = GetFactors(integerToFactor);
		
		// Output the factors for the entered integer
		System.out.printf("%20s %10s %n", "Factors: ", factors);
		
		// Of the factors, get the smallest whose product is the original integer
		List<Integer> smallestFactors = GetSmallestFactors(integerToFactor, factors);

		System.out.printf("%20s %10s %n", "Smallest factors: ", smallestFactors);
	}
}
