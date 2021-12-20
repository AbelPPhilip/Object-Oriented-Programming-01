//package _solution;
//package _solutionF2018;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENTTest {
	private double[][] array1 = {{100,100,100},{200,200},{300,300,300}};
	private double[][] array2 = {{7,2,9,4},{5},{8,1,3},{11,6,7,2}};
	private double[][] array3 = {{7.2,2.5,9.3},{5.9},{8.1,1.7,3.3},{11.6,6.9,7.3,2.7}};
	//dataSet3 has fewer elements in first row than in other rows
	private double[][] array4 = {{-2.5,-5.3,6.1},{-4.4,8.2},{2.3,-7.5},{-4.2,7.3,-5.9,2.6}};
	//dataSet4 has negative elements as well as positive
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		array1 = array2 = array3 = array4 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Test getTotal method
	 * Returns the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(1600,TwoDimRaggedArrayUtility.getTotal(array1),.001);
		assertEquals(65.0,TwoDimRaggedArrayUtility.getTotal(array2),.001);
		assertEquals(66.5,TwoDimRaggedArrayUtility.getTotal(array3),.001);
		assertEquals(-3.3,TwoDimRaggedArrayUtility.getTotal(array4),.001);
	}

	/**
	 * Test getAverage method
	 * Returns the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(200,TwoDimRaggedArrayUtility.getAverage(array1),.001);
		assertEquals(5.417,TwoDimRaggedArrayUtility.getAverage(array2),.001);
		assertEquals(6.045,TwoDimRaggedArrayUtility.getAverage(array3),.001);
		assertEquals(-.3,TwoDimRaggedArrayUtility.getAverage(array4),.001);
		//fail("Not yet implemented");
	}

	
	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(400.0,TwoDimRaggedArrayUtility.getRowTotal(array1,1),.001);
		assertEquals(5.0,TwoDimRaggedArrayUtility.getRowTotal(array2,1),.001);
		assertEquals(22.0,TwoDimRaggedArrayUtility.getRowTotal(array2,0),.001);
		assertEquals(28.5,TwoDimRaggedArrayUtility.getRowTotal(array3,3),.001);
		assertEquals(5.9,TwoDimRaggedArrayUtility.getRowTotal(array3,1),.001);
		assertEquals(3.8,TwoDimRaggedArrayUtility.getRowTotal(array4,1),.001);
		assertEquals(-.2,TwoDimRaggedArrayUtility.getRowTotal(array4,3),.001);
		//fail("Not yet implemented");
	}
	

	/**
	 * Test getColumnTotal method
	 * Returns the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(600,TwoDimRaggedArrayUtility.getColumnTotal(array1,0),.001);
		assertEquals(19.0,TwoDimRaggedArrayUtility.getColumnTotal(array2,2),.001);
		assertEquals(11.1,TwoDimRaggedArrayUtility.getColumnTotal(array3,1),.001);
		assertEquals(-8.8,TwoDimRaggedArrayUtility.getColumnTotal(array4,0),.001);
		assertEquals(2.7,TwoDimRaggedArrayUtility.getColumnTotal(array4,1),.001);
		//fail("Not yet implemented");
	}
	

	/**
	 * Test getHighestInRow method
	 * Returns the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRow() {
		assertEquals(100,TwoDimRaggedArrayUtility.getHighestInRow(array1,0),.001);
		assertEquals(8.0,TwoDimRaggedArrayUtility.getHighestInRow(array2,2),.001);
		assertEquals(5.9,TwoDimRaggedArrayUtility.getHighestInRow(array3,1),.001);
		assertEquals(6.1,TwoDimRaggedArrayUtility.getHighestInRow(array4,0),.001);
		assertEquals(8.2,TwoDimRaggedArrayUtility.getHighestInRow(array4,1),.001);
		//fail("Not yet implemented");
	}

	/**
	 * Test getHighestInRowIndex method
	 * Returns the index of the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(array1,0));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(array2,2));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(array3,1));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(array4,0));
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInRowIndex(array4,1));
	}
	
	/**
	 * Test getLowestInRowIndex method
	 * Returns the index of the smallest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(array1,0));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(array2,2));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(array3,1));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(array4,0));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(array4,1));
	}

	/**
	 * Test getLowestInRow method
	 * Returns the smallest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetLowestInRow() {
		assertEquals(300.0,TwoDimRaggedArrayUtility.getLowestInRow(array1,2),.001);
		assertEquals(5.0,TwoDimRaggedArrayUtility.getLowestInRow(array2,1),.001);
		assertEquals(2.5,TwoDimRaggedArrayUtility.getLowestInRow(array3,0),.001);
		assertEquals(-4.4,TwoDimRaggedArrayUtility.getLowestInRow(array4,1),.001);
		assertEquals(-7.5,TwoDimRaggedArrayUtility.getLowestInRow(array4,2),.001);
		//fail("Not yet implemented");
	}
	

	/**
	 * Test getHighestInColumn method
	 * Returns the largest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetHighestInColumn() {
		assertEquals(300.0,TwoDimRaggedArrayUtility.getHighestInColumn(array1,2),.001);
		assertEquals(6.0,TwoDimRaggedArrayUtility.getHighestInColumn(array2,1),.001);
		assertEquals(11.6,TwoDimRaggedArrayUtility.getHighestInColumn(array3,0),.001);
		assertEquals(8.2,TwoDimRaggedArrayUtility.getHighestInColumn(array4,1),.001);
		assertEquals(6.1,TwoDimRaggedArrayUtility.getHighestInColumn(array4,2),.001);
		//fail("Not yet implemented");
	}

	/**
	 * Test getHighestInColumn method
	 * Returns the index of the largest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(array1,2));
		assertEquals(3,TwoDimRaggedArrayUtility.getHighestInColumnIndex(array2,1));
		assertEquals(3,TwoDimRaggedArrayUtility.getHighestInColumnIndex(array3,0));
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(array4,1));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInColumnIndex(array4,2));
		//fail("Not yet implemented");
	}
	/**
	 * Test getLowestInColumn method
	 * Returns the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumn() {
		assertEquals(100.0,TwoDimRaggedArrayUtility.getLowestInColumn(array1,1),.001);
		assertEquals(3.0,TwoDimRaggedArrayUtility.getLowestInColumn(array2,2),.001);
		assertEquals(5.9,TwoDimRaggedArrayUtility.getLowestInColumn(array3,0),.001);
		assertEquals(-4.4,TwoDimRaggedArrayUtility.getLowestInColumn(array4,0),.001);
		assertEquals(-7.5,TwoDimRaggedArrayUtility.getLowestInColumn(array4,1),.001);
		//fail("Not yet implemented");
	}

	/**
	 * Test getLowestInColumnIndex method
	 * Returns the index of the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(array1,1));
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInColumnIndex(array2,2));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInColumnIndex(array3,0));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInColumnIndex(array4,0));
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInColumnIndex(array4,1));
		//fail("Not yet implemented");
	}
	/**
	 * Test getHighestInArray method
	 * Returns the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(300.0,TwoDimRaggedArrayUtility.getHighestInArray(array1),.001);
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInArray(array2),.001);
		assertEquals(11.6,TwoDimRaggedArrayUtility.getHighestInArray(array3),.001);
		assertEquals(8.2,TwoDimRaggedArrayUtility.getHighestInArray(array4),.001);
		//fail("Not yet implemented");
	}
	

	/**
	 * Test getLowestInArray method
	 * Returns the smallest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetLowestInArray() {
		assertEquals(100.0,TwoDimRaggedArrayUtility.getLowestInArray(array1),.001);
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInArray(array2),.001);
		assertEquals(1.7,TwoDimRaggedArrayUtility.getLowestInArray(array3),.001);
		assertEquals(-7.5,TwoDimRaggedArrayUtility.getLowestInArray(array4),.001);
		//fail("Not yet implemented");
	}
	
	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(array4, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(-2.5, array[0][0],.001);
		assertEquals(-5.3, array[0][1],.001);
		assertEquals(6.1, array[0][2],.001);
		assertEquals(-4.4, array[1][0],.001);
		assertEquals(8.2, array[1][1],.001);
		assertEquals(2.3, array[2][0],.001);
		assertEquals(-7.5, array[2][1],.001);
		assertEquals(-4.2, array[3][0],.001);
		assertEquals(7.3, array[3][1],.001);
		assertEquals(-5.9, array[3][2],.001);
		assertEquals(2.6, array[3][3],.001);		
		
	}
	
	/**
	 * Test the readFile method
	 * reads from a file and then test that the returned two dimensional array of doubles
	 * is ragged.
	 */
	@Test
	public void testReadFile() {
		double[][] array=null;
		try {
			inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("-2.5 -5.3 6.1\n" +
					"-4.4 8.2\n" +
					"2.3 -7.5\n" +
					"-4.2 7.3 -5.9 2.6");
			inFile.close();
			array = TwoDimRaggedArrayUtility.readFile(inputFile);
			assertEquals(-2.5, array[0][0],.001);
			assertEquals(-5.3, array[0][1],.001);
			assertEquals(6.1, array[0][2],.001);
			assertEquals(-4.4, array[1][0],.001);
			assertEquals(8.2, array[1][1],.001);
			assertEquals(2.3, array[2][0],.001);
			assertEquals(-7.5, array[2][1],.001);
			assertEquals(-4.2, array[3][0],.001);
			assertEquals(7.3, array[3][1],.001);
			assertEquals(-5.9, array[3][2],.001);
			assertEquals(2.6, array[3][3],.001);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[1][2],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[2][2],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}
	}
	
	
}