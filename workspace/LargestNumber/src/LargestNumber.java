public class LargestNumber {

	public static void main(String[] args) {
		
		int[] array = {85, 29, 34, 110, 43};
		
		largestFor(array);
		largestWhile(array);
	}
	
	static void largestFor(int[] numArray) {
		if (numArray != null) {
			int largest = -1;
			
			for (int i = 0; i < numArray.length; i++) {
				if (numArray[i] > largest) {
					largest = numArray[i];
				}
			}
			
			System.out.println("Largest (for): " + largest);
		}
	}
	
	static void largestWhile(int[] numArray) {
		if (numArray != null) {
			int largest = -1;
			int i = 0;
			while (i < numArray.length) {
				if (numArray[i] > largest)
					largest = numArray[i];
				i++;
			}
			
			System.out.println("Largest (while): " + largest);
			
		}
	}
}

