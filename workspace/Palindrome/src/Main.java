import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the word/phrase: ");
		String original = input.nextLine(),
				reverse = "";
		
		int length = original.length() - 1;
		int skip = -1;
		
		for (int i = length; i >= 0; i--) {
			if (original.charAt(length - i) == ' ') {
				reverse += ' ';
			}
			reverse += original.charAt(i);
			
		}
		
	}

}
