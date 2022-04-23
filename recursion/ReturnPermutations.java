package recursion;

public class ReturnPermutations {

	public static String[] permutationsOfString(String input) {
		if(input.length()==0) {
			String output[] = {""};
			return output;
		}
		String[] smallerOutput = permutationsOfString(input.substring(1));
		String output[] = new String[input.length()*smallerOutput.length];
		int k = 0;
		for(int i =0;i<smallerOutput.length;i++) {
			String currentString = smallerOutput[i];
			for(int j=0;j<=currentString.length();j++) {
				output[k] = currentString.substring(0,j)+input.charAt(0)+currentString.substring(j); // remember that in substring fn end index is exclusive!
				k++;
			}
		}		
	return output;	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="adg";
		String[] d = permutationsOfString(s);
		for(String j : d) {
			System.out.println(j);
		}
		
	
		
		
	}

}
