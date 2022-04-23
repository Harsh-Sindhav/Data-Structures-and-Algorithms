package recursion;

public class CountZeroes {
public static int countZeroes(int n) {
	
	if(n<10) {
	
	if(n==0)return 0;
	else return 0;
	
	}
//	int count  = 0;
	int smallAns = countZeroes(n/10);
	if(n%10==0) smallAns+=1;
	return smallAns;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int n = 1002040;
    int x = countZeroes(n);
    System.out.println(x);
	}

}
