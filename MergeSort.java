import java.util.Scanner;
import java.util.Arrays;

public class MergeSort{
	
	public static void fnMergeSort(){
		
		System.out.println("Merge sort an array\n");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in the array");
		
		int n = in.nextInt();
		
		int arr[] = new int[n];
		
		System.out.println("Enter " + n + " elements of the array");
		
		for(int i=0; i<n; i++){
			
			String token = in.next();
			arr[i] = Integer.parseInt(token);
		
		}
		
		System.out.println("Array to be sorted: " + Arrays.toString(arr));
		
		arr = mergeSortArray(arr, n);
		
		System.out.println("Sorted Array: " + Arrays.toString(arr));
		
	}
	
	public static int[] mergeSortArray(int arr[], int size){
		
		if(size==1)
			return arr;
			
		int mid = (size)/2;
		
		int a[] = new int[mid];
		int b[] = new int[mid];
		
		for(int i=0; i< mid; i++){
			a[i] = arr[i];
			b[i] = arr[i+mid];
		}
		
		a = mergeSortArray(a, mid);
		b = mergeSortArray(b, mid);
		
		return mergeArray(a, b, mid);
		
	}
	
	public static int[] mergeArray(int a[], int b[], int size){
		
		int rn = 2*size;
		int result[] = new int[rn];
		int n = 0;
		int i=0; int j=0;
		
		while(i!=size && j!=size){
				
				if(a[i]<b[j]){
					result[n] = a[i];
					i++;
				}
				else{
					result[n] = b[j];
					j++;
				}
				
				n++;
				
		}
		
		if(i!=size){
			for(int x=i; x<size; x++,n++)
				result[n] = a[x];
		}
		
		if(j!=size){
			for(int x=j; x<size; x++,n++)
				result[n] = b[x];
		}	
		
		return result;
	}		
					
}
