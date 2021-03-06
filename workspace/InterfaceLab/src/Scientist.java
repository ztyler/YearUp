import static java.lang.System.out;

public class Scientist implements ITaxPayer {

	private double m_income;
	private boolean m_donePayingTaxes = false;
	
	public Scientist(double income) {
		setIncome(income);
	}
	
	public void payTaxes(double taxRate) {
		if (!m_donePayingTaxes) {
			double taxAmount = getIncome() * taxRate;
			setIncome(getIncome() - taxAmount);
			
			m_donePayingTaxes = true;
			
			out.printf("Scientist paid $%.2f in taxes.\n", taxAmount);
		}
		else {
			out.println("Scientists has already paid taxes");
		}
	}

	public void fileTaxReturn() {
		if (m_donePayingTaxes) {
			out.println("Scientist has filed tax return.");
		}
		else {
			out.println("Scientist has not filed tax return yet.");
		}
	}
	
	public double getIncome() {
		return m_income;
	}

	private void setIncome(double newIncome) {
		m_income = newIncome;
	}

}
