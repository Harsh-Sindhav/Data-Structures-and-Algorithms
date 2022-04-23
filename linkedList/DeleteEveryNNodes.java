package linkedList;

public class DeleteEveryNNodes {

	
public static Node<Integer> skipMdeleteN(Node<Integer> head,int m,int n){

	if(m==0 || head == null)return null;
	
	if(n==0)return head;
	
	Node<Integer> currNode = head;
	Node<Integer> temp = null;
	
	while(currNode != null) {
		int take = 0;
		int skip = 0;
		while(currNode != null && take < m) {
			if(temp == null) {
				temp = currNode;
			}else {
				temp.next = currNode;
				temp = currNode;
			}
			currNode = currNode.next;
			take++;
		}
		while(currNode != null && skip < n) {
			currNode = currNode.next;
			skip++;
		}
		}
		if(temp != null) {
			temp.next = null;
		}
		
		return head;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
	
}
