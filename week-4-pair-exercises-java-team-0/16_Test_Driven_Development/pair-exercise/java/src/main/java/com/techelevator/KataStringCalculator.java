package com.techelevator;

public class KataStringCalculator {
	public int add(String numbers) {
		int result = 0;
		String delimiter;
		if (numbers.startsWith("//")) {
			delimiter = numbers.substring(2,3);
			numbers = numbers.replaceAll(delimiter, ",");
			numbers = numbers.substring(3);
		}
		
		String[] splitNumString = numbers.split("\\n|,");
		
		if (numbers.length()>0) {
			for (int i = 0; i < splitNumString.length; i++) {
				if (!splitNumString[i].equals("")) {
					result += Integer.parseInt(splitNumString[i]);
				}
				
			}
		}
		
		return result;
	}
}
//given string Numbers, parse into integers
	//split on commas
//check to see if Numbers is empty/null