package dp;

public class MaximumSquareMatrixWithAllZeros {

   public static int findMaxSquareWithAllZeroes(int[][] input) {
	   int max =0;
	   if(input.length==0) {
		   return 0;
	   }
	   
	   int[][] arr = new int[input.length][input[0].length];
	   
	   for(int i=0;i<input.length;i++) {
		   if(input[i][0] == 0) {
			   arr[i][0]=1;
			   max = 1;
		   }else {
			   arr[i][0]=0;
		   }
	   }
	   
	   for(int j=0;j<input[0].length;j++) {
		   if(input[0][j] == 0) {
			   arr[0][j] = 1;
			   max =1;
		   }else {
			   arr[0][j] = 0;
		   }
	   }
	   
	   for(int i=1;i<input.length;i++) {
		   for(int j=1;j<input[0].length;j++) {
			   if(input[i][j] == 1) {
				   arr[i][j] = 0;
			   }else {
				   arr[i][j] = 1 + Math.min(arr[i-1][j-1], Math.min(arr[i][j-1], arr[i-1][j]));
			  if(arr[i][j] > max) {
				  max = arr[i][j];
			  }
			   }
		   }
	   }
	   
	 return max;
   }	
	
	public static void main(String[] args) {
		
	}
}
