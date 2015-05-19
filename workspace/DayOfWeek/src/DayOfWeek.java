import java.util.Scanner;


public class DayOfWeek {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String day;
		
		do {
			System.out.print("Enter the day of the week: ");
			day = userInput.nextLine();
		}
		//loop if input is invalid
		while (EvalDay(day));
		
		userInput.close();
	}
	
	static boolean EvalDay(String day) {
		
		//null or "" check. Feed "true" to do/while if true. Break the universe.
		if (day.isEmpty() || day == null) {
			System.out.println("Days no longer exist. Time isn't a thing. Chaos and confusion.\n");
			return true;
		}
		
		//change day to proper case
		day = day.substring(0, 1).toUpperCase() + day.substring(1, day.length()).toLowerCase();
		
		//check for weekend.
		if (day.equals("Saturday")
				|| day.equals("Sunday")) {
			
			System.out.printf("It's %s. It's the weekend!!!", day);
			
		}
		//check for weekday
		else if (day.equals("Monday")
				|| day.equals("Tuesday")
				|| day.equals("Wednesday")
				|| day.equals("Thursday")
				|| day.equals("Friday")) {
			
			System.out.printf("It's %s. That's a weekday. Go to work.", day);
		}
		//if String day isn't really a day of the week, call the user a liar and feed true to do/while
		else {
			System.out.println("That's not a day. You're a liar. Try again.\n");
			return true;
		}
		
		//return false to exit do/while loop
		return false;
	}
}
