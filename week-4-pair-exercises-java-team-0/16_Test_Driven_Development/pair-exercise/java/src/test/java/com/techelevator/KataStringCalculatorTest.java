package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataStringCalculatorTest {
	KataStringCalculator ksc = new KataStringCalculator();
	
	@Test
	public void testReturnsZeroOneOrTwoNumbersSummedUp() {
		String noNumbers = "";
		String oneNumber = "1";
		String twoNumbers = "1,2";
		Assert.assertEquals(0, ksc.add(noNumbers));
		Assert.assertEquals(1, ksc.add(oneNumber));
		Assert.assertEquals(3, ksc.add(twoNumbers));
	}
	
	@Test
	public void testReturnsSumOfAnyStringLength() {
		String bunchaNumbers = "1,2,3,4,5";
		Assert.assertEquals(15, ksc.add(bunchaNumbers));
	}
	
	@Test
	public void testReturnsSumWithNewlineAndComma() {
		String newlineNumbers = "5\n3,2";
		Assert.assertEquals(10, ksc.add(newlineNumbers));
	}
	
	@Test
	public void canDeliminateOnOtherThingsCorrectly() {
		String delimChoice1 = "//;\n1;2";
		String delimChoice2 = "//!\n4!9";
		String delimChoice3 = "3\n5\n2,6";
		Assert.assertEquals(3, ksc.add(delimChoice1));
		Assert.assertEquals(13, ksc.add(delimChoice2));
		Assert.assertEquals(16, ksc.add(delimChoice3));
	}
}
