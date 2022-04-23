package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class Graphs {

	public static void dfstraversal(int adjMatrix[][]) {
		boolean visited[] = new boolean[adjMatrix.length];
//		dfstraversal(adjMatrix,0 /*i*/,visited); // for connected component
		for (int i = 0; i < adjMatrix.length; i++) {
			
			if(!visited[i]) {
			
			dfstraversal(adjMatrix,i,visited);  // for disconnected component
		System.out.println();
			}
		}
		
	} 
	
	public static void dfstraversal(int[][] adjMatrix, int currIndex,boolean visited[]) {
		// TODO Auto-generated method stub
		visited[currIndex] = true;
		System.out.print(currIndex + " ");
		for (int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[currIndex][i] == 1 && visited[i]==false) {
				dfstraversal(adjMatrix, i,visited);
			}
		}
		
	}
	
	public static void bfTraversal(int adjMatrix[][]) {
		Queue<Integer> pendingVertices = new LinkedList<>();
		boolean visited[] = new boolean[adjMatrix.length];
		visited[0] = true;
		pendingVertices.add(0);
		while(!pendingVertices.isEmpty()) {
			int currentVertex = pendingVertices.poll();
			System.out.print(currentVertex + " ");
			for (int i = 0; i < adjMatrix.length; i++) {
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					pendingVertices.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static boolean BFS(int[][] adjMatrix,int sv,int ev,boolean[] visited) {
		
		if(sv > (adjMatrix.length-1) || ev > (adjMatrix.length - 1)){
			return false;
		}
		
		if(adjMatrix[sv][ev] == 1) {
			return true;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[sv] = true;
		queue.add(sv);
		while(!queue.isEmpty()) {
			int front = queue.poll();
			for (int i = 0; i < adjMatrix.length; i++) {
				if(adjMatrix[front][i] == 1 && !visited[i]) {
					if(i == ev) return true;
					else {
						visited[i] = true;
						queue.add(i);
					}
				}
			}
		}
		
		return false;
	}
	
	
	public static boolean hasPath(int[][] adjMatrix, int sv,int ev) {
		boolean[] visited = new boolean[adjMatrix.length];
		return BFS(adjMatrix,sv,ev,visited);
		
	}
	
	
	
	public static ArrayList<Integer> getPathHelper(int[][] adjMatrix, int n, int sv, int ev,boolean[] visited){
		if(sv == ev) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		output.add(ev);
		return output;
		}
		
		visited[sv] = true;
		
		for (int i = 0; i < n; i++) {
			if(adjMatrix[sv][i] == 1 && !visited[i]) {
				ArrayList<Integer> smallOutput = getPathHelper(adjMatrix, n, i, ev, visited);
				if(smallOutput != null) {
					smallOutput.add(sv);
					return smallOutput;
				}
			}
		}
		
		return null;
	}
	
	
	public static ArrayList<Integer> getPath(int[][] adjMatrix, int n, int sv, int ev){
	// n is no of vertices
	boolean[] visited = new boolean[n];
//	for (int i = 0; i < n; i++) {
//		visited[i] = false;
//	}
	      // getPathDFS
		return getPathHelper(adjMatrix, n, sv, ev, visited);
		
	}
	
//	public static ArrayList<Integer> getPathBfs(int[][] adjMatrix,int n, int sv,int ev){
//		Queue<Integer> bfsQ = new LinkedList<Integer>();
//		boolean[] visited = new boolean[n];
//
//		boolean done = false;
//		if((sv > adjMatrix.length-1) || ev > (adjMatrix.length -1)) {
//		
//			return null;
//		}
//		
//		if(adjMatrix[sv][ev] == 1 && sv == ev) {
// 			ArrayList<Integer> ans = new ArrayList<Integer>();
// 			ans.add(sv);
// 			return ans;
//			
//			
//		}
//		
//		for(int i = 0;i < n; i++) {
//			visited[i] = false;
//		}
//		bfsQ.add(sv);
//		visited[sv] = true;
//
//		
//		
//		
//		Map<Integer,Integer> parent = new HashMap<>();
//		while(!bfsQ.isEmpty() && !done) {
//			int front = bfsQ.remove();
//			for (int i = 0; i < n; i++) {
//				if(adjMatrix[front][i] == 1 && !visited[i]) {
//					parent.put(i, front);
//					bfsQ.add(i);
//					visited[i] = true;
//					if(i == ev) {
//						done = true;
//						break;
//					}
//				}
//			}
//		}
//	
//		if(!done) {
//		return null;
//		}else {
//			ArrayList<Integer> output = new ArrayList<Integer>();
//			int current = ev;
//			output.add(ev);
//			while(current != sv) {
//				current = parent.get(current);
//				output.add(current);
//			}
//			return output;
//		}
		 
//		ArrayList<Integer> ans = new ArrayList<>();
//		ans.add(ev);
//		int value = parent.get(ev);
//		while(value != sv) {
//			ans.add(value);
//			value = parent.get(value);
//		}
//			ans.add(value);
//			return ans;
//		}			
//	}
	
	
	
	
	
	public static ArrayList<Integer> getPathBFS(int adjMatrix[][],int s ,int e){
		Queue<Integer> pendingVertices = new LinkedList<Integer>() ;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				// hashmap stores child as key and parent as value !
		boolean visited[] = new boolean[adjMatrix.length];
		visited[s] = true;
		pendingVertices.add(s);
		map.put(s,-1);
		boolean pathFound = false;
		while(!pendingVertices.isEmpty()) {
			int currentVertex = pendingVertices.poll();
			for(int i =0;i< adjMatrix.length;i++) {
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					pendingVertices.add(i);
					visited[i] = true;
					map.put(i , currentVertex);
					if(i == e) {
					 	pathFound = true;
					 	break;
					}
				}
			}
		}
		// pathFound roles comes into play here !
		if(pathFound) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			int currentVertex = e; 
		while(currentVertex != -1) {
			path.add(currentVertex);
			int parent = map.get(currentVertex);
			currentVertex = parent;
		}
		return path;
		}else {
			return null;
		}
		
	}
	
	public static void DFS(int[][] adjMatrix,int sv,boolean[] visited) {
		visited[sv] = true;
		for (int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[sv][i] == 1 && !visited[i]) {
				DFS(adjMatrix, i, visited);
				visited[i] = true;
			}
		}
	}
	
	public static boolean isConnected(int[][] adjMatrix) {
		// this fn doesnt define the graph is a complete graph 
		boolean[] visited = new boolean[adjMatrix.length];
		DFS(adjMatrix,0,visited);
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i])return false;
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();  // n is no of vertices
      int e = s.nextInt();
      int adjMatrix[][] = new int[n][n];
      for (int i = 0; i < e; i++) {
//       for checking adj matrix  v 4 e 5 i/p 0 1 0 2 3 0 1 3 2 3
    	int v1 = s.nextInt();
		int v2 = s.nextInt();
		adjMatrix[v1][v2]  =1;
		adjMatrix[v2][v1]  =1;
	}

     // getPath 
