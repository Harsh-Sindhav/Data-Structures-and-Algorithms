package linkedList;

import java.util.Scanner;

class DoubleNode{
	Node<Integer> head;
	Node<Integer> tail;
	public DoubleNode() {
		// TODO Auto-generated constructor stub
	}
	public DoubleNode(Node<Integer> head,Node<Integer> tail) {
		// TODO Auto-generated constructor stub
    this.head = head;
    this.tail = tail;
	}
}
 

public class LinkedListUse {


public static Node<Integer> createLL(){
	Node<Integer> n1 = new Node<>(10);
	Node<Integer> n2 = new Node<>(20);
	Node<Integer> n3 = new Node<>(30);
	Node<Integer> n4 = new Node<>(40);
	Node<Integer> n5 = new Node<>(-1);
	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	n4.next = n5;
	return n1;
	
}

public static Node<Integer> takeInput(){
	Scanner s = new Scanner(System.in);
	int data = s.nextInt();
	Node<Integer> head = null, tail = null;
	while(data != -1) {
		Node<Integer> currentNode = new Node<>(data);
		if(head == null ) {
			head = currentNode;
            tail = currentNode;
		}else {
//			Node<Integer> tail = head;
//			while(tail.next != null) {
//				tail = tail.next;
//			}
			tail.next = currentNode;
			tail = currentNode; // or tail = tail.next;
		}
		data = s.nextInt();
	}
	return head;
}



public static int length(Node<Integer> head) {
   int count =0;
   while(head != null) {
	   count++;
	   head = head.next;
   }
   return count;
}


public static void increment(Node<Integer> head) {
	Node<Integer> temp = head;
	while(temp != null) {
		temp.data++;
		temp = temp.next;
	}
}



public static void printLL(Node<Integer> head) {
	Node<Integer> temp = head;
	while(temp != null) {
		System.out.print(temp.data +" ");
		temp = temp.next;
	}
//	temp = head;
//	System.out.println();
//	while(temp != null) {
//		System.out.print(temp.data +" ");
//		temp = temp.next;
//	}
//	System.out.println();
}


public static Node<Integer> insertNode(Node<Integer> head,int element, int pos) {
	
	Node<Integer> nodeToBeInserted = new Node<>(element);
	
	if(pos == 0) {
		
		nodeToBeInserted.next = head;
		
		return nodeToBeInserted;
	
	}else {
		
		int count = 0;
		
		Node<Integer> prev = head;
		
		while(count < pos - 1 && prev != null) {
			
			count++;
			
			prev = prev.next; //reached at pos -1
	
		}
	
		if(prev != null) {
			// rule of ll and that is make before you break !!!
			nodeToBeInserted.next = prev.next;  // elem at pos is connected with nodetobeinserted 
		
			prev.next = nodeToBeInserted;   // nodetobeinserted comes at the req pos i.e pos
		
		}
		
		return head;
	}
	
}


public static Node<Integer> deleteNode(Node<Integer> head,int pos){
	if(head == null) {
		return head;
	}
	if(pos == 0) {
		return head.next;
	}
	int count =0;
	Node<Integer> currHead = head;
	while(currHead != null && count < (pos-1)) {
		currHead = currHead.next; // //reached at pos -1
		count++;
	}
	if(currHead == null || currHead.next == null) {
		return head;
	}
	currHead.next = currHead.next.next;
	return head; 
}

public static void printR(Node<Integer> head) {
	if(head == null) {
		return;
	}
	System.out.print(head.data +" ");
	printR(head.next);
}

public static Node<Integer> insertNodeR(Node<Integer> head,int element, int pos) {
	if(head == null && pos > 0) {
		System.out.println("empty LL or pos > length of LL or both");
		return head;
	}
	if(pos == 0) {
		Node<Integer> nodeToBeInserted = new Node<>(element);
		nodeToBeInserted.next = head;
		return nodeToBeInserted;
	}
	head.next = insertNodeR(head.next, element, pos-1);
	return head;
}

public static Node<Integer> deleteNodeR(Node<Integer> head,int pos){
	if(head == null && pos > 0) {
		System.out.println("empty LL or pos > length of LL");
		return head;
	}
	if(pos == 0) {
		return head.next;
      }
	 head.next = deleteNodeR(head.next, pos-1);
     return head;
}

public static void printReverseLL(Node<Integer> head) {
	if(head.next == null) {
		System.out.print(head.data +" ");
		return;
	}
	printReverseLL(head.next);
	System.out.print(head.data + " ");
}	

public static Node<Integer> reverseLL(Node<Integer> head){
	/* T = T(n-1) + n-1 --> O(n^2) */
	if(head == null || head.next == null) {
		return head;
	}
   Node<Integer> reverseHead = reverseLL(head.next);
//   head.next.next = head;
//   head.next = null;
   Node<Integer> tail = reverseHead;
   while(tail.next != null) {
	   tail = tail.next;
   }
   tail.next = head;
   head.next = null;
   return reverseHead;
}

public static DoubleNode reverseLLBetter(Node<Integer> head){
	DoubleNode ans;
	if(head == null || head.next == null) {
		ans = new DoubleNode(head,head);
//		ans.head = head;
//		ans.tail = head;
		return ans;
	}
	DoubleNode smallAns = reverseLLBetter(head.next);
	smallAns.tail.next = head;
	head.next = null;
	ans = new DoubleNode();
	ans.head = smallAns.head;
	ans.tail = head;
	return ans;
}

public static Node<Integer> reverseLLBetter1(Node<Integer> head){
	DoubleNode ans = reverseLLBetter(head);
	return ans.head;
}

public static Node<Integer> reverseLLBest(Node<Integer> head){
	if(head == null || head.next == null) {
		return head;
	}
	
// if u notice tail of the small rev ll is actually the node which is next to head of the i/p ll
   Node<Integer> reverseHead = reverseLLBest(head.next);
   Node<Integer> reversedTail = head.next;
   reversedTail.next = head;
   head.next = null;
   return reverseHead;
}


public static Node<Integer> midPtOfLL(Node<Integer> head) {
	
	 Node<Integer> fast = head,slow = head;
	 while(fast.next != null && fast.next.next != null){
	        slow = slow.next;
           fast = fast.next.next; 
	 }
	 return slow;
}

public static Node<Integer> mergeTwoLL(Node<Integer> l1, Node<Integer> l2 ){
	 Node<Integer> t1 = l1;
	 Node<Integer> t2 = l2;
    Node<Integer> head = null;
    Node<Integer> tail = null; 
    	if(t1.data <= t2.data) {
    		head = t1;
    		tail= head;
    		t1 = t1.next;
    	}else {
    		head = t2;
    		tail= head;
    		t2 = t2.next;
    	}
    	
    while(t1 != null && t2 != null) {
    	if(t1.data <= t2.data) {
    		tail.next = t1;
    		tail = t1;
    		t1 = t1.next;
    	}else {
    		tail.next = t2;
    		tail = t2;
    		t2 = t2.next;
    	}
    } 
   
    if(t1 != null) {
    	tail.next = t1;
    }else {
    	tail.next = t2;
    }
    return head;
}

// merge sort in ll 

