package dp;


public class MatrixChainMultiplication {

	
	
	public static int mcmRgfg(int[]p,int i,int j) {
		// i starts from 1
		if(i==j) return 0;
		
		int min  = Integer.MAX_VALUE;
		
		for(int k = i;k < j;k++) {
		
			int count = mcmRgfg(p, i , k) + mcmRgfg(p, k+1, j) + p[i-1]*p[k]*p[j];
		
			if(count < min) min = count;
		}
		
	return min;	
	}
	

	public static int mcmRCN(int[]p,int si,int ei) {
		if(si == ei ) {
			return 0;
		}
		if(si == ei-1) {
		return 0;	
		}
		
		int min = Integer.MAX_VALUE;
		for(int k=si+1;k<ei;k++) {
			int count = mcmRCN(p, si, k)+mcmRCN(p, k, ei) + p[si]*p[k]*p[ei];
		   if(count<min) min = count;
		}
		return min;	
	}
	
	public static int mcmRdpCN(int[]p,int si,int ei,int[][]dp) {
		if(si==ei)return 0;
		if(si == ei-1)return 0;
		if(dp[si][ei] != -1) {
			return dp[si][ei];
		}
		dp[si][ei] = Integer.MAX_VALUE;
		for(int k=si+1;k<ei;k++) {
			dp[si][ei] = Math.min(dp[si][ei], mcmRdpCN(p, si, k, dp) + mcmRdpCN(p, k, ei, dp) + p[si]*p[k]*p[ei]);
		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
	  return dp[si][ei];	
	}
	
	public static int mcmCNIdp(int[] p) {
		
		int[][] storage = new int[p.length][p.length];
		for(int i = p.length-2;i>=1 ;i--) {
			for(int j=1;j<=p.length-1;j++) {
				if(i<j) {
					int minCost = Integer.MAX_VALUE;
					for(int k=i;k<j;k++) {
						int cost = storage[i][k] + storage[k+1][j] + p[i-1]*p[k]*p[j];
						System.out.println(cost);
						if(cost < minCost) {
							minCost = cost;
						}
						storage[i][j] = minCost;
					}
				}
			}
		}

		for(int i=0;i<storage.length;i++) {
			for(int j=0;j<storage[0].length;j++) {
				System.out.print(storage[i][j] + " ");
			}
			System.out.println();
		}
		
		return storage[1][p.length-1];
	}
	
	
	//gap Strategy
	public static int mcmPepIDP(int[] arr) {
		int[][] dp = new int[arr.length-1][arr.length-1];
		
		for(int g = 0;g < dp.length;g++) {
			for(int i=0,j=g;j<dp.length;i++,j++) {
				if(g==0) {
					dp[i][j] = 0;
				}else if(g==1) {
				  dp[i][j] = arr[i]*arr[j]*arr[j+1];	
				}else {
					int min = Integer.MAX_VALUE;
					
					for(int k=i;k<j;k++) {
						// dp ->i,k leftHalf and k+1,j rightHalf
						// arr-> i*k+1 leftHalf,k+1*j+1 rightHalf
						int lc = dp[i][k];
						int rc = dp[k+1][j];
						int mc = arr[i]*arr[k+1]*arr[j+1];
						int tc = lc+rc+mc;
						if(tc<min) {
							min = tc;
						}	
					}
				dp[i][j] = min;	
				}
			}
		}
		
		
		return dp[0][dp.length-1];
	}
	
	
	
	
	
//	public static int mcmidp(int[] p) {
//		
//		int[][] dp = new int[p.length][p.length];
//		for(int i = dp.length-1;i>=0 ;i--) {
//			for(int j=0;j<=dp.length-1;j++) {
//	
//				if(i<j) {
//					if(i==j-1) {
//					 continue;
//					}else {
//					int minCost = Integer.MAX_VALUE;
//					for(int k=i-1;k<j;k++) {
//						int cost = dp[i][k] + dp[k][j] + p[i]*p[k]*p[j];
//						System.out.println(cost);
//						if(cost < minCost) {
//							minCost = cost;
//						}
//						dp[i][j] = minCost;
//					}
//					}
//				}
//			}
//		}
//
////		for(int i=0;i<dp.length;i++) {
////			for(int j=0;j<dp[0].length;j++) {
////				System.out.print(dp[i][j] + " ");
////			}
////			System.out.println();
////		}
//		
//		return dp[1][p.length-1];
//	} 
	
	
	
	public static void main(String[] args) {
    
	
//		int[] p = {10,15,20,25};
		
//		int[] p = {40,20,30,10,30};
		
		int[] p = {1,2,3,4,3};
		
		int[][] dp = new int[p.length][p.length];
		for(int i=0;i<dp.length;i++) {
			for(int j = 0;j<dp[0].length;j++) {
				dp[i][j] = -1;
			}
		}
//		int x = mcmCN(p);          
		int x = mcmCNIdp(p);   
//		int x =mcmRdp(p, 0, p.length-1,dp);       
		System.out.println(x);
		
	}
}
