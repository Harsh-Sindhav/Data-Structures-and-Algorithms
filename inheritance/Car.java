package inheritance;

public class Car extends Vehicle {
 
	// when not using doing inheritance i.e. common in both bike and car
//	String color;
//	int maxSpeed;
	int numDoors;
	//super
//	int maxSpeed;
  	
	// inheritance and constructor
	
//   public Car() {
//	   System.out.println("Car's Constructor");
//   }
 	
//	 public Car(int numDoors) {
//		 super(100);
//		 System.out.println("Car's Constructor");
//		 
//		 this.numDoors = numDoors;
//	 }
	
	public Car(int numDoors, int maxSpeed) {
		 super(maxSpeed);
		 System.out.println("Car's Constructor");
		 
		 this.numDoors = numDoors;
	 }
	
//public void printCar() {
//		
//		System.out.println("Car" + "color" + color + " maxSpeed" + maxSpeed + "numDoors "+ numDoors);
//		   
//	}
	
	
//public void printCar() {
//		
//		System.out.println("Car" + "color" + getColor() + " maxSpeed" + maxSpeed + "numDoors "+ numDoors);
//		   
//	}	
	
public void print() {
		super.print();
		System.out.println("car " + "numDoors " + numDoors);
//		System.out.println("Car" + "color" + getColor() + " maxSpeed" + maxSpeed + "numDoors "+ numDoors);
		   
	}	
	
// public void printMaxSpeed() {
//	 System.out.println(maxSpeed);
//	 
// }
public void printMaxSpeed() {
	
	 // setting vehicle maxSpeed to 150 lets say....
	super.maxSpeed = 150;
	 System.out.println(maxSpeed + " " + super.maxSpeed);  
	 
}

}
