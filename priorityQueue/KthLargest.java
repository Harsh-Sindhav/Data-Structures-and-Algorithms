package priorityQueue;

import java.util.PriorityQueue;

public class KthLargest {

	
	static int kthLargest(int[] arr,int n,int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<k;i++) {
			pq.add(arr[i]);
		}
		for(int i=k;i<n;i++) {
			if(arr[i] > pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		
	return pq.peek();
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(kthLargest(null, 0, 0));
	}
}