//      int sv,ev;
//      sv = s.nextInt();
//      ev = s.nextInt();
      // getPath i/p --> 4 4 0 1 0 2 1 2 2 3 0 3
//      ArrayList<Integer> output = getPath(adjMatrix, n, sv, ev);
//      if(output != null) {
//    	  System.out.print("path ");
//    	  for (Integer i : output) {
//			System.out.print("--> " + i);
//		} 	  
//      }
      //getPathBfs i/p --> 4 4 0 1 0 2 1 2 2 3 0 3 0 3 
//      ArrayList<Integer> output = getPathBfs(adjMatrix,n, sv, ev);
//     for(Integer i:output) {
//    	 System.out.print(i + " ");
//     }
     
      
//     dfs i/p -->  4 3 0 1 0 3 1 2 dfs diconnected graph i/p 6 5 0 1 0 2 1 3 2 3 4 5 
      dfstraversal(adjMatrix);
//      bfTraversal(adjMatrix); // it will print only connected components of a graph and will not print disconnected component
//    dfs i/p  -->  5 4 0 2 0 3 2 1 3 4
//     for (int i = 0; i < n; i++) {
//		for (int j = 0; j < n; j++) {
//			System.out.print(adjMatrix[i][j] + " ");
//		}
//	System.out.println();
//     } 
	}
}
