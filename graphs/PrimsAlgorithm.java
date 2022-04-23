package graphs;

import java.util.Scanner;

public class PrimsAlgorithm {

	
	public static int findMinVertex(boolean[] visited, int[] weight) {
		// TODO Auto-generated method stub
	   int minVertex = -1;  // you don't have vertex that means you've to travel over all the vertices
	   for (int i = 0; i < visited.length; i++) {
		   if(!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
		minVertex = i;
	   }
	  }
	   return minVertex;
	}

	
	public static void prims(int[][] adjMatrix) {
	int n = adjMatrix.length;
	boolean visited[] = new boolean[n];
	int parent[] = new int[n];
	int weight[] = new int[n];  // weight of each vertex
	// source - vertex 0
		parent[0] = -1;
		weight[0]=0;
		for (int i = 1; i < n; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < n; i++) {
			int minVertex = findMinVertex(visited,weight); //vertex with min weight !
			visited[minVertex] = true;
	
		// exlore neighbours of min vertex
		for (int j = 0; j < n; j++) {
       if(adjMatrix[minVertex][j] != 0 && !visited[j]) {
    	   if(weight[j] > adjMatrix[minVertex][j]) {
    		   // update values
    		   weight[j] = adjMatrix[minVertex][j];
    		   parent[j] = minVertex;
    	   }    
        } 
	   }
      }
	    // print mst
	      for(int i = 1; i < n; i++) {
	    	  if(i < parent[i]) {
	    	System.out.println(i + " " + parent[i] + " " + weight[i]);  
	      }else {
	    	  System.out.println(parent[i] + " " + i + " " + weight[i]);
	      }
	    	  
	}
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner s = new Scanner(System.in);
	      int n = s.nextInt();
	      int e = s.nextInt();
	      int adjMatrix[][] = new int[n][n];
	      for (int i = 0; i < e; i++) {
//	       for checking adj matrix  v 4 e 5 i/p 0 1 0 2 3 0 1 3 2 3
	    	int v1 = s.nextInt();
			int v2 = s.nextInt();
			int weight = s.nextInt();
			adjMatrix[v1][v2]  = weight;
			adjMatrix[v2][v1]  = weight;
		}
//	  i/p--> 5 7
//	  0 1 4 
//	  0 2 8
//	  1 2 2
//	  1 3 6
//	  2 3 3
//	  2 4 9
//	  3 4 5 
	    prims(adjMatrix); 
	      
	}
}
