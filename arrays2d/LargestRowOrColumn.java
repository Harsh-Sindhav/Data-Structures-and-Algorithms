package arrays2d;
import java.util.*;
public class LargestRowOrColumn {
   public static void takeInput(int arr[][]) {
	   Scanner s = new Scanner(System.in);
	  System.out.println("rows");
	   int rows = arr.length;
	   System.out.println("cols");
	   int cols = arr[0].length;
	   for(int i=0;i<rows;i++) {
		   for (int j = 0; j < cols; j++) {
			System.out.println("enter"+ i +"row"+ j +"col");
			arr[i][j]=s.nextInt();
			
		}
	   }
	   for (int i = 0; i < arr.length; i++) {
		for(int j=0;j<arr[0].length;j++) {
			System.out.print(arr[i][j]);
		}
		System.out.println();
	}
	  
   }
   public static int maxSumCol_row(int arr[][]){
	   int max = Integer.MIN_VALUE;
	   boolean isCol = true;
	   
	   int Index = Integer.MIN_VALUE;
	   for(int i=0;i<arr[0].length;i++) {
		   int Colsum=0;
		   for(int j=0;j<arr.length;j++) {
			   Colsum+=arr[i][j];
		   }
		   if(Colsum>max) {
			   max=Colsum;
			   Index=i;
		   }
	   }
//	   int maxRow = Integer.MIN_VALUE;
//	   int maxRowIndex = Integer.MIN_VALUE;
	   for(int i=0;i<arr.length;i++) {
		   int sum=0;
		   for(int j=0;j<arr[0].length;j++) {
			   sum+=arr[i][j];
		   }
		   if(sum>max) {
			   isCol=false;
			   max=sum;
			   Index=i;
		   }
	   }
	   if(isCol) {
		   System.out.println("col");
	   }else System.out.println("row");
	   return Index;
	  
   }
//   public static int maxSumRow(int arr[][]){
//	   int maxRow = Integer.MIN_VALUE;
//	   int maxRowIndex = Integer.MIN_VALUE;
//	   for(int i=0;i<arr.length;i++) {
//		   int sum=0;
//		   for(int j=0;j<arr[0].length;j++) {
//			   sum+=arr[i][j];
//		   }
//		   if(sum>maxRow) {
//			   maxRow=sum;
//			   maxRowIndex=i;
//		   }
//	   }
//	   return maxRowIndex;
//   }
   
//   public static int maxRowOrCOl(int arr[][]) {
//	   int maxRow = maxSumRow(arr);
//	   int maxCol = maxSumCol(arr);
//	   if(maxRow>maxCol) { 
//		   System.out.println("row");
//		   return maxRow;
//	   }
//	   else {
//		   System.out.println("col");
//		   return maxCol;}
//   }
//  
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
      System.out.println("enter rows");
      
      int rows = sc.nextInt();
      int cols = sc.nextInt();
   	  int arr[][] = new int[rows][cols];
   	   takeInput(arr);
   	   int max = maxSumCol_row(arr);
   	   System.out.println(max);
	  
	
	}

}
