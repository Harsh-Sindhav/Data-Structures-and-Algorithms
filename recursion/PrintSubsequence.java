package recursion;

public class PrintSubsequence {
	public static void printSubsequence(String input, String outputSoFar){
		if(input.length()==0) {
			System.out.println(outputSoFar);
		   return;
		}
		printSubsequence(input.substring(1), outputSoFar);
		printSubsequence(input.substring(1), outputSoFar + input.charAt(0));
//		return;
	}

	public static void printSubsequence(String input) {
	printSubsequence(input, "");	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "xyz";
		printSubsequence(s);

	}

}