  public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
	   
	   if(head1 == null) return head2;
	   if(head2 == null)return head1;
	   
	   Node<Integer> newHead = null, newTail = null;
	   
	   if(head1.data < head2.data) {
		   newHead = head1;
		   newTail = head1;
		   head1 = head1.next; 
	   }else {
		   newHead = head2;
		   newTail = head2;
		   head2 = head2.next;
	   }
	   while(head1 != null && head2 != null) {
		   if(head1.data < head2.data) {
			   newTail.next = head1;
			   newTail = newTail.next;
			   head1 = head1.next;
		   }else {
			   newTail.next = head2;
			   newTail = newTail.next;
			   head2 = head2.next;
			   
		   }
	   }
	   
	   if(head1 != null) newTail.next = head1;
	   if(head2 != null) newTail.next = head2;
	   return newHead;
	   
   }
   
   public static Node<Integer> mergeSort(Node<Integer> head){
	   
	   if(head == null || head.next == null) {
		   return head;
	   }
	   
	   Node<Integer> mid = midPtOfLL(head);
	   
	   Node<Integer> half1 = head;
	   Node<Integer> half2 = mid.next;
	   mid.next =  null;
	   
	   half1 = mergeSort(half1);
	   half2 = mergeSort(half2);
	   
	   Node<Integer> finalhead = merge(half1, half2);
	   
	   return finalhead;
   } 



