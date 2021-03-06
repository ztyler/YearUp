import static java.lang.System.out;


public class Banker implements ITaxPayer {
	
	private double m_income;
	private boolean m_donePayingTaxes = false;
	
	Banker(double income) {
		setIncome(income);
	}
	
	public void payTaxes(double taxRate) {
		if (!m_donePayingTaxes) {
			double taxAmount = m_income * taxRate;
			setIncome(getIncome() - taxAmount);
			
			m_donePayingTaxes = true;
			
			System.out.printf("Banker paid $%.2f in taxes.\n", taxAmount);
		}
	}

	public void fileTaxReturn() {
		if (m_donePayingTaxes) {
			out.println("Banker has filed tax return.");
		}
		else {
			out.println("Banker has not filed tax return yet.");
		}
	}

	public double getIncome() {
		return m_income;
	}

	private void setIncome(double newIncome) {
		m_income = newIncome;
	}

}
