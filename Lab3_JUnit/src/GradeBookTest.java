import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import  static java.lang.Math.*;

class GradeBookTest {
	
	GradeBook gradeBook1, gradeBook2, gradeBook3, gradeBook4, gradeBook5;  

	@BeforeEach
	void setUp() throws Exception {
		gradeBook1 = new GradeBook(5);
		gradeBook2 = new GradeBook(5);
		gradeBook3 = new GradeBook(5);
		gradeBook4 = new GradeBook(5);
	    gradeBook5 = new GradeBook(5);
		
		
		gradeBook1.addScore(10);
		gradeBook1.addScore(20);
		gradeBook1.addScore(30);
		gradeBook1.addScore(40);
		gradeBook1.addScore(50);
		
		gradeBook2.addScore(0);
		gradeBook2.addScore(25);
		gradeBook2.addScore(50);
		gradeBook2.addScore(75);
		gradeBook2.addScore(100);
		
		
		gradeBook3.addScore(65);
		gradeBook3.addScore(73);
		gradeBook3.addScore(42);
		gradeBook3.addScore(69);
		
		
		gradeBook4.addScore(11);
		gradeBook4.addScore(22);
		gradeBook4.addScore(33);
		gradeBook4.addScore(44);
		gradeBook4.addScore(55);
		
		gradeBook5.addScore(99);
		gradeBook5.addScore(1);
		gradeBook5.addScore(50);
		
		
		
	}
	@Test
	void testAddScore() {
		
		assertTrue(gradeBook1.toString().equals("10.0 20.0 30.0 40.0 50.0"));
		assertTrue(gradeBook2.toString().equals("0.0 25.0 50.0 75.0 100.0"));
		assertTrue(gradeBook3.toString().equals("65.0 73.0 42.0 69.0 0.0"));
		assertTrue(gradeBook4.toString().equals("11.0 22.0 33.0 44.0 55.0"));
		assertTrue(gradeBook5.toString().equals("99.0 1.0 50.0 0.0 0.0"));
	}

	@Test
	void testSum() {
		assertEquals(150,gradeBook1.sum(),0.0001);
		assertEquals(250,gradeBook2.sum(),0.0001);
		assertEquals(249,gradeBook3.sum(),0.0001);
		assertEquals(165,gradeBook4.sum(),0.0001);
		assertEquals(150,gradeBook5.sum(),0.0001);
		
		
		
	}

	@Test
	void testMinimum() {
		assertEquals(10,gradeBook1.minimum());
		assertEquals(0,gradeBook2.minimum());
		assertEquals(42,gradeBook3.minimum());
		assertEquals(11,gradeBook4.minimum());
		assertEquals(1,gradeBook5.minimum());
	};

	@Test
	void testFinalScore() {
		assertEquals(140,gradeBook1.sum()-gradeBook1.minimum());
		assertEquals(250,gradeBook2.sum()-gradeBook2.minimum());
		assertEquals(207,gradeBook3.sum()-gradeBook3.minimum());
		assertEquals(154,gradeBook4.sum()-gradeBook4.minimum());
		assertEquals(149,gradeBook5.sum()-gradeBook5.minimum());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(5,gradeBook1.getScoreSize());
		assertEquals(5,gradeBook2.getScoreSize());
		assertEquals(4,gradeBook3.getScoreSize());
		assertEquals(5,gradeBook4.getScoreSize());
	}

	@Test
	void testToString() {
		assertTrue(gradeBook1.toString().equals("10.0 20.0 30.0 40.0 50.0"));
		assertTrue(gradeBook2.toString().equals("0.0 25.0 50.0 75.0 100.0"));
		assertTrue(gradeBook3.toString().equals("65.0 73.0 42.0 69.0 0.0"));
		assertTrue(gradeBook4.toString().equals("11.0 22.0 33.0 44.0 55.0"));
		assertTrue(gradeBook5.toString().equals("99.0 1.0 50.0 0.0 0.0"));
		
	}
	

	@AfterEach
	void tearDown() throws Exception {
		gradeBook1=null;
		gradeBook2=null;
		gradeBook3=null;
		gradeBook4=null;
		gradeBook5=null;
	}

	

}
