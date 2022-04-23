package arrays2d;

public class MoreWith2DArrays {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//     int[][] arr = new int[3][5];  // arr of 3 rows 5 cols
//     System.out.println(arr[0][0]);
	 
       int[][] arr = new int[4][];   // arr with 4 rows having null stored in it bcoz we haven't initialsed the cols of it
//       System.out.println(arr);  // will give address of the arr that is the master array
//	for(int i = 0;i<arr.length;i++) {
//		System.out.println(arr[i]);  // null will be the o/p 4 times
//	}
//	System.out.println(arr[0][0]); //leads to null ptr exception
     
     
       // ways of intitialising an array
       
//       for(int i = 0; i < arr.length; i++ ) {
//    	   
//    	   arr[i] = new int[5];
//    	   
//       }
//       System.out.println(arr[0][1]);   // now the o/p will be 0 and not null coz we've initialsed the array
       
       // jagged array
       
       for(int i =0 ; i < arr.length ; i++) {
    	   
    	   arr[i] = new int[i+2];
    	   
       }
       
       // this is the way how to print the jagged array elements
       
       
       for(int i = 0;i< arr.length;i++ ) {
    	   
    	   for(int j = 0; j < arr[i].length ; j++) {
    		   
    		   System.out.print(arr[i][j] + " ");
    		   
    	   }
    	   
    	   System.out.println();
    	   
       }
            
       
     
       
       
       
       
	}

}
