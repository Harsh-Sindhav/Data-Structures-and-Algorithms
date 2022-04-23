package binaryTree;


class Pair2<T,A>{
	T min;
	T max;
	public Pair2(T min,T max) {
		this.min = min;
		this.max = max;
	}
	
}


public class MinAndMaxInBT {	
	
	public static Pair2<Integer,Integer> getMinAndMax(BinaryTreeNode<Integer> root){
		if(root == null) {
			return new Pair2<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
		}

	Pair2<Integer,Integer> leftPair = getMinAndMax(root.left);
	Pair2<Integer,Integer> rightPair = getMinAndMax(root.right);
	
	int min = Math.min(root.data, Math.min(leftPair.min, rightPair.min));
	int max = Math.max(root.data, Math.max(leftPair.max, rightPair.max));
	
	return new Pair2<Integer,Integer>(min, max);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}

}
