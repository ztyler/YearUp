
public class Square implements IShape {

	double m_length = 0;
	
	public double calculatePerimeter() {
		double perimeter = m_length * 4;
		return perimeter;
	}

	public double calculateArea() {
		double perimeter = Math.pow(m_length, 4);
		return perimeter;
	}
	
	

}
