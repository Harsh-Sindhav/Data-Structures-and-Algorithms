package recursion;

public class CalPower {

	public static int power(int x,int n) {
	if(x==0 && n ==0) return 1;
	if(x==0) return 0;
    if(n==0) return 1;
    return x*power(x, n-1);
}

	public static int powerBetter(int x,int n) {
	if(x==0 && n ==0) return 1;
	if(x==0) return 0;
    if(n==0) return 1;
    
    int smallAns = powerBetter(x, n/2);
    if(n % 2 == 0) {
    	return smallAns*smallAns;
    }else {
    	return x*smallAns*smallAns;
    }
     
}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int n=2;
   int p =3;
   int x = power(n, p);
   System.out.println(x);
	}

}
