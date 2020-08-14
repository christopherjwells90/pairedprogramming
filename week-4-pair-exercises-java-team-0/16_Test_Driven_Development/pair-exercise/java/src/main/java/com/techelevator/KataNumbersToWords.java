package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class KataNumbersToWords {
	private Map<Integer, String> map = new HashMap<Integer, String>();
	
	
	
	public String numbersToWords(int num) {
		setUpMap();
		
		String result = "";
		if (num == 0) {
			result = map.get(num);
		}
		if (num > 99999) {
			int flattenedSixDigit = num/1000;
			if (flattenedSixDigit > 99) {
				int flattenedThreeDigit = flattenedSixDigit/100;
				if (num%1000 == 0) {
					result = result + map.get(flattenedThreeDigit) + " hundred thousand";
					num-=num;
				}
				else {
					result = result + map.get(flattenedThreeDigit) + " hundred and ";
					num -= flattenedThreeDigit*100000;
				}
			}
		}	
		if (num > 9999) {
			int flattenedFiveDigit = num/1000;
			if (num%1000 == 0) {
				if (flattenedFiveDigit > 20) {
					int flattenedTens = (flattenedFiveDigit/10)*10;
					result = result + map.get(flattenedTens) + " thousand";
					num -= flattenedFiveDigit*1000;
					flattenedFiveDigit-=flattenedTens;
				}
				if (flattenedFiveDigit < 21 && flattenedFiveDigit > 0) {
					result += map.get(flattenedFiveDigit) + " thousand";
					num-=flattenedFiveDigit*1000;
				}
			}
			if (flattenedFiveDigit > 20) {
				int flattenedTens = (flattenedFiveDigit/10)*10;
				result = result + map.get(flattenedTens) + "-";
				num -= (flattenedTens)*1000;
				flattenedFiveDigit-=flattenedTens;
			}
			if (flattenedFiveDigit < 21 && flattenedFiveDigit > 0) {
				result += map.get(flattenedFiveDigit) + " thousand and ";
				num-=(num/1000)*1000;
			}
			
		}
		if (num > 999) {
			int flattenedFourDigit = num/1000;
			if (num%1000 == 0) {
				result = result + map.get(flattenedFourDigit) + " thousand";
				num-=num;
			}
			else {
				result = result + map.get(flattenedFourDigit) + " thousand and ";
				num -= flattenedFourDigit*1000;
			}
		}
		if (num > 99) {
			int flattenedThreeDigit = num/100;
			if (num%100 == 0) {
				result = result + map.get(flattenedThreeDigit) + " hundred";
				num-=num;
			}
			else {
				result = result + map.get(flattenedThreeDigit) + " hundred and ";
				num -= flattenedThreeDigit*100;
			}
		}
		if (num > 20) {
			int flattenedTens = (num/10)*10;
			result = result + map.get(flattenedTens) + "-";
			num -= flattenedTens;
		}
		if (num < 21 && num > 0) {
			result += map.get(num);
		}
		
		return result;
	}



	private void setUpMap() {
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");
		map.put(20, "twenty");
		map.put(30, "thirty");
		map.put(40, "forty");
		map.put(50, "fifty");
		map.put(60, "sixty");
		map.put(70, "seventy");
		map.put(80, "eighty");
		map.put(90, "ninety");
	}
}
