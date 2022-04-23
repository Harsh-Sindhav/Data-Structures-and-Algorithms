package priorityQueue;

import java.util.PriorityQueue;

public class KSortedArray {

	
	// T(A,n) : O(n+k(logk))
	 static void kSortedArray(int[] arr,int n,int k) {
   
	 PriorityQueue<Integer> pq = new PriorityQueue<>();
	 for(int i=0;i<k;i++) {
		 pq.add(arr[i]);
	 }
	 int j=0;
	 for(int i=k;i<n;i++) {
		arr[j++] = pq.poll();
		pq.add(arr[i]);
	 }
	 	
		while(!pq.isEmpty()) {
			arr[j++] = pq.poll();
		}
//	   int start = 0, end = n-1;
//	   while(start < end) {
//		   arr[start] = arr[start] ^ arr[end];
//		   arr[end] = arr[start] ^ arr[end];
//		   arr[start] = arr[start] ^ arr[end];
//		   start++;
//		   end--;
//	   }
		
	}	
	
	public static void main(String[] args) {
		int[] arr = {10,12,6,7,9};
		int k = 3;
		kSortedArray(arr, arr.length, k);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
