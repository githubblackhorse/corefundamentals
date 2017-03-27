package com.fundamentals.utils.string;

import java.util.ArrayList;
import java.util.List;

import com.fundamentals.utils.number.NumberGenerator;

public class WordGenerator {
	
	private final String charList;
	
	public WordGenerator(String aCharList) {
		charList = aCharList;
	}
	
	public List<String> generateRandomWords (int totalWords, boolean variableLength, int minLength, int maxLength, int fixedLength) {
		
		List<String> words = new ArrayList<String>();
		int eachWordLength = fixedLength;
		
		StringBuffer randomString = new StringBuffer();
		for (int i=1; i<=totalWords; i++) {			

			if(variableLength) {
				eachWordLength = NumberGenerator.generateOneRandomNumber(minLength, maxLength);
			}
			
			int eachCharIndex = 0;
			for(int j=1; j<=eachWordLength; j++) {
				eachCharIndex = NumberGenerator.generateOneRandomNumber(0, charList.length()-1);
				randomString.append(charList.charAt(eachCharIndex));
				eachCharIndex = 0;
			}
			
			System.out.println("Random String Generated: " + randomString);
			words.add(randomString.toString());
			randomString.delete(0, randomString.length());
		}
		
		System.out.println("Number of random words generated: " + words.size());
		return words;
	}
	
	public static void main(String [] args) {
		WordGenerator wGen = new WordGenerator("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		wGen.generateRandomWords(1000, true, 6, 10, 0);
	}
}
