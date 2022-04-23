package dp;

public class MagicGrid { public static int getMinimumStrength(int[][] grid) {
    
    /* Your class should be named Solution
	 * Don't write main().
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
 	 * Taking input and printing output is handled automatically.
    */
    
    int[][] dp = new int[grid.length+1][grid[0].length+1];
   
    return getMinRdp(grid,0,0,dp);
}

public static int getMin(int[][] grid,int i,int j){
    int m = grid.length;
    int n = grid[0].length;
    if(i>=m || j >= n){
        return Integer.MAX_VALUE;
    }
    
    if(i == m-1 && j == n-1){
        if(grid[i][j] <= 0){
            return grid[i][j] + 1;
        }else{
            return 1;
        }
    }
    
    int ans1 = getMin(grid,i+1,j);
    int ans2 = getMin(grid,i,j+1);
    int myAns = Math.min(ans1,ans2) - grid[i][j];
    if(myAns <=0 ){
        return 1;
    }else{
        return myAns;
    }
    
}

 public static int getMinRdp(int[][] grid,int i,int j,int[][] dp){
    int m = grid.length;
    int n = grid[0].length;
    if(i>=m || j >= n){
        return Integer.MAX_VALUE;
    }
    
    if(i == m-1 && j == n-1){
        if(grid[i][j] <= 0){
            return grid[i][j] + 1;
        }else{
            return 1;
        }
    }
    int ans1,ans2;
    
     if(dp[i+1][j] == 0){
     ans1 = getMinRdp(grid,i+1,j,dp);
         dp[i+1][j] = ans1;
     }else{
         ans1 = dp[i+1][j];
     }
     
    if(dp[i][j+1] == 0){
     ans2 = getMinRdp(grid,i,j+1,dp);
         dp[i][j+1] = ans2;
     }else{
         ans2 = dp[i+1][j];
     }
     
     int myAns = Math.min(ans1,ans2) - grid[i][j];
    if(myAns <=0 ){
        return 1;
    }else{
        return myAns;
    }
     }
    }
