public class CheckingAccount extends BankAccount
{
    private final float overdraftFee;
    private final float overdraftLimit;

    CheckingAccount()
    {
        super();
        this.overdraftFee = 50.0f;
        this.overdraftLimit = 0.0f;
    }

    CheckingAccount(double balance, String accountHolder, String accountNumber, int accountType, double withdrawFee)
    {
        super(balance, accountHolder, accountNumber, accountType);
        this.overdraftFee = 50.0f;
        this.overdraftLimit = 1000.0f;
    }

    CheckingAccount(String accountHolder, String accountNumber, int accountType, double withdrawFee)
    {
        super(accountHolder, accountNumber, accountType);
        this.overdraftFee = 50.0f;
        this.overdraftLimit = 1000.0f;
    }

    CheckingAccount(String accountHolder, String accountNumber, int accountType)
    {
        super(accountHolder, accountNumber, accountType);
        this.overdraftFee = 50.0f;
        this.overdraftLimit = 1000.0f;
    }

    public double getOverdraftLimit()
    {
        return this.overdraftLimit;
    }

    public double getOverdraftFee()
    {
        return this.overdraftFee;
    }

    public boolean isOverLimit(double amount)
    {
        return (this.getBalance() - amount) < (0 - this.overdraftLimit);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException
    {
        if(isOverLimit(amount)) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        else if ((this.getBalance() - amount) < 0) {
            this.setBalance(this.getBalance() - amount - this.overdraftFee);
        }
        else {
            this.setBalance(this.getBalance() - amount);
        }
    }

    @Override
    public void deposit(double amount)
    {
        this.setBalance(this.getBalance() + amount);
    }
}