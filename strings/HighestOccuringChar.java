package strings;


public class HighestOccuringChar {
	
	public static char highestOccur(String s) {
		int max = Integer.MIN_VALUE;
		char maxOccur = 0;
       for(int i =0; i<s.length();i++) {
    	   int count =0;
    	   char c = s.charAt(i);
    	   for(int j =0;j<s.length();j++) {
    		   if(s.charAt(j) == c) {
    			   count++;
    		   }   
    	   }
    	   if(count > max) {
    		   max = count;
    		   maxOccur = c;
    	   }
       }
       
		return maxOccur;
	}
	
	
public static char highestOccurBetter(String s) {
	int freq[]=new int[128];
	for(int i=0;i<s.length();i++){
		int ascii_val=s.charAt(i);
		freq[ascii_val]++;
	}
	int max = Integer.MIN_VALUE;
	int maxIndex = Integer.MIN_VALUE;
	for (int i = 0; i < freq.length; i++) {
		if(freq[i]>max) {
			max = freq[i];
			maxIndex=i;
		}
	}
	char x = (char)maxIndex;
	return x;
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="zbfehsbvaaajjjj";
//		char x= 'a';
		 char z= highestOccur(s);
			System.out.println(z);
	}

}
