package arrays2d;
import java.util.*;
public class LargestColumnSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int arr[][] = new int[2][3];
   Scanner s = new Scanner(System.in);
   for (int i = 0; i < arr.length; i++) {
	for (int j = 0; j < arr[0].length; j++) {
		arr[i][j] = s.nextInt();
	}
}
   int rows = arr.length;
   
   int cols = arr[0].length-1;
   int max = Integer.MIN_VALUE;
   for(int i=0;i<cols;i++) {
	   int sum = 0;
	   for(int j=0;j<rows;j++) {
		   sum+=arr[i][j];
//		   System.out.print(sum+" ");
	   }
	   System.out.println();
	   if(sum>max) {
		   max = sum;
	   }
   }
   System.out.println(max);
	}
    
}
