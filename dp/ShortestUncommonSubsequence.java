package dp;

import java.util.Arrays;

public class ShortestUncommonSubsequence {

static final int MAX = 1005;
	
 public static int shortestSeq(char []S, char []T, int m, int n)
{
	 if (m == 0)
	        return MAX;
	 
	    // T String is empty
	    if (n <= 0)
	        return 1;
	    
	    int k;
	    for(k=0;k<n;k++) {
	    	if(T[k] == S[0])
	    		break;
	    }
	    if(k==n) return 1;
	    
	    return Math.min(shortestSeq(Arrays.copyOfRange(S, 1, S.length), T, m-1, n), 1 + shortestSeq(Arrays.copyOfRange(S, 1,S.length), Arrays.copyOfRange(T, k+1, T.length), m-1, n-k-1));




}
	
	
	
	public static void main(String[] args)
	{
	    char S[] = "babab".toCharArray();
	    char T[] = "babba".toCharArray();
	    int m = S.length, n = T.length;
	    int ans = shortestSeq(S, T, m, n);
	    if (ans >= MAX)
	    ans = -1;
	    System.out.print("Length of shortest subsequence is: "
	        + ans +"\n");
	}
	
	
	
	
}
