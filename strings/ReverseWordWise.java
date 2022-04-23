package strings;

public class ReverseWordWise {
	public static String reversewordwise(String s) {
		
		int end = s.length();
		int i = s.length() - 1;
		String output = "";
		while(i >= 0) {
		if(s.charAt(i) == ' ') {
			output = output + s.substring(i + 1, end) + " ";
			end = i;
		}	
	    	i--;
		}
		output += s.substring(i + 1, end);	   
		return output;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String s = "my name is harsh";
		     System.out.println(reversewordwise(s));
	}
}
