public class CalculateArea {

	public static void main(String[] args) {
		
		double circleArea = CalculateCircleArea(5);
		System.out.printf("The area of the circle is %.2f", circleArea);
	}
	
	static double CalculateCircleArea(int rad) {
		return rad * rad * Math.PI;
	}
	
	
}
