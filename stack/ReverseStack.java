package stack;
import java.util.Stack;
public class ReverseStack {

	public static void ReverseStack(Stack<Integer> s1, Stack<Integer> helper) {
		if(s1.size()<=1) {
			return;
		}	
		int temp = s1.pop();
		
		ReverseStack(s1, helper);
		
		while(!s1.isEmpty()) {
			helper.push(s1.pop());
		}
		s1.push(temp);
		while(!helper.empty()) {
			s1.push(helper.pop());
		}
	}
	
	public static void main(String[] args) {
		
      int arr[] = {5,6,7,1,9};
      Stack<Integer> stack = new Stack<>();
      Stack<Integer> helper = new Stack<>();
	
	for(int elem: arr) {
		stack.push(elem);
	}
      ReverseStack(stack, helper);
      while(!stack.isEmpty()) {
    	  System.out.print(stack.pop() +" ");
      }
      
	}

}
