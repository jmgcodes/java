//package com.self.impl;
import java.util.Scanner;

public class StringImpl{
	
	public static void fnStringImpl(){
		
		
	System.out.println("This program teaches the basics of the string class in Java\n\n");
	
	Scanner in = new Scanner(System.in);
	
	String s1;
	
	System.out.println("Enter a string:");
	s1 = in.nextLine();
	
	System.out.println("String you entered: " + s1);
	
	int len = s1.length();
	
	System.out.println("Length of string: " + len + "\n");
	
	System.out.println("After trim: " + s1.trim());
	
	System.out.println("To upper: " + s1.toUpperCase());
	
	System.out.println("To lower: " + s1.toLowerCase());
	
	System.out.println("Concat 'Good night': " + s1.concat(" Good night"));
	
	System.out.println("Substring from 2-4: " + s1.substring(2,4));
	
	System.out.println("Replace: " + s1.replace('!',':'));
	
	System.out.println("Find hi: " + s1.contains("hi"));
	
	}
}
