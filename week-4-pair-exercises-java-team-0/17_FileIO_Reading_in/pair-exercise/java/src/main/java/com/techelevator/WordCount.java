package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class WordCount {

	public static void main(String[] args) {
	    //prompt for file path
	    //create file object based on file path
	    //read file object line by line
	    //for each line, count words and sentence
	    //return both
	    boolean validPath = false;
	    Scanner input = new Scanner(System.in);
	    String filePath = null;
	    File wordCountFile = null;
	    
	    while (!validPath) {
	    	System.out.println("Please enter a file path for word count progaram: ");
	    	
	    	filePath = input.nextLine();
	    
	    	try { 
	    		wordCountFile = new File(filePath);
	    		if (wordCountFile.exists() && wordCountFile.isFile()) {
	            validPath = true;   
	    		} 
	    		else {
	    			System.out.println("You have not entered a valid path.");
	           
	    		}
	    	} catch (Exception e) {
	    		System.out.println("Something has gone wrong!");
	    	}
	    }
	   int wordCount = 0;
	   int sentenceCount = 0;
	   if (wordCountFile != null) {
		   try (Scanner wordCountScanner = new Scanner(wordCountFile)) {
			   while (wordCountScanner.hasNextLine()) {
				   String line = wordCountScanner.nextLine();
				   String[] words = line.split(" ", 0);
				   for (String word: words) {
					   if (word.equals("")) {
						  wordCount--;
					   }
					   if (word.contains("?")||word.contains("!")||word.contains(".")) {
						   sentenceCount++;
					   }
				   }
				   wordCount+=words.length;		   }
		   } catch (Exception e) {
				System.out.println("Something has gone horribly wrong. A crow caws in the distance.");
				e.printStackTrace();
		   }
	   }
	   System.out.println("Word Count: "+wordCount);
	   System.out.println("Sentence Count: "+sentenceCount);
	    
	}
}
