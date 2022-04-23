package binaryTree;

public class Bst {
	
  private BinaryTreeNode<Integer> root;

  private int size;
  
  private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node,int x){
	  if(node == null) {
	  BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
	  return newRoot;
	 }
	  
	if(x >= node.data) {
		node.right = insert(node.right, x);
	}else {
		node.left = insert(node.left, x);
	}
	  
	 return node; 
	  }
	  
  private static boolean ispresentHelper(BinaryTreeNode<Integer> node,int x) {
	  if(node == null) return false;
	  if(node.data ==x) return true;
	  if(x < node.data) {
		 return ispresentHelper(node.left,x);
	  }else {
		  return ispresentHelper(node.right,x);
	  }  
  }
  
  public boolean isPresent(int x) {
	return ispresentHelper(root, x);
  }
  
  public void insert(int x) {// we're only passing the integer that we want to check if it present or not and we're not passsing the root in the ip 
	root =  insert(root, x); //imp thing to undertand here is that insert will retrun the new root, in case the root has changed so i've to update my root to new root 
  }
  
  
  //pvt fn coz we need the min fn internally
  public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) return Integer.MAX_VALUE;
		
		 int leftMin = minimum(root.left);
		 int rightMin = minimum(root.right);
		 
		 return Math.min(root.data, Math.min(leftMin, rightMin));
	
	}
  
  private static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root,int x) {
	if(root == null) return new BSTDeleteReturn(null,false);
	
	if(root.data < x) {
		BSTDeleteReturn opRight = deleteDataHelper(root.right, x);
		root.right = opRight.root;
		opRight.root = root;
		return opRight;
	}
	
	if(root.data > x) {
		BSTDeleteReturn opLeft = deleteDataHelper(root.left, x);
		root.left = opLeft.root;
		opLeft.root = root;
		return opLeft;
	}  
	
	//0 children
	if(root.left == null && root.right == null) {
		return new BSTDeleteReturn(null,true);
	}
	//only leftChild
	if(root.left != null && root.right == null) {
	  return new BSTDeleteReturn(root.left,true);
  }
	
	// only rightChild
  if(root.right != null && root.left == null) {
	  return new BSTDeleteReturn(root.right,true);
  } 
   
  //bothChildrenPresent
  int rightMin = minimum(root.right);
  root.data = rightMin;
  BSTDeleteReturn opRight = deleteDataHelper(root.right, rightMin);
  //pls see notes if revisiting here for revision ,it is mandatory !!!!
  root.right = opRight.root;
  return new BSTDeleteReturn(root,true);
  
  }
  public boolean deleteData(int x) {
	  
	  BSTDeleteReturn op = deleteDataHelper(root, x);
	  root = op.root;
	  if(op.deleted) {
		  size--;
	  }
	  return op.deleted;
  }
  
  public int size() {
	  return size;
  }
  private static void printtreehelper(BinaryTreeNode<Integer> node) {
	  if(node == null) {
			return;
		}
		System.out.print(node.data + ":");
		if(node.left != null) {
			System.out.print("L" + node.left.data + ",");
		}
		if(node.right != null) {
			System.out.print("R" + node.right.data + " ");
		}
		System.out.println();
		printtreehelper(node.left);
		printtreehelper(node.right);
  }
  
  public void printTree() {
    printtreehelper(root);	  
  }

}
