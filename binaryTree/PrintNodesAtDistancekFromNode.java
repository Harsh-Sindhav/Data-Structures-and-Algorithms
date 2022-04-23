package binaryTree;

public class PrintNodesAtDistancekFromNode {

	//this fn nodesAtDistanceKHelper as the return type is int returns dist b/w root and elem
	// Prints all nodes at distance k from a given target node.
    // The k distant nodes may be upward or downward.This function
    // Returns distance of root from target node, it returns -1
    // if target node is not present in tree rooted with root.
	private static int nodesAtDistanceKHelper(BinaryTreeNode<Integer> root,int target,int k) {
		// Base Case 1: If tree is empty, return -1
		if(root == null) {
			return -1;
		}
		// If we reach a k distant node, print it
		// If target is same as root.  Use the downward function
        // to print all nodes at distance k in subtree rooted with
        // target or root
		if(root.data == target) {
			nodesAtDistanceKdown(root,k);
			return 0; // in this case root is the elem so dist of root from root is zero so return zero
		}
		// Recur for left and right subtrees
		
		int leftD = nodesAtDistanceKHelper(root.left, target, k); //leftDistance returns dist b/w the nodes that we're looking for
		// Check if target node was found in left subtree
		if(leftD != -1) {
			// If root is at distance k from target, print root
            // Note that dl is Distance of root's left child from
            // target
		if(leftD + 1 == k) { //leftD + 1, +1 coz dist b/w left of root and the node that we're looking for if it is leftD will be leftD +1
			System.out.println(root.data); // we've to print it coz of obvious reasons i.e. leftD + 1  ==k
		}   // Else go to right subtree and print all k-dl-2 distant nodes
        // Note that the right child is 2 edges away from left child	
		else { // as != k then we've to print some elem at a particular depth towards right of root
			nodesAtDistanceKdown(root.right, k-(leftD+1)-1);//k-(ld+1) is the depth remaining that we've to look for and rt substree is even 1 dist apart from root so subtracting 1 and also at first ld returns 0 so logic should be correct  
		} 

        // Add 1 to the distance and return value for parent calls
		return 1 + leftD;
		}
	
		// searching for the elem in right subtree
		 // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left
        // subtree
		int rightD = nodesAtDistanceKHelper(root.right, target, k); //rightDistance returns dist b/w the nodes that we're looking for
		if(rightD != -1) {
			if(rightD + 1 == k) {
				System.out.println(root.data);
			}else {
				nodesAtDistanceKdown(root.left, k-(rightD+1)-1);
			}
		return 1+rightD;
		}
		
		// If target was neither present in left nor in right subtree
		return -1;
	}
	
	
	
	  /* Recursive function to print all the nodes at distance k in
    tree (or subtree) rooted with given root. */
	private static void nodesAtDistanceKdown(BinaryTreeNode<Integer> root, int k) {
		// TODO Auto-generated method stub
	if(root == null) {
		return;
	}
	if(k==0) {
		System.out.println(root.data);
	   return;
	}
	nodesAtDistanceKdown(root.left, k-1);
	nodesAtDistanceKdown(root.right, k-1);
		
	}


	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root,int node,int k) {
	nodesAtDistanceKHelper(root, node, k);	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
