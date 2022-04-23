package dp;

public class WaysToMakeCoinChange {
 
	
	
	public static int countWaysToMakeChangeR(int denominations[], int value){
        // Write your code here
	
      return countR(denominations,value,0);
    }
    
    public static int countR(int[] arr,int val,int i){
        if(i == arr.length){
            return 0;
        }
    
    if(val<0){
        return 0;
    }
    
        if(val == 0){
            return 1;
        }
        
    return countR(arr,val-arr[i],i) + countR(arr,val,i+1);
        
    }
	
    public static long countWaysToMakeChangeI(int denominations[], int value){
    	int m = denominations.length;
    	int n = value;
    	long[][] dp = new long[m+1][n+1];
    	 for(int i = 0; i <= m; i++){
             dp[i][0] = 1; 
         } 
    	 
    	 for(int i = m-1; i >= 0; i--) {
    			for(int j = 1; j < dp[i].length;j++) { 
    				long count1 = 0;
    			if(i+1 <= m-1){
    				count1 = dp[i+1][j];  			
    				}
    			long count2 = 0;
    			if(j-denominations[i]>=0) {
    				count2 = dp[i][j-denominations[i]]; 
    			}
    			dp[i][j] = count1 + count2;
    			}
    			
    			}
    			
   
    	return dp[0][n];
    }
    
	
	
 public static int countWaysToMakeChangeIDP(int denominations[],int value) {

	 int n = denominations.length; 
     int ways[][] = new int[n][value + 1];
     for(int i = 0; i < n; i++){
         ways[i][0] = 1; 
     } 
     for(int i = n-1; i >=0 ; i--){ 
         for(int j = 1; j <= value; j++){
             int count1 = 0; 
             if(i + 1 <= n - 1){
                 count1 = ways[i + 1][j] ; 
             } 
             int count2 = 0; 
             if(j - denominations[i] >= 0){ 
                 count2 = ways[i][j - denominations[i]];
             } 
             ways[i][j] = count1 + count2;
         } 
     } 
     for(int i=0;i<ways.length;i++) {
 		for(int j=0;j<ways[0].length;j++) {
 			System.out.print(ways[i][j] + " ");
 		}
 		System.out.println();
 	} 
     return ways[0][value];

 }	
	
	
	
	public static void main(String[] args) {
		
		int[] denominations = {1,2,3};            // {1 ,2 ,3 ,4 ,5 ,6};
		int val = 4;      // 250
		
	int ans = countWaysToMakeChangeIDP(denominations, val);                                  // countWaysToMakeChangeR(denominations, val);
	System.out.println(ans);
	
		
		
}
	
}
