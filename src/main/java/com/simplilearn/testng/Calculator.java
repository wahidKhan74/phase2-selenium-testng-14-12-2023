package com.simplilearn.testng;

/**
 * This class will demonstrate basic arithmetic calculation
 * @author khanw
 *
 */
public class Calculator {
    
	// addition fn should never return -ve values. ( should return +ve number or zero )
	public int add(int num1 , int num2) {
		if(num1>=0 & num2>=0)
			return num1 + num2;
		else 
			return 0;
	}
}
