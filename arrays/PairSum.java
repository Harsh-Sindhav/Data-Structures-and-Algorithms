package arrays;

import java.util.Arrays;

public class PairSum {
	
	// O(n^2)
public static int pairSum(int arr[],int n) {
	int a= 0;
	int sum = n;
	for (int i = 0; i < arr.length-1; i++) {
		for (int j = i+1; j < arr.length; j++) {
		   if(arr[i]+arr[j]==sum) a++;
		}
	}
	return a;
}


// nlogn + n and only true for unique elements only
public static int pairSum1(int arr[],int n) {
	Arrays.sort(arr);
	int i =0 , j = arr.length-1 , count = 0;
	while(i < j) {
		if(arr[i] + arr[j] == n) {
			count++;
			i++;
			j--;
		}else if(arr[i] + arr[j] < n) {
			i++;
		}else {
			j--;
		}
	}

	return count;
}

//nlogn + n 
public static int pairSum2(int arr[],int n) {
	
	Arrays.sort(arr);
	int si = 0;
	int ei = arr.length-1;
	int numPair = 0;
	while(si < ei) {
		
		if(arr[si] + arr[ei] < n) {
			si++;
		} else if(arr[si] + arr[ei] > n) {
			ei--;
		} else {
			//we get as i/p all elements are dupliates even in sorted Array
			int elementAtStart = arr[si];
			int elementAtEnd = arr[ei];
			if(elementAtStart == elementAtEnd) {
				
				int totalElementFromStartToEnd = (ei - si) + 1; // +1 coz if si = 0 & ei = 4 then actually the elements in total are 5 and if we don't add +1 then 4 - 0 = 4 which is false so +1
				numPair += (totalElementFromStartToEnd*(totalElementFromStartToEnd-1)/2);
				return numPair;	
			}
			int tempSi = si + 1;
			int tempEi = ei - 1;
			while(tempSi <= tempEi && arr[tempSi] == elementAtStart) {
				tempSi += 1;
			}
			
			while(tempEi >= tempSi && arr[tempEi] == elementAtEnd) {
				tempEi -= 1;
			}			
			
			int totalElementsFromStart = (tempSi - si);
			int totalElementsFromEnd = (ei - tempEi);
			
			numPair += (totalElementsFromStart*totalElementsFromEnd);
			si = tempSi;
			ei = tempEi;
			
		}		
	}
	return numPair;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int arr[] = {1, 5, 7, -1, 5};
    int n = 6;
    int a= pairSum1(arr, n);
    
    		System.out.println(a);
	}

}
