package com.fundamentals.clientApp;

import com.fundamentals.multithreading.MathOperations;

public class ExternalApplication {

	public static void main(String[] args) {
		
		//Random set of maximum numbers within a given set
		MathOperations maxNumberOpr = new MathOperations();
		//operations.generateRandomMaxNumbers(5, 10000000, 1, 1000000000);
		maxNumberOpr.generateRandomMaxNumbers(5, 10, 1, 100);
		maxNumberOpr.printRandomNumbers();
		
		//Random set of minimum numbers within a given set
		MathOperations minNumberOpr = new MathOperations();
		//operations.generateRandomMinNumbers(5, 10000000, 1, 1000000000);
		minNumberOpr.generateRandomMinNumbers(5, 10, 1, 100);
		minNumberOpr.printRandomNumbers();
	}

}
