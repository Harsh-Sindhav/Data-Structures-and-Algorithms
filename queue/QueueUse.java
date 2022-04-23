package queue;

public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//    QueueUsingArray queue = new QueueUsingArray();
		QueueUsingLL queue = new QueueUsingLL();
    int arr[] = {10,20,30,40,50};
    for(int elem: arr) {
//    	try {
//			queue.enqueue(elem);
//		} catch (QueueFullException e) {
//			// will never reach here
//		}
    	queue.enqueue(elem);
    }
	
	while(!queue.isEmpty()) {
		try {
			System.out.println(queue.dequeue());
		} catch (QueueEmptyException e) {
		// will never reach here
		}
	}
	
	
	}

}

