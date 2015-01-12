import java.util.Scanner;

public class BinaryGray{
	
	public static void fnBinaryGray(){
		
		System.out.println("This program converts a number into its binary and gray counterparts\n");
		
		System.out.println("Enter the number: ");
		
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		String bin = fnBin(num);
		String gray = fnGray(bin);
		
		System.out.println("Binary: " + bin);
		System.out.println("Gray: " + gray);
		
	}
	
	private static String fnBin(int num){
		
		String bin = "";
		
		while(num>0){
			
			bin = (num%2) + bin;
			num >>= 1;
			
		}
		
		return bin;
		
	}
	
	private static String fnGray(String bin){
		
		String gray = "";
		
		gray = gray + bin.charAt(0);
		
		for(int i=1; i<bin.length(); i++){
			
			gray += (bin.charAt(i) ^ bin.charAt(i-1));
			
		}
		
		return gray;
		
	}
}
