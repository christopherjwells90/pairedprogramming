package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataNumbersToWordsTest {
	KataNumbersToWords kntw = new KataNumbersToWords();
	
	@Test
	public void convertOneDigitNumber() {
		Assert.assertEquals("zero", kntw.numbersToWords(0));
		Assert.assertEquals("three", kntw.numbersToWords(3));
		Assert.assertEquals("seven", kntw.numbersToWords(7));
	}
	
	@Test
	public void convertTwoDigitNumber() {
		Assert.assertEquals("ten", kntw.numbersToWords(10));
		Assert.assertEquals("fourteen", kntw.numbersToWords(14));
		Assert.assertEquals("twenty-six", kntw.numbersToWords(26));
	}
	
	@Test
	public void convertThreeDigitNumber() {
		Assert.assertEquals("two hundred and nine", kntw.numbersToWords(209));
		Assert.assertEquals("three hundred", kntw.numbersToWords(300));
		Assert.assertEquals("four hundred and twenty", kntw.numbersToWords(420));
	}
	
	@Test
	public void convertFourDigitNumber() {
		Assert.assertEquals("three thousand and four", kntw.numbersToWords(3004));
		Assert.assertEquals("five thousand and twenty-six", kntw.numbersToWords(5026));
		Assert.assertEquals("seven thousand and one hundred and eleven", kntw.numbersToWords(7111));
		Assert.assertEquals("six thousand and nine hundred and sixty-nine", kntw.numbersToWords(6969));
	}
	
	@Test
	public void convertFiveDigitNumber() {
		Assert.assertEquals("forty thousand", kntw.numbersToWords(40000));
		Assert.assertEquals("eighty-seven thousand and six hundred and fifty-four", kntw.numbersToWords(87654));
		
	}
	
	@Test
	public void convertSixDigitNumber() {
		Assert.assertEquals("five hundred thousand", kntw.numbersToWords(500000));
		Assert.assertEquals("eight hundred and three thousand and three hundred and eight", kntw.numbersToWords(803308));
		Assert.assertEquals("nine hundred and ninety-nine thousand and nine hundred and ninety-nine", kntw.numbersToWords(999999));
	}
}
