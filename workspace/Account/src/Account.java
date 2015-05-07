import static java.lang.System.out;

public class Account {
	private int m_accountId = -1,
			m_customerId = -1;
	private String m_accountName;
	private double m_amount = 0.0;
	
	//Constructor
	public Account(int accountId, String accountName, int customerId) {
		m_accountId = accountId;
		m_accountName = accountName;
		m_customerId = customerId;
	}
	
	//Actions
	private void UpdateAmount(double newAmount) {
		m_amount = newAmount;
	}
	
	public void UpdateAmountSecurely(double newAmount, String password) {
		if (password != null) {
			if (password.equals("admin")) {
				UpdateAmount(newAmount);
				out.printf("Updated amount in account id %s to $%.2f\n",
						m_accountId,
						m_amount);
			}
			else {
				out.println("Call the police! Unsecure access!");
			}
		}
	}
	
	//Getters
	public int GetAccountId() {
		return m_accountId;
	}
	public int GetCustomerId() {
		return m_customerId;
	}
	public String GetAccountName() {
		return m_accountName;
	}
	public double GetAmount() {
		return m_amount;
	}
	
	//Setters
	public void SetAccountId(int accountId) {
		m_accountId = accountId;
	}
	public void SetCustomerId(int customerId) {
		m_customerId = customerId;
	}
	public void SetAccountName(String accountName) {
		m_accountName = accountName;
	}
	public void SetAmount(double amount) {
		m_amount = amount;
	}
}
