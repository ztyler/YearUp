import static java.lang.System.out;


public class SchoolTeacher implements ITaxPayer {

	private double m_income;
	private boolean m_donePayingTaxes = false;
	
	public SchoolTeacher(double income) {
		setIncome(income);
	}
	
	public void payTaxes(double taxRate) {
		if (!m_donePayingTaxes) {
			double taxAmount = getIncome() * taxRate;
			setIncome(getIncome() - taxAmount);
			
			m_donePayingTaxes = true;
			
			System.out.printf("School Teacher paid $%.2f in taxes.\n", taxAmount);
		}
	}

	public void fileTaxReturn() {
		if (m_donePayingTaxes) {
			out.println("School Teacher has filed tax return.");
		}
		else {
			out.println("School Teacher has not filed tax return yet.");
		}
	}
	
	public double getIncome() {
		return m_income;
	}

	private void setIncome(double newIncome) {
		m_income = newIncome;
	}

}
