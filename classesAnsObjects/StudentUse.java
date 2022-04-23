package classesAnsObjects;

public class StudentUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(Student.getnumStudents());
		Student s1 = new Student("harsh",50);
		s1.print();
		Student s2 = new Student("dhaval",125);
		s2.print();
		System.out.println(Student.getnumStudents());
			
	}

}
