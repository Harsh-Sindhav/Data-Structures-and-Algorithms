package binaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//import javax.swing.text.html.HTMLDocument.Iterator;

import linkedList.Node;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Queue;
public class LevelWiseLL {
//	
	public static ArrayList<Node<Integer>> constructLLForEachLevel(BinaryTreeNode<Integer> root){
		if(root == null) return null;
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
	    pendingNodes.add(root);
	    int currLevelRemaining = 1;
	    int nextLevel = 0;
	    Node<Integer> currLevelHead = null;
	    Node<Integer> currLeveltail = null;
		ArrayList<Node<Integer>> op = new ArrayList<>();
		while(!pendingNodes.isEmpty()) {
//			while(currLevelRemaining>0) {
			BinaryTreeNode<Integer> currNode;
			currNode = pendingNodes.remove();
			Node<Integer> newNode = new Node<Integer>(currNode.data);
			if(currLevelHead == null) {
				currLevelHead = newNode;
				currLeveltail = newNode;
			}else {
				currLeveltail.next = newNode;
				currLeveltail = newNode;
			}
     
			if(currNode.left != null) {
				pendingNodes.add(currNode.left);
				nextLevel++;
			}
			
			if(currNode.right != null) {
				pendingNodes.add(currNode.right);
				nextLevel++;
			}
			currLevelRemaining--;
//			}
			if(currLevelRemaining == 0) {
				op.add(currLevelHead);
				currLevelHead = null;
				currLeveltail = null;
				currLevelRemaining = nextLevel;
				nextLevel = 0;
			}
//			}
			
		}
		return op;
	} 
//	
////public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
////        
////        Node<BinaryTreeNode<Integer>> head = null;
////        Node<BinaryTreeNode<Integer>> tail = null;
////        
////        ArrayList<Node<BinaryTreeNode<Integer>>> arr = new  ArrayList<Node<BinaryTreeNode<Integer>>>();
////        
////        
////        
////        Queue<BinaryTreeNode<Integer>> pendingChild = new LinkedList<BinaryTreeNode<Integer>>();
////        
////         Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
////        
////        pendingChild.add(root);
////        
////        while(!pendingChild.isEmpty())
////        {
////            while(!pendingChild.isEmpty())
////            {
////                
////                BinaryTreeNode<Integer> front = pendingChild.poll();
////                
////                Node<BinaryTreeNode<Integer>> node = new Node<BinaryTreeNode<Integer>>(front);//here we have maked a node with front data
////                
////                if(head == null)
////                {
////                    
////                    head = node;
////                    tail = node;
////                }
////                else{
////                    tail.next = node;
////                    
////                    tail = tail.next;
////                }
////                
////                //Now we will add left and right child of root into q queue
////                
////                if(front.left != null)
////                {
////                    q.add(front.left);
////                }
////                
////                if(front.right != null)//this is for adding write chold of front
////                {
////                    q.add(front.right);
////                    
////                }
////            }
////            
////            //Before going to second we will add thr head of link list into arrayList;
////            
////            arr.add(head);
////            
////            //now we reached into second line
////            
////            head =null;
////            tail = null;
////            
////              Queue<BinaryTreeNode<Integer>> temp = new LinkedList<BinaryTreeNode<Integer>>();
////            
////            temp = pendingChild;
////            
////            pendingChild = q;
////            
////            q = temp;
////            
////            
////        }
////        
////        return arr;
////        
////        
////  
////  
////
//// }
//
//
   public static void main(String[] args) {
	BinaryTreeNode<Integer> root =    BinaryTreeUse.takeTreeInputBetter(true, 1, false);                    //new BinaryTreeNode<Integer>(5);    // BinaryTreeUse.takeTreeInputBetter(true, 1, false);
//	 root.left = new BinaryTreeNode<Integer>(10);
//	 root.right = new BinaryTreeNode<Integer>(15);
//	 root.left.left = new BinaryTreeNode<Integer>(20);
//	 root.left.right = new BinaryTreeNode<Integer>(25);
//	 root.right.left = new BinaryTreeNode<Integer>(30);
//	 root.right.right = new BinaryTreeNode<Integer>(35);
	
	ArrayList<Node<Integer>>  al =  constructLLForEachLevel(root);
	 Iterator<Node<Integer>> it = (Iterator) al.iterator();
	 while(it.hasNext()){
	 Node head = it.next();
	 //System.out.print("->" + head.data);
	 while(head!=null){
	 System.out.print("->" + head.data);
	 head = head.next;
	 }
	 System.out.println("");
	 }
	
}
//	
//	
//	public static void main (String[] args) throws java.lang.Exception
//	 {
//	 Node root = new Node(5);
//	 root.left = new Node(10);
//	 root.right = new Node(15);
//	 root.left.left = new Node(20);
//	 root.left.right = new Node(25);
//	 root.right.left = new Node(30);
//	 root.right.right = new Node(35);
//
//	 ListAtDepthBtree i = new ListAtDepthBtree();
//	 //i.levelOrder(root);
//	 i.levelOrderQueue(root);
//	 }

}
//	class ListAtDepthBtree {
//	 ArrayList<ListNode> al = new ArrayList<>();
//	 public void levelOrder(Node root){
//	 int h = height(root);
//	 for(int i=1;i<=h;i++){
//	 printLevels(root,i);
//	 System.out.println("");
//	 }
//	 }
//	 public void printLevels(Node root, int h){
//	 if(root==null) return;
//	 if(h==1) System.out.print(" " + root.data);
//	 else{
//	 printLevels(root.left,h-1);
//	 printLevels(root.right,h-1);
//	 }
//	 }
//	 public int height(Node root){
//	 if (root==null) return 0;
//	 return 1 + Math.max(height(root.left),height(root.right));
//	 }
//	 public void levelOrderQueue(Node root){
//	 Queue q = new LinkedList();
//	 int levelNodes =0;
//	 if(root==null) return;
//	 q.add(root);
//	 while(!q.isEmpty()){
//	 levelNodes = q.size();
//	 ListNode head = null;
//	 ListNode curr = null;
//	 while(levelNodes>0){
//	 Node n = (Node)q.remove();
//	 ListNode ln = new ListNode(n.data);
//	 if(head==null){
//	 head = ln;
//	 curr = ln;
//	 }else{
//	 curr.next = ln;
//	 curr = curr.next;
//	 }
//	 if(n.left!=null) q.add(n.left);
//	 if(n.right!=null) q.add(n.right);
//	 levelNodes--;
//	 }
//	 al.add(head);
//	 }
//	 display(al);
//	 }
//	 public void display(ArrayList<ListNode> al){
//	 Iterator it = al.iterator();
//	 while(it.hasNext()){
//	 ListNode head = (ListNode)it.next();
//	 //System.out.print("->" + head.data);
//	 while(head!=null){
//	 System.out.print("->" + head.data);
//	 head = head.next;
//	 }
//	 System.out.println("");
//	 }
//	 }
//	 
//	}
//	class Node{
//	 int data;
//	 Node left;
//	 Node right;
//	 public Node(int data){
//	 this.data = data;
//	 this.left = null;
//	 this.right =null;
//	 }
//	}
//	class ListNode{
//	 int data;
//	 ListNode next;
//	 public ListNode(int data){
//	 this.data = data;
//	 this.next = null;
//	 }
//	}


