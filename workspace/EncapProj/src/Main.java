
public class Main {

	public static void main(String[] args) {
		
		Person Zach = new Person("Zach", "555-9050", "1686 Some Rd, Atlanta, GA", 22);
		
		System.out.printf("NAME:\n%s\n\n"
				+ "PHONE:\n%s\n\n"
				+ "ADDRESS:\n%s\n\n"
				+ "AGE:\n%d\n\n",
				Zach.getName(),
				Zach.getPhoneNum(),
				Zach.getAddress(),
				Zach.getAge());
		
		Zach.growsOlder();
		
		System.out.printf("%s's new age is %d\n",
				Zach.getName(),
				Zach.getAge());
		
	}

}
