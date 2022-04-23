import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice {
   
	// Graphs
	
	public static void dfsTraversal(int[][] adjMat) {
	
	boolean visited[] = new boolean[adjMat.length];
	for(int i=0;i<adjMat.length;i++) {
		if(!visited[i]) {
			dfsTraversal(adjMat,i,visited);
	System.out.println();
		}
	}
		
			
	}
	
	private static void dfsTraversal(int[][] adjMat, int curr, boolean[] visited) {
         visited[curr] = true;
         System.out.println(curr);
         for(int i=0;i<adjMat.length;i++) {
        	 if(adjMat[curr][i] == 1 && !visited[i]) {
        		 dfsTraversal(adjMat,i,visited);
        	 }
         }
	}

   public static void bfstraversal(int[][] adjMat) {
	   
	   Queue<Integer> pendingVertices = new LinkedList<>();
	   boolean visited[] = new boolean[adjMat.length];
	   visited[0] = true;
	   pendingVertices.add(0);
	   while(!pendingVertices.isEmpty()) {
		   int curr = pendingVertices.poll();
		   System.out.print(curr + " ");
		   for(int i = 0;i<adjMat.length;i++) {
			   if(adjMat[curr][i] == 1 && !visited[i]) {
				   pendingVertices.add(i);
				   visited[i] = true;
			   }
		   }
	   }   
   }
	
   public static boolean bfs(int[][] adjMat,int sv,int ev,boolean[] visited) {
   	Queue<Integer> queue = new LinkedList<>();
   	
   	if(sv > adjMat.length-1 || ev > adjMat.length -1) return false;
   	
   	if(sv == ev) return true;
   	
   	queue.add(0);
   	visited[0] = true;
   	
   	while(!queue.isEmpty()) {
   		int curr = queue.poll();
   		for(int i=0;i<adjMat.length;i++) {
   		if(adjMat[curr][i] == 1 && !visited[i])
   			if(i == ev) return true;
   		else {
   			queue.add(i);
   		   visited[i] = true;
   		}
   		} 
   	}
   	  
   	return false;
     }
	
	
	public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int e = s.nextInt();
      int adjMat[][] = new int[n][n];
      
      for(int i = 0;i<e;i++) {
    	  int v1 = s.nextInt();
    	  int v2 = s.nextInt();
    	  adjMat[v1][v2] = 1;
    	  adjMat[v2][v1] = 1;
      }
      
      
      
		
		
	}
	
}
