import java.util.Random;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance = 0;
	private double savingsBalance = 0;
	private static int numberOfAccounts = 0;
	private static double totalAccountBalance = 0;
	private static ArrayList<String> accountList = new ArrayList<String>();
	
	DecimalFormat df = new DecimalFormat("#.00");
	
	private void accountNumGenerator() {
		Random r = new Random();
		int set1 = r.nextInt(900) + 100;
		int set2 = r.nextInt(900) + 100;
		int set3 = r.nextInt(9000) + 1000;
		String newAccountNumber = set1 + "-" + set2 + "-" + set3;
		for(int i=0; i<accountList.size(); i++) {
			if(newAccountNumber == accountList.get(i)) {
				Random rand = new Random();
				int set4 = rand.nextInt(900) + 100;
				int set5 = rand.nextInt(900) + 100;
				int set6 = rand.nextInt(9000) + 1000;
				newAccountNumber = set4 + "-" + set5 + "-" + set6;
				i = 0;
			}
		}
		accountList.add(accountNumber);
		this.accountNumber = newAccountNumber;
		System.out.println("Your new account number is: " + accountNumber);
	}
	
	public double getCheckingBalance(BankAccount account) {
		double balance = this.checkingBalance;
		System.out.print("Checking balance: $" + df.format(balance));
		return balance;
	}
	
	public double getSavingsBalance(BankAccount account) {
		double balance = this.savingsBalance;
		System.out.print("Savings balance: $" + df.format(balance));
		return balance;
	}
	
	public void getTotalBalance() {
		double checking = this.checkingBalance;
		double savings = this.savingsBalance;
		totalAccountBalance = checking + savings;
		double total = totalAccountBalance;
		System.out.println("Checking: $" + df.format(checking) + "; Savings: $" + df.format(savings) + "; Total: $" + df.format(total));
	}
	
	public void deposit(double checking, double savings) {
		this.checkingBalance += checking;
		this.savingsBalance += savings;
		totalAccountBalance = this.checkingBalance + this.savingsBalance;
		double total = totalAccountBalance;
		
		System.out.println("Deposited: $" + df.format(checking) + " into Checking, $" + df.format(savings) + " into Savings; Deposited: $" + df.format(total) + " total.");
	}
	
	public void withdraw(double checking, double savings) {
		if(0 > (this.checkingBalance - checking)) {
			System.out.println("Insufficient Funds: Unable to complete transaction.");
		}
		if(0 > (this.savingsBalance - savings)) {
			System.out.println("Insufficient Funds: Unable to complete transaction.");
		}
		else if(0 < (this.checkingBalance - checking) && (0 < (this.savingsBalance - savings))) {
			this.checkingBalance = this.checkingBalance - checking;
			this.savingsBalance = this.savingsBalance - savings;
			totalAccountBalance = this.checkingBalance + this.savingsBalance;
			double total = checking + savings;
			System.out.println("Withdrew: $" + df.format(checking) + " from Checking, $" + df.format(savings) + " from Savings; Withdrew: $" + df.format(total) + " total.");
		}
		
	}
	
	public BankAccount() {
		accountNumGenerator();
		numberOfAccounts++;
	}
	public BankAccount(double value1, double value2) {
		accountNumGenerator();
		numberOfAccounts++;
		deposit(value1, value2);
	}
	
	
	
}
