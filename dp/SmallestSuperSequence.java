package dp;

public class SmallestSuperSequence {

	public static int smallestSuperSequence(String str1,String str2,int i,int j) {
		if(i>= str1.length()) return 0;
		if(j>= str2.length()) return 0;
		
		if(str1.charAt(i)==str2.charAt(j)) {
			return 1 + smallestSuperSequence(str1, str2, i+1, j+1);
		}else {
			return 1 + Math.min(smallestSuperSequence(str1, str2, i, j+1),smallestSuperSequence(str1, str2, i+1, j));  
		}
		
	}
	
	public static int smallestSuperSequenceIdp(String str1,String str2) {
	int len1 = str1.length();
	int len2 = str2.length();
	int superseq[][] = new int[len1+1][len2+1]; 
			for(int p=0;p<=len1;p++) {
				for(int q=0;q<=len2;q++) {
					if(p==0) {
						superseq[p][q] = q;
					}
					else if(q ==0) {
						superseq[p][q] = p;
					}else if(str1.charAt(p-1) == str2.charAt(q-1)){
						superseq[p][q] = 1+superseq[p-1][q-1];
					}else {
						superseq[p][q] = 1 + Math.min(superseq[p-1][q], superseq[p][q-1]);
					}
				}
			}
		
		return superseq[len1][len2];
	}
	
	public static void main(String[] args) {
		
	}
}
