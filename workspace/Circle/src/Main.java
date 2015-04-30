
public class Main {

	public static void main(String[] args) {
		
		Circle bigCircle = new Circle(10);
		Circle smallCircle = new Circle(5, "blue");
		
		//print smallCircle vars
		System.out.printf("smallCircle\n"
				+ "\tradius: %.2f\n\tcolor: ", 
				smallCircle.calcArea());
		smallCircle.printColor();
		
		//print bigCircle vars
		System.out.printf("bigCircle\n"
				+ "\tradius: %.2f\n\tcolor: ", 
				bigCircle.calcArea());
		bigCircle.printColor();
		
	}

}