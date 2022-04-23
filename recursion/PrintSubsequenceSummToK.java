package recursion;

public class PrintSubsequenceSummToK {

	public static void printSubsequenceHelper(int[] input,int si,int[] output,int k) {
		
		if(si == input.length) {
		if(k==0) {
			
			for(int i : output) {
				
				System.out.print(i + " ");
				
			}
			System.out.println();
			
			return;
			
		}else {
			
			return;
		}
		
		}
		
		
		int[] newOutput = new int[output.length+1];
		
		int i = 0 ;
		
		for(;i<output.length;i++) {
			
			newOutput[i] = output[i];
			
		}
		
		newOutput[i] = input[si];
		printSubsequenceHelper(input, si+1, output, k);
		printSubsequenceHelper(input, si+1, newOutput, k-input[si]);
		
		
		
	}
	
	public static void printSubsequence(int[] input,int k) {
		
		int output[] = new int[0];
	  	// created output arr and saving the output here and will print the results that are stored in it ...
	// and obviously as we're doing nothing in the func other then printing so the return type is void 
		printSubsequenceHelper(input, 0, output, k);
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {5,12,3,17,1,18,15,3,17};
		int k = 6;
       printSubsequence(arr, k);		
		

	}

}
