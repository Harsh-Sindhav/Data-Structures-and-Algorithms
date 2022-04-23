package linkedList;
import linkedList.LinkedListUse;
public class FindANodeinLL {

	
	public static int findNode(Node<Integer> head,int elem) {
		
		if(head == null)return -1;
		
		int pos = 0;
	  Node<Integer> temp = head;
		while(temp != null) {
			
//			if(temp.data == elem)
			if(temp.data.equals(elem))
			return pos;
				temp = temp.next;
		pos++;	
		}
	
		return -1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> head = LinkedListUse.takeInput(); 
		int elem = 5;
		int ans = findNode(head, elem);
		System.out.println(ans);
		
	}

}
