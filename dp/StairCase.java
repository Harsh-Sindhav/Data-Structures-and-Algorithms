package dp;

public class StairCase {
	
	public static int stairCaseR(int n) {
		if(n==0) return 1;
		if(n==1 || n==2) return n;
		return stairCaseR(n-1) + stairCaseR(n-2) + stairCaseR(n-3);
	}
	

	public static long staircaseRDP(int n,long ways[]) {
		
		if(n==0) {
			return 1;
	
		}
		if(n==1 || n==2) {
			return n;
		}
		
		long ans1, ans2, ans3;
	ans1 = staircaseRDP(n-1,ways);
	ans2 = staircaseRDP(n-2,ways);
	ans3 = staircaseRDP(n-3,ways);
	long count;
	
	 if(ways[n]==-1){
		 count = ans1 + ans2 + ans3;
			ways[n] = count;}
		        else{
		            count = ways[n];
		        }
	return count;
	}
	
	public static long staircaseidp(int n) {
	long ways[] = new long[n+1];
	
	if(n==0) {
		return 1;
	}
	if(n == 1 || n==2) {
		return n;
	}
	ways[0] = 1;
	ways[1] = 1;
	ways[2] = 2;
	for (int i = 3; i < ways.length; i++) {
		ways[i] = ways[i-1]+ways[i-2] + ways[i-3];
	}
	return ways[n];
}

	public static long staircaserdpmy(int n,long[] dp) {
		if(n==0) return 1;
		if(n==1 || n==2) return n;
		long ans1,ans2,ans3;
		if(dp[n-1] == 0) {
			ans1 = staircaserdpmy(n-1, dp);
			dp[n-1] = ans1;
		}else {
			ans1 = dp[n-1];
		}
		if(dp[n-2] == 0) {
			ans2 = staircaserdpmy(n-2, dp);
			dp[n-2] = ans2;
		}else {
			ans2 = dp[n-2];
		}
		if(dp[n-3] == 0) {
			ans3 = staircaserdpmy(n-3, dp);
			dp[n-3] = ans3;
		}else {
			ans3 = dp[n-3];
		}
		
	return ans1+ans2+ans3;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
    int n=10;
    long[] dp = new long[n+1];
    System.out.println(staircaserdpmy(n,dp));

	}	
}
