package recursion;

public class StairCase {
	
   public static int stairCase(int n) {
	int x = stairCase(n,0);
	return x;
   }
   
    public static int stairCase(int n,int steps) {
	if(n<0) {
		return 0;
	}
	if(n==0) return 1; // coz see constraint n is from 1
	int a = stairCase(n-1, 1);
	int b = stairCase(n-2, 2);
	int c = stairCase(n-3, 3);
	
	return a+b+c;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int n = 4;
     int x = stairCase(n);
     System.out.println(x);
	}

}
