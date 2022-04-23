package linkedList;

public class Kreverse {

	public static Node<Integer> kReverse(Node<Integer> head,int k){
		
		if(k==0 || k==1) {
			return head;
		}
		
		Node<Integer> curr = head;
		Node<Integer> fwd = null;
		Node<Integer> prev = null;
		
		int count = 0;
		while(count < k && curr != null) {
			
			fwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fwd;
			count++;
			
		} 
		
		if(fwd != null) {
			
			head.next = kReverse(fwd, k);
			
		}
		
		return prev;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
