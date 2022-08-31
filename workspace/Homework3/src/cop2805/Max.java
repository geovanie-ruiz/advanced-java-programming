package cop2805;

/**
 * @author Geovanie Ruiz
 *
 */
public class Max {
	/**
	 * Compares a list of generic and returns the maximum value
	 * 
	 * @param list collection of generic
	 * @return the maximum element in the list collection
	 */
	 public static <E extends Comparable<E>> E max (E [] list) {
		 // max value is the first index as there's nothing to compare against
		 E maxValue = list[0];
		 
		 // iterate over rest of list and compare to current max value
		 for (var i = 1; i < list.length; i++) {
			 // compareTo returns 1 if the value is greater than the passed value
			 if (list[i].compareTo(maxValue) > 0) {
				 maxValue = list[i];
			 }
		 }

		 return maxValue;
	 }

	/**
	 * Output a table of maximum values from a few lists
	 */
	public static void main(String[] args) {
		// Create list of strings which will use ASCII comparison
		String[] colors = {"Red","Green","Blue"};

		// Create lists that use numerical comparison
		Integer[] numbers = {1, 2, 3};
		Double[] circleRadius = {3.0, 5.9, 2.9};
		
		// Print Table header
		System.out.printf("%10s %10s %n", "List", "Max");

		// Print Table rows
		System.out.printf("%10s %10s %n", "Colors", max(colors));
		System.out.printf("%10s %10s %n", "Numbers", max(numbers));
		System.out.printf("%10s %10s %n", "Radii", max(circleRadius));

	}

}
