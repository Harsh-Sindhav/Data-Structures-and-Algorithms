package binaryTree;

public class IsNodePresent {

	public static boolean findNode(BinaryTreeNode<Integer> root,int x) {
		if(root == null)return false;
		
		if(root.data == x) return true;
		
		boolean checkLeft = findNode(root.left,x);
		if(checkLeft)return true;
		boolean checkRight = findNode(root.right,x);
		if(checkRight)return true;
		
		return false;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
