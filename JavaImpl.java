import java.util.Scanner;


public class JavaImpl{

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Programs Implemented");

		System.out.println("1. String class basics");
		System.out.println("2. Binary and Gray code");
		System.out.println("3. Merge sort array");
		System.out.println("4. Merge sort LL");

		System.out.println("\nEnter the program you like to run: ");
		
		int sel = in.nextInt();
		
		System.out.println("---------------------------------------------------------------------\n\n");
		switch(sel){
			
			case 1: 
				
				StringImpl.fnStringImpl();
				
				break;
				
			case 2:
				BinaryGray.fnBinaryGray();
				break;
				
			case 3:
				MergeSort.fnMergeSort();
				break;
				
			case 4:
				LLMergeSort LLMS = new LLMergeSort();
				LLMS.fnLLMergeSort();
				break;
				
			default:
				break;
		}
		
	}
}


