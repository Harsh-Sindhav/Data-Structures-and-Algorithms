package binaryTree;

public class PathSumRootToLeaf {

	public static void rootToleafPathsSumToK(BinaryTreeNode<Integer> root,int k,String path,int currSum) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			currSum+=root.data;
		
		if(currSum == k) {
			System.out.println(path + root.data + " ");
		}
		return;
		}
	    rootToleafPathsSumToK(root.left, k, (path + root.data + " "), (currSum + root.data));	
	    rootToleafPathsSumToK(root.right, k, (path + root.data + " "), (currSum + root.data));	
	
	}
	
	public static void rootToLeafPathSumToK(BinaryTreeNode<Integer> root,int k) {
		rootToleafPathsSumToK(root, k, "", 0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
