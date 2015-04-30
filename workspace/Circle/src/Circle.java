
public class Circle {
	
	double m_radius;
	String m_color;
	
	Circle(double radius) {
		m_radius = radius;
		m_color = "grey";
	}
	
	Circle(double radius, String color) {
		m_radius = radius;
		m_color = color;
	}
	
	
	double calcArea() {
		return Math.PI * m_radius * m_radius;
	}
	
	void printColor() {
		System.out.println(m_color);
	}
}
