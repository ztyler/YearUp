
public class ExceptionCentral {
	
	public ExceptionCentral() {
		// TODO Auto-generated constructor stub
	}

	static int firstMethod() throws ArithmeticException {
		int numberThatExists = 4 / 0;
		
		return numberThatExists;
	}
	
	@SuppressWarnings("null")
	static char secondMethod() throws NullPointerException {
		String thisShouldWork = null;
		
		return thisShouldWork.charAt(0);
	}
	
	static void thirdMethod() {
		int[] array = new int[4];
		
		try {
			for (int i = 0; i <= array.length; i++) {
				int x = 43 * array[i];
			}
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Out of bounds, STUPID!");
			e.printStackTrace();
		}
	}
	
	static void fourthMethod(String[] array) {
		
		try {
			for (int i = 0; i <= array.length; i++) {
				try {
					int printThis = Integer.parseInt(array[i]);
					
					System.out.println(printThis);
				}
				catch(NumberFormatException e) {
					System.out.println("Null!");
				}
			}
		}
		catch (NullPointerException e) {
			System.out.println("NULL ARRAY DUMMY!");
			e.printStackTrace();
		}
		
	}
	
}

