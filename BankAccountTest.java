
public class BankAccountTest {

	public static void main(String[] args) {
		
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		BankAccount account3 = new BankAccount(5000, 250.50);
		
		account3.getTotalBalance();
		account1.deposit(532.00, 134.45);
		account1.getTotalBalance();
		account2.deposit(1000.89, 644.75);
		account1.withdraw(100.00, 0);
		account2.getTotalBalance();
		account1.getTotalBalance();
		
		account1.withdraw(1000.00, 0);
	}

}
