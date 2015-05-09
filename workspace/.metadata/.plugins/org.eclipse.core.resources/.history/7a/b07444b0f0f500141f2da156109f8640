
public class Main {

	public static void main(String[] args) {
		
		Account savingsAccount = new Account(123, "Savings", 456);
		savingsAccount.UpdateAmountSecurely(500, "admin");
		
		savingsAccount.UpdateAmountSecurely(0, "thief");
		
		savingsAccount.SetAmount(0);
		System.out.printf("Updated amount in account ID %d to $%.2f\n",
				savingsAccount.GetAccountId(),
				savingsAccount.GetAmount());
	}

}
