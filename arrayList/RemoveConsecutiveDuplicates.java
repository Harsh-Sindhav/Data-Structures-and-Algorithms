package arrayList;
import java.util.*;
public class RemoveConsecutiveDuplicates {
public static ArrayList<Integer> removeConsecutiveDuplicates(int arr[]) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	result.add(arr[0]);
	for (int i = 1; i < arr.length; i++) {
		if(arr[i] != arr[i-1]) {
			result.add(arr[i]);
		}
	}
	
	return result;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int arr[] = {10,10,10,20,20,30,30,10};
   ArrayList<Integer> s = removeConsecutiveDuplicates(arr);
   for (int i = 0; i < s.size(); i++) {
	System.out.println(s.get(i));
}
	}

}
