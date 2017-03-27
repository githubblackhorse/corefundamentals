package com.fundamentals.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.fundamentals.client.api.IMathPlugin;
import com.fundamentals.multithreading.tasks.MaxNumberCalculator;
import com.fundamentals.multithreading.tasks.MinNumberCalculator;
import com.fundamentals.utils.number.NumberGenerator;

public class MathOperations implements IMathPlugin {

	ExecutorService executor = Executors.newFixedThreadPool(10);
	private List<Integer> integerList = new ArrayList<Integer>();
	
	/**	  
	 * @param totalMaxNumbers: Total Number of Integers
	 * @param eachRandomNumberGroupSize : Size of each group from which one Random number should be picked up
	 * @param minRange : Minimum number for each group
	 * @param maxRange : Maximum number for each group
	 */
	public void generateRandomMaxNumbers (int totalMaxNumbers, int eachRandomNumberGroupSize, Integer minRange, Integer maxRange) {
		System.out.println("MathOperations: generateRandomMaxNumbers() : Start");
		
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();	
		
		//Calculate totalMaxNumbers Max Numbers from each of the randomly generated group
		for (int i=1; i<=totalMaxNumbers; i++) {
			List<Integer> integersList = NumberGenerator.generateUniqueRandomIntegersInRange_ArrayList(eachRandomNumberGroupSize, minRange, maxRange);
			MaxNumberCalculator calculator  = new MaxNumberCalculator(integersList);				
			
			Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
		}		
		
		for(Future<Integer> future : resultList)
        {
			try {            
				integerList.add((Integer)future.get());
			} 
            catch (Exception e)	{
            	e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("MathOperations: generateRandomMaxNumbers() : End");
	}	
	
	/**	  
	 * @param totalMinNumbers: Total Number of Integers
	 * @param eachRandomNumberGroupSize : Size of each group from which one Random number should be picked up
	 * @param minRange : Minimum number for each group
	 * @param maxRange : Maximum number for each group
	 */
	public void generateRandomMinNumbers (int totalMinNumbers, int eachRandomNumberGroupSize, Integer minRange, Integer maxRange) {
		System.out.println("MathOperations: generateRandomMinNumbers() : Start");
		
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		
		//Calculate totalMaxNumbers Max Numbers from each of the randomly generated group
		for (int i=1; i<=totalMinNumbers; i++) {
			System.out.println("MathOperations: generateRandomMinNumbers() : Generating random nubmers for Group : " + i);
			List<Integer> integersList = NumberGenerator.generateUniqueRandomIntegersInRange_ArrayList(eachRandomNumberGroupSize, minRange, maxRange);
			MinNumberCalculator calculator  = new MinNumberCalculator(integersList);
			
			Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
		}		
		
		for(Future<Integer> future : resultList)
        {
			try {            
				integerList.add((Integer)future.get());
			} 
            catch (Exception e)	{
            	e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("MathOperations: generateRandomMinNumbers() : End");
	}	
	
	public List<Integer> getGeneratedNumbers() {
		return this.integerList;
	}
	
	public void printRandomNumbers() {
		System.out.println("Following are the numbers generated from random number groups:");
		
		for(Integer num : integerList) {
			System.out.println(num);
		}
	}
	
	public static void main(String[] args) {	
		
		MathOperations operations = new MathOperations();
		operations.generateRandomMaxNumbers(15, 10, 1, 100);
		operations.printRandomNumbers();
	}
}
