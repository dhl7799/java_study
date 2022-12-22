package prob05;

public class Account {
	private String accountNumber;
	private int balance;
	public Account(String anum) {
		this.accountNumber = anum;
		this.balance = 0;
	}
	public String getAccountNo() {
		return accountNumber;
	}
	public void setAccountNo(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void save(int money) {
		this.balance += money;
	}
	public void deposit(int money) {
		this.balance -= money;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
