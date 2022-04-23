package recursion;

public class PrintKeypad {
public static void printKeypad(int n) {
	printKeypad(n,""); 
}
static int i = 1;
public static void printKeypad(int n,String outputSoFar) {
	if(n==0) {
		System.out.println(outputSoFar + " " + i++ );
	  return;
	}
	String[] options = keypad(n%10);
	
	
	for(int i=0;i<options.length;i++) {
		printKeypad(n/10, options[i] + outputSoFar);;
	}

//	printKeypad(n/10, options[0]+ outputSoFar  );
//	printKeypad(n/10,options[1]+outputSoFar  );
//	printKeypad(n/10,options[2]+ outputSoFar  );

} 
public static String[] keypad(int n) {


	if(n==0 || n==1) {
		String[] ans= {""};
		return ans;
	}

	else if(n==2) {
		String[] ans= {"a","b","c"};
		return ans;
	}
	else if(n==3) {
		String[] ans= {"d","e","f"};
		return ans;
	}
	else if(n==4) {
		String[] ans= {"g","h","i"};
		return ans;
	}
	else if(n==5) {
		String[] ans= {"j","k","l"};
		return ans;
	}
	else if(n==6) {
		String[] ans= {"m","n","o"};
		return ans;
	}
	else if(n==7) {
		String[] ans= {"p","q","r","s"};
		return ans;
	}
	else if(n==8) {
		String[] ans= {"t","u","v"};
		return ans;
	}
	else if(n==9) {
		String[] ans= {"w","x","y","z"};
		return ans;
	}
	return null;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int x = 234;
   printKeypad(x);
	}

}
