package timeComplexity;

import java.util.Arrays;

public class ArrayIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int a[] = {3,6,1,3,3,8,5,0};
      int b[] = {8,4,5,1,9,3,3,3,3,32};
      Arrays.sort(a);
      Arrays.sort(b);
      int i=0,j=0;
      while(i<a.length && j<b.length) {
    	  if(a[i]==b[j]) {
    		  System.out.println(a[i]);
    		  i++;
    		  j++;
    	  }else if(a[i]>b[j]) {
    		  j++;
    	  }else if(a[i]<b[j]) {
    		  i++;
    	  }
      }
//      for (int j2 = 0; j2 < b.length; j2++) {
//		
//	}
		
	}

}
