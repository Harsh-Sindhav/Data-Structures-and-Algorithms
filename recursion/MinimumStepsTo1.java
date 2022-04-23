package recursion;

public class MinimumStepsTo1 {
public static int minStepsTo1(int n) {
		if(n == 1) {
			return 0;
		}
		
		
		int ans1,ans2=Integer.MAX_VALUE,ans3=Integer.MAX_VALUE;
		// in finding min the value of ans2, ans 3 is asking and we have not initialised the values so value of ans2, ans3 will be largest possible value bcoz we are taking min at the end so min of definite (as ans1 is definate) ans2 as infinity and ans 3 as infinity 
		 ans1 = minStepsTo1(n-1);
		
		if((n % 2) == 0) {
			ans2 = minStepsTo1(n/2);
		}
		if((n % 3) == 0) {
			 ans3 = minStepsTo1(n/3);
		}
		int myAns =Math.min(ans1, Math.min(ans2, ans3)) + 1;
		return myAns;
	
		
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int n =10;
     int x = minStepsTo1(n);
     System.out.println(x);
	}

}
