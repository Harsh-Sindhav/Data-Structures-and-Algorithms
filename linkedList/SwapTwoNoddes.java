package linkedList;

import linkedList.LinkedListUse;

public class SwapTwoNoddes {

	public static Node<Integer> swapNode(Node<Integer> head,int i,int j){
		
		if(i == j) return head;
		
		Node<Integer> currnode = head,prev = null;
		Node<Integer> firstNode = null, secondNode = null,firstNodeprev = null,secondNodeprev = null;
		int pos = 0;
		
		while(currnode != null) {
			if(pos == i) 
			{
				firstNodeprev = prev;
				firstNode = currnode;

			}else if(pos == j) {
				
				secondNodeprev = prev;
				secondNode = currnode;
				
			}
			
			prev = currnode;
			currnode = currnode.next;
			pos += 1;
				
		}
		
	   if(firstNodeprev != null) {
		  firstNodeprev.next = secondNode;
	  }else {
		  head = secondNode;
	  }
	   
	   if(secondNodeprev != null) {
		   secondNodeprev.next = firstNode;
	   }else {
		   head = firstNode; 
	   }
		
	   Node<Integer> currfirstNode = secondNode.next;
	   secondNode.next = firstNode.next;
	   firstNode.next = currfirstNode;
	   
		return head;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}
