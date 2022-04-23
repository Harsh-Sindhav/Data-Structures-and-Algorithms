package graphs;

import java.util.Scanner;

public class DijkstraAlgorithm {
	public static int findMinVertex(boolean[] visited, int[] weight) {
		// TODO Auto-generated method stub
	   int minVertex = -1;
	   for (int i = 0; i < visited.length; i++) {
		   if(!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
		minVertex = i;
	    }
	   }
	   return minVertex;
	}

	public static void dijkstra(int adjMAtrix[][]) {
	
		int n = adjMAtrix.length;
		boolean visited[] = new boolean[n];
		int distance[] = new int[n];
		distance[0] = 0;
		for (int i = 1; i < n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		for(int i = 0;i< n-1;i++) {
	   int minVertex = findMinVertex(visited,distance);
	   visited[minVertex] = true;
	
	   for(int j = 0; j < n; j++) {
		if(adjMAtrix[minVertex][j] > 0 && !visited[j] && adjMAtrix[minVertex][j] != Integer.MAX_VALUE) {
			// j is unvisited neighbor of minVertex
			// Calculate distance to reach j from source via minVertex
			int newDistance = distance[minVertex] + adjMAtrix[minVertex][j];
			if(newDistance < distance[j]) {
				distance[j] = newDistance;
			}
		}   
	   }
	   }
		
		for(int i = 0; i < n; i++) 
		{
			System.out.println(i + " " + distance[i]);
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
//		i/p-->	5 8
//			0 1 4
//			0 2 8
//			1 2 2
//			1 3 6
//			1 4 8
//			2 3 3 
//			2 4 5
//			3 4 7 
			
	}
	      dijkstra(adjMatrix);

}
	}
