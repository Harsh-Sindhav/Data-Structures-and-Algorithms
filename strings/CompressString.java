package strings;

public class CompressString {
public static String compressString(String str) {
    if(str.length()==0)return str;  
	String s ="";
      s+=str.charAt(0);
      int count =1;
      for(int i=1;i<str.length();i++) { 
    	  if(str.charAt(i)==str.charAt(i-1)) {
    		  count++;
    		  
    	  }else {
    		if(count>1) {
    			s+=count;
    			count=1;
    		}
    		s+=str.charAt(i);
    	  }
      }
      if(count>1) {
			s+=count;
		}
//		s+=str.charAt(i);
	  return s;   
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="zbfehsssss";
//		char x= 'a';
		 String z= compressString(s);
			System.out.println(z);
	}

}
