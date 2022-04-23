package linkedList;

public class EvenAfterOddLL {

	
	public static Node<Integer> evenAfterOddLL(Node<Integer> head){
		
		if(head == null || head.next == null) return head;
		
		
		Node<Integer> oddhead = null,oddtail = null,evenhead = null,eventail = null;
		
		while(head!=null) {
			if(head.data % 2 ==0) {
				
				if(evenhead == null) {
					evenhead = head;
					eventail = head;
				}else {
					eventail.next = head;
					eventail = eventail.next;
					
				}
				
			}else {
				if(oddhead == null) {
					oddhead = head;
					oddtail = head;
				}else {
					oddtail.next = head;
					oddtail = eventail.next;
					
				}
			}
			head = head.next;
		}
		
		if(oddhead == null)return evenhead;
		else oddtail.next = evenhead;
		
		if(evenhead != null)eventail.next = null;
		
		
		return oddhead;
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
