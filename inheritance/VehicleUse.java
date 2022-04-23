package inheritance;

import java.util.Scanner;

public class VehicleUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
		// class cast and objecct class

		
		Vehicle v= new Car(4,100);
//		v= new Bike();
		Car c = (Car)v;
		c.numDoors = 3;   // will get runtime error that is class cast exception bcoz we're assigning doors to bike
		c.print();	
		
		
		// polymorphism 
	
//		Vehicle v;
//		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		if(n<10) {
//			v = new Car(4,100);
//		}else {
//			v = new Vehicle(100);
//		}
		
		
		
		
		
//		Vehicle v = new Car(4,100);
////		v = new Bike();
//		v.maxSpeed = 100;
////		v.numDoors = 4;
//		
//		v.print();  
		
		
		// inheritance and Constructor 
//	  Vehicle v = new Vehicle();
//	  Car c = new Car(10,100);
//		c.print();
		
		
//		Vehicle v = new Vehicle();
////		v.color = "red";	
//		v.setColor("red");
//		v.maxSpeed = 80;
//		v.print();
//		
//		Car c = new Car();
////		c.color = "black";
//		c.setColor("black");
//		c.maxSpeed = 100;
//		
//		c.numDoors = 4;
//		// super
//		c.printMaxSpeed(); // car's maxSpeed 100 and vehicle's maxspeed 0
//		c.print();
////		c.printCar();
//		
//      	
//		
////		Bike b = new Bike();
////		b.print();
		
	}

}
