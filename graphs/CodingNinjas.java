package graphs;

public class CodingNinjas {

	static int[][] a = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	static String pattern = "CODINGNINJA";
	static int[][] used;
	
	static int validPoint(int x,int y,int N,int M) {
		if(x>=0 && x<N && y>=0 && y < M) 
			return 1;
		return 0;
	}
	
	static int DFS(String[] G, int x,int y,int index,int N,int M) {
		if(index == 11){
			return 1;
		}
		used[x][y] = 1;
		int i,newx,newy;
		int found = 0;
		for(i=0;i<8;i++) {
			newx = x + a[i][0];  // 0 means x position
			newy = y + a[i][1]; // 1 means y position
			
			if(validPoint(newx,newy,N,M)==1 && G[newx].charAt(newy) == pattern.charAt(index) && used[newx][newy] == 0) {
				found = found | DFS(G, newx, newy, index+1, N, M);
			}	
		}
	
		used[x][y] = 0;
		
		return found;
	}
	
	static int solve(String[] Graph,int N,int M) {
	int i,j,found = 0;
	used = new int[N][M];
	
	for(i=0;i<N;i++) {
		for(j=0,found =0;j<M;j++) {
			if(Graph[i].charAt(j) == 'C') {
				found = DFS(Graph, i, j, 1, N, M);
				if(found == 1) break;
			}
		}
		if(found == 1) break; // here bcoz to break the outer for loop
	}
		
	return found;	
	}
	
	
	
	public static void main(String[] args) {
		String Graph[] ={"CXDXNXNXNXA",
		                 "XOXIXGXIXJX"};
	    int  ans = solve(Graph, 2, 11);
	    System.out.println(ans);
	
	
	}
	
}
