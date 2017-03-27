package com.fundamentals.client.api;

public interface IMathPlugin {

	public void generateRandomMaxNumbers (int totalMaxNumbers, int eachRandomNumberGroupSize, Integer minRange, Integer maxRange);
	
	public void generateRandomMinNumbers (int totalMinNumbers, int eachRandomNumberGroupSize, Integer minRange, Integer maxRange);
}
