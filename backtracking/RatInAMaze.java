package backtracking;

public class RatInAMaze {
public static boolean ratInAMaze(int maze[][]) {
	int n = maze.length;
	int path[][] = new int[n][n];
	printAllPaths(maze, 0, 0, path);
	return solveMaze(maze,0,0,path); // 0,0 is a source
}
public static boolean solveMaze(int maze[][], int i,int j, int path[][]) {
	int n = maze.length;
	if(j < 0 || j >=n || i < 0 || i >=n || maze[i][j] == 0 || path[i][j] == 1) {
		return false;
	}
	path[i][j] = 1;
	if(i== n-1 && j == n-1)  {  // n-1,n-1 is a destination
		return true;
	}
	if(solveMaze(maze, i-1, j, path)) { // left
    return true;	
    }
	if(solveMaze(maze, i+1, j, path)) { // right
	    return true;	
	    }
	if(solveMaze(maze, i, j-1, path)) {  // top
	    return true;	
	    }
	if(solveMaze(maze, i, j+1, path)) {  // down
	    return true;	
	    }
	return false;
}

public static void printAllPaths(int maze[][], int i,int j, int path[][]) {
	int n = maze.length;
	if(j < 0 || j >=n || i < 0 || i >=n || maze[i][j] == 0 || path[i][j] == 1) {
		return;
	}
	path[i][j] = 1;
	if(i== n-1 && j == n-1) {
		for (int k = 0; k < path.length; k++) {
			for (int k2 = 0; k2 < path.length; k2++) {
				System.out.print(path[k][k2] +" ");  // we're printing the path that is path[k][k2] and not maze 
			}
			System.out.println();
		}
		System.out.println();
		path[i][j]=0;
		return;
	}
	printAllPaths(maze, i+1, j, path);
	printAllPaths(maze, i, j+1, path);
	printAllPaths(maze, i, j-1, path);
	printAllPaths(maze, i-1, j, path);
	path[i][j]=0;
	return;
}
	
	public static void main(String[] args) {
		int maze[][] = {{1,1,0},{1,1,0},{1,1,1}};
		boolean pathPossible = ratInAMaze(maze);
		System.out.println(pathPossible);
        int maze2[][] = {{1,1,0},{1,0,1},{0,1,1}};
        boolean pathPossible2 = ratInAMaze(maze2);
        System.out.println(pathPossible2);
	}

}
