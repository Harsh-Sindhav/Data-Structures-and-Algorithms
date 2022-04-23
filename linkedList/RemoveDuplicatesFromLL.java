package linkedList;
import linkedList.LinkedListUse;
public class RemoveDuplicatesFromLL {

	public static Node<Integer> removeDuplicatesFromLL(Node<Integer> head) {
		
		Node<Integer> currNode = head;
		while(currNode != null) {
			Node<Integer> nextNode = currNode.next;
			if(nextNode == null || nextNode.data != currNode.data) {
				currNode = nextNode;
			}else {
				currNode.next = nextNode.next;
			}
		}
	return head;	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> head = LinkedListUse.takeInput();
		Node<Integer> head2 = removeDuplicatesFromLL(head);
	   LinkedListUse.printLL(head2);
		
	}

}
