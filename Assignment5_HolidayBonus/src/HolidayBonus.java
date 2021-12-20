/**
 * Description: A data manager to provide functions where the bonuses that are awarded to retail can be calculated
 * @author abelp
 *Date: 11/8/2021
 */
public class HolidayBonus {

  /**
   * Calculates the holiday bonus for each store and return an array.
   * 
   * @param data the two dimensional array of store sales
   * @param high bonus for the highest store in a category
   * @param low bonus for the lowest store in a category
   * @param other bonus for all other stores in a category
   * @return an array of the bonus for each store
   */
  public static double[] calculateHolidayBonus(double[][] data, double high, double low,
      double other) {
	  
	 double []array = new double [data.length];
	 
	 
	
	 for (int row = 0; row <data.length;row++) {
		 for (int col = 0; col<data[row].length;col++) {
			if (data[row].length>col) {
				if (((int)TwoDimRaggedArrayUtility.getHighestInColumn(data,col))==data[row][col]) {
					array[row]+=high;
				}
				else if (((int)TwoDimRaggedArrayUtility.getLowestInColumn(data, col))==data[row][col]) {
					array[row]+=low;
				}
				else {
					if(data[row][col]>=0) {
						array[row]+=other;
					}
				}
			} 
		 }
	 }
	 
	 return array;
}

  /**
   * Method to iterate through the array and return the sum 
   * 
   * @param data the two dimensional array of store sales
   * @param high bonus for the highest store in a category
   * @param low bonus for the lowest store in a category
   * @param other bonus for all other stores in a category
   * @return the total of all holiday bonuses
   */
  public static double calculateTotalHolidayBonus(double[][] data, double high, double low,
      double other) {
    
    double[] array = calculateHolidayBonus(data, high, low, other);
    double total = 0;
    
    for (double bonus:array) {
      total+=bonus;
    }
    return total;
  }
}