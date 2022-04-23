package practice;

public class Practice {

	public static int minSquaresToRepresentN(int n) {
		if(n==0) return 0;
		int minAns = Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			int currAns = minSquaresToRepresentN(n-i*i);
			if(currAns < minAns) minAns = currAns;
		}
		return minAns+1;
	}
	
	public static int minSquaresToRepresentNRdp(int n,int[] dp) {
		if(n==0) return 0;
		int minAns = Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			int currAns;
			if(dp[n-i*i] == -1) {
				currAns = minSquaresToRepresentNRdp(n-i*i, dp);
				dp[n-i*i]= currAns;
			}else {
				currAns=dp[n-i*i];
			}
			if(currAns<minAns) minAns = currAns;				
		}
		return minAns + 1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
