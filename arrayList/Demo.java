package arrayList;
import java.util.*;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(10);
    arr.add(20);
    arr.add(30);
    arr.add(1, 15);
    System.out.println(arr.size());
    System.out.println(arr.get(2));
    for (int i = 0; i < arr.size(); i++) {
		System.out.print(arr.get(i) +" ");
	}
    System.out.println();
    arr.remove(2); // 2 is index!
    
    for (int i = 0; i < arr.size(); i++) {
		System.out.print(arr.get(i) +" ");
	}
    System.out.println();
    Integer k = 10;
     
    arr.remove(k); //10 is the object 
    
    for (int i = 0; i < arr.size(); i++) {
		System.out.print(arr.get(i) +" ");
	}
    
    arr.set(0, 100); // replaces the element at 0th index note that insertion is not happening here
    System.out.println();
    System.out.println(arr);
    
	}

}
