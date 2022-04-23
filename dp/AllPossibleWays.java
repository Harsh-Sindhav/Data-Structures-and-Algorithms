package dp;

public class AllPossibleWays {

	public static int getAllWaysHelper(int a,int b,int currNum,int currSum) {
	int result = 0;
	int p = (int)Math.pow(currNum, b);
	
	while(p + currSum < a) {
	result += getAllWaysHelper(a, b, currNum+1,p+currSum);
	currNum++;
	p = (int)Math.pow(currNum, b);
	}
	
	if(p+currSum ==a) {
		result++;
	}
	
	return result;
	}
	
	public static int getAllWays(int a,int b) {
		return getAllWaysHelper(a,b,1,0); 
	}
	
	
	public static int getAllWaysHelper2(int k,int a,int b) {
		int rest = (int)(a - Math.pow(k, b));
		if(rest == 0) {
			return 1;
		}else if(rest < 0) {
			return 0;
		}
		int r = 0;
		for(int i = k+1;i<a;i++) {
			r+= getAllWaysHelper2(i, rest, b);
		}
		return r;	
	}
	
	public static int getAllWays2(int a,int b) {
		int r = 0;
		for(int i=1;i<a;i++) {
			r += getAllWaysHelper2(i, a, b);
		}
	  return r;
	}
	
	public static void main(String[] args) {
		int a = 100,b=2;
//		int ans = getAllWays(a, b);
        int ans = getAllWays2(a, b);
		System.out.println(ans);
	}
}
