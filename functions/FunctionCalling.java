package functions;

public class FunctionCalling {

	public static int sum(int a,int b) {
		int result = a+b;
		return result;
	}
	
	public static void increment(int n) {
		n++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

   int n = 10;
   increment(n);
		System.out.println(n);
		
//		int a = 10;
//		int b = 5;
//		int result = sum(a,b);
//		System.out.println(result);
		
		
	}

}
