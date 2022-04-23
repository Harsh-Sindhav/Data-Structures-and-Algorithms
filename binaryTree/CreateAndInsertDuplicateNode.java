package binaryTree;

public class CreateAndInsertDuplicateNode {

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root == null)return;
		
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
		BinaryTreeNode<Integer> rootLeft = root.left;
		root.left = newNode;
		newNode.left = rootLeft;
		
		insertDuplicateNode(rootLeft);
		insertDuplicateNode(root.right);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
