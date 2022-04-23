package graphs;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int weight;
	Edge(int v1,int v2,int weight){
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	
	@Override
	public int compareTo(Edge o) {
	return this.weight - o.weight;
	}

}



public class KruskalAlgorithm {
	
	public static int findParent(int v,int parent[]) {
		if(v == parent[v]) {
			return v;
		}
		return findParent(parent[v], parent);
	}
	
	
	
	
	public static Edge[] kruskalAlgorithm(Edge[] edges, int n) {
		
	Arrays.sort(edges);
	Edge mst[] = new Edge[n - 1]; // n-1 bcoz mst !!
	
	int parent[] = new int[n];
	for (int j = 0; j < parent.length; j++) {
		parent[j]=j;
	}
	
	
	int count = 0,i = 0;  // count if for counting no of edges as we reach n-2 we achieved mst and will break the loop !
	while(count != n-1) // why n-1 bcoz array size for mst is n-1 and index will be from 0 to n-2
	{
		Edge currentEdge = edges[i++];
		// union find algo
	    int v1Parent = findParent(currentEdge.v1,parent);
	    int v2Parent = findParent(currentEdge.v2,parent);
	if(v1Parent != v2Parent) {
		mst[count] = currentEdge;
		count++;
		parent[v1Parent] = v2Parent;
	      }
	 	}
	return mst;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int e = s.nextInt();
      
      Edge edges[] = new Edge[e];
      for (int i = 0; i < edges.length; i++) {
    	int v1 = s.nextInt();
    	int v2 = s.nextInt();
    	int weight = s.nextInt();
   Edge edge = new Edge(v1, v2, weight);
	edges[i] = edge;
      
      }
     Edge mst[] = kruskalAlgorithm(edges , n); 
//     i/p 6 11
//     0 1 1
//     0 2 5
//     0 3 4
//     1 3 3 
//     1 2 6
//     2 3 10
//     2 4 8
//       2 5 9
//     3 5 6
//     3 4 7
//     4 5 2
     for (int i = 0; i < mst.length; i++) {
		if(mst[i].v1 < mst[i].v2) {
			System.out.println(mst[i].v1 +" "+ mst[i].v2 + " " + mst[i].weight);
		}else {
			System.out.println(mst[i].v2 +" "+ mst[i].v1 + " " + mst[i].weight);

		}
	}
     s.close();
	}

	
}
