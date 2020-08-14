package com.techelevator;

import org.junit.*;

public class KataWordsToNumbersTest {
	
	KataWordsToNumbers kwtn = new KataWordsToNumbers();
	@Test
	public void convertOneDigitWord() {
		Assert.assertEquals(0, kwtn.wordsToNumbers("zero"));
		Assert.assertEquals(3, kwtn.wordsToNumbers("three"));
		Assert.assertEquals(7, kwtn.wordsToNumbers("seven"));
	}
}
