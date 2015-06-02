import static java.lang.System.out;

public class ReverseString {

	public static void main(String[] args) {

		reverseString("Pamela");
		
		inPlaceSwap("Pamela");
		
	}
	//better way of doing it
	static void reverseString(String input) {
		String reversed = "";
		
		for (int i = input.length() - 1; i >= 0; i--) {
			reversed += input.charAt(i);
		}
		
		out.println(reversed);
	}
	
	//used StringBuilder instead of two char[]. Still uses in-place swap strategy
	static void inPlaceSwap(String input) {
		StringBuilder reverse = new StringBuilder(input);
		char swap;
		
		for (int i = 0, n = input.length() - 1; i < input.length()/2; i++, n--) {
			swap = reverse.charAt(i);
			reverse.setCharAt(i, reverse.charAt(n));
			reverse.setCharAt(n, swap);
		}
		
		out.println(reverse);
	}
	
	static void outPlaceSwap(String input) {
		
		
	}

}
