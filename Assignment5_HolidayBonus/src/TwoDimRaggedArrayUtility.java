/**
 * @author abelp
 * Description: Data manager class to perform various functions with the given array. 
 * Date: 11/8/2021
 * Instructor: Ahmed Tarek 
 * Class: CMSC 203 
 */
import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {

/**
 * Method to provide average
 * @param data 2d array 
 * @return average 
 */
	public static double getAverage(double [][] data) {
		double total = getTotal(data);
		int counter = 0;
		for (int i = 0; i<data.length;i++) {
			for(int j = 0; j<data[i].length;j++) {
				counter++;
			}
		}
		return total/counter;
	}
	
/**
 * 	Method to provide the total sum in the column 
 * @param data 2d array 
 * @param col index of column
 * @return total sum
 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0; 
		for(int i = 0 ; i<data.length;i++) {
			if (data[i].length>col) {
				total+=data[i][col];
			}
		}
		return total;
	}
/**
 * Method to provide the largest element in the array
 * @param data 2d array 
 * @return maximum alement 
 */
	public static double getHighestInArray (double [][] data) {
		double max = data[0][0];
		for (int i = 0; i<data.length;i++) {
			for (int j = 0; j<data[i].length;j++) {
				if(data[i][j]>max) {
					max=data[i][j];
				}
			}
		}
		return max;
		
		
		
	}
/**
 * 	Method to return the highest element in the column
 * @param data 2d array 
 * @param col index 
 * @return highest element in the column 
 */
	public static double getHighestInColumn (double [][] data, int col) {
		return data [getHighestInColumnIndex(data,col)][col];
	}
/**
 * 	Method to return the index of the row in which the highest element found 
 * @param data 2d array
 * @param col 
 * @return the index of the highest element in the column
 */
	public static int getHighestInColumnIndex(double [][] data, int col) {
		int index = 0;
		double max = data[index][col];
		for(int i = 1; i<data.length;i++) {
			if (data[i].length>col) {
				if (data[i][col]>max) {
					max = data[i][col];
					index = i;
				}
			}
		}
		return index; 
	}
/**
 * Method to return the value of the highest element in the row found
 * @param data 2d array 
 * @param row index 
 * @return value  of the highest element in the row 
 */
	public static double getHighestInRow(double [][] data, int row) {
		return data [row][getHighestInRowIndex(data,row)];
	}
/**
 * Method to return the index of the highest element in the row
 * @param data 2d array
 * @param row index
 * @return index of the  highest value in the row 
 */
	public static int getHighestInRowIndex(double [][] data, int row) {
		int index = 0;
		double max = data[row][index];
		for(int i = 1; i<data[row].length;i++) {
			if (data[row][i]>max) {
				max = data[row][i];
				index = i;
			}
		}
		return index; 
		
	}
/**
 * method to return the lowest value in the array
 * @param data 2d array 
 * @return lowest value in the array 
 */
	public static double getLowestInArray (double [][] data) {
		double min = data[0][0];
		for (int i = 0; i<data.length;i++) {
			for (int j = 0; j<data[i].length;j++) {
				if(data[i][j]<min) {
					min=data[i][j];
				}
			}
		}
		return min;
	}
/**
 * method to return the lowest value in the column	
 * @param data 2d array 
 * @param col integer column index 
 * @return lowest double value in the column given
 */
	public static double getLowestInColumn (double[][] data, int col) {
		return data[getLowestInColumnIndex(data,col)][col];
	}
/**
 * Method to return the lowest index 
 * @param data 2d array
 * @param col index 
 * @return index of the lowest element in the column 
 */
	public static int getLowestInColumnIndex (double [][] data, int col) {
		int index = 0;
		double min = data[index][col];
		for(int i = 1; i<data.length;i++) {
			if (data[i].length>col) {
				if (data[i][col]<min) {
					min = data[i][col];
					index = i;
				}
			}
			
		}
		return index; 
	}
/**
 * Method to return the lowest value in the row 
 * @param data 2d array 
 * @param row index 
 * @return the lowest value in the row 
 */
	public static double getLowestInRow(double [][] data, int row) {
		return data [row][getLowestInRowIndex(data,row)];
	}
/**
 * Method to return the lowest element's index 
 * @param data 2d array 
 * @param row index 
 * @return the lowest element's index 
 */
	public static int getLowestInRowIndex (double [][] data, int row) {
		int index = 0;
		double min = data[row][index];
		for(int i = 1; i<data[row].length;i++) {
			if (data[row][i]<min) {
				min = data[row][i];
				index = i;
			}
		}
		return index; 
	}
/**
 * Method to return the total sum in the Row	
 * @param data 2d array 
 * @param row index
 * @return the total sum in the row
 */
	public static double getRowTotal(double [][] data, int row) {
		double total = 0;
		for (int i = 0; i<data[row].length;i++){
			total+=data[row][i];
		}
		return total;
			
	}
/**
 * Method to return the total sum in the array
 * @param data 2d array 
 * @return total sum 
 */
	public static double getTotal(double [][] data) {
		double total = 0;
		for (int i = 0; i<data.length;i++) {
			for (int j = 0; j<data[i].length;j++){
				total+=data[i][j];
			}
		}
		
		return total;
		
	}
/**
 * Method to return the array which is filled in using the text 
 * @param file file object 
 * @return the array of which the file has been copied
 * @throws FileNotFoundException incase the file is not to be found 
 */
	public static double [][] readFile (File file) throws FileNotFoundException{
		Scanner in = new Scanner(file);
		int num = 0;
		String[][] temp = new String[10][]; 
		    
		    // read file and pass numbers to temp array as Strings
		while (in.hasNextLine()) {
			String[] line = in.nextLine().split(" ");
		    temp[num] = new String[line.length];
		    for (int i = 0;i < line.length;i++) {
	        temp[num][i]=line[i];   
	        }
		     num++;
	    }
		   // Create double data array and parse numbers as doubles
		double[][]array = new double[num][];
		for (int i = 0; i < num;i++) {
			array[i]= new double[temp[i].length];
		    for (int j = 0;j < temp[i].length;j++) {
		    	System.out.print(temp[i][j] + " ");
		        array[i][j] = Double.parseDouble(temp[i][j]);
		    }
		    System.out.println();
	    }
		    
		in.close();
		return array;
	}
/**
 * Method to write the contents of the 2d array into a file 
 * @param data 2d array 
 * @param outputFile the file to be copied onto 
 * @throws IOException accepts all exceptions
 */
	public static void writeToFile(double[][]data, File outputFile) throws IOException {
		
		PrintWriter output = new PrintWriter(outputFile);
	    StringBuilder out = new StringBuilder();
	    for (int i = 0;i < data.length;i++) {
	      for (int j = 0;j < data[i].length;j++) {
	        out.append(data[i][j]+ " ");
	      }
	      out.append("\n");
	    }
	    output.print(out.toString());
	    output.close();
		
	}
	
}
