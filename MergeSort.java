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
		
		arr = mergeSortArray(arr, n-1);
		
		System.out.println("Sorted Array: " + Arrays.toString(arr));
		
	}
	
	public static int[] mergeSortArray(int arr[], int size){
		
		if(size == 0)
			return arr;
			
		int mid = size/2;
		
		int a[] = new int[mid+1];
		int b[] = new int[size-mid];
		
		for(int i=0, j=0;i<=mid;i++,j++){
			a[j] = arr[i];
		}
		for(int i = mid+1,j=0;i<=size;i++,j++){
			b[j] = arr[i];
		}
			
		a = mergeSortArray(a, a.length-1);
		b = mergeSortArray(b, b.length-1);
		
		return mergeArray(a, b , a.length, b.length);
		
	}
	
	public static int[] mergeArray(int a[], int b[], int size1, int size2){
		
		int rn = size1+size2;
		int result[] = new int[rn];
		int n = 0;
		int i=0; int j=0;
		
		while(i!=size1 && j!=size2){
				
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
		
		if(i!=size1){
			for(int x=i; x<size1; x++,n++)
				result[n] = a[x];
		}
		
		if(j!=size2){
			for(int x=j; x<size2; x++,n++)
				result[n] = b[x];
		}	
		
		return result;
	}		
					
}
