package recursion;

public class FibonacciNo {
public static int fibonacciNo(int n) {
	if(n==0 || n==1) return n;
	 int smallAns = fibonacciNo(n-1)+fibonacciNo(n-2);
	 return smallAns;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int n = 6;
    int x = fibonacciNo(n);
    System.out.println(x);
	}

}
