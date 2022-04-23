package linkedList;
import linkedList.LinkedListUse;

public class PallindromeLL {
	
	
	// t -> O(n) S-> O(1)
public static boolean isPallindromeBetter(Node<Integer> head) {
	
	if(head == null || head.next == null) {
		return true;
	}
	
	Node<Integer> fast = head;
	Node<Integer> slow = head;
	
	while(fast.next != null && fast.next.next != null) {
		fast = fast.next.next;
		slow = slow.next;
	}

    Node<Integer> secondHead = slow.next;
    slow.next = null;
    secondHead = LinkedListUse.reverseLLBest(secondHead);
    
    Node<Integer> firstSublist = secondHead;
    Node<Integer> secondSublist = head;
    
    while(firstSublist != null) {
    	if(firstSublist.data != secondSublist.data) {
    		return false;
    	}
    	firstSublist =  firstSublist.next;
    	secondSublist = secondSublist.next;
    }
	
    // rejoin the two sublists to restore the i/p list to its original form
    firstSublist = head;
    secondSublist = LinkedListUse.reverseLLBest(secondHead);
    
    while(firstSublist.next != null) {
    	
    	firstSublist = firstSublist.next;
    	
    }
	firstSublist.next = secondSublist;
	return true;
}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

   Node<Integer> head = LinkedListUse.takeInput();
   boolean check = isPallindromeBetter(head);
   System.out.println(check);
		
	}

}
