
public class Circle implements IShape {

	int m_radius;
	
	public double calculateArea() {
		double area = m_radius * m_radius * Math.PI;
		return area;
	}
	
	public double calculatePerimeter() {
		double perimeter  = 2 * Math.PI * m_radius;
		return perimeter;
	}
	
}
