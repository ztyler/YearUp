
public class Main {

	public static void main(String[] args) {
		
		Circle bigCircle = new Circle(10);
		Circle smallCircle = new Circle(5, "blue");
		
		//print smallCircle vars
		System.out.printf("smallCircle\n"
				+ "\tradius: %.2f\n\tcolor: %s\n", 
				smallCircle.calcArea(),
				smallCircle.m_color);
		
		//print bigCircle vars
		System.out.printf("bigCircle\n"
				+ "\tradius: %.2f\n\tcolor: %s\n", 
				bigCircle.calcArea(),
				bigCircle.m_color);

		
	}
}
