package dp;

public class CoinTower {

	public static String findWinnerR(int n,int x,int y) {
		boolean a1=false,a2=false,a= false,b= false,c=false;
		if(x > n && y < n) {
			 a1 = findWinnerHelper(n-1, x, y); 
		     a2 = findWinnerHelper(n-y, x, y);	
		}
		else if(x < n && y > n) {
			 a1 = findWinnerHelper(n-1, x, y);
			 a2 = findWinnerHelper(n-x, x, y);
		}else if(n < x && n < y) {
			a1 = findWinnerHelper(n-1, x, y);
		}
		else {
		 a = findWinnerHelper(n-1, x, y);
		 b = findWinnerHelper(n-x, x, y);
		 c = findWinnerHelper(n-y, x, y);
		}
		
		if(a1^1 ==1 || a2^1 ==1|| a^1 == 1 || b^1 == 1 || c^1 == 1 ) {
			return "Beerus";  
		}else {
			return "Whis";		
		}
	
	}
	
	public static boolean findWinnerHelper(int n,int x,int y) {
		
      		if(n==0) {
      	return true;		
      		}
      				
		return findWinnerHelper(n-1, x, y) || findWinnerHelper(n-x, x, y);
	}

	
	public static String findWinner(int n,int x,int y) {
		if(x>y) {
			int temp = x;
			x = y;
			y = temp;
		}
		
		boolean dp[] = new boolean[n+1];
		
		for(int i = 1; i <= n; i++) {
				if(i==1||i==x||i==y) {
					dp[i] = true;
				}
				else if(i<x) {
				dp[i] = !dp[i-1]; 	
				}
				else if(i < y) {
					dp[i] = !dp[i - x] && dp[i - 1];
				}else {
					dp[i] = !dp[i-x] && dp[i-y] && dp[i-1];
				}	
			}
		
			boolean result = dp[n];
		if(result) {
			return "Beerus";
		}else {
			return "Whis";
		}
	} 
	
	
	public static void main(String[] args) {
		
	}
}
