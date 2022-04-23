package arrays;

import java.util.Arrays;

public class SecondLargestElementInanArray {

	
	//this approach fails in case of duplicate elements in array
	public static int secondLargestElement0(int arr[]) {
		Arrays.sort(arr);
		return arr[arr.length-2];
		
	}
	
	public static int secondLargestElement1(int arr[]) {
		
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] > largest) {
				largest =arr[i];
			}
			
			
		}
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] > secondLargest && arr[i]<largest) {
				
				secondLargest = arr[i];
				
			}
			
		}
		return secondLargest;
		
		
	}
	
	
	
	
	public static int secondLargestElement2(int arr[]) {
	int largest = Integer.MIN_VALUE;
	int secondLargest = Integer.MIN_VALUE+1;
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]>largest) {
			secondLargest = largest;
			largest = arr[i];
		}else if(arr[i] !=largest && arr[i]> secondLargest) {
			secondLargest = arr[i];
		}
	}
	return secondLargest;
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,6,1,9,8,7,5};
//		int x= secondLargestElement0(arr);
//		int x= secondLargestElement2(arr);
		int x= secondLargestElement1(arr);
		System.out.println(x);
			}
	}


