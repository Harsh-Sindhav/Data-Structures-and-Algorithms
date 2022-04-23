package recursion;

public class NoOfDigits {
   public static int noOfDigits(int n) {

//	    int smallAns = count(n/10);
//        int count =0;
//        if(n%10 != 0) 
	   // error is that there can be zeroes in b/w the nos so this condition is incorrect and will lead to wrong ans 
//	   {
//            count++;
//        }
//
//return count + smallAns;
	   if(n==0) return 0;
	   int small = noOfDigits(n/10);
	   int ans = small + 1 ;
	   return ans;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int n =786655;
     int x = noOfDigits(n);
     System.out.println(x);
	}

}
