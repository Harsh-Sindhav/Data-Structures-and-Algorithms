import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class node{
	
	public node(){
		
	}
}

public class JustForCheckingSmallThings {

	 public static String replacePi(String str) {
		 if(str.length() <= 1) {
			 return str;
		 }
		 
		 String smallAns= replacePi(str.substring(1));
		 
		 if(str.charAt(0)=='p' && smallAns.charAt(0)=='i') {
			 return "3.14"+smallAns.substring(1);
		 }
		 return str.charAt(0) + smallAns;
		 }
		 
	 
	 public static void printNosR(int n) {
		 
		 if(n<1) return;
		 printNosR(n-1);
		System.out.println(n + " ");
		
		 
	 }
	 
	 public static int fibbRdp(int n,int[] dp) {
	    if(n==0||n==1) return n;
	    int ans1,ans2;
	    if(dp[n-1] == -1) {
	    	ans1 = fibbRdp(n-1, dp);
	    	dp[n-1] = ans1;
	    }else {
	       ans1 = dp[n-1];
	    }
	    
	    if(dp[n-2] == -1) {
	    	ans2 = fibbRdp(n-2, dp);
	    	dp[n-2] = ans2;
	    }else {
	    	ans2 = dp[n-2];
	    }
	    
		 return ans1 + ans2;
	 }
	 
	 public static int fibbidp(int n) {
		 if(n==0 || n==1) return n;
		 
		 int[] dp = new int[n+1];
		 dp[0] = 0;
		 dp[1] = 1;
		 for(int i=2;i<dp.length;i++) {
			 dp[i] = dp[i-1]+dp[i-2];
		 }
		 
	 return dp[n]; 
	 }
	 
	 
	 
	 
	 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int n = 3,m=4;
		int[][] visited = new int[n][m];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(visited[i],0);
		}
		
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	
		
		
		
//		int[][] arr = new int[1][0];
//		arr[0] = new int[1];
//		System.out.println(arr[0][0]);
		
		
//        int n = 4;
//		int[] dp = new int[n+1];
//	    for(int i=0;i<dp.length;i++) {
//	    	dp[i] = -1;
//	    }		
		
//        String x = "harsh";
//        System.out.println(x.length());
//        String h = x.substring(0, x.length()-1); // print hars and not harsh coz last index is exclusive
//        System.out.println(h);
		
//		String s = "x";
//		System.out.println(s.substring(0, 1));	
		
//		int x = Integer.MIN_VALUE;
//		System.out.println(x);
////		int a[] = {6,1,2,3,4,5,7,3,4,2};
////		x+=a[7];
//        int y = Integer.MIN_VALUE;	
//		System.out.println(y);
		
		
//		String s = "x";
//		System.out.println(s.substring(1).length());
		
		
		
//		String s = null;
//		System.out.println(s.length()); // returns null ptr exception
		
		
//		node s[] = new node[26];
//		for(int i=0;i<s.length;i++) {
//			System.out.println(s[i]); // will print null coz non primitive data types stores null as its def value
//		}
		
		
		
		
//		boolean s =false;
//		if(!s) { // if statement will only print if the condition given in the bracket is true and as the condition here is false (coz we've initialised s as false) and the !s(false) is true coz if statement is checking if false is there or not and false is there so it is printing false !!   
//			System.out.println(s);
//		}
		
		
   	   
//		Queue<Integer> q = new LinkedList<>();
//		System.out.println(q.peek()); // by def null is stored in queue
//		System.out.println(q.isEmpty()); // returns true
		
		
//		char a ='0';
//		int c = (int)a;
//		System.out.println(c);
		
		
//		String s = "";
//		System.out.println(s.length());
		
//		char c = 'a';
//		
//		int d = c;
//		System.out.println(d);// ascii value of  a is 97 !!
		
		
//		int n = 7;
//		printNosR(n);
		
		
//		int arr[][] = new int[0][0];
//		System.out.println(arr[0][0]);
		
		
//		int count = 0;
////		count++;
//		System.out.println(count++);
		
//		int arr[] = new int[0];
//		for(int i : arr) {
//			System.out.println(i);
//		}
		
		
//		Scanner s = new Scanner(System.in);
//		int i = s.nextInt();
////		s.nextLine();
////		String str = s.nextLine();
////		System.out.println(str + " " + str.length());
//		s.nextLine();
//		int j = s.nextInt();
//		System.out.println(i +" " + j);
		
		
//		String s = "naman";
//		
//
//		String r = "";
//		for (int i = 0; i < s.length(); i++) {
//			r += s.charAt(i) + r ;
//		}
//		System.out.println(r);
//		boolean checkPallindrome = true;
		
//			if(s.compareTo(r) == 0) {
//			return	checkPallindrome = true;
//			   
//		}
		
//		for(int i = 0; i < s.length(); i++) {
//			
//			if(s.charAt(i) != r.charAt(i)) {
//				System.out.println(s.charAt(i) + " " + r.charAt(i));
//				 checkPallindrome = false;
//				
//			}	
//	     }
	
	
		// your code goes here
//				Scanner s = new Scanner(System.in);
//				int t = s.nextInt();
//				for(int i = 0;i<t;i++){
//				    String str = s.nextLine();
//				    String ans = replacePi(str);
//				    System.out.println(ans);
//				    }
	
	
	}
}
