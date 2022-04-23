package stack;

import java.util.Stack;

public class MinimumBracketReversal {

	public static int countBracketReversal(String ip) {
		
		int len = ip.length();
		if(len == 0) {
			return 0;
		}
		
		if(len %2 != 0) {
		return -1;	
		}
		
		Stack<Character> s = new Stack<Character>();
		
		for(int i=0;i<len;i++) {
			char currChar = ip.charAt(i);		
		
			if(currChar == '{') {
			s.push(currChar);
		}  else {
			if(!s.isEmpty() && s.peek() == '{') {
				s.pop();
			} else {
				s.push(currChar);
			}	
		}
		}
		
	int count =0;
	
	while(!s.isEmpty()) {
		char char1 = s.pop();
		char char2 = s.pop();
	
		if(char1 != char2) {
			count+=2;
		}else {
			count+=1;
		}
	}
		
		return count;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
