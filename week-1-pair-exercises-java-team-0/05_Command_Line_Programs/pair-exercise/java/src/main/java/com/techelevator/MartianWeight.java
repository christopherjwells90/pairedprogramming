package com.techelevator;

import java.util.Scanner;

/*
 In case you've ever pondered how much you weight on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

 $ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth, is 37 lbs. on Mars.
 235 lbs. on Earth, is 88 lbs. on Mars.
 185 lbs. on Earth, is 69 lbs. on Mars. 
 */
public class MartianWeight {
	
	public static void main(String[] args) {
		System.out.println("With a space inbetween, please input the weight of your items: ");
		Scanner input = new Scanner(System.in);
		String strWeight = input.nextLine();
		String[] strItemWeights = strWeight.split(" ");
		double martianGravityFactor = 0.378; //magic number
		int startWeight = 0;
		int martianWeights = 0;
		
		
		for(int i=0; i< strItemWeights.length; i++) {
			startWeight = Integer.parseInt(strItemWeights[i]);
			martianWeights = (int)(startWeight * martianGravityFactor);
			System.out.println(startWeight + " lbs. on Earth, is " + martianWeights + " lbs. on Mars.");
		}
		
	}
}
