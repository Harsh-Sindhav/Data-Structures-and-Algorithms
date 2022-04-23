package dp;

import java.util.Scanner;

public class NoOfBalancedBTs {
  
	
	
	// h>=0
	public static long balancedBTs(long n){ 
		if (n <= 1) { return 1; }
		int mod =(int) Math.pow(10, 9) + 7;
		long x = balancedBTs(n - 1);
		long y = balancedBTs(n - 2);
		long temp1 = (x * x) % mod; // Number of BTs made by attaching subtrees of height (n - 1) at both sides of root 
		long temp2 = (2 * x * y) % mod; // Number of BTs made by attaching subtrees of heights (n - 1) and (n - 2) at each side of root 
		long ans = (temp1 + temp2) % mod; 
		return ans; 
		}
	
	
	public static int balancedBtsmyRec(int height) {
		if(height<=1) return 1;
		
		int mod = (int) Math.pow(10, 9)+7;
		
		int x = balancedBtsmyRec(height-1);
		int y = balancedBtsmyRec(height-2);
		
		int temp1 = (int)(((long)x * x)%mod);
		int temp2 = (int)(2*((long)x*y)%mod);
		
		int ans = temp1 + temp2;
		return ans;
	}
	
	public static int balancedBtsmyRdp(int height,int[] dp) {
		
		if(height<=1) return 1;
		int mod = (int)Math.pow(10, 9)+7;
		int x,y;
		if(dp[height-1] == 0) {
			x = balancedBtsmyRdp(height-1, dp);
			dp[height-1] = x;
		}else {
			x = dp[height-1];
		}
		
		
		if(dp[height-2] == 0) {
			y = balancedBtsmyRdp(height-2, dp);
			dp[height-2] = y;
		}else {
			y = dp[height-2];
		}
		
		
		int temp1 = (int)(((long)x * x)%mod);
		int temp2 = (int)(2*((long)x*y)%mod);
		
	return temp1+temp2;	
	}
	
	
	public static int balancedBTs(int height){ 
		if(height == 0){
			return 1;
			}
		int arr[] = new int[height + 1]; 
		arr[0] = arr[1] = 1;
		int mod = (int) Math.pow(10, 9) + 7;
		for(int i = 2; i <= height; i++){
			// Cast to long 
			long temp1 = (long) (arr[i- 1]) * arr[ i - 1];
			temp1 = temp1 % mod; 
			
			// Cast to long 
			
			long temp2 = 2 * (long) (arr[i - 1]) * arr[ i - 2];
			temp2 = temp2 % mod; 
			arr[i] = (int) (temp1 + temp2) % mod;
			} 
		return arr[height];
		}
		
	
	public static void main(String[] args) {

		Scanner s  = new Scanner(System.in);
		int h = s.nextInt();
//		long ans = balancedBTs(h);
//		int ans = balancedBtsmyRec(h);
		int[] dp = new int[h+1];
		int ans = balancedBtsmyRdp(h, dp);
		
		System.out.println(ans);
		s.close();
		
	}
	
	
}
