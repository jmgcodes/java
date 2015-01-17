import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Map.Entry;

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
		Map<String,Integer> tokenPair = new HashMap<String, Integer>();
		Map<String,Integer> twoGramPair = new HashMap<String, Integer>();
		Map<String,Integer> palindromePair = new HashMap<String, Integer>();

		
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
		printToken(tokenPair);
		
		
		//PartC
		
		twoGramPair = computeTwoGramFrequencies(tokenList);
		printTwoGram(twoGramPair);
		
		//PartD
		
		palindromePair = computePalindromeFrequencies(tokenList);
		printPalindrome(palindromePair);
	}
	
	//Part A
	public static List<String> tokenizeFile(String FileName){
		
		BufferedReader brSample = null;
		List<String> tokenList = new ArrayList();
		
		try {
 
			String strSample;
			brSample = new BufferedReader(new FileReader(FileName));
 
			while ((strSample = brSample.readLine()) != null) {
					
				for(String words: strSample.toLowerCase().split("[^a-z0-9]+")){
					if(words.length()>0)
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
	
	//Part B
	public static Map<String, Integer> computeWordFrequencies(List<String> tokenList){
		
		Map<String,Integer> tokenPairTemp = new HashMap<String, Integer>();
		
		for (String token : tokenList) {
			Integer count = tokenPairTemp.get(token);
			count = (count == null) ? 1 : ++count;
			tokenPairTemp.put(token, count);
		}
		
		return tokenPairTemp;
	
	}
	
	public static void printToken(Map<String, Integer> tokenPair){
		
		System.out.println("\nTokens: " + tokenPair.size());
		
		//System.out.println("\n\tFrequency - Token\n\t---------   -----\n");
		
		Set<Entry<String, Integer>> tokenPairSet = tokenPair.entrySet();
        List<Entry<String, Integer>> tokenPairList = new ArrayList<Entry<String, Integer>>(tokenPairSet);
        Collections.sort( tokenPairList, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> mapEntry1, Map.Entry<String, Integer> mapEntry2 )
            {
                return (mapEntry2.getValue()).compareTo( mapEntry1.getValue() );
            }
        } );
        
        for(Map.Entry<String, Integer> mapEntry:tokenPairList){
          //  System.out.println("\t" + mapEntry.getValue() + "\t" + mapEntry.getKey());
        }
						
	}
	
	//Part C
	
	public static Map<String, Integer> computeTwoGramFrequencies(List<String> tokenList){
		
		Map<String,Integer> twoGramPairTemp = new HashMap<String, Integer>();
		
		String previous = "";
		for (String token : tokenList) {
			String tokenTemp = (previous == "") ? token: previous + " " + token;
			previous = token;
			Integer count = twoGramPairTemp.get(tokenTemp);
			count = (count == null) ? 1 : ++count;
			twoGramPairTemp.put(tokenTemp, count);
			
		}
		
		return twoGramPairTemp;
	
	}
	
	public static void printTwoGram(Map<String, Integer> twoGramPair){
		
		System.out.println("\nTwo Grams: " + twoGramPair.size());
		
		//System.out.println("\n\tFrequency - Two Grams\n\t---------   ---------\n");
		
		Set<Entry<String, Integer>> twoGramPairSet = twoGramPair.entrySet();
        List<Entry<String, Integer>> twoGramPairList = new ArrayList<Entry<String, Integer>>(twoGramPairSet);
        Collections.sort( twoGramPairList, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> mapEntry1, Map.Entry<String, Integer> mapEntry2 )
            {
                return (mapEntry2.getValue()).compareTo( mapEntry1.getValue() );
            }
        } );
        
        for(Map.Entry<String, Integer> mapEntry: twoGramPairList){
          //  System.out.println("\t" + mapEntry.getValue() + "\t" + mapEntry.getKey());
        }
						
	}
	
	
	//Part D
	/*
	public static Map<String, Integer> computePalindromeFrequencies(List<String> tokenList){

		Map<String,Integer> palindromePairTemp = new HashMap<String, Integer>();
		
		int indexToken = 0;		
		
		for (String token : tokenList) {
						
			boolean palindrome = false;
			
			palindrome = isPalindrome(token);
			
			if(palindrome){	
				Integer count = palindromePairTemp.get(token);
				count = (count == null) ? 1 : ++count;
				palindromePairTemp.put(token, count);
			}
			
			
			int index = indexToken;
			int strlen = 0;
			String strTemp = token;
			
			while(strlen<=20 && index < tokenList.size()-1){
				
				strTemp += tokenList.get(index+1);
				
				palindrome = isPalindrome(strTemp);
			
				if(palindrome){	
					Integer count = palindromePairTemp.get(strTemp);
					count = (count == null) ? 1 : ++count;
					palindromePairTemp.put(strTemp, count);
				}
				
				strlen = strTemp.length();
				index++;
			}
			
			indexToken++;
		}
		
		return palindromePairTemp;
	
	}*/
	
	public static Map<String, Integer> computePalindromeFrequencies(List<String> tokenList){

		Map<String,Integer> palindromePairTemp = new HashMap<String, Integer>();
		
		int indexToken = 0;	
		int indexNotIncl = -1;	
		
		for (String token : tokenList) {
						
			boolean palindrome = false;
			/*
			palindrome = isPalindrome(token);
			
			if(palindrome){	
				Integer count = palindromePairTemp.get(token);
				count = (count == null) ? 1 : ++count;
				palindromePairTemp.put(token, count);
			}
			*/
			
			int index = indexToken;
			int indexPal = -1;
			
			int strlen = 0;
			String strTemp = "";
			String strPalindrome = "";
			
			while(strlen<=20 && index < tokenList.size()){
				
				strTemp += tokenList.get(index);
				
				palindrome = isPalindrome(strTemp);
			
				if(palindrome){	
					
					strPalindrome = strTemp;
					indexPal = index;
					//indexToken = index;
					
				}
				
				strlen = strTemp.length();
				index++;
			}
			
			if(strPalindrome.length() > 1 && indexPal > indexNotIncl){
				
				Integer count = palindromePairTemp.get(strPalindrome);
				count = (count == null) ? 1 : ++count;
				palindromePairTemp.put(strPalindrome, count);
				
				indexNotIncl = indexPal;
				
			}

			
			indexToken++;
		}
		
		return palindromePairTemp;
	
	}
	
	public static boolean isPalindrome(String str){
		
		
		int len = str.length();
			
			for(int i=0, j=len-1; i<j; i++, j--){
				if(str.charAt(i)==str.charAt(j))
					continue;
				else{
					return false;
				}
			}
			
			return true;
	}
	
	public static void printPalindrome(Map<String, Integer> palindromePair){
		
		System.out.println("\nPalindromes: " + palindromePair.size());
		
		//System.out.println("\n\tFrequency - Palindromes\n\t---------   -----------\n");
		
		Set<Entry<String, Integer>> palindromePairSet = palindromePair.entrySet();
        List<Entry<String, Integer>> palindromePairList = new ArrayList<Entry<String, Integer>>(palindromePairSet);
        Collections.sort( palindromePairList, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> mapEntry1, Map.Entry<String, Integer> mapEntry2 )
            {
                return (mapEntry2.getValue()).compareTo( mapEntry1.getValue() );
            }
        } );
        
        for(Map.Entry<String, Integer> mapEntry: palindromePairList){
           // System.out.println("\t" + mapEntry.getValue() + "\t\t" + mapEntry.getKey());
        }
						
	}
	
}
