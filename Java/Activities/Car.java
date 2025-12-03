package Activities;

public class Car {
	
	String colour;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	Car() {
		tyres = 4;
		doors = 4;
	}

	public void displayCharacteristics() {
		System.out.println("Car Colour:" +colour);
		System.out.println("Car Transmission:" +transmission);
		System.out.println("Car make:" +make);
		System.out.println("No of tyres:" +tyres);
		System.out.println("No of doors:" +doors);
	}
	
	public void accelerate() {
		System.out.println("car is moving forward");
	}
	
	public void brake() {
		System.out.println("car has stopped");
	}
}
