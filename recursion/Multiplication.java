package recursion;

public class Multiplication {
public static int multiplication(int x,int y) {
	if(y==0)return 0;
	int smallAns = multiplication(x, y-1);
	return smallAns+x;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int x =4;
  int y=0;
  int z = multiplication(x, y);
  System.out.println(z);
	}

}
