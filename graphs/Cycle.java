package graphs;

import java.util.Scanner;

public class Cycle {

	public static int solve(int[][] graph,int n) {
		
		int cycleCount = 0;
		
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				for(int k = j+1;j<n;j++) {
					if(graph[i][j] == 1 && graph[j][k] ==1 && graph[k][i] ==1) {
						cycleCount++;
					}
				}
			}
		}
		
		
		return cycleCount;
	}
	
	
	
	public static void main(String[] args) {
		
		 Scanner s = new Scanner(System.in);
	      int n = s.nextInt();  // n is no of vertices
	      int e = s.nextInt();
	      int adjMatrix[][] = new int[n][n];
	      for (int i = 0; i < e; i++) {
//	       for checking adj matrix  v 4 e 5 i/p 0 1 0 2 3 0 1 3 2 3
	    	int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2]  =1;
			adjMatrix[v2][v1]  =1;
		}

	      
	       int ans = solve(adjMatrix, n);
		
		System.out.println(ans);
	}
}
