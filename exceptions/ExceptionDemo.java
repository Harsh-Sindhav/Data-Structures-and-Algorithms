package exceptions;

public class ExceptionDemo {
	
	public static int factorial(int n) throws NegativeNumberException {
		
		if(n < 0) {
			throw new NegativeNumberException();
		}
		int ans = 1;
		for (int i = 2; i <= n; i++) {
			ans*=i;
		}
		return ans;
	}
	
public static int divide(int a, int b) throws DivideByZero {
	if(b == 0) {
		
		throw new ArithmeticException();
		//throw new DivideByZero();
	}
	return a/b;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
    try {
		divide(10,5);
//		System.out.println(factorial(2));
		System.out.println(factorial(-1));
		System.out.println("within try ");
		
		
	} catch (DivideByZero e) {
		// TODO Auto-generated catch block
		System.out.println("divide by zero exception raised");
//		e.printStackTrace();
	} catch (NegativeNumberException e) {
		// TODO Auto-generated catch block
		System.out.println("negative number exception");
		
//		e.printStackTrace();
	}catch(Exception e) {
		System.out.println("generic exception");
	}finally {
    System.out.println("Main");
	}
	}

}
