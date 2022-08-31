package cop2805;

import java.text.NumberFormat;

public class ComputeIncome {
	private static double[] commissionTiers = {0.08, 0.1, 0.12};
	private static double baseIncome = 5000;

	/**
	* Computes the total income for a sale amount. Includes base
	* salary as well as commission on sales in graduated tiers.
	* 
	* @param salesAmount the total amount of sales made
	* @return sum of base income and commission
	*/
	public static double computeIncome(double salesAmount) {
		double commission = 0;

		if (salesAmount <= 5000) {
			commission += salesAmount * commissionTiers[0];
		} else {
			commission += 5000 * commissionTiers[0];
			
			if (salesAmount <= 10000) {
				commission += (salesAmount - 5000) * commissionTiers[1];
			} else {
				commission += 5000 * commissionTiers[1];
				
				if (salesAmount > 10000) {
					commission += (salesAmount - 10000) * commissionTiers[2];
				}
			}
		}

		return baseIncome + commission;
	}

	/**
	* Output a table of sales and income from $1,000 to $20,000.
	*/
	public static void main(String[] args) {
		/**
		 * Use NumberFormat to format into USD per default locale (US)
		 * 
		 * Dollah Dollah Bills, y'all!
		 */
		NumberFormat dollerBills = NumberFormat.getCurrencyInstance();

		/**
		 * Table heading
		 */
		System.out.printf("%10s %20s %n", "Sales", "Income");

		/**
		 * Iterate from 1 to 20 to build table row data
		 */
		for (int i = 1; i <= 20; i++) {
			double sales = i*1000.0; // Multiple sales by 1,000 to use correct interval
			double income = computeIncome(sales);
			
			/**
			 * Table row
			 */
			System.out.printf("%10s %20s %n", dollerBills.format(sales), dollerBills.format(income));
		}
	}
}
