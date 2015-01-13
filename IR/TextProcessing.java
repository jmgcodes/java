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
		
		List<String> tokenList = new ArrayList();
		Map<String,Integer> tokenPair = new TreeMap<String, Integer>();
		
		
		//PartA
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
			
		print(tokenList);
		
		
		//PartB
		
		tokenPair = computeWordFrequencies(tokenList);
		print(tokenPair);
			
	}
	
	
	public static List<String> tokenizeFile(String FileName){
		
		BufferedReader brSample = null;
		List<String> tokenList = new ArrayList();
		
		try {
 
			String strSample;
			brSample = new BufferedReader(new FileReader(FileName));
 
			while ((strSample = brSample.readLine()) != null) {
					
				for(String words: strSample.toLowerCase().split("[^a-z0-9]+")){
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
	
	public static void print(List<String> tokenList){
		
		//System.out.println("Tokens: " + tokenList);
		
	}
	
	public static Map<String, Integer> computeWordFrequencies(List<String> tokenList){
		
		Map<String,Integer> tokenPairTemp = new TreeMap<String, Integer>();
		
		for (String token : tokenList) {
			Integer count = tokenPairTemp.get(token);
			count = (count == null) ? 1 : ++count;
			tokenPairTemp.put(token, count);
		}
		
		return tokenPairTemp;
	
	}
	
	public static void print(Map<String, Integer> tokenPair){
		
		System.out.println("\nTokens: " + tokenPair.size());
		
		//System.out.println("\n\tToken\t\tFrequency\n\t-----\t\t---------\n");
		
		for(String token : tokenPair.keySet()){
			
			//System.out.println("\t" + token + "\t\t" + tokenPair.get(token));

		}
		
	}
	
}
