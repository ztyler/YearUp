
public class Main {

	public static void main(String[] args) {
		
		Banker Satan = new Banker(120000);
		SchoolTeacher Uthra = new SchoolTeacher(50000);
		Scientist AlanTuring = new Scientist(90000);
		
		Satan.payTaxes(.33);
		Uthra.payTaxes(.23);
		AlanTuring.payTaxes(.28);
		
		Satan.fileTaxReturn();
		Uthra.fileTaxReturn();
		AlanTuring.fileTaxReturn();
	}

}
