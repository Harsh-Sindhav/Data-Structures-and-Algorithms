package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueInCollections {

	
	
	
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(20);
		q.add(10);
		System.out.println(q.size());
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.size());
		
		
		
	}
}
