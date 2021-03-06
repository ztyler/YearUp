import java.util.Scanner;
import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		out.print("Enter a word: ");
		String word = input.nextLine();
		input.close();
		
		isPalindrome(word);
		
	}
	
	static void isPalindrome(String input) {
		if (input != null) {
			String word = (input.replaceAll("\\W+", "")).toLowerCase();
			
			boolean isPalindrome = true;
			for (int n = 0, i = word.length() - 1; i > word.length()/2; n++, i--) {
				if (word.charAt(i) != word.charAt(n)) {
					isPalindrome = false;
					break;
				}
			}
			
			if (isPalindrome) {
				out.printf("%s is a palindrome.\n", input);
			}
			else {
				out.printf("%s is not a palindrome.\n", input);
			}
		}
		else {
			out.println("Null string, stupid.");
		}
	}
}
