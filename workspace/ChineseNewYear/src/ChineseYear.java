import java.util.Scanner;
import static java.lang.System.out;

public class ChineseYear {
	
	static int s_minYear = 1900;

	public static void main(String[] args) {
		while (true) {
			Scanner yearInput = new Scanner(System.in);
			out.print("Enter Year: ");
			
			if (yearInput.hasNextInt()) {
				int year = yearInput.nextInt();
				yearInput.close();
				if (year >= s_minYear) {
					EvalChineseYear(year);
					break;
				}
			}
			
			out.println("Invalid entry\n");
		}
	}
	
	static void EvalChineseYear(int year) {
		
		int yearDiff = year - s_minYear;
		
		switch (yearDiff % 12) {
		case 0:
			out.printf("%d is the year of the %s", year, "Rat");
			break;
		case 1:
			out.printf("%d is the year of the %s", year, "Ox");
			break;
		case 2:
			out.printf("%d is the year of the %s", year, "Tiger");
			break;
		case 3:
			out.printf("%d is the year of the %s", year, "Rabbit");
			break;
		case 4:
			out.printf("%d is the year of the %s", year, "Dragon");
			break;
		case 5:
			out.printf("%d is the year of the %s", year, "Snake");
			break;
		case 6:
			out.printf("%d is the year of the %s", year, "Horse");
			break;
		case 7:
			out.printf("%d is the year of the %s", year, "Sheep");
			break;
		case 8:
			out.printf("%d is the year of the %s", year, "Monkey");
			break;
		case 9:
			out.printf("%d is the year of the %s", year, "Rooster");
			break;
		case 10:
			out.printf("%d is the year of the %s", year, "Dog");
			break;
		case 11:
			out.printf("%d is the year of the %s", year, "Pig");
			break;
		}
		
		
	}
}
