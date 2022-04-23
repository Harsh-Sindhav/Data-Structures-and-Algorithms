package linkedList;
import linkedList.LinkedListUse;

public class PrintReverseLL {

	
	// o(n^2)
	public static void printRevereseLL(Node<Integer> head) {
		
    	int l = LinkedListUse.length(head);
    	
    	Node<Integer> current = head;
    	Node<Integer> last  = null;
    	
    	while(last != head) 
    	{
    		while(current.next != last) 
    		{
    			current = current.next;
    		}
    		last = current; 
    		System.out.print(last.data + " ");
    		// reset current and start all over
            current = head;
    		
    	}		
	}
	
	
	// O(n)
	public static void printRevereseLLBetter(Node<Integer> head) {
	
	if(head == null) {
		return;
	}
		
	printRevereseLLBetter(head.next);	
	System.out.print(head.data + " ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> head = LinkedListUse.takeInput();
//		printRevereseLL(head);
		
		printRevereseLLBetter(head);
		
	}

}
