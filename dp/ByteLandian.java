package dp;

public class ByteLandian {

	
	public static long bytelandianR(int n) {
		
		if(n<=1) {
			return n;
		}
		
	long a = bytelandianR(n/2);
	long b = bytelandianR(n/3);
	long c = bytelandianR(n/4);		
		return Math.max(n, (a+b+c)); 
	}
	
	public static long bytelandianRdp(int n,int[] dp) {
		if(n<=1) {
			return n;
		}
		
	dp[0] = 0;
	dp[1] = 1;
	long a,b,c;
	if(dp[n/2] == -1) {
		a = bytelandianRdp(n/2,dp);
		dp[n/2] = (int)a;
	}else {
		a = dp[n/2];
	}
	
	if(dp[n/3] == -1) {
		b = bytelandianRdp(n/3,dp);
		dp[n/3] = (int)b;
	}else {
		b = dp[n/3];
	}
	
	if(dp[n/4] == -1) {
		c = bytelandianRdp(n/4,dp);
		dp[n/4] = (int)c;
	}else {
		c = dp[n/4];
	}
	
	return  Math.max(n, (a+b+c));
	}
	
	public static int ByteLandianIdp(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<dp.length;i++) {
			int a = dp[i/2];
			int b = dp[i/3];
			int c = dp[i/4];
			dp[i] = Math.max(i, a+b+c); 
		}
	return dp[n];
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n =12;

int dp[] = new int[n+1];
for(int i =0;i<dp.length;i++) {
    dp[i] = -1;	
}		

long x = bytelandianR(n);
//long x = bytelandianRdp(n,dp);
// int x = ByteLandianIdp(n);
System.out.println(x);
	
	}

}
