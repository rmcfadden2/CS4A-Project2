public class CreditAccount extends BankAccount implements InterestBearing {
    private final double limit;
    private final double withdrawFee;
    private final double interestRate = 0.05;
    // Constructors are public so it is 
    // accesible from App
    public CreditAccount()
    {
        super();
        this.limit = 1000;
        this.withdrawFee = 100;
    }

    public CreditAccount(double balance, String accountHolder, String accountNumber, int accountType, double limit, double withdrawFee)
    {
        super(balance, accountHolder, accountNumber, accountType);
        this.limit = limit;
        this.withdrawFee = withdrawFee;
    }

    public CreditAccount(String accountHolder, String accountNumber, int accountType, double limit, double withdrawFee)
    {
        super(accountHolder, accountNumber, accountType);
        this.limit = limit;
        this.withdrawFee = withdrawFee;
    }


    public CreditAccount(String accountHolder, String accountNumber, int accountType)
    {
        super(accountHolder, accountNumber, accountType);
        this.limit = 1000;
        this.withdrawFee = 100;
    }

    public double getWithdrawFee()
    {
        return this.withdrawFee;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException
    {
        double tempBal = this.getBalance();
        tempBal -= (amount + withdrawFee);
        if(tempBal < (limit * -1))
        {
            throw new InsufficientFundsException("Unable to withdraw " + amount);
        }
        else
        {
            this.setBalance(tempBal);
        }
    }

    @Override
    public void deposit(double amount)
    {
        double tempBal = this.getBalance();
        tempBal += amount;
        this.setBalance(tempBal);
    }

    @Override
    public void applyInterest()
    {
        double interest = calculateInterest();
        deposit(interest);
    }

    @Override
    public double calculateInterest()
    {
        return getBalance() * interestRate;
    }

}
