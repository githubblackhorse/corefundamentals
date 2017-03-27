package com.fundamentals.multithreading.tasks;

import java.util.List;
import java.util.concurrent.Callable;

public final class MinNumberCalculator implements Callable<Integer> {

	List<Integer> integers;	
	
	public MinNumberCalculator(List<Integer> aIntegers) {
		integers = aIntegers;
	}
	
	@Override
	public Integer call() throws Exception {
		return calculateMinNumber();
	}
	
	private final Integer calculateMinNumber() {
		Integer maxNumber = 0;
		
		for (Integer eachInteger : integers) {
			if (eachInteger > maxNumber) {
				maxNumber = eachInteger;
			}
		}
		return maxNumber;	
	}
}
