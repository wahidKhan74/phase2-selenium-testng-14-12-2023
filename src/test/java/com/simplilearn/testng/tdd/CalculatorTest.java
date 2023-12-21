package com.simplilearn.testng.tdd;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.simplilearn.testng.Calculator;

public class CalculatorTest {
	
	
	Calculator calculator;
	
	@BeforeMethod
	public void setUp() {
		calculator = new Calculator();
	}
	
	@AfterMethod
	public void cleanUp() {
		calculator = null;
	}
	
	@Test(description = "Test +ve numbers")
	public void testAddition1() {
		int eResult = 100;
		int aResult = calculator.add(50, 50);
		assertEquals(aResult, eResult);
	}
	
	@Test(description = "Test -ve numbers")
	public void testAddition2() {
		int eResult = 0;
		int aResult = calculator.add(-50, -50);
		assertEquals(aResult, eResult);
	}
	
	@Test(description = "Test -ve and +ve numbers")
	public void testAddition3() {
		int eResult = 0;
		int aResult = calculator.add(-20, 30);
		assertEquals(aResult, eResult);
	}


	@Test(description = "Test +ve and -ve numbers")
	public void testAddition4() {
		int eResult = 0;
		int aResult = calculator.add(50, -50);
		assertEquals(aResult, eResult);
	}
	
	@Test(description = "Test0 and +ve numbers")
	public void testAddition5() {
		int eResult = 50;
		int aResult = calculator.add(0, 50);
		assertEquals(aResult, eResult);
	}
	
	@Test(description = "Test0 and -ve numbers")
	public void testAddition6() {
		int eResult = 0;
		int aResult = calculator.add(0, -50);
		assertEquals(aResult, eResult);
	}
}
