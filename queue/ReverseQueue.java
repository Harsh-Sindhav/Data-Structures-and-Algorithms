package queue;
import java.util.Queue;

public class ReverseQueue {

	public static void reverseQueue(Queue<Integer> input) {

		if(input.size() <= 1) {
			return;
		}
		
		int front = input.poll();
		
		reverseQueue(input);
		
		input.add(front);
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
