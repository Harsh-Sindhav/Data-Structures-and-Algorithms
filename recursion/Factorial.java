package recursion;

public class Factorial {
public static int fact(int n) {
	if(n==0)return 1;
	int smallAns=fact(n-1);
	return smallAns*n;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n = 4;
      int x = fact(n);
      System.out.println(x);
	}

}
