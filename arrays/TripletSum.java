package arrays;

import java.util.Arrays;

public class TripletSum {
public static int tripletSum(int[] arr, int x) {
      int tripletSum = 0;
	for(int i=0;i<arr.length;i++) {
		for (int j = i+1; j < arr.length; j++) {
		for (int k = j+1; k < arr.length; k++) {
			if(arr[i]+arr[j]+arr[k] == x) {
				tripletSum++;
			}
		}	
		}
	}
    
	return tripletSum;
	
	
}

public static int tripletSumBetter(int arr[],int x) {
	
	Arrays.sort(arr);
	
	int n = arr.length;
	
	int numTriplets = 0;
	
	for(int i = 0;i < n ; i++) {
		int pairSumFor = x - arr[i];
		int numPairs = pairSum(arr,(i+1),(n-1),pairSumFor);
		numTriplets += numPairs;
	} 
	
	return numTriplets;
	
}

	private static int pairSum(int[] arr, int si, int ei, int pairSumFor) {
	// TODO Auto-generated method stub
	int numPair = 0;
	while(si < ei) {
		if(arr[si] + arr[ei] < pairSumFor) {
			
			si++;
			
		}else if(arr[si] + arr[ei] > pairSumFor)
		{
			
			ei--;
			
		}else {
			
			int elementAtStart = arr[si];
			int elementAtEnd = arr[ei];
			if(elementAtStart == elementAtEnd) {
				
				int totalElementFromStartToEnd = (ei - si) + 1;
				numPair += (totalElementFromStartToEnd*(totalElementFromStartToEnd-1)/2);
				return numPair;
				
			}
			int tempSi = si + 1;
			int tempEi = ei - 1;
			while(tempSi <= tempEi && arr[tempSi] == elementAtStart) {
				tempSi += 1;
			}
			
			while(tempEi >= tempEi && arr[tempEi] == elementAtEnd) {
				tempEi -= 1;
			}			
			
			int totalElementsFromStart = (tempSi - si);
			int totalElementsFromEnd = (ei - tempEi);
			
			numPair += (totalElementsFromStart*totalElementsFromEnd);
			si = tempSi;
			ei = tempEi;
	
		}		
		
	}
	
		return numPair ;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
