
public class Car {

	String _model = null; 

	String _color = "black";
	
	int _numberOfCylinders = 6;
	
	boolean _isHybrid = false;
	
	public Car (String model) {
		_model = model;
	}
	
	public Car (String model, String color) {
		_model = model;
		_color = color;
	}
	
	public Car (String model, String color, int numCylinders, boolean isHybrid) {
		_model = model;
		_color = color;
		_numberOfCylinders = numCylinders;
		_isHybrid = isHybrid;
	}
	
	public String getColor () {
		return _color;
	}
	
	public void setColor (String color) {
		_color = color;
	}
	
	public String isThisCarAHybrid() {
		String result = null;
		if (_isHybrid) {
			result = "Yes";
		}
		else {
			result = "No"; 
		}
		
		return (result);
	}
	
	public String toString() {
		return ("This car is a " + _model + ", it's color is " + _color + ", and it has " + _numberOfCylinders + " cylinders");
		
	}
	
	public static void main (String[] args) {
		
				
	}

}