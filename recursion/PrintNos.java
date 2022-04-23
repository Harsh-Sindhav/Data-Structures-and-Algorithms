package recursion;

public class PrintNos {
public static void print(int n){
	if(n==0) return;
    print(n-1);
    System.out.print(n + " ");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int n =6;
     print(n);
	}

}
