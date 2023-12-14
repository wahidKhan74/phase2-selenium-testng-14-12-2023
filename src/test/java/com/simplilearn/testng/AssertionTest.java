package com.simplilearn.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class demonstrate TestNg Assertion's.
 * 
 * @author khanw
 *
 */
public class AssertionTest {

	@Test
	public void testAsserts() {
		
		String userName = "Prajwal Diwakar";
		String message = null;
		int age = 30;
		boolean isMarred = false;
		
		assertEquals("Prajwal Diwakar", userName);
		assertEquals(30, age);
		assertNotEquals("Prajwal", userName);
		
		assertNotNull(userName);
		assertNull(message);
		
		assertFalse(isMarred);
		assertTrue(!isMarred);
		
	}
	
	// Hard assert :  Hard Assert throws an AssertException immediately when an
	// assert statement fails and test suite continues with next @Test method.
	@Test(description = "Hard Assert method Test")
	public void hardAssertTest() {
		System.out.println("--- Hard assert method is started ---");
		// assertEquals("Prajwal", "Prajwal Diwakar");
		assertEquals("Prajwal Diwakar", "Prajwal Diwakar");
		System.out.println("--- Hard assert method is ended ---");
	}
	
	// Soft assert :- Soft Assert collects errors during @Test.
	// Soft Assert does not throw an AssertException when an assert fails
	@Test(description="Soft Assert method Test")
	public void softAssertTest() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("--- Soft assert method is started ---");
		softAssert.assertEquals("Hello", "Hi");
		softAssert.assertEquals("Prajwal Diwakar", "Prajwal Diwakar");
		softAssert.assertEquals(true, false);
		softAssert.assertTrue(true);
		System.out.println("--- Soft assert method is completed ---");
	}
	
	
	
	
	
	
	
	
	
}
