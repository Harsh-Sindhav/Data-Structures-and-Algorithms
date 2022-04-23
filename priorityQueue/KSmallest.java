package priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallest {

 static ArrayList<Integer> ksmallest(int n,int[] input,int k){
   PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
   for(int i=0;i<k;i++) {
	   pq.add(input[i]);
   }
   for(int i=k;i<n;i++) {
	   if(input[i] < pq.peek()) {
		   pq.poll();
		   pq.add(input[i]);
	   }
   }
   ArrayList<Integer> op = new ArrayList<>();
   while(!pq.isEmpty()) {
	   op.add(pq.poll());
   }
	return op; 
 }	
	
	
	public static void main(String[] args) {
	
}
	
}
