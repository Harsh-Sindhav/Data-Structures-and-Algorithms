package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseFirstKElements {

	public static Queue<Integer> reverseKElements(Queue<Integer> ip,int k){
		
		if(ip.isEmpty() || k > ip.size()) {
			return ip;
		}
		
		if(k <= 0) {
			return ip;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i =0;i<k;i++) {
			stack.push(ip.poll());
		}
		
		while(!stack.isEmpty()) {
			ip.add(stack.pop());
		}
		
		for(int i=0;i<ip.size()-k;i++) {
			ip.add(ip.poll());
		}
	   return ip;	
		
	} 
	
	public static void reverseQueue(Queue<Integer> input,int k) {

		if(input.size() <= 1) {
			return;
		}
		
		int front = input.poll();
		
		reverseQueue(input,k-1);
		
		input.add(front);
		
		
	}
	
//	public static Queue<Integer> reverseKElementsR(Queue<Integer> ip,int k){	
//		
//		if(ip.isEmpty() || k > ip.size()) {
//			return ip;
//		}
//		
//		if(k <= 0) {
//			return ip;
//		}
//		
//		reverseQueue(ip,k);
//		
//
//		for(int i=0;i<ip.size()-k;i++) {
//			ip.add(ip.poll());
//		}
//		
//		
//	return ip;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Queue<Integer> q = new LinkedList<>();
		 Scanner s = new Scanner(System.in);
 		Integer n = s.nextInt() ;
		 while(n != -1) {
			 q.add(n);
			 n = s.nextInt();		 }
	       Queue<Integer> ans = reverseKElements(q, 3);
		 
	       while(!ans.isEmpty()) {
	    	   System.out.println(ans.poll());
	       }
	       
	}



       

}
