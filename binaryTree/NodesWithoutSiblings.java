package binaryTree;

public class NodesWithoutSiblings {

	public static void nodewithoutsibling(BinaryTreeNode<Integer> root) {
		
		if(root == null)return;
		if(root.left == null && root.right != null ) {
			System.out.println(root.right.data);
		}else if(root.left != null && root.right == null) {
			System.out.println(root.left.data);	
		}
		nodewithoutsibling(root.left);
		nodewithoutsibling(root.right);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
