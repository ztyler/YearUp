public class LargestNumber {

	public static void main(String[] args) {
		
		int[] array = {85, 29, 34, 110, 43};
		
		largestFor(array);
		largestWhile(array);
	}
	
	static void largestFor(int[] numArray) {
		if (numArray != null) {
			if (numArray.length > 0) {
				int largest = numArray[0];
				
				for (int i = 0; i < numArray.length; i++) {
					if (numArray[i] > largest) {
						largest = numArray[i];
					}
				}
				
				System.out.println("Largest (for): " + largest);
			}
			else {
				System.out.println("Empty array, stupid.");
			}
		}
		else {
			System.out.println("Null array, stupid.");
		}
		
	}
	
	static void largestWhile(int[] numArray) {
		if (numArray != null) {
			//make largest the first value in the array
			int largest = numArray[0];
			
			//start index at 0
			int i = 0;
			
			//test each value in the array, assigning the biggest value to largest
			while (i < numArray.length) {
				if (numArray[i] > largest)
					largest = numArray[i];
				
				//add 1 to the index
				i++;
			}
			
			System.out.println("Largest (while): " + largest);
			
		}
	}
}

