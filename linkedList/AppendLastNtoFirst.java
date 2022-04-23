package linkedList;
import linkedList.LinkedListUse;
public class AppendLastNtoFirst {


	public static Node<Integer> AppendLastNtoFirst(Node<Integer> head,int n)
	{
		
    if(n==0 || head == null) {
    	return head;
    }		
	
    Node<Integer> fast = head ;
    Node<Integer> slow = head ;
    Node<Integer> initialHead = head;
    
    for(int i =0;i<n;i++) {
    	
    	fast = fast.next;
    	
    }
    
    while(fast.next != null) {
    	slow = slow.next;
    	fast = fast.next;
    	
    }
    
	Node<Integer> temp = slow.next;
	slow.next = null;
	fast.next = initialHead;
	head = temp;
	
	return head;
    
    
    
	}  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Node<Integer> ll = LinkedListUse.takeInput();
	    Node<Integer> ll2 = AppendLastNtoFirst(ll, 2);
// 1 2 3 4 5 -1 
	    
	    LinkedListUse.printLL(ll2);
		
		
	}

}
