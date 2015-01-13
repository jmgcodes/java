import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
/*
 * Author: Jwala Mohith Girisha
 * 
 */

import java.io.IOException;
import java.io.File;
 
 
public class TextProcessing{

	public static void fnBeginTextProcessing(){
		
		Scanner in = new Scanner(System.in);
		
		List tokenList = new ArrayList();
		
		String filePath;
		System.out.println("Enter the file path:");
		
		filePath = in.nextLine();
		File file = new File(filePath);
	
		if(file.exists() && !file.isDirectory())
			tokenList = tokenizeFile(filePath);
		else{
			System.out.println("File not found");
			return;
		}			
			
		System.out.println("Tokens: " + tokenList);
			
	}
	
	
	public static List tokenizeFile(String FileName){
		
		BufferedReader brSample = null;
		List tokenList = new ArrayList();
		
		try {
 
			String strSample;
			brSample = new BufferedReader(new FileReader(FileName));
 
			while ((strSample = brSample.readLine()) != null) {
				
				System.out.println(strSample);
		
				for(String words: strSample.split("[^a-zA-Z0-9]+")){
					tokenList.add(words);
				}
		
			}
 
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (brSample != null)
					brSample.close();
					
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	
		return tokenList;
	}
	
}
