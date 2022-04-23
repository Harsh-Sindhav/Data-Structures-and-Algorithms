package stack;

import java.util.Stack;

//import com.sun.org.apache.xpath.internal.Expression;

public class BalancedParanthesis {

	public static boolean checkBalance(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			}else if(s.charAt(i) == ')' ||s.charAt(i) == '}' || s.charAt(i) == ']' ) {
				if(stack.isEmpty()) {
					return false;
				}
				char topChar = stack.pop();
				if(s.charAt(i) == ')' && topChar == '(' ||s.charAt(i) == '}' && topChar == '{' || s.charAt(i) == ']' && topChar == '['  ) {
					continue;
				}else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "{a+[b+(c+d)]+(e+f)}" ;
		boolean check = checkBalance(s);
		System.out.println(check);
	}
	}



