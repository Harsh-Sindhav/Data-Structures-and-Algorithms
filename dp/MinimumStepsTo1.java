package dp;

import java.util.Scanner;

public class MinimumStepsTo1 {
	
	public static int minStepsTo1R(int n) {
		if(n==1) return 0;
		int ans1,ans2=Integer.MAX_VALUE,ans3 = Integer.MAX_VALUE;
		 ans1 = minStepsTo1R(n-1)+1;
		if(n%2 == 0) {
			ans2 = minStepsTo1R(n/2) +1;
		}
		if(n%3 == 0) {
			ans3 = minStepsTo1R(n/3) +1;
		}
		
		return Math.min(ans1, Math.min(ans2,ans3));
		
	}
	
public static int minStepsTo1(int n,int[] dp) {
	if(n == 1) {
		return 0;
	}
	int ans1,ans2=Integer.MAX_VALUE,ans3=Integer.MAX_VALUE;
	// in finding min the value of ans2, ans 3 is asking and we have not initialised the values so value of ans2, ans3 will be largest possible value bcoz we are taking min at the end so min of definite (as ans1 is definate) ans2 as infinity and ans 3 as infinity 
	if(dp[n-1] == -1){
	ans1 = minStepsTo1(n-1,dp);
	dp[n-1] = ans1;
	}else {
		ans1 = dp[n-1];
	}
	if((n % 2) == 0) {
		if(dp[n/2] == -1) {
			ans2 = minStepsTo1(n/2,dp);
			dp[n/2] = ans2;
			}else {
				ans2 = dp[n/2];
			}
		}
	if((n % 3) == 0) {
		if(dp[n/3] == -1) {
			ans3 = minStepsTo1(n/3,dp);
			dp[n/3] = ans3;
			}else {
				ans3 = dp[n/3];
			}
		}
	int myAns =Math.min(ans1, Math.min(ans2, ans3)) + 1;
	return myAns;
}

public static int minStepsTo1IDP(int n) {
	
	    int[] dp = new int[n+1];
		dp[1] = 0;
	        if(n==1) return 0;
		for(int i=2;i<dp.length;i++) {
		int a,b=Integer.MAX_VALUE,c=Integer.MAX_VALUE;
			 
		    a = 1 + dp[i-1];
			
		if(i%2==0) {
			b = 1 + dp[i/2];
		}

		if(i%3==0) {
			c = 1 + dp[i/3];
		}
		
		dp[i] = Math.min(a, Math.min(b, c));
		
			
		}
		
		return dp[n];
}

public static int minStepsTo1Idpmy(int n) {
	if(n==1) return 0;
	int[] dp = new int[n+1];
	for(int i=2;i<dp.length;i++) {
	     
		int ans1= Integer.MAX_VALUE, ans2= Integer.MAX_VALUE,ans3 = Integer.MAX_VALUE;
		ans1 = dp[i-1];
		
		if(i%2 == 0) {
			ans2 = dp[i/2];
		}
		
		if(i%3 == 0) {
			ans3 = dp[i/3];
		}		
			dp[i] = 1 + Math.min(ans1, Math.min(ans2, ans3));
	}
	
   return dp[n];
}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
//		int[] dp = new int[n+1];
//		for (int i = 0; i < dp.length; i++) {
//			dp[i] = -1;
//		}
//		int ans = minStepsTo1(n,dp);
//		int ans = minStepsTo1R(n);
		int ans = minStepsTo1Idpmy(n);
		System.out.println(ans);
		s.close();
	}
}
