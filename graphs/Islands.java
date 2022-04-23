package graphs;

import java.util.Scanner;

public class Islands {
	
	
	public static int numConnected(int[][] edges,int n) {
		boolean[] visited = new boolean[n];
		int count  = 0 ;
		for(int i=0;i<n;i++) {
			if(visited[i] == false) {
				dfs(edges,i,visited,n);
				count++;
			}
		}
	  return count;
	}
	
	
	private static void dfs(int[][] edges,int v1,boolean[] visited,int n) {
	    visited[v1] = true;
	    
	    for(int i=0;i<n;i++) {
	    	if(visited[i] == false && edges[v1][i] == 1) {
	    		dfs(edges,i,visited,n);
	    	}
	    }
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int e = s.nextInt();
		int[][] adjMatrix = new int[n][n];
		
		for(int i =0;i<e;i++) {
			
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
		int count  = numConnected(adjMatrix, n);
		System.out.println(count);
		s.close();
	}

}
