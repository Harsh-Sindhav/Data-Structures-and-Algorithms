package dp;

public class EditDistance {

	
	public static int editdistance(String s1,String s2) {
		if(s1.length() == 0) {
			return s2.length();
		}
     
		 if(s2.length() == 0) {
			 return s1.length();
		 } 
  
		int myAns;
		if(s1.charAt(0) == s2.charAt(0)) {
			int smallAns = editdistance(s1.substring(1), s2.substring(1));
		    myAns = smallAns;
		}else {
			int remove = editdistance(s1.substring(1), s2);
			int insert = editdistance(s1, s2.substring(1));
			int substitute = editdistance(s1.substring(1), s2.substring(1));
		  myAns = 1 + Math.min(remove, Math.min(insert, substitute));
		}
	
		return myAns;
	}
	
	
   public static int editdistancerdp(String s1,String s2,int i,int j,int[][] dp) {
	   
		if(s1.length() == 0) {
			return s2.length();
		}
     
		 if(s2.length() == 0) {
			 return s1.length();
		 } 
		 int m = s1.length();
	   	int n = s2.length();  
		int myAns;
		if(s1.charAt(0) == s2.charAt(0)) {
	   	int smallAns;
			if(dp[i+1][j+1] == -1) {
	   		 smallAns = editdistancerdp(s1.substring(1), s2.substring(1),i+1,j+1,dp);
	   		dp[i+1][j+1] = smallAns;
	   	}else {
	   		smallAns = dp[i+1][j+1]; 
	   	}
			myAns = smallAns;
		}else {
		    int remove,insert,substitute;
			if(dp[i+1][j] == -1) {
		     remove = editdistancerdp(s1.substring(1), s2,i+1,j,dp);
		     dp[i+1][j] = remove;
			}else {
				remove = dp[i+1][j] ;
			}
			
			if(dp[i][j+1] == -1) {
			 insert = editdistancerdp(s1, s2.substring(1),i,j+1,dp);
			 dp[i][j+1] = insert;
			 }else {
				 insert = dp[i][j+1];
			 }
			if(dp[i+1][j+1]==-1) {
			substitute = editdistancerdp(s1.substring(1), s2.substring(1),i+1,j+1,dp);
		    dp[i+1][j+1] = substitute;	
			}else {
				substitute = dp[i+1][j+1];
			}
			myAns = 1 + Math.min(remove, Math.min(insert, substitute));
		}
	   
	   return myAns;
   }	
	

   public static int edditDistanceIdp(String s1,String s2) {
	  // top down
	   int m = s1.length();
	   int n= s2.length();
	   int[][] dp = new int[m+1][n+1];
	   for(int i=0;i<=m;i++) {
		   dp[i][0]=i;
		   }
		   for(int j=0;j<=n;j++) {
			   dp[0][j] = j;
		   }
	   for(int i=1;i<=m;i++) {
		   for(int j=1;j<=n;j++) {
			   if(s1.charAt(i-1) == s2.charAt(j-1)) {
				   dp[i][j] = dp[i-1][j-1];
			   }else {
				   int remove,insert,substitute;
					remove = dp[i-1][j];
					insert =dp[i][j-1];
					substitute = dp[i-1][j-1];
					dp[i][j] = 1 + Math.min(remove, Math.min(insert, substitute));	
			   }
		   }
	   }
	   for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	 return dp[m][n];
	   
   }
   
   public static int edditDistanceIdpBtup(String s1,String s2) {
		  // bottom up
		   int m = s1.length();
		   int n= s2.length();
		   int[][] dp = new int[m+1][n+1];
		   int l=0;
		   for(int i=m;i>=0;i--) {
			   dp[i][n]=l++;
//System.out.println(dp[i][n]);
			   }
		   int k=0;
			   for(int j=n;j>=0;j--) {
				   dp[m][j] = k++;
			   }
			   for(int i=0;i<dp.length;i++) {
					for(int j=0;j<dp[i].length;j++) {
						System.out.print(dp[i][j] + " ");
					}
					System.out.println();
				}
			   System.out.println();
		   for(int i=m-1;i>=0;i--) {
			   for(int j=n-1;j>=0;j--) {
				   if(s1.charAt(i) == s2.charAt(j)) {
					   dp[i][j] = dp[i+1][j+1];
				   }else {
					   int remove,insert,substitute;
						remove = dp[i+1][j];
						insert =dp[i][j+1];
						substitute = dp[i+1][j+1];
						dp[i][j] = 1 + Math.min(remove, Math.min(insert, substitute));	
				   }
			   }
		   }
		   for(int i=0;i<dp.length;i++) {
				for(int j=0;j<dp[i].length;j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}
		 return dp[0][0];
		   
	   }
   
   
	public static void main(String[] args) {
		
//		String s1 = "whgtdwhgtdg";
//		String s2 = "aswcfg";

		String s1 = "ecfbefdcfca"; String s2 =  "badfcbebbf";
		
		
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = -1;
			}
		}
		int edit = edditDistanceIdpBtup(s1, s2);
		System.out.println();
//		int edit = editdistancerdp(s1, s2,0,0,dp);
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[i].length;j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println();

	   System.out.println(edit);
	}
}
