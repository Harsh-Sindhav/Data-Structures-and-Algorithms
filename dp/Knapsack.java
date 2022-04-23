package dp;

public class Knapsack {
	
	private static int knapsack(int W, int[] val, int[] wt, int i) {
    
		if(i == val.length) {
			return 0; 
		}
		
		int ans;
    if(wt[i] <= W) {
    	//including the ith item
    	int ans1 = val[i] + knapsack(W-wt[i], val, wt, i+1);
      // excluding the ith item
    	int ans2 = knapsack(W, val, wt, i+1);
       ans = Math.max(ans1, ans2);
    }	else {
    	ans = knapsack(W, val, wt, i+1);
    }	
		return ans;
	}
	
	public static int knapsackRdp(int W,int[]wt,int[] val,int n,int[][] dp) {
		if(n==0 || W ==0) {
			return 0;
		}
		if(dp[n][W] != -1) {
			return dp[n][W];
		}
		
		if(wt[n-1] > W) {
			return dp[n][W] = knapsackRdp(W, wt, val, n-1, dp);
		}else {
			return dp[n][W] =  Math.max(val[n-1] + knapsackRdp(W-wt[n-1], wt, val, n-1, dp), knapsackRdp(W, wt, val, n-1, dp));
		}
		
		
	}
	
	
	
	public static int knapsackidp(int[] wt,int[] val,int W) {
		int n = val.length;
		int[][] dp = new int[n+1][W+1];

		for(int i = n-1; i >= 0; i--) {
		for(int w = 0; w <= W;w++) {  // or you can start from w=1 
             int ans;
			if(wt[i] <= w) {
				int ans1 = val[i] + dp[i+1][w-wt[i]];
				int ans2 = dp[i+1][w];
			    ans = Math.max(ans1 ,ans2);
			}else {
			      ans = dp[i+1][w];
			}
			dp[i][w] = ans;
		}	
		}
		
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//		System.out.print(dp[i][j] + " ");		
//			}
//			System.out.println();
//		}
	
		return dp[0][W];
	}
	

	
	public static void main(String[] args) {
//	 
		int val[]= {200,300,100};
		int wt[] = {20,25,30};
		int W  = 50;
		
		int dp[][] = new int[val.length+1][W+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = -1;
			}
		}
//		int ans = knapsack(W,val,wt,0);
//		int ans = knapsackidp(wt, val, W);
		int n = val.length;
		int ans = knapsackRdp(W, wt, val, n, dp);
		System.out.println(ans);
	
//		int wt[] = {1,3,4,5};
//		int val[] = {1,4,5,7};
//		int w = 7;
////		int n = wt.length;
//		int max = knapsack(w, val, wt, 0);
//		System.out.println(max);
		
    }
	
}
