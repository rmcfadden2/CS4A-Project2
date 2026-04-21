public class BusinessAccount  extends BankAccount implements InterestBearing {
    private String businessName;
    private double minimumBalance;
    private final double interestRate = 0.03;

    public BusinessAccount()
    {
        super();
        businessName = "Business Name";
        minimumBalance = 10000;
    }
    
    public BusinessAccount(double balance, String accountHolder, String accountNumber,
                     int accountType, String businessName, double minimumBalance)
    {
        super(balance, accountHolder, accountNumber, accountType);
        this.businessName = businessName;
        this.minimumBalance = minimumBalance;
    }

    public BusinessAccount(String accountHolder, String accountNumber, int accountType, String businessName, double minimumBalance)
    {
        super(accountHolder, accountNumber, accountType);
        this.businessName = businessName;
        this.minimumBalance = minimumBalance;
    }

    public BusinessAccount(String accountHolder, String accountNumber, int accountType, String businessName)
    {
        super(accountHolder, accountNumber, accountType);
        this.businessName = businessName;
        this.minimumBalance = 10000;
    }

    public void setBusiness(String businessName)
    {
        this.businessName = businessName;
    }

    public String getBusiness()
    {
        return this.businessName;
    }

    public double getMinimumBalance()
    {
        return this.minimumBalance;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException
    {
        double tempBal = this.getBalance();
        tempBal -= amount;
        if(tempBal < this.minimumBalance)
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
