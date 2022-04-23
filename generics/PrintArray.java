package generics;

import java.util.Iterator;

import finalClass.Vehicle;

public class PrintArray {

	
//	public static <T> void printArray(T a[]) {
//		
//		for(int i = 0; i<a.length;i++) {
//			System.out.print(a[i]);
//			System.out.print(" ");
//		}
//		System.out.println();
//	}

	
//public static <T extends Vehicle> void printArray(T a[]) {
//		
//		for(int i = 0; i<a.length;i++) {
//			System.out.print(a[i]);
//			System.out.print(" ");
//		}
//		System.out.println();
//	}


	public static <T extends PrintInterface > void printArray(T a[]) {
	
	for(int i = 0; i<a.length;i++) {
		System.out.print(a[i]);
		System.out.print(" ");
	}
	System.out.println();
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int a[] = new int[10]; // compiler will throw error coz primitiive
	
		Integer a[] = new Integer[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i+1;
		}
		
		String s[] = new String[10];
		for (int i = 0; i < s.length; i++) {
			s[i] = "abc";
		}
		
//		printArray(a); 
//        printArray(s);
        
        
        
//        Vehicle v[] = new Vehicle[10];
//        
//        for(int i=0;i<10;i++) {
//        	v[i] = new Vehicle(10);
//        }
//		printArray(v); 

		Student s1[] = new Student[10];
		for(int i=0; i < 10;i++) {
			s1[i] = new Student();
			
		}
		printArray(s1);
		
		
}
}