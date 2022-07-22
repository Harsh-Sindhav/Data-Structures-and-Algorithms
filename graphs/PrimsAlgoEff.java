package graphs;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Scanner;

class NodeP implements Comparator<NodeP>
{
    private int v;
    private int weight;
    
    NodeP(int _v, int _w) { v = _v; weight = _w; }
    
    NodeP() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }

    @Override
    public int compare(NodeP NodeP1, NodeP NodeP2) 
    { 
        if (NodeP1.weight < NodeP2.weight) 
            return -1; 
        if (NodeP1.weight > NodeP2.weight) 
            return 1; 
        return 0; 
    } 
}

public class PrimsAlgoEfficient {

	static void primsAlgo(ArrayList<ArrayList<NodeP>> adj, int N)
    {
        int key[] = new int[N];
        int parent[] = new int[N]; 
        boolean mstSet[] = new boolean[N]; 
        for(int i = 0;i<N;i++) {
        	key[i] = 100000000; 
        	mstSet[i] = false; 
        }

        PriorityQueue<NodeP> pq = new PriorityQueue<NodeP>(N, new NodeP());

        key[0] = 0;
        parent[0] = -1; 
        pq.add(new NodeP(key[0], 0)); 
		// Run the loop till all the NodePs have been visited
	    // because in the brute code we checked for mstSet[NodeP] == false while computing the minimum
	    // but here we simply take the minimal from the priority queue, so a lot of times a NodeP might be taken twice
	    // hence its better to keep running till all the NodePs have been taken. 
	    // try the following case: 
	    // Credits: Srejan Bera
	    // 6 7 
	    // 0 1 5 
	    // 0 2 10 
	    // 0 3 100 
	    // 1 3 50 
	    // 1 4 200
	    // 3 4 250
	    // 4 5 50 
        while(!pq.isEmpty()) {
        	int u = pq.poll().getV();
        	mstSet[u] = true;
        
        	for(NodeP it: adj.get(u)) {
        		if(mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
        			parent[it.getV()] = u; 
        			key[it.getV()] = it.getWeight(); 
        			pq.add(new NodeP(it.getV(), key[it.getV()]));
        		}
        	}
        }

        for(int i = 1;i<N;i++) {
        	System.out.println(parent[i] + " - " + i); 
        }
    }
	
	
	public static void main(String[] args) {
		int n = 5;
        ArrayList<ArrayList<NodeP> > adj = new ArrayList<ArrayList<NodeP> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<NodeP>());
			
		adj.get(0).add(new NodeP(1, 2));
		adj.get(1).add(new NodeP(0, 2));
		
		adj.get(1).add(new NodeP(2, 3));
		adj.get(2).add(new NodeP(1, 3));
		
		adj.get(0).add(new NodeP(3, 6));
		adj.get(3).add(new NodeP(0, 6));
		
		adj.get(1).add(new NodeP(3, 8));
		adj.get(3).add(new NodeP(1, 8));
		
		adj.get(1).add(new NodeP(4, 5));
		adj.get(4).add(new NodeP(1, 5));
		
		adj.get(2).add(new NodeP(4, 7));
		adj.get(4).add(new NodeP(2, 7));
		
	
		primsAlgo(adj, n); 
	}
	
}
