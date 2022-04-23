package recursion;

public class GeometricSum {
public static double geometricSum(int k) {
	if(k ==0) return 1;
	return geometricSum(k-1) + 1/Math.pow(2, k);
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int k =5;
  double x = geometricSum(k);
  System.out.println(x);
	}

}
