package linkedList;

import linkedList.LinkedListUse;
import java.util.Scanner;

public class FindANodeInaLLRecr {

	public static int findNode(Node<Integer> head,int n) {
		
		if(head == null) return -1;
		
		if(head.data == n) return 0;
		
		int smallAns = findNode(head.next, n);
		
		if(smallAns == -1)return -1;
				
		return smallAns + 1;
	}
	
	public static void main(String[] args) {
	 	// TODO Auto-generated method stub
    
        Node<Integer> head = LinkedListUse.takeInput();
        int n = 20010;
//       i/p 10 20010 30 400 600 -1
        int x = findNode(head, n);
        System.out.println(x);
	    
	   
	}

}
