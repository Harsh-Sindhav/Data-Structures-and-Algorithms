package arrays;

import java.util.Iterator;

public class ReverseArray {
	public static int[] reverseArray(int arr[]) {
	
	int reverse[] = new int[arr.length];
	
	int n = arr.length - 1;
	
	int i = 0;
	
	while(n >= 0) {
		
   reverse[i] = arr[n];
   i++;
   n--;
   
	}
	
	return reverse;	
	}
	
	public static void reverseArrayBetter(int arr[]) {
		
		int t;
		
		
		for (int i = 0; i < arr.length/2 ; i++) {
			
			t = arr[i];
			
			arr[i] = arr[arr.length - i - 1];
			
			arr[arr.length - i - 1] = t; 
			
		}
		}
	
	
	public static void swapElements(int[] arr,int start,int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	public static void reverseBest(int[] arr,int start,int end) {
		while(start < end) {
			
			swapElements(arr, start, end);
			start+=1;
			end-=1;
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,6,3,1,5,9,8};
		
//		int rev[] = reverseArray(arr);
		reverseBest(arr,0,arr.length-1);
		for (int i : arr) {
			System.out.println(i);
		}
		
	}

}
