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
		
		System.out.println("Tokens: " + tokenList);
		
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
		
		System.out.println("\n\tFrequency - Token\n\t---------   -----\n");
		
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
            System.out.println("\t" + mapEntry.getValue() + "\t" + mapEntry.getKey());
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
		
		System.out.println("\n\tFrequency - Two Grams\n\t---------   ---------\n");
		
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
            System.out.println("\t" + mapEntry.getValue() + "\t" + mapEntry.getKey());
        }
						
	}
	
}
