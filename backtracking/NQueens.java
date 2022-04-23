package backtracking;
public class NQueens {
public static void placeNQueens(int n) {
	int board[][] = new int[n][n];
	placeQueens(board,0);
}
private static void placeQueens(int board[][],int row) {
	int n = board.length;
	if(row ==n) {  // prints all possible positions
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
		System.out.println();
		}
		System.out.println();
	}
    for (int cols = 0; cols < board.length; cols++) {
		if(isItsafePlaceForTheQueen(board, row, cols)){
			board[row][cols] = 1;
			placeQueens(board, row + 1);
			board[row][cols]=0;
		}
	}
}


public static boolean isItsafePlaceForTheQueen(int board[][],int row,int cols) {
	// check if 1 is present on top left diagonal
	for(int i = row -1,j = cols-1;i >=0 && j>=0; i--,j--) {
		if (board[i][j] ==1) {
			return false;
		}
	}
	// check if 1 is present on bottom right diagonal  
	for(int i = row +1,j = cols+1;i < board.length && j <board.length;i++,j++) {
		if (board[i][j] ==1) {
			return false;
		}
	}
	// check if 1 is present on top right diagonal 
		for(int i = row -1,j = cols+1;i>=0 && j<board.length;i--,j++) {
			if (board[i][j] ==1) {
				return false;
			}
		}

		// check if 1 is present on bottom left diagonal
		for(int i = row + 1,j = cols-1;i<board.length && j>=0;i++,j--) {
			if (board[i][j] ==1) {
				return false;
			}
		}
		
		// check if 1 is present on top  
		for(int i = row -1; i >= 0; i--) {
			if (board[i][cols] ==1) {
				return false;
			}
		}
		
		// check if 1 is present on bottom
		for(int i = row + 1; i < 0; i++) {
			if (board[i][cols] ==1) {
				return false;
			}
		}
			
		return true;
		
}



public static void main(String[] args) {
		// TODO Auto-generated method stub
    placeNQueens(4);
	}

}
