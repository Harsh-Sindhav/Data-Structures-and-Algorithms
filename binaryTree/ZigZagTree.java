package binaryTree;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import queue.QueueEmptyException;
import binaryTree.*;

public class ZigZagTree {

	//odd levels should get printed from left to right and even level right to left.

	public static void printZigZag1(BinaryTreeNode<Integer> root) {
	if(root == null) {
		System.out.println("tree is empty");
		return;
	}
	
	Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
	
	Stack<BinaryTreeNode<Integer>> s2 = new Stack<>(); 
	s2.push(root);
	while(!s1.isEmpty() || !s2.isEmpty()) {
		
		while(!s2.isEmpty()) {
			BinaryTreeNode<Integer> node = s2.pop();
			System.out.print(node.data + " ");
			// storing elem in s1 in left to right
			if(node.left != null) {
		    	s1.push(node.left);
		    }
		    if(node.right != null) {
		    	s1.push(node.right);
		    }
		   		
		}
		 System.out.println("");	
		 while(!s1.isEmpty()) {
				BinaryTreeNode<Integer> node = s1.pop();
				System.out.print(node.data + " ");
				
				// storing elem in s2 in right to left
			    if(node.right != null) {
			    	s2.push(node.right);
			    }
			    if(node.left != null) {
			    	s2.push(node.left);
			    }
			    
				}
				System.out.println("");
		 }
	
	}
	
	
	
	public static void printZigZag2(BinaryTreeNode<Integer> root) {
			
		if(root == null) {
			return;
		}
		
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		Stack<BinaryTreeNode<Integer>> s = new Stack<BinaryTreeNode<Integer>>();
		int level = 1;
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer> currNode;
			try {
			currNode = q.poll();
			System.out.print(currNode.data +  " ");
           if(level % 2 ==0) {
           if(currNode.right != null)
			s.push(currNode.right);
           if(currNode.left != null)
			s.push(currNode.left); 
            
           }else 
           {
			if(currNode.left != null)
				s.push(currNode.left);
			if(currNode.right != null)
				s.push(currNode.right);
			}
			if(q.isEmpty()) {
				while(!s.isEmpty()) {
					q.add(s.pop());
				}
				System.out.println();
				level++;
		   }
           }catch (Exception e) {
			// TODO: handle exception
		} 
           }
		
		}
			
			
	
		
		
	
	
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
 //ip 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1 
		BinaryTreeUse bt = new BinaryTreeUse();
		BinaryTreeNode<Integer> root = bt.takeInputLevelWise();
				printZigZag1(root);
//		printZigZag2(root);
		
		
	}

}
