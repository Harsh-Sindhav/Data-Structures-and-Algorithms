package backtracking;
import java.util.*;

import java.io.*;

public class CrossWord {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static void solve(char[][] crossword, String[] words, int vidx) {
		// TODO Auto-generated method stub
		if(vidx == words.length) {
			print(crossword);
			return;
		}
		
		for(int r=0;r<10;r++) {
			for(int c=0;c<10;c++) {
				if(crossword[r][c] == '-' || crossword[r][c] == words[vidx].charAt(0)) {
					// try vertical 
					if(isValidVertical(crossword,r,c,words[vidx]) == true) {
						boolean[] resetHelper = new boolean[words[vidx].length()];
						setVertically(crossword,r,c,words[vidx],resetHelper);
						solve(crossword,words,vidx+1);
						resetVertically(crossword,r,c,words[vidx],resetHelper);
					}
				
			
			 if(isValidHorizontal(crossword,r,c,words[vidx]) == true) {
				 boolean[] resetHelper = new boolean[words[vidx].length()];
				 setHorizontally(crossword,r,c,words[vidx],resetHelper);
				 solve(crossword, words, vidx+1);
				 resetHorizontally(crossword,r,c,words[vidx],resetHelper);
			 }
			}
		  }
		}
	  }
	

	private static void resetHorizontally(char[][] crossword, int r, int c, String word, boolean[] resetHelper) {
		// TODO Auto-generated method stub
		for(int cdash = c;cdash<c+word.length();cdash++) {
			if(resetHelper[cdash-c] == true)
			crossword[r][cdash] = '-';
		}
	}



	private static void setHorizontally(char[][] crossword, int r, int c, String word, boolean[] resetHelper) {
		// TODO Auto-generated method stub
		 for(int cdash = c;cdash<c+word.length();cdash++) {
			  resetHelper[cdash - c] = crossword[r][cdash] == '-';
			  crossword[r][cdash] = word.charAt(cdash - c);
		  }	
	}

	private static boolean isValidHorizontal(char[][] crossword, int r, int c, String word) {
		// TODO Auto-generated method stub
		for(int cdash = c;cdash<c + word.length();cdash++) {
			if(cdash == 10) {
				return false;
			} else if(crossword[r][cdash] == '+') {
				return false;
			}	else if(crossword[r][cdash] != '-') {
				if(crossword[r][cdash] != word.charAt(cdash - c)) {
					return false;
				}
			}
		}
			return true;
		
	}


	private static void resetVertically(char[][] crossword, int r, int c, String word, boolean[] resetHelper) {
		// TODO Auto-generated method stub
		for(int rdash = r;rdash<r+word.length();rdash++) {
			if(resetHelper[rdash-r] == true)
			crossword[rdash][c] = '-';
		}
	}

	private static void setVertically(char[][] crossword, int r, int c, String word, boolean[] resetHelper) {
		// TODO Auto-generated method stub
	 
	  for(int rdash = r;rdash<r+word.length();rdash++) {
		  resetHelper[rdash - r] = crossword[rdash][c] == '-';
		  crossword[rdash][c] = word.charAt(rdash - r);
	  }		
	}
	

	private static boolean isValidVertical(char[][] crossword, int r, int c, String word) {
		// TODO Auto-generated method stub
		
		for(int rdash = r;rdash<r + word.length();rdash++) {
		if(rdash == 10) {
			return false;
		} else if(crossword[rdash][c] == '+') {
			return false;
		}	else if(crossword[rdash][c] != '-') {
			if(crossword[rdash][c] != word.charAt(rdash - r)) {
				return false;
			}
		}
	}
		return true;
	}

	private static void print(char[][] crossword) {
		// TODO Auto-generated method stub
 
		for(int i=0;i<crossword.length;i++) {
			for(int j=0;j<crossword.length;j++) {
			  System.out.print(crossword[i][j] + " ");
			}
			System.out.println();
		}
	}

	
	
	public static void main(String[] args) throws IOException, NumberFormatException {
	
		char[][] crossword = new char[10][10];
//		Scanner s = new Scanner(System.in);
		for(int i=0;i<crossword.length;i++) {
//			for(int j=0;j<10;j++) {
//				crossword[i][j] = s.next().charAt(0); // see how to take i/p of char in arr
//			}
	
		   crossword[i] = br.readLine().toCharArray();
		
		}
		String[] words =   br.readLine().split(";");          // {"CALIFORNIA","NIGERIA","CANADA","TELAVIV"};
		solve(crossword,words,0);
//		s.close();
//		print(crossword);
		
		/*
		+-++++++++
		+-++-+++++
		+-------++
		+-++-+++++
		+-++-+++++
		+-++-+++++
		++++-+++++
		++++-+++++
		++++++++++
		----------
		CALIFORNIA;NIGERIA;CANADA;TELAVIV
		*/
		
   }

	
}
