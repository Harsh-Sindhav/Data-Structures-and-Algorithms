package arrays;

public class DuplicateElement {
//	Problem Description: You are given with an array of integers of size n which contains numbers
//	from 0 to n - 2. Each number is present at least once. That is, if n = 5, numbers from 0 to 3 is
//			present in the given array at least once and one number is present twice. You need to find and
//			return that duplicate number present in the array.
	
public static int findDuplicates(int arr[]) {
	for (int i = 0; i < arr.length-1; i++) {
		int a = arr[i];
		for (int j = i+1; j < arr.length; j++) {
			int b = a ^ arr[j];
			if(b==0) return a;
			
		}
		
		
		
	}
	
	return Integer.MIN_VALUE;
}

public static int findDuplicates1(int arr[]) {
//	int ans = Integer.MIN_VALUE;
	for (int i = 0; i < arr.length-1; i++) {
		for (int j = i+1; j < arr.length; j++) {
				if(arr[i]==arr[j]) {
					return arr[i];
				}
		}
	}
	return Integer.MAX_VALUE;
//	return ans;
}

public static int findDuplicates2(int arr[]) {
	int sum = 0;
	for(int i =0; i < arr.length; i++) {
		sum = sum + arr[i];
	}
	int n = arr.length;
	int sumOfNaturalNumbers = ((n-1)*(n-2))/2;
    
	return sum - sumOfNaturalNumbers;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[] = {0 ,2 ,1 ,3 ,1};
       System.out.println(findDuplicates2(arr));
       
	}

}
