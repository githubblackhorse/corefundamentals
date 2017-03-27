package com.fundamentals.multithreading.tasks;

import java.util.List;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

public final class MaxNumberCalculator implements Callable<Integer> {
	
	private static Logger logger = Logger.getLogger(MaxNumberCalculator.class.getName());
	List<Integer> integers;	
	
	public MaxNumberCalculator(List<Integer> aIntegers) {
		integers = aIntegers;
	}
	
	@Override
	public Integer call() throws Exception {
		logger.debug("MaxNumberCalculator : call() : Thread started max number calculator");
		logger.trace("MaxNumberCalculator : call() : Thread Name: `" + Thread.currentThread().getName() + "`");
		
		return calculateMaxNumber();
	}	
	
	private final Integer calculateMaxNumber() {
		Integer maxNumber = 0;
		
		for (Integer eachInteger : integers) {
			if (eachInteger > maxNumber) {
				maxNumber = eachInteger;
			}
		}
		return maxNumber;	
	}
}
