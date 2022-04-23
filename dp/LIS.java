package dp;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {


	//leetcode recursive
   
	static int lis(int[] nums) {
		
		if(nums.length == 1)return 1;
		
	   return recursion(nums,0,Integer.MIN_VALUE);
	}
	
	
	 static int recursion(int[] nums,int idx,int prev) {
		 if(idx >= nums.length) return 0;
		 
		 int cur = nums[idx];
		 int ans2 = 0;
		 if(cur <= prev) ans2 = recursion(nums, idx+1, prev);   // not select
		 int ans1 = 1 + recursion(nums,idx+1,cur);  // select
//		 ans2 = recursion(nums, idx+1, prev);   // not select
		 
		 return Math.max(ans1, ans2);
	 }
	
	
	
	// giving wrong ans
	public static int lisR(int[] arr,int n,int si,int ei) {
		if(si>=ei) return 1;
		
		int smallAns = lisR(arr, n, si+1, ei);
		if(arr[si] < arr[si+1]) {
			return 1 + smallAns;
		}else {
			return smallAns;
		}
		
	}
	
	// giving wrong ans
	public static int lisrdp(int[] arr,int[] dp,int n) {
	if(n <= 1) return 1;
  	int longest = 1;
	if(dp[n] == 0){
		longest = lisrdp(arr,dp,n-1);
		dp[n] = longest;
	}else {
		longest = dp[n];
	}		
	if(arr[n-2] < arr[n-1])
		longest++;
		
		return longest;
	}
	
	// giving wrong ans	
//	public static int lisRdp(int[] arr,int[] dp,int n) {
//		
//		if(arr[0] < arr[1]) return 1;
//		
//		if(n <= 0 ) {
//			return 1;
//		}	
//		
//		
//		int ans;
//		
//		if(dp[n-1] == 0) {
//		   if(arr[n-2] < arr[n-1]) {
//			   ans = 1 + lisRdp(arr, dp, n-1);
//		   }else {
//			ans = lisRdp(arr, dp, n-1);   
//		   }
//		}else {
//		ans = dp[n-1];
//		}	
//	
//		
//		return ans;
//	}
	
	
	private static int lis(int[] arr, int n) {
		int dp[] = new int[n];
		dp[0] = 1;
		for(int i = 1;i < n; i++) {
		dp[i] = 1;  // error is here !
		for(int j = i - 1; j >= 0; j--) {
		if(arr[j] >= arr[i]) {
			continue;
		}	
		int possibleAns = dp[j] + 1;
		if(possibleAns > dp[i]) {
			dp[i] = possibleAns; 
		}
		 }
		}
		int best = 0;
		for(int i=0;i<n;i++) {
			if(best < dp[i])
			best = dp[i];
		}
		
		return best;
	}
	
	public static int lisCorrect(int arr[]) {
		int dp[] = new int[arr.length];
		dp[0]=1;
		int ans=1;
		for(int i=1;i<dp.length;i++) {
			int max = 1;
			for(int j = i-1;j>=0;j--) {
				if(arr[j] < arr[i]) {
				int op = dp[j] + 1;	
				if(op > max)
				max = op;
				}	
			}
			dp[i] = max;
			if(max > ans) {
				ans = max;
			}
		}
	
	return ans;	
	}
	
	
	
	
	
	public static void main(String[] args) {
		 int n;
		 Scanner s = new Scanner(System.in);
		 n = s.nextInt();
		 int[] arr = new int[n];
		 
       for(int i=0;i<arr.length;i++) {
    	   arr[i] = s.nextInt();
       }		 
		//ip = 7 , 4 3 9 7 6 8 20  o/p 4
//		int ans = lis(arr,n);
//       int ans = lisR(arr, n, 0, arr.length-1);
//       int[] dp = new int[n+1];
//		Arrays.fill(dp, 0);
//       int ans = lisrdp(arr, dp, n);
//		System.out.println(ans);
	
		s.close();
	
	}

	
}
