package patterns;
import java.util.*;
public class AlphaPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      char val = 'A';
      for(int i=0;i<5;i++) {
    	  for(int j=0;j<i+1;j++) {
    	  System.out.print(val);
    	  
    	  }
    	  System.out.println();
         val++;
      }
	}

}
