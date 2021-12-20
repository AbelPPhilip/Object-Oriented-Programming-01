/*
 * Name: Abel P. 
 * Date: 10/25/2021
 * Description: Student Created JUnit Test for Management Company class
 */



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5,p6;
	ManagementCompany m ; 
	
	@Before
	public void setUp() throws Exception {
		p1 = new Property ("Abel's Palace", "Rockville", 100.0, "Abel P.",2,1,2,2);
		p2 = new Property ("MC College", "Rockville", 100.0, "Eric Holder",4,1,2,2);
		p3 = new Property ("Taj Mahal", "Delhi", 200.0, "PM Modi",6,1,2,2);
		
		m= new ManagementCompany("Estate", "9293",6);
	 
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() throws Exception {
		p1=p2=p3=p4=p5=p6=null;
		m=null;
	}
			
	@Test
	public void testGetMAX_PROPERTY() {
		assertEquals(m.getMAX_PROPERTY(),5);
	}

	@Test
	public void testAddProperty() {
		p4 = new Property ("Google", "California", 300.0, "SundarPichai",2,5,2,2);
		p5 = new Property ("Apple", "California", 200.0, "Tim Cook",4,5,2,2);
		assertEquals(m.addProperty(p4),3,0);
		assertEquals(m.addProperty(p5),4,0);

	}

	@Test
	public void testTotalRent() {
		assertEquals(m.totalRent(),400.0,0);
	}

	 
	@Test
	public void testMaxRentProperty() {
		assertEquals(m.maxRentProp(),200.0,0);
	}
	

	
	@Test
	public void testDisplayPropertyAtIndex() {
		
		String prop = m.displayPropertyAtIndex(2);
		//split the toString into an array
		String[] propArray = prop.split(" ");
		//test that the last element of the toString is the rent of the third property
		assertEquals(propArray[propArray.length-1],"200.0");
	}
	

}