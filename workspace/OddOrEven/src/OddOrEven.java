import java.util.Scanner;
import static java.lang.System.out;

public class OddOrEven {

	public static void main(String[] args) {
		
		int num;
		
		while (true) {
			Scanner numInput = new Scanner(System.in);
			out.print("Enter a number: ");
			
			if (numInput.hasNextInt()) {
				num = numInput.nextInt();
				numInput.close();
				
				switch (num % 2) {
				case (0):
					out.println("Even");
					break;
				default:
					out.println("Odd");
				}
				
				numInput.close();
				break;
				
			}
			else {
				out.println("Invalid entry\n");
			}
		
		}
		
	}

}
