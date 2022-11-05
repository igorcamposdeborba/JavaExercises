package withdrawException;

public class Account {
	private Integer idAccount;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
    public Account(Integer idAccount, String holder, Double initialBalance) throws IllegalArgumentException {
		if (idAccount == null || idAccount < 0 
			|| holder == null || holder == ""
			|| initialBalance == null || initialBalance <= 0.0) {
				throw new IllegalArgumentException("Revise os dados digitados da criacao da conta");
		} else {
			this.idAccount = idAccount;
			this.holder = holder;
			this.balance = initialBalance;
			this.withdrawLimit = withdrawLimitCalc(initialBalance); // calculate withdraw limit based on initial balance
		}
	}
	
	// Access methods
	public int getIdAccount() {
		return idAccount;
	}
	public String getHolder() {
		return holder;
	}
	public double getBalance() {
		return balance;
	}
	public double getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public void setHolder(String holder) {
		this.holder = holder ;
	}
	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	
	// Logic methods
	public void deposit(double amount) {
		this.balance = amount;
	}
	public double withdrawLimitCalc(Double initialBalance) {
		return initialBalance * 0.7;
	}
	
	public void withdraw(double amountWithdraw) throws withoutBalanceException {
		// Exception
		if (amountWithdraw > withdrawLimit) { 
			throw new withoutBalanceException("Saque superior ao limite permitido de R$ " + String.format("%.2f", withdrawLimit));
		}
		balance -= amountWithdraw;
	}
	
	
}
