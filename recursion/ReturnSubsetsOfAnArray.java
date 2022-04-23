package recursion;

public class ReturnSubsetsOfAnArray {
	
	// time comp 2^n

	public static int[][] subset(int arr[]) {
		
     return subset(arr,0,arr.length-1);
		
	}
	
	private static int[][] subset(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
		if(si > ei) { 
			int[][] ans = new int[1][0];
			return ans;
				} 
		
		int[][] smallArr = subset(arr, si+1, ei);
		// jagged array
		int[][] ans = new int[2*smallArr.length][];
		int k = 0;
		for (int i = 0; i < smallArr.length; i++) {
			ans[k] = new int[smallArr[i].length];
			for(int j = 0; j < smallArr[i].length;j++) {  //smallArr[i].length iska matlab ek particular row ke kitne cols hain kyuki jagged array hain
				ans[k][j] = smallArr[i][j];
			}
			k++;
		}
		for(int i = 0;i<smallArr.length;i++) {
			
			ans[k] = new int[smallArr[i].length + 1];
			ans[k][0] = arr[si];
			for(int j = 1; j <= smallArr[i].length;j++) {
				ans[k][j] = smallArr[i][j-1];
			}
			k++;  
			 
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[] = {15,20,12};
      int ans[][] = subset(arr);
      int k =1;
      System.out.print("jagged array" + "\n");
      for (int i = 0; i < ans.length; i++) {
    	  
    	  if(i==0) {
    		  System.out.print(k + "-->  ");
    	  }
    	  
		for (int j = 0; j < ans[i].length; j++) {
			System.out.print(k +"-->  ");
			System.out.print(ans[i][j] + " ");
		}
		System.out.println();
	    k++;
      }
	}

}
