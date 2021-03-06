import static java.lang.System.out;

public class ReverseString {

	public static void main(String[] args) {
		
		String original = "Hello Class 13!";
		
		inPlaceSwap(original);
		
		outPlaceSwap(original);
		
		reverseString(original);
	}
	
	//used StringBuilder instead of two char[]. Still uses in-place swap strategy
	static void inPlaceSwap(String input) {
		if (input != null) {
			StringBuilder reverse = new StringBuilder(input);
			
			for (int i = 0, n = input.length() - 1; i < input.length()/2; i++, n--) {
				char swap = reverse.charAt(i);
				reverse.setCharAt(i, reverse.charAt(n));
				reverse.setCharAt(n, swap);
			}
			
			out.println(reverse);
		}
	}
	
	//out-place swap
	static void outPlaceSwap(String input) {
		if (input != null) {
			char[] reverse = new char[input.length()];
			
			for (int i = 0, n = input.length() - 1; i < input.length(); i++, n--) {
				reverse[i] = input.charAt(n);
			}
			
			out.println(reverse);
		}
		
	}
	
	//alternate out-place
	static void reverseString(String input) {
		if (input != null) {
			String reverse = "";
			
			for (int i = input.length() - 1; i >= 0; i--) {
				reverse += input.charAt(i);
			}
			
			out.println(reverse);
		}
		
	}

}
