
public class Main {
	public static void main(String[] args)
	{
		
		System.out.println ("My Car program is starting...");
		
		
		Car porsche = new Car ("Porsche 911 Turbo S");
		
		Car bmw = new Car ("BMW 335i");
		bmw.setColor ("Light Blue");
		
		Car stingray = new Car ("Chevy Corvette Stingray", "Red", 8, false);
		stingray.setColor ("Fiery Volcano Red");
		
		Car carsArray[] = new Car[5];
		carsArray [0] = porsche;
		carsArray [1] = bmw;
		carsArray [2] = stingray;
		
		carsArray [3] = new Car ("Tesla Model S", "White", 0, true);
		
		carsArray [4] = new Car ("Dodge Caravan", "Brown", 4, false);
		
		System.out.println ("There are " + carsArray.length + " cars in the array");
		
		int j = 0;
		int electricCount = 0;
		while (j < carsArray.length)
		{
			String isElectric = "";
			if (carsArray[j].isElectric() == true) {
				isElectric = " (Electric)";
				electricCount++;
			}
			
			System.out.printf("Car at index %d: %s%s.\n",
					j,
					carsArray[j].toString(),
					isElectric);
			j++; 
			
		}
		if (electricCount == 1) {
			System.out.println("There is one electric car.");
		}
		else {
			System.out.printf("\nThere are %d electric cars.\n", electricCount);
		}
		
		
		
		System.out.println ("This program is over, happy coding and peace out!");
				
	}
}
