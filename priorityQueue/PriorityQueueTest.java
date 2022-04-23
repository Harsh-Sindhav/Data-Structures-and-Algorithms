package priorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) throws PriorityQueueException {
		// TODO Auto-generated method stub
  
		MaxPriorityQueue<String> pq = new MaxPriorityQueue<String>();
		pq.insert("abc", 15);
		pq.insert("def", 12);
		pq.insert("ghi", 67);
		pq.insert("jkl", 69);
		while(!pq.isEmpty()) {
			System.out.println(pq.getMax());
			pq.removeMax();
		}
		
		 
	}

}
