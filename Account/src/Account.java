public class Account {
	private int m_accountId = -1;
	private String m_accountName;
	private int m_customerId = -1;
	private double m_amount = 0.0;

	Account(int accountId, String accountName, int customerId) {
		m_accountId = accountId;
		m_accountName = accountName;
		m_customerId = customerId;
	}

	private void UpdateAmount(double newAmount) {
		m_amount = newAmount;
	}

	public void UpdateAmountSecurely(double newAmount, String password) {
		if (password != null) {
			if (password.equals("admin")) {
				UpdateAmount(newAmount);
				System.out.println("Updated amount in account id " + m_accountId + " to " + m_amount);
			}
			else {
				System.out.println("Call the police! Unsecure access!!");
			}
		}
	}
	
	int GetAccountId() {
		return m_accountId;
	}
	
	String GetAccountName() {
		return m_accountName;
	}
	
	int GetCustomerId() {
		return m_customerId;
	}
	
	double GetAmount() {
		return m_amount;
	}

	private void SetAccountId(int accountId) {
		m_accountId = accountId;
	}

	private void SetAccountName(String accountName) {
		m_accountName = accountName;
	}
	
	private void SetCustomerId(int customerId) {
		m_customerId = customerId;
	}
	
	private void SetAmount(double amount) {
		m_amount = amount;
	}

}
