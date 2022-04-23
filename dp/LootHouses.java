package dp;

import java.util.Arrays;

public class LootHouses {

	public static int maxMooneyLooted(int[] houses,int i) {
	 // i starts from 0
		if(i==houses.length) {
			return 0;
		}
		if(i == houses.length-1) {
			return houses[houses.length-1];
		}
		
		int ans1 = houses[i] + maxMooneyLooted(houses ,i+2);
		int ans2 = maxMooneyLooted(houses,i+1);
		
		return Math.max(ans1, ans2);
	}
	
	public static int maxLootedRdp(int[] houses,int[] dp,int ei) {
	
		if(ei < 0) {
			return 0;
		}
		if(ei == 0) {
			return houses[0];
		}
		
		int ans;
		if(dp[ei] == 0) {
			ans = Math.max(houses[ei] + maxLootedRdp(houses,dp,ei-2),maxLootedRdp(houses, dp, ei-1));
		   dp[ei] = ans;
		}else {
			ans = dp[ei];
					
		}
		
	return ans;
	}
	
	
	public static int maxLooted(int[] houses) {
		
		int n = houses.length;
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return houses[0];
		}
		
		int[] dp = new int[n];
		dp[0] = houses[0];
		dp[1] = Math.max(houses[0], houses[1]);
		for(int i=2;i<n;i++) {
			dp[i] = Math.max(dp[i-1], houses[i]+dp[i-2]);
		}
	return dp[n-1]; 	
	}
	
	public static void main(String[] args) {
	
//		int[] houses = {5 ,5 ,10 ,100 ,10 ,5};
		int[] houses = {10,2,30,20,3,50};
		int[] dp = new int[houses.length+1];
//		Arrays.fill(dp,-1);
		int ans = maxLootedRdp(houses, dp, houses.length-1);
//		int ans = maxMooneyLooted(houses, 0);
		System.out.println(ans);
		
}
	
}
