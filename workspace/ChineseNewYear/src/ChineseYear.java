import java.util.Scanner;

import static java.lang.System.out;

public class ChineseYear {
	
	static int s_minYear = 1900;

	public static void main(String[] args) {
		while (true) {
			//open scanner
			@SuppressWarnings("resource")
			Scanner yearInput = new Scanner(System.in);
			out.print("Enter Year: ");
			
			//test input
			if (yearInput.hasNextInt()) {
				int year = yearInput.nextInt();
				
				//check value
				if (year >= s_minYear) {
					EvalChineseYear(year);
					yearInput.close();
					break;
				}
			}
			
			out.println("Invalid entry\n");
		}
	}
	
	static void EvalChineseYear(int year) {
		
		int yearDiff = year - s_minYear;
		String animal;
		
		switch (yearDiff % 12) {
		case 0:
			animal = "Rat";
			break;
		case 1:
			animal = "Ox";
			break;
		case 2:
			animal = "Tiger";
			break;
		case 3:
			animal = "Rabbit";
			break;
		case 4:
			animal = "Dragon";
			break;
		case 5:
			animal = "Snake";
			break;
		case 6:
			animal = "Horse";
			break;
		case 7:
			animal = "Sheep";
			break;
		case 8:
			animal = "Monkey";
			break;
		case 9:
			animal = "Rooster";
			break;
		case 10:
			animal = "Dog";
			break;
		case 11:
			animal = "Pig";
			break;
		default:
			animal = "[YOU BROKE MATH]";
		}
		
		out.printf("%d was the year of the %s.", year, animal);
		
		
	}
}
