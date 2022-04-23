package backtracking;

import java.util.Scanner;

public class SodukuSolver {
	
	private static boolean check(int[][] board,int row,int col,int val) {
		for(int k=0;k<9;k++) {
			if(board[row][k] == val)
				return false;
			if(board[k][col] == val)
				return false;
			
		}
		int rowFactor  = row - row%3;
		int colFactor = col - col%3;
		for(int c = 0;c<3;c++) {
			for(int d = 0;d<3;d++) {
				if(board[c+rowFactor][d+colFactor] == val) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean helper(int[][] board,int row,int col) {
		if(row ==9) {
			return true;
		}
		if(col ==9) {
			return helper(board,row+1,0);
		}
		if(board[row][col] != 0) {
			return helper(board, row, col+1);
		}
		for(int k=1;k<=9;k++) {
			if(check(board,row,col,k)) {
			board[row][col] = k;
			if(helper(board,row,col+1))
				return true;
		}
		board[row][col] = 0;
	}
	 return false;
	}
	
	public static boolean sudokuSolver(int[][] board) {
		return helper(board,0,0);
	}
	
	public static void main(String[] args) {
		int n=9;
		int arr[][] = new int[n][n];
		Scanner s = new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
       sudokuSolver(arr);
       
   	for(int i=0;i<arr.length;i++) {
		
		for(int j=0;j<arr[0].length;j++) {
//			arr[i][j] = s.nextInt();
			System.out.print(arr[i][j] + " ");
		}
      System.out.println();
   	}
   	s.close();
		
	}
}
