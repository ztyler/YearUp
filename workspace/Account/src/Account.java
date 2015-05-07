import static java.lang.System.out;

public class Account {
	public int m_accountId = -1,
			m_customerId = -1;
	public String m_accountName;
	public double m_amount = 0.0;
	
	public Account(int accountId, String accountName, int customerId) {
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
				out.printf("Updated amount in account id %s to %d",
						m_accountId,
						m_amount);
			}
			else {
				out.println("Call the police! Unsecure access!");
			}
		}
	}
}
