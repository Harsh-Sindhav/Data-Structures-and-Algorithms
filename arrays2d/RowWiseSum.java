package arrays2d;

public class RowWiseSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int[][]arr = {{1,3,2,4,5},
  {1,2,3,4,5},
  {1,2,3,4,5},
  {1,2,3,4,5}};
  int rows =4;
  int columns = 5;
  
  for (int i = 0; i < rows; i++) {
	  int sum = 0;
	for (int j = 0; j <  columns; j++) {
		sum+=arr[i][j];
		
	}
	System.out.print(sum + " ");
}
	}

}
