package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws FileNotFoundException {
		//C:\Users\Student\workspace\week-4-pair-exercises-java-team-0\18_FileIO_Writing_out\pair-exercise\java\alices_adventures_in_wonderland.txt
		Scanner input = new Scanner(System.in);
		String searchWord = getSearchWord(input);
		String replaceWord = setReplaceWord(input);
		File wordReplaceFile = null;
		wordReplaceFile = getFilePath(input, wordReplaceFile);
		File newFile = null;
		newFile = setReplacementPath(input, newFile);
		newFile = wordSearch(wordReplaceFile, newFile, searchWord, replaceWord);
		System.out.println("Word replacement finished!");
		
	}
	
	private static String getSearchWord(Scanner input) {
		String searchWord;
		System.out.println("Please enter the word that you would like to search for.");
		searchWord = input.nextLine();
		return searchWord;
	}
	
	private static String setReplaceWord(Scanner input) {
		String replaceWord;
		System.out.println("Please enter the word that you would like to use as a replacement.");
		replaceWord = input.nextLine();
		return replaceWord;
	}
	
	private static File getFilePath(Scanner input, File wordReplaceFile) {
		String filePath;
	    System.out.println("Please enter a file path for word replacement progaram: ");
	    filePath = input.nextLine();
	    try { 
	    	wordReplaceFile = new File(filePath);
	    	if (wordReplaceFile.exists() && wordReplaceFile.isFile()) {  
	    	} 
	    	else {
	    		System.out.println("You have not entered a valid file.");
	    		System.exit(0);
	           
	    	}
	    } catch (Exception e) {
	    	System.out.println("Something has gone wrong!");
	    }
	    
		return wordReplaceFile;
	}
	
	private static File setReplacementPath(Scanner input, File newFile) {
		String filePath;
	    System.out.println("Please enter a file path for word replacement progaram to put new file with replacements: ");
	    filePath = input.nextLine();
	    String fileName = "File_With_Words_Replaced.txt";
	    try { 
	    	newFile = new File(filePath, fileName);
	    	newFile.createNewFile();
	    	if (newFile.exists() && newFile.isFile()) {  
	    	} 
	    	else {
	    		System.out.println("You have not entered a valid file destination.");
	    		System.exit(0);
	           
	    	}
	    } catch (Exception e) {
	    	System.out.println("You have not entered a valid file destination.");
	    	System.exit(0);
	    }
	    
		return newFile;
	}
	
	private static File wordSearch(File wordReplaceFile, File newFile, String searchWord, String replaceWord) throws FileNotFoundException {
		
		if (wordReplaceFile != null) {
			try (Scanner wordCountScanner = new Scanner(wordReplaceFile)) {
				try (FileWriter writer = new FileWriter(newFile)) {
					while (wordCountScanner.hasNextLine()) {
						String line = wordCountScanner.nextLine();
						line = line.replaceAll(searchWord, replaceWord);
						writer.write(line+"\n");
					}
				}
			} catch (Exception e) {
				System.out.println("Something wrong has happened.");
				
			} finally {
			
			}
	    }
		return newFile;
	}
}
