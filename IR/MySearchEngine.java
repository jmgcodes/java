/*
 * Author: Jwala Mohith Girisha
 * Student ID: 12647996
 * 
 * This is the main class. 
 * In this class a TextProcessing object is created and used to process a file by tokenizing it and computing the Two Grams and Palindromes in it.
 * 
 */

import java.util.Scanner;
import java.util.Date;


public class MySearchEngine{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
	
		System.out.println("Search Engine Implementation");
	
		System.out.println("\nPart1: Text Processing\n-----------------------------------------------------------------\n");
		
		TextProcessing txtProcObj = new TextProcessing();
		txtProcObj.fnBeginTextProcessing();

	}
	
}
