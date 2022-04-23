package graphs;
//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Graph
{
    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    int V;
    ArrayList<ArrayList<Integer>> adjListArray;
 
    // constructor
    Graph(int V)
    {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new ArrayList<>();
 
        // Create a new list for each vertex
        // such that adjacent nodes can be stored
 
        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
    }
 
    // Adds an edge to an undirected graph
    void addEdge(int v1, int v2)
    {
        // Add an edge from src to dest.
        adjListArray.get(v1).add(v2);
 
        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray.get(v2).add(v1);
    }
    
}
public class AllConnectedComponents {
	 public static void DFSUtil(int v, boolean[] visited, Graph g,ArrayList<Integer> smallop)
	    {
	        // Mark the current node as visited and print it
	        visited[v] = true;
//	        System.out.print(v + " ");
	        smallop.add(v);
	        // Recur for all the vertices
	        // adjacent to this vertex
	        for (int x : g.adjListArray.get(v) ) {
	            if (!visited[x])
	                DFSUtil(x, visited,g,smallop);
	        }
	    }
	 public static ArrayList<ArrayList<Integer>> connectedComponents(Graph g, int V)
	    {
	        // Mark all the vertices as not visited
	      ArrayList<ArrayList<Integer>> op = new ArrayList<>();
	      boolean[] visited = new boolean[V];
	        for (int v = 0; v < V; ++v) {
	            if (!visited[v]) {
	                // print all reachable vertices
	                // from v
	            	ArrayList<Integer> smallop = new ArrayList<Integer>();
	                DFSUtil(v, visited,g,smallop);
//	                System.out.println();
	                op.add(smallop);
	            }
	        }
	    return op;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(
	            9); // 5 vertices numbered from 0 to 4
	 
	        g.addEdge(0, 8);
//	        g.addEdge(0, 8);
	        g.addEdge(1, 6);
	        g.addEdge(1, 7);
	        g.addEdge(1, 8);
	        g.addEdge(5, 8);
	        g.addEdge(6, 0);
	        g.addEdge(7, 3);
	        g.addEdge(7, 4);
	        g.addEdge(8, 7);
	        g.addEdge(2, 5);
	     
	        System.out.println(
	            "Following are connected components");
	        ArrayList<ArrayList<Integer>> ans = connectedComponents(g,9);
//	        Collections.sort(ans);
	        for(int i=0;i<ans.size();i++) {
	        	ArrayList<Integer> component = ans.get(i);
//	        	Collections.sort(component);
	        	for(int k=0;k<component.size();k++) {
	        		System.out.print(component.get(k) + " ");
	        	}
	        	System.out.println();
	        }
	           
	}

}
