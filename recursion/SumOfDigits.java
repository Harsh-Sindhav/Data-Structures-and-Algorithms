package recursion;

public class SumOfDigits {
public static int sumOfDigits(int x) {
	if(x==0)return 0 ;
	int smallAns = sumOfDigits(x/10);
	return smallAns + (x%10);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int x = 12345;
    int n = sumOfDigits(x);
    System.out.println(n);
	}

}
