
public class Main {

	public static void main(String[] args) {
		Account savingsAccount = new Account(123, "Savings", 456);
		savingsAccount.UpdateAmountSecurely(500, "admin");
		savingsAccount.UpdateAmountSecurely(0, "thief");
		
		System.out.println("Updated amount in account id " + savingsAccount.GetAccountId() + " to " + savingsAccount.GetAmount());

	}
}
