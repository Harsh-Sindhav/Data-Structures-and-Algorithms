package timeComplexity;

import java.util.Arrays;

public class PrintDuplicates {
public static int duplicates(int arr[]) {
	Arrays.sort(arr);
	for (int i = 0; i < arr.length-1; i++) {
		if(arr[i]==arr[i+1])return arr[i];
	}
	return -1;
} 
//below approach is better in terms of space complexity
public static int duplicates_better(int arr[]) {
	Arrays.sort(arr);
	int sumOFn_2 = ((arr.length-1)*(arr.length-2))/2;
	int sumOfN=0 ;
	for (int i = 0; i < arr.length; i++) {
		sumOfN+=arr[i];
	}
	int x = sumOfN - sumOFn_2;
	return x;
} 

public static int duplicates_better2(int[] arr) {
   
	int ans = 0;
	for(int i=0;i<arr.length;i++) {
		ans = ans^arr[i];
	}
	for(int i=0;i<arr.length-1;i++) {
	    ans = ans^i ;	
	}
	return ans;
   	
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int arr[] = {0, 7, 2, 5, 4, 7, 1, 3, 6};
//		int arr[]= {0,1,2,3,2,4};
//    int d = duplicates_better(arr);
    int d = duplicates_better2(arr);
    System.out.println(d);
	}

}
