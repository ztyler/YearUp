
public class Main {

	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.m_radius = 5;
		
		Square square = new Square();
		square.m_length = 5;
		
		IShape plate = circle;
		IShape box = square;
		
		System.out.println(plate.calculateArea());
		System.out.println(box.calculateArea());

	}

}