public static Node<Integer> appendLastNtofirst(Node<Integer> head,int n){

	int length = length(head);
	int count = length - n;
	if(n==0 || head== null) {
		return head;
	}
	Node<Integer> curr = head;
	Node<Integer> temp = curr;
	for(int i = 1; i < count; i++) {
		temp = temp.next;
	}
	Node<Integer> head2 = temp.next;
	Node<Integer> temp2 = head2;
	temp.next = null;
	while(temp2 != null) {
		if(temp2.next == null) {
			temp2.next = curr;
			break;
		}
		temp2 = temp2.next;
	}
	return head2;

}

public static void printithNode(Node<Integer> head,int n) {
    Node<Integer> temp = head;
	int count = 0;
	while( temp !=null) {
		if(n==count) {
			System.out.println(temp.data);
			break;
		}
			count++;
		temp = temp.next;
	}

}

public static int finaANode(Node<Integer> head,int element) {

	Node<Integer> temp = head;
	int count = 0;
	if(head == null) {
		return -1;
	}
	while(temp != null) {
		if(temp.data == element) {
			return count;
		}
		count++;
		temp = temp.next;
	}
	return -1;

}

public static Node<Integer> EleminateDuplicates(Node<Integer> head){
	if(head == null || head.next == null) {
		return head;
	}else {
		Node<Integer> t1 = head;
		Node<Integer> t2 = head.next;
		while(t2 != null) {
			if(t1.data != t2.data) {
				t1.next = t2;
				t1 = t1.next;
				t2 = t2.next;
			}else {
				t2 = t2.next;
			}
		}
		t1.next = t2;
		return head;
	}	
}

public static boolean checkPallindrome(Node<Integer> head) {
	if(head == null) {
		System.out.println("linkedlist is empty");
		return true;
	}
	if(head.next == null) {
		return true;
	}
	Node<Integer> copy = null,tail = null;
	Node<Integer> temp = head;
	while(temp != null) {
		if(copy == null) {
			copy = new Node<>(temp.data);
			tail = copy;
		}else {
			tail.next= new Node<>(null);
			tail = tail.next;
			tail.data = temp.data;
			tail.next = null;
		}
		temp = temp.next;
	}
 Node<Integer> reversehead = reverseLL(copy);
 while(head != null) {
	 if(head.data != reversehead.data) {
		 return false;
	 }
	 head = head.next;
	 reversehead = reversehead.next;
 }	
 return true;
}

public static boolean checkPallindromeBetter(Node<Integer> head) {
	if(head == null) {
		System.out.println("linkedlist is empty");
		return true;
	}
	if(head.next == null) {
		return true;
	}
	int length = length(head);
	int mid = length/2;
	int count = 0;
    Node<Integer> temp = head;
    Node<Integer> temp2;
	while(count < mid) {
		count++;
		temp = temp.next;
	}
	temp2 = temp.next;
	temp.next = null;
	Node<Integer> reverseTemp = reverseLL(temp2);
	while(temp2 != null) {
		if(head.data != reverseTemp.data) {
			return false;
		}
		temp2 = temp2.next;
	}
	return true;
}

public static void main(String[] args) {
	Node<Integer> head1 = takeInput();
//	Node<Integer> head2 = takeInput();
    Node<Integer> x = mergeSort(head1);
    printLL(x);  
}

}
