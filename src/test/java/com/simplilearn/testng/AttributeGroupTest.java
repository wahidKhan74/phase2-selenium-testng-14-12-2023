package com.simplilearn.testng;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

/**
 * This class demonstrate attribute of @Test.
 * 
 * @author khanw
 *
 */
public class AttributeGroupTest {

	// @Test annotation that describes the information about the test.
	@Test(description = "The sample Test One", priority = 2)
	public void testOne() {
		System.out.println("--- Test One is executed ---");
		// fail();
	}

	// @Test annotation that describes the information about the test.
	@Test(description = "The sample Test Three", priority = 1 , enabled = false)
	public void testThree() {
		System.out.println("--- Test Three is executed ---");
		// fail();
	}

	// @Test annotation, attribute dependOnMethods used
	// When the second test method wants to be dependent on the first test method.
	@Test(description = "The sample Test Two", dependsOnMethods = { "testOne", "testThree" }, alwaysRun = true)
	public void testTwo() {
		System.out.println("--- Test Two is executed ---");
	}

	
	@Test(groups = "Regression Test")
	public void r1() {
		System.out.println("--- Test R1 is executed ---");
	}
	
	@Test(groups = "Regression Test" , timeOut = 200)
	public void r2() throws InterruptedException {
		// fail();
		Thread.sleep(500);
		System.out.println("--- Test R2 is executed ---");
	}
	
	@Test(groups = "Regression Test" , dependsOnGroups = {"Regression Test"})
//	@Test(groups = "Regression Test" , dependsOnGroups = {"Regression Test"}, alwaysRun = true)
	public void r3() {
		System.out.println("--- Test R3 is executed ---");
	}
}
