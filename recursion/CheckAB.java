package recursion;

public class CheckAB {
public static boolean checkAB(String s) {
	if(s.length()==0) {
		return true;
	}
	if(s.charAt(0) =='a') {
  if(s.substring(1).length() > 1 && s.substring(1,3).equals("bb")) {
	  return checkAB(s.substring(3));
  }else {
	  return checkAB(s.substring(1));
  }
  
	}	
	return false ;}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    String s = "aaabbab";
    System.out.println(checkAB(s));
	}

}
