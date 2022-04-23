package recursion;

public class SumOfNnaturalNos {
public static int sumOfNnaturalNos(int n) {
	if(n==1)return 1;
	int smallAns = sumOfNnaturalNos(n-1);
	return n+ smallAns;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int n =5;
     int x = sumOfNnaturalNos(n);
     System.out.println(x);
	}

}
