package arrays2d;

import java.util.Scanner;

public class FunctionWith2DArrays {

	public static void print2DArray(int[][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] takeInput(){
		Scanner s = new Scanner(System.in);
		System.out.println("enter no of rows");
		int rows = s.nextInt();
		System.out.println("enter no of cols");
		int cols = s.nextInt();
		int[][] arr = new int[rows][cols];
		for(int i =0 ;i < rows;i++) {
			for (int j=0;j<cols;j++) {
				
				System.out.println("enter the element at " + i + " row" + j + "col");
				
				arr[i][j] = s.nextInt();
				
			}
			
			
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {

		
		
	}

}
