package binaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
import finalHashMap.InbuiltHashMap;
import linkedList.LinkedListUse;
import linkedList.Node;


class bstSubtreeReturn{
	int max;
	int min;
	int height;
	boolean isBST;
}


  class Pair{
	int diameter;
	int height;
	public Pair(int height,int diameter) {
		this.diameter = diameter;
		this.height = height;
	}
  }
	
	 class PairOfNodeElem{
		Node<Integer> head;
		Node<Integer> tail;
		
	}


public class BinaryTreeUse {	
	
	public static void printTree(BinaryTreeNode<Integer> root) {

	if(root == null) {
		return;
	}
	System.out.println(root.data);
	printTree(root.left);
	printTree(root.right);
}
		
	public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
		
		// Pre Order Traversal
		
		if(root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if(root.left != null) {
			System.out.print("L" + root.left.data + ",");
		}
		if(root.right != null) {
			System.out.print("R" + root.right.data + " ");
		}
		System.out.println();
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
	}
	
	public static void printTreeInOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		printTree(root.left);
		System.out.println(root.data);
		printTree(root.right);
	}
	
	public static void printTreePostOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		printTree(root.left);
		printTree(root.right);
		System.out.println(root.data);
	}
	
	public static BinaryTreeNode<Integer> takeTreeInput(){
		System.out.println("enter root data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> leftChild = takeTreeInput();
		BinaryTreeNode<Integer> rightChild = takeTreeInput();
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot,int parentData,boolean isLeft){
		
		if(isRoot) {
		System.out.println("enter root data");
		}
		else {
			if(isLeft) {
				System.out.println("enter left child of " + parentData);
			}else {
				System.out.println("enter right child of " + parentData);
			}	
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false,rootData,true);
		BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false,rootData,false);
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}

    public static int numOfNodes(BinaryTreeNode<Integer> root) {
    	if(root == null) {
    		return 0;
    	}
    	return numOfNodes(root.left) + numOfNodes(root.right) + 1;
    }
	
    public static int largest(BinaryTreeNode<Integer> root) {
    	if(root == null) {
    		return -1;
    	}
    	int largestLeft  = largest(root.left);
    	int largestRight  = largest(root.right);
 return Math.max(root.data, Math.max(largestLeft, largestRight));
       
    
    } 
    
    public static int countnodesGreaterThanX(BinaryTreeNode<Integer> root,int x) {
    	if(root == null) {
    		return 0;
    	}
    	
    	int count = 0;
    	if(root.data > x) {
    		count++;
    	}
    	if(root.left != null) {
    		count+=countnodesGreaterThanX(root.left, x);
    	}
    	if(root.right != null) {
    		count+=countnodesGreaterThanX(root.right, x);
    	}
    	return count;
    } 
    
    public static int height(BinaryTreeNode<Integer> root) {
    	
    	if(root == null) {
    		return 0;
    	}
    	
       int left = height(root.left);
       
       int right = height(root.right);
    	
    return Math.max(left, right) + 1;
    
    }
    
    public static int NoOfLeafNodes(BinaryTreeNode<Integer> root) {
    	if(root == null) {
    		return 0;
    	}
    	if(root.left == null && root.right == null) {
    		return 1;
    	}
    	
    	return NoOfLeafNodes(root.left) + NoOfLeafNodes(root.right);
    }
    
    public static void printNodesAtDepthK(BinaryTreeNode<Integer> root,int k) {
    	if(root == null) {
    		return  ;
    	}
    	if(k == 0) {
    		System.out.println(root.data);
    	return;
    	}
    	printNodesAtDepthK(root.left, k-1);
    	printNodesAtDepthK(root.right, k-1);
    }
    
    public static void replaceNodeWithDepth(BinaryTreeNode<Integer> root,int k) {
    	
    	if(root == null) {
    		return ;
    	}
    	
    	System.out.println(root.data = k);
    	replaceNodeWithDepth(root.left, k+1);
    	replaceNodeWithDepth(root.right, k+1);
    	
    }
    
    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
    	if(root == null) {
    		return null;
    	}
    	if(root.left == null && root.right == null) {
        return null;		
    	}
    	root.left = removeLeaves(root.left);
    	root.right = removeLeaves(root.right);	
    	return root;
        }
    
    public void mirror(BinaryTreeNode<Integer> root){
    	if(root == null) {
    		return;
    	}
    	mirror(root.left);
    	mirror(root.right);
    	BinaryTreeNode<Integer> temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	
    }
    
    
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
    if(root == null) {
    	return true;
    }	
    // checked for the root only but we have to check for the each small sub tree so go deep
    int Lheight = height(root.left);
    int Rheight = height(root.right);
    if(Math.abs(Lheight-Rheight)>1) {  //math.abs means it will give absolute value that is only  +ve value consider this as mod of the things that are there in the braacket 
    	return false;
    	}
    	boolean isLeftBalanced = isBalanced(root.left);
    	boolean isLRightBalanced = isBalanced(root.right);
    
    	return isLeftBalanced && isLRightBalanced;
    
    }
    
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
    	if(root == null) {
    		int height = 0;
    		boolean isBal = true;
    		BalancedTreeReturn ans = new BalancedTreeReturn();
    		ans.height = height;
    		ans.isBalanced = isBal;
           return ans;
    	}
    	
    	BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
    	BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
    	Boolean isBal = true;
    	int height = 1 + Math.max(leftOutput.height,rightOutput.height);
    	if(Math.abs(leftOutput.height-rightOutput.height)>1) {
    		isBal =  false;
    	}
    	
    	if(!leftOutput.isBalanced || !rightOutput.isBalanced) {
    		isBal = false;
    	}
    	
    	BalancedTreeReturn ans = new BalancedTreeReturn();
    	ans.height = height;
    	ans.isBalanced = isBal;
    	return ans;
    	
    }
    
    public static int diameter(BinaryTreeNode<Integer> root) {
    if(root == null) {
    	return 0;
    }
    
    int option1 = height(root.left) + height(root.right);
    int option2 = diameter(root.left); // gives left dia 
    int option3 = diameter(root.right); // gives right dia
    // returns the max of the three
    return Math.max(option1, Math.max(option2, option3));
    
    }
    
   public static Pair heightDiameter(BinaryTreeNode<Integer> root) {
	   if(root == null) {
		   Pair p ;
		   int diameter = 0;
		   int height = 0;
		   p = new Pair(height, diameter);
		   return p ;
	   }
	   
	  // here we're not calling the height fn again and again as we're doing in the prev dia fn instead we'd stored the value of height and dia in the obj of pair class  
	   Pair leftAns = heightDiameter(root.left);
	   Pair rightAns = heightDiameter(root.right);
	   int ld = leftAns.diameter;
	   int lh = leftAns.height;
	   int rd = rightAns.diameter;
	   int rh = rightAns.height;
	   
	   int height = 1 + Math.max(lh, rh) ;
	   int diameter = Math.max(lh+rh, Math.max(ld, rd));
	   
	   Pair p = new Pair(height, diameter);
	   return p;
   }
   
   public static BinaryTreeNode<Integer> takeInputLevelWise(){
	   Scanner s = new Scanner(System.in);
	   System.out.println("Enter root data");
	   int rootData = s.nextInt();
	   if(rootData == -1) {
		   return null;
	   }
    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
   Queue <BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
   
   pendingChildren.add(root);
   while(!pendingChildren.isEmpty()) {
	 BinaryTreeNode<Integer> front = pendingChildren.poll();
	 System.out.println("enter left child of " + front.data);
	 int left = s.nextInt();
	 if(left != -1) {
		 BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
 	     front.left = leftChild;
 	     pendingChildren.add(leftChild); 
	 }
	 
	 System.out.println("Enter right child of "+ front.data);
	 int right = s.nextInt();
	 if(right !=-1) {
	 BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
	 front.right = rightChild;
	 pendingChildren.add(rightChild);	 
	 }
	 
   }   
    return root;
   }
   
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
    
    	Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
    	pendingNodes.add(root);
    	while(!pendingNodes.isEmpty()) {
    		BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
    		if(frontNode==null) {
      			System.out.println();
      			if(!pendingNodes.isEmpty()) {
    			pendingNodes.add(null);  // important
    		}
    	}else {
    		System.out.print(frontNode.data + ":L");
    		if(frontNode.left != null) {
    			pendingNodes.add(frontNode.left);
    			System.out.print(frontNode.left.data + ",R:");
    		}else {
    			System.out.print(-1 + ",R:");
    		}
    		if(frontNode.right!=null) {
    			pendingNodes.add(frontNode.right);
    			System.out.println(frontNode.right.data);
    		}else {
    			System.out.println(-1);
    		}	
    	   }	
    	  }
         }
    
    
    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] pre,int[] in, int siPre,int eiPre,int siIn,int eiIn){
    	if(siPre > eiPre ) {
    		return null;
    	}
    	int rootData = pre[siPre];
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
   
     int rootIndex = -1;
     
    	for (int i = siIn; i <= eiIn; i++) {
			if(in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}
    	
    	// I am assuming that root actually is present in inOrder if not present then rootIndex will remain -1
    	
    int siPreLeft = siPre + 1;
    int siInLeft = siIn;
    int eiInLeft = rootIndex-1;
    int eiPreRight = eiPre;
    int siInRight = rootIndex + 1;
    int eiInRight = eiIn;
    int leftSubtreeLength = eiInLeft - siInLeft + 1 ; // coz for eg we've si = 3 and ei = 5 so length will be ei-si+1 why +1 coz 5-3=2 but no of elem = 3 i.e. at 3,4,5 index so +1 !! haha   
    int eiPreLeft = siPreLeft + leftSubtreeLength - 1;
    int siPreRight = eiPreLeft + 1  ;
    BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
    BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(pre, in, siPreRight, eiPreRight, siInRight, eiInRight);
    	root.left = left;
    	root.right = right;
    	return root;	
    }
    
    
    
    public static BinaryTreeNode<Integer> buildTreeFromPreIn(int pre[], int in[]){
   
    	BinaryTreeNode<Integer> root = buildTreeFromPreInHelper(pre, in, 0, pre.length - 1, 0, in.length - 1);
    	
    		return root;
    	}
    
    
    public static BinaryTreeNode<Integer> buildTreeFromPostInHelper(int[] post,int[] in, int siPost,int eiPost,int siIn,int eiIn){
    	
    	if(siPost > eiPost || siIn > eiIn) {
    		return null;
    	}
    	
    	int rootVal = post[eiPost];
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootVal);
    	int rootIndex=-1;
    	for(int i=0;i<=eiIn;i++) {
    		if(rootVal == in[i]) {
    			rootIndex = i;
    			break;
    		}
    	}
    	
    	
        int siPostLeft = siPost;
        int siInLeft = siIn;
        int eiInLeft = rootIndex-1;
        int eiPostRight = eiPost - 1;
        int siInRight = rootIndex + 1 ;
        int eiInRight = eiIn;
        int leftSubtreeLength = eiInLeft - siInLeft + 1 ; // coz for eg we've si = 3 and ei = 5 so length will be ei-si+1 why +1 coz 5-3=2 but no of elem = 3 i.e. at 3,4,5 index so +1 !! haha 
//      int eiPostLeft = siPost + rootIndex - siIn - 1;
        int eiPostLeft = siPost + leftSubtreeLength -1 ;
        int siPostRight = siPost + rootIndex - siIn;
    	
        root.left = buildTreeFromPostInHelper(post, in, siPostLeft, eiPostLeft, siInLeft, eiInLeft);
    	root.right =buildTreeFromPostInHelper(post, in, siPostRight, eiPostRight ,siInRight, eiInRight );
    	
    	return root;
    }
    
    public static BinaryTreeNode<Integer> buildTreeFromPostIn(int[] post,int[] in){
    	int n = post.length;
    	int siPost = 0;
    	int eiPost = n-1;
    	int siIn = 0;
    	int eiIn = n-1;
    	return buildTreeFromPostInHelper(post, in, siPost, eiPost, siIn, eiIn);
    }
    
    
    
    
    // BST 1 and BST 2
    
    public static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int data){
   // the tree given must be bst !!! 
    	
    	if(root == null) {
    		return null;
    	}
    	if(root.data == data) {
    		return root;
    	}
    	else if(root.data > data) {
    		return	findNode(root.left, data);
    		
    	}else {
    		return findNode(root.right, data);
    	}
    }
    
    public static void printBetweenk1k2(BinaryTreeNode<Integer> root,int k1,int k2) {
    	if(root == null) {
    		return;
    	}
    	if(root.data >= k1  && root.data <=k2) {
      	  printBetweenk1k2(root.left, k1, k2);

    		System.out.println(root.data);
    	
    		printBetweenk1k2(root.right, k1, k2);

    	}
    
    	else if(root.data < k1) {
    		
    	  printBetweenk1k2(root.right, k1, k2);
    	   
    	 
    	}
    	else if(root.data > k2) {
    		printBetweenk1k2(root.left, k1, k2);
    		
    	}
    }
    
    public static BinaryTreeNode<Integer> sortedArrayToBst(int[] arr,int n){
    	
    	return SortedArrya(arr,0,n-1);
    }
    
    
    
    
	private static BinaryTreeNode<Integer> SortedArrya(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
		if(si > ei)return null;
		
		int mid = si + (ei - si)/2;
		
		BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(arr[mid]);
		temp.left = SortedArrya(arr, si, mid-1);
		temp.right = SortedArrya(arr, mid+1, ei);
		
		return temp;
	}
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) return Integer.MAX_VALUE;
		
		 int leftMin = minimum(root.left);
		 int rightMin = minimum(root.right);
		 
		 return Math.min(root.data, Math.min(leftMin, rightMin));
	
	}
	 public static int maximum(BinaryTreeNode<Integer> root) {
	    	if(root == null) {
	    		return Integer.MIN_VALUE;
	    	}
	    	int largestLeft  = maximum(root.left);
	    	int largestRight  = maximum(root.right);
	 return Math.max(root.data, Math.max(largestLeft, largestRight));
	       
	    } 
	    
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null) return true;
		
		int leftMax = maximum(root.left);
		if(leftMax >= root.data)return false;
		
		int rightMin = minimum(root.right);
		if(rightMin < root.data )return false;
		
		boolean isLeft = isBST(root.left);
		boolean isRight = isBST(root.right);
		return isLeft && isRight;
		
	}
	
	 public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root) {
		if(root == null) {
			IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		return ans;	
		} 
		
		IsBSTReturn leftAns = isBST2(root.left);
		IsBSTReturn rightAns = isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		if(leftAns.max >= root.data) isBST = false;
		if(rightAns.min < root.data) isBST = false;
		if(!leftAns.isBST) isBST = false;
		if(!rightAns.isBST) isBST = false;
		
		IsBSTReturn ans = new IsBSTReturn(min, max, isBST);
		return ans;
		
	 }
	
	 public static boolean isBST3(BinaryTreeNode<Integer> root,int minRange,int maxRange) {
		 if(root == null) return true;
		 
		 if(root.data < minRange || root.data > maxRange) return false;
		 
		 boolean isLeftWithinRange = isBST3(root.left, minRange, root.data-1);
		 boolean isRightWithinRange = isBST3(root.right, root.data, maxRange);
		 return isLeftWithinRange && isRightWithinRange;
		 
	 }
	 
	 public static ArrayList<Integer> nodetoRootPath(BinaryTreeNode<Integer> root,int x){
		 // it can be any tree and not need to be bst
		if(root == null) return null;
		
		if(root.data == x) {
		ArrayList<Integer> op = new ArrayList<>();
		op.add(root.data);
		return op;
		}
		 
		ArrayList<Integer> leftop = nodetoRootPath(root.left, x);
		if(leftop != null) {
			leftop.add(root.data);
			return leftop;
		}
		ArrayList<Integer> rightop = nodetoRootPath(root.right, x);
		if(rightop != null) {
			rightop.add(root.data);
			return rightop;
		}
		return null;
		
	 }
	 
	 
	 
	 
	 //bst 1 Assignment  
	 
	 public static Node<Integer> constructLL(BinaryTreeNode<Integer> root){
	 
		 return constructLLHelper(root).head;
	 
	 }
	 
	 private static PairOfNodeElem constructLLHelper(BinaryTreeNode<Integer> root) {
		 if(root == null) {
			 PairOfNodeElem pair = new PairOfNodeElem();
			 return pair;
		 }
		 Node<Integer> newnode = new Node<Integer>(root.data);
	     PairOfNodeElem leftList = constructLLHelper(root.left);
	     PairOfNodeElem rightList = constructLLHelper(root.right);
	     PairOfNodeElem pair = new PairOfNodeElem();
	     if(leftList.tail != null) {
	    	leftList.tail.next = newnode;
	     }
	 newnode.next = rightList.head;
	 
	 if(leftList.head != null) {
		 pair.head = leftList.head;
	 }else {
		 pair.head = newnode;
	 }
	 if(rightList.tail != null) {
		 pair.tail = rightList.tail;
	 }else {
		 pair.tail = newnode;
	 }
	 return pair;
	 }
	 
	 public static BinaryTreeNode<Integer> lcaHelper(BinaryTreeNode<Integer> root,int a,int b){
		 
		 if(root == null || root.data == a || root.data == b) {
			 return root;
		 }
		if(root.data < a && root.data < b){
			
		return lcaHelper(root.right, a, b);
		
		}else if(root.data > a && root.data > b) {
		   return lcaHelper(root.left, a, b);	
		}	 
		 
		 BinaryTreeNode<Integer> leftlcaHelper = lcaHelper(root.left, a, b);
		 BinaryTreeNode<Integer> rightlcaHelper = lcaHelper(root.right, a, b);
		 if(leftlcaHelper != null && rightlcaHelper != null) 
			 return root;
		 else if(leftlcaHelper != null) return leftlcaHelper;
		 return rightlcaHelper;
		 
	 }
	 
	 public static int lca(BinaryTreeNode<Integer> root,int a,int b) {
		 BinaryTreeNode<Integer> node = lcaHelper(root, a, b);
		 return (node == null) ? -1 : node.data;
	 }
	 
	 
	 public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root,int sum) {
		 
		  if(root == null)return sum;
	 
	 sum = replaceWithLargerNodesSum(root.right, sum);
	 sum += root.data;
	 root.data = sum;
	 sum = replaceWithLargerNodesSum(root.left, sum);
	 return sum;
	
	 }
	
	 public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		 int sum = 0;
		 replaceWithLargerNodesSum(root, sum);
	 }
	 
	 
	 private static void rootToLeafPathSumTok(BinaryTreeNode<Integer> root,int k,String path,int currsum) {
		 if(root == null) return;
		 if(root.left == null && root.right == null) {
			 currsum += root.data;
			 if(currsum == k) {
				 System.out.println((path + root.data + " "));
			 }
			 return;
		 }
		 rootToLeafPathSumTok(root.left, k,(path+root.data + " "), (currsum+root.data));
		 rootToLeafPathSumTok(root.right, k, (path + root.data + " "),(currsum + root.data));
	 }
	 
	 
	 
	 
   public static void rootToLeafPathSumTok(BinaryTreeNode<Integer> root,int k) {
	 rootToLeafPathSumTok(root, k, "", 0);  
   }	
   
   //bst 2 assignment
   
   public static bstSubtreeReturn largesstSubTreeHelper(BinaryTreeNode<Integer> root) {
	
	   if(root == null) {
		   bstSubtreeReturn ans = new bstSubtreeReturn();
		   ans.max = Integer.MIN_VALUE;
		   ans.min = Integer.MAX_VALUE;
		   ans.isBST = true;
		   ans.height = 0;
		   return ans;
	   }
	   
	   bstSubtreeReturn left = largesstSubTreeHelper(root.left);
	   bstSubtreeReturn right = largesstSubTreeHelper(root.right);
	   if(!(right.isBST && right.min > root.data)) {
		   right.isBST = false;
	   }
	   if(!(left.isBST && left.max < root.data)) {
		   left.isBST = false;
	   }
	   
	   bstSubtreeReturn ans = new bstSubtreeReturn();
	   if(!left.isBST || !right.isBST || root.data < left.max || root.data > right.min) {
		   if(left.height > right.height) {
			   left.isBST = false;
			   return left;
		   }else {
			   right.isBST = false;
			   return right;
		   }
	   }
	   ans.isBST = true;
	   ans.min = Math.min(left.min, Math.min(right.min, root.data));
	   ans.max = Math.max(left.max, Math.max(right.max, root.data));
	   ans.height = Math.max(left.height, right.height) + 1;
	   return ans;
   }
   
  public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
	  return largesstSubTreeHelper(root).height;
  }
  
  
  public static int countNodes(BinaryTreeNode<Integer> root) {
	  if(root == null) return 0;
	  
	  return countNodes(root.left) + countNodes(root.right) + 1;
	  
  }
  
  public static void printNodesSumToS(BinaryTreeNode<Integer> root,int s) {

	  if(root == null) return ;
	  
	  int totalCount = countNodes(root);
	  int count =0;
	  Stack<BinaryTreeNode<Integer>> inOrder = new Stack<>();
	  Stack<BinaryTreeNode<Integer>> revInOrder = new Stack<>();
	  BinaryTreeNode<Integer> temp = root;
	  while(temp != null) {
		  inOrder.push(temp);
		  temp = temp.left;
	  }

	  temp = root;
	  
	  while(temp != null) {
		revInOrder.push(temp);
		temp = temp.right;
	  }

      while(count < totalCount - 1) {//coz we've include the root node in both the stack
    	  BinaryTreeNode<Integer> top1 = inOrder.peek();
    	  BinaryTreeNode<Integer> top2 = revInOrder.peek();
    	  if(top1.data + top2.data == s) {
    		  System.out.println(top1.data + " " + top2.data);
    		  BinaryTreeNode<Integer> top = top1;
    		 inOrder.pop();
    		 count++;
    		 if(top.right != null) {
    			 top = top.right;
    			 while(top != null) {
    				 inOrder.push(top);
    				 top = top.left;
    			 }
    		 }
    		 top = top2;
    		 revInOrder.pop();
    		 count++;
    		 if(top.left != null) {
    			 top = top.left;
    			 while(top != null) {
    				 revInOrder.push(top);
    				 top = top.right;
    			 }
    		 }  
    	  }else if(top1.data + top2.data > s)   {
    		  BinaryTreeNode<Integer> top = top2;
    		  revInOrder.pop();
    		  count++;
    		  if(top.left != null) {
    			  top = top.left;
    			  while(top != null) {
    				  revInOrder.push(top);
    				  top = top.right;
    				  
    			  }
    		  }
    	  }else {
    		  BinaryTreeNode<Integer> top = top1;
    		  inOrder.pop();
    		  count++;
    		  if(top.right != null) {
    			  top = top.right;
    			  while(top != null) {
    				  inOrder.push(top);
    				  top = top.left;
    			  }
    		  }
    		  
    	  }
      }
  }
   

	public static void main(String[] args) {

BinaryTreeNode<Integer> root = takeInputLevelWise();
//printLevelWise(root);

//int in[] = {4,2,5,1,3};
//int pre[] = {1,2,4,5,3};
//BinaryTreeNode<Integer> root = buildTreeFromPreIn(pre, in);
//printTreeDetailed(root);

// printBetweenk1k2(root, 2, 6);

//System.out.print("Pre Order");
//
//printTreeDetailed(root);
//
//System.out.println(" In Order");
//
//printTreeInOrder(root);
//
//System.out.println("Post Order");
//
//printTreePostOrder(root);
 
//int largest = largest(root);
//System.out.println(largest);

//int height = NoOfLeafNodes(root);
//System.out.println(height);
//     BinaryTreeNode<Integer> root = takeTreeInput();
//  replaceNodeWithDepth(root, 0);

//BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
//BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
//root.left = rootLeft;
//root.right = rootRight;
//BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
//BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<>(5);
//rootLeft.right = twoRight;
//rootRight.left = threeLeft;
		
		ArrayList<Integer> path = nodetoRootPath(root, 1);
		// levelwiseip -> 4 5 3 2 7 8 1 
		if(path == null) {
			System.out.println("not found");
		}else {
			for(int i:path) {
				System.out.println(i);
			}
		}
 		

	}
}
