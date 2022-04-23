package graphs;

import java.util.Arrays;

public class ConnectingDots {

	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] visited;
	static int findCycle = 0;
	
	static void dfs(String[] board,int x,int y,int fromX,int fromY,char needColor,int n,int m) {
		if(x <  0 || x >=n || y < 0 || y >= m) return;
	
		if(board[x].charAt(y) != needColor) return;
		
		if(visited[x][y] == 1) {
			findCycle = 1;
			return;
		}
		visited[x][y] = 1;
		for(int f =0;f < 4;f++) {
			int nextX = x + dx[f];
			int nextY = y + dy[f];
			if(nextX == fromX && nextY == fromY) continue; // coz from every point it can move in 4 possible directions and one is possibly the pre one so in that case we can continue
			dfs(board,nextX,nextY,x,y,needColor,n,m);
		}
	}
	
	static int solve(String[] board,int n,int m) {
		visited = new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(visited[i],0);
		}
		
		for(int i=0;i<n;i++) {
		 for(int j=0;j<m;j++) {
			 if(visited[i][j] == 0)
				 dfs(board, i, j, -1, -1, board[i].charAt(j), n, m);
		 }	
		}
		
	return findCycle;	
	}
	
	
	
	public static void main(String[] args) {
	
		String[] board = {
				"AAAA",
				"ABCA",
				"AAAA"
		};
		
		int ans = solve(board, 3, 4);
//		  if (new Solution().solve(Graph,Graph.length,Graph[0].length())==1){
//	            System.out.print("true");
//	        }
//	        else{
//	            System.out.print("false");
//	        }

		
		  if (ans==1){
	            System.out.print("true");
	        }
	        else{
	            System.out.print("false");
	        }   
		  System.out.println();
		System.out.println(ans);
	}
}
