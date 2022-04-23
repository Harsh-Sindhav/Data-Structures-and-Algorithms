package strings;

public class PrintAllSubstring {

	public static void printAllSubstrings(String s) {
		int n = s.length();
		for(int i =0; i < n ;i++)
			for(int j = i+1 ; j <= n; j++)
				System.out.println(s.substring(i, j));	
	}

	public static void printAllSubstrings1(String s) {
		int n = s.length();
		for(int len =1;len<=n;len++) {
			for(int start = 0; start <= s.length()-len; start++) {
				int end = start + len -1;
				System.out.println(s.substring(start , end + 1)); // end +1 bcoz in substring fn the end index  is exclusive
			}
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s = "harsh";
    
      printAllSubstrings(s);
      System.out.println();
      printAllSubstrings1(s);
      System.out.println();    
      
	  }
    }
