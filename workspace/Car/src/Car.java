
public class Car {
	
	private String _model = null; 
	
	private String _color = "Black";
	
	private int _numberOfCylinders = 6;

	private boolean _isElectric = false;

	public Car (String model)
	{

		_model = model;
	}
	

	public Car (String model, String color)
	{
		_model = model;
		_color = color;
	}
	

	public Car (String model, String color, int numCylinders, boolean isElectric)
	{
		_model = model;
		_color = color;
		_numberOfCylinders = numCylinders;
		_isElectric = isElectric;
	}
	

	public String getColor ()
	{
		return _color;
	}
	

	public void setColor (String color)
	{
		_color = color;
	}
	
	public String getModel ()
	{
		return this._model;
	}
	

	public boolean isElectric()
	{
		return this._isElectric;
	}
	

	public String toString()
	{
		return ("This car is a " + _model + ", it's color is " + _color + ", and it has " + _numberOfCylinders + " cylinders");
		
	}

}
