import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the word/phrase: ");
		String original = input.nextLine(),
				reverse = "";
		input.close();
		
		int length = original.length() - 1;
		
		//reverse word without spaces
		for (int i = length; i >= 0; i--) {
			if (original.charAt(i) == ' ') continue;
			reverse += original.charAt(i);
		}
		
		//add spaces
		if (original.contains(" ")) {
			for (int i = 0; i <= length; i++) {
				if (original.charAt(i) == ' ') {
					reverse = reverse.substring(0, i) + ' ' + reverse.substring(i);
				}
			}
		}
		
		//print results
		System.out.printf("Original:\t%s\n" + "Reverse:\t%s\n" + "Palindrome:\t%b\n",
				original,
				reverse,
				reverse.equals(original));
	}

}
