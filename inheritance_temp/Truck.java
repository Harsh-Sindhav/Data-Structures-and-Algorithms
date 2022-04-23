package inheritance_temp;

import inheritance.Vehicle;

public class Truck  extends Vehicle {

   int maxLoadingCapacity;
   
   public Truck() {
	   super(100);
   }
	
   public void print() {
		
		System.out.println("Vehicle" + "color" + getColor() + " maxSpeed" + maxSpeed + "maxLoadingCapacity " + maxLoadingCapacity);
 	
	}

   
   
}
