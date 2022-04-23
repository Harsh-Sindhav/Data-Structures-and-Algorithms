package classesAnsObjects;

public class Student {

	public String name;
	final private int rollNumber;
	double cgpa;
	private static int numStudents;
	
	public Student(String name, int rollNumber) {
		
		this.name = name;
		this.rollNumber = rollNumber;
		numStudents++;

	}
	
	public Student(String name) {
		
		this.name = name;
		numStudents++;
		this.rollNumber = numStudents;
		
	}
	
	public Student() {
		
		name = "abc";
		numStudents++;
		this.rollNumber = numStudents;
		
	}
	
	
	public void print() {
		System.out.println(name + " " + rollNumber);
	}
	
	public static int getnumStudents() {
		
		return numStudents;
	}
	
	public int getRollNumber(){
		
		return this.rollNumber;
		
	}
	
	public void setRollNumber(int rollNumber) {
		
		if(rollNumber <= 0) {
			
			return;
		}
		System.out.println("this " + this);
		
		
//		this.rollNumber = rollNumber;
		
	}
	
	
	
	
	
	
	
}
