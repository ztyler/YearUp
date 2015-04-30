public class CalculateArea {

	public static void main(String[] args) {
		
		double circleArea = CalculateCircleArea(5);
		System.out.printf("The area of the circle is %.2f\n", circleArea);
		
		double rectArea = CalculateRectArea(5, 6);
		System.out.printf("The area of the rectangle is %.0f\n", rectArea);
	}
	
	static double CalculateCircleArea(int rad) {
		return rad * rad * Math.PI;
	}
	
	static double CalculateRectArea(int length, int width) {
		return length * width;
	}
	
}