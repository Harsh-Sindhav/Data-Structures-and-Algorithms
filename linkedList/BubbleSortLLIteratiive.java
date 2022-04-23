package linkedList;

public class BubbleSortLLIteratiive {

	public static Node<Integer> bubbleSort(Node<Integer> head){
		
		int n = LinkedListUse.length(head);
		for(int i = 0; i < (n - 1); i++) {
		Node<Integer> prev = null;
		Node<Integer> curr = head;
		for(int j=0;j<(n-i-1);j++) {
			if(curr.data <= curr.next.data) {
				prev = curr;
				curr = curr.next;
			} else {
				if(prev == null) {
					Node<Integer> fwd = curr.next;
					head = head.next;
					curr.next = fwd.next;
					fwd.next = curr;
					prev = fwd;
					
				}else {
					Node<Integer> fwd = curr.next;
					prev.next = fwd;
					curr.next = fwd.next;
					fwd.next = curr;
					prev = fwd;
					
				}
				
			}
		 }	
		}
		
		
		return head;
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head = LinkedListUse.takeInput();
		Node<Integer> sortedLL = bubbleSort(head);
		LinkedListUse.printLL(sortedLL);

	}

}
