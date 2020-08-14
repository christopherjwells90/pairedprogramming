package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
        System.out.println("Please input your bill:");
        
		Scanner input = new Scanner(System.in);
		String strBillTotal = input.nextLine(); 
		double billTotal = Double.parseDouble(strBillTotal);
		System.out.println("You entered $" + billTotal + ".");
		
        System.out.println("Please input how much you will be paying:");
        
		String strPayment = input.nextLine(); 
		double payment = Double.parseDouble(strPayment);
		double change = payment - billTotal;
		System.out.println("You entered $" + payment + " as your payment.");
		if (change < 0.0) {
			System.out.println("Hey bud you're short $" + (change * -1) + ", pay up or I'm calling the cops.");
		}
		String thankYou = "Your change today is $" + change + ", have a nice day."; 
		 if(change >= 0.0) {
			 if(change == 0.0) {
				 System.out.println("What no tip? Fine well you get no change.");
			 }
			 System.out.println(thankYou);
		 }
	}

}
