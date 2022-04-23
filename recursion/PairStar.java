package recursion;

public class PairStar {
public static String pairStar(String s) {
	if(s.length()<=1)return s;
	String ans = "";
	String small = s.substring(1);
	if(s.charAt(0)==small.charAt(0)) { 
		ans+=s.charAt(0);
		ans+='*';
	
	}
	else {ans+=s.charAt(0);}
	String smallAns= pairStar(s.substring(1));
	return ans + smallAns;
}

public static String addStars(String s) {

	if(s.length()<=1) {
		return s;
	}
	 
	String out = addStars(s.substring(1));
	if(s.charAt(0) == out.charAt(0)) {
		out = s.charAt(0) + "*" + out;
	}else {
		out = s.charAt(0) + out;
	}
	
	return out;
	
	
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String s = "hello";
//     String k = pairStar(s);
     String k = addStars(s);
     System.out.println(k);
		
		
	}

}
