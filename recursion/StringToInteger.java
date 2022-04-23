package recursion;

public class StringToInteger {
	public static int strToInt(String s) {
//		if(s.length()==1) {
//			char a = s.charAt(0);
//			int b = a - '0';
//			return b;
//		}
//	         int smallAns = strToInt(s.substring(1));
//	         char c = s.charAt(0);
//		       int d = c - '0';
//		       d*=(int)Math.pow(10, s.length()-1);
//     
//       return  smallAns + d;
       
       
//       if(s.length() <= 1) return s.charAt(0)-'0';
//       int smallop = convertStringToInt(s.substring(1));
//       int first = (s.charAt(0)-'0')*(int)Math.pow(10,s.substring(1).length());
//       return first + smallop;

      if(s.length() == 1)return s.charAt(0)- '0';
      int smallop = strToInt(s.substring(0, s.length()-1));
      int lastDigit = s.charAt(s.length()-1)-'0';
      return smallop*10 + lastDigit;
       
	} 
	public static void main(String[] args) {
		String s = "1234";
		int b = strToInt(s);
		System.out.println(b);
	}

}
