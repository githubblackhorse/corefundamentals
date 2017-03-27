package com.fundamentals.utils.number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {	
	
	public static Set<Integer> generateUniqueRandomIntegersInRange_HashSet(Integer size, Integer minRange, Integer maxRange) {
		System.out.println("NumberGenerator : generateUniqueRandomIntegersInRange_HashSet() : Start");
		validateInput(size, minRange, maxRange);
		
		HashSet<Integer> integers = new HashSet<Integer>();		
		Random random = new Random();		
		
		//Insert Operations
		long startTime = System.currentTimeMillis();
		for (int i=1; i<=size; i++) {			
			integers.add(random.nextInt((maxRange - minRange) + 1) + 1);
		}
		long endTime = System.currentTimeMillis();
		//System.out.println("HashSet Insert: Time taken (in millis): " + (endTime - startTime));		
		
		System.out.println("NumberGenerator : generateUniqueRandomIntegersInRange_HashSet() : End");
		return integers;
	}
	
	public static List<Integer> generateUniqueRandomIntegersInRange_ArrayList(Integer size, Integer minRange, Integer maxRange) {
		System.out.println("NumberGenerator : generateUniqueRandomIntegersInRange_ArrayList() : Start");
		
		validateInput(size, minRange, maxRange);		
		
		List<Integer> integers = new ArrayList<Integer>();
		Random random = new Random();
		
		//long startTime = System.currentTimeMillis();
		for (int i=1; i<=size; i++) {			
			int randInt = random.nextInt(maxRange - minRange);
			integers.add(randInt + minRange);
		}
		//long endTime = System.currentTimeMillis();
		
		//System.out.println("ArrayList Insert: Time taken (in millis): " + (endTime - startTime));		
		System.out.println("NumberGenerator : generateUniqueRandomIntegersInRange_ArrayList() : End");
		return integers;
	}
	
	public static Integer generateOneRandomNumber(int minRange, int maxRange) {
		Random random = new Random();
		int randInt = random.nextInt(maxRange - minRange);
		return (randInt + minRange);
	}
	
	public static void validateInput(Integer size, Integer minRange, Integer maxRange) {
		if (minRange > maxRange) {
			throw new IllegalArgumentException("maxRange must be greated than minRange");
		} else if (size < 1) {
			throw new IllegalArgumentException("size should be greater than or equal to 1");
		}		
	}
	
	public static void printIntegers(Set<Integer> integers) {
		System.out.println("List of randonmly generated integers");
		for(Integer eachInt : integers) {
			System.out.println(eachInt);
		}
	}
	
	public static void main(String [] args) {
		Set<Integer> integersSet = NumberGenerator.generateUniqueRandomIntegersInRange_HashSet(10000000, 1, 1000000000);	
		System.out.println("Total Integers Generated:" + integersSet.size());
		List<Integer> integersList = NumberGenerator.generateUniqueRandomIntegersInRange_ArrayList(10000000, 1, 1000000000);	
		System.out.println("Total Integers Generated:" + integersList.size());
		//printIntegers(integersList);
	}	 
}
