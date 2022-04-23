package queue;

import java.util.Queue;
import java.util.LinkedList;

public class StackUsing2Queues {

	public Queue<Integer> q1;
	public Queue<Integer> q2;
	
   public StackUsing2Queues() {
	   q1 = new LinkedList<>();
	   q2 = new LinkedList<>();
	   
   }
	
   public int getSize() {
	   return this.q1.size();
   }
   
   public boolean isEmpty() {
	   return this.getSize()==0;
   }
   
   public void push(int elem) {
	   this.q1.add(elem);
   }
   
   public int pop() {
	   if(q1.isEmpty()) {
		   return -1;
	   }
	   
	   while(this.q1.size()>1) {
		   this.q2.add(this.q1.poll());
	   }
 
	   int ans = this.q1.poll();
	   
	   Queue<Integer> temp = this.q1;
	   q1 = q2;
	   q2 = temp;
	   
	   return ans;
	   
   }
   
   public int top() {
	   if(this.isEmpty()) return -1;
	   
	   while(this.q1.size() > 1) {
		   this.q2.add(this.q1.poll());
	   }
	   
	   int ans = q1.poll();
	   q2.add(ans);
   
   
   Queue<Integer> temp = q1;
   q1 = q2;
   q2 = temp;
   return ans;
  }
 
   }