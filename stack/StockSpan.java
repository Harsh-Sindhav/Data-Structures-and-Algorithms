package stack;

import java.util.Stack;

public class StockSpan {

public static int[] stockSpan(int[] price) {
	
	Stack<Integer> stk =  new Stack<>();
	int n = price.length;
	int[] op = new int[n];
	stk.push(0); // putting indexes
	
	op[0] =1;
	for(int i=1;i<n;i++) {
		while(!stk.isEmpty() && price[stk.peek()] < price[i]) {
			stk.pop();
		}
		if(stk.isEmpty()) {
			op[i] = i+1;
		}else {
			op[i] = i - stk.peek();
		}
		stk.push(i);
	}
	
	return op;
}	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
