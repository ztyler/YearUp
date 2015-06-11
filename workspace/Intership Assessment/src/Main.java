public class Main {

	public static void main(String[] args) {
		
		LCRoster OneUp = new LCRoster(3, "One-Up");
		//No students
		OneUp.printInfo();
		
		String[] students = {"Zachary Tyler", null, "Taha Sabra", "Adrian Brinson", null};
		
		//null test
		OneUp.inputStudentList(null);
		
		//real test
		OneUp.inputStudentList(students);
		
		//now with students
		OneUp.printInfo();
		
	}

}
