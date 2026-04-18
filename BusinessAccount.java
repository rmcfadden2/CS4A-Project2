public class BusinessAccount  extends BankAccount {
    private String businessName;
    private double minimumBalance;

    BusinessAccount()
    {
        super();
        businessName = "Business Name";
        minimumBalance = 10000;
    }
    
    BusinessAccount(double balance, String accountHolder, String accountNumber,
                     int accountType, String businessName, double minimumBalance)
    {
        super(balance, accountHolder, accountNumber, accountType);
        this.businessName = businessName;
        this.minimumBalance = minimumBalance;
    }

    BusinessAccount(String accountHolder, String accountNumber, int accountType, String businessName, double minimumBalance)
    {
        super(accountHolder, accountNumber, accountType);
        this.businessName = businessName;
        this.minimumBalance = minimumBalance;
    }

    BusinessAccount(String accountHolder, String accountNumber, int accountType, String businessName)
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
    public void withdraw(double amount) //throws insufficientFunds;
    {
        try
        {
            double tempBal = this.getBalance();
            tempBal -= amount;
            if(tempBal < this.minimumBalance)
            {
                // need exception class
            }
            else
            {
                this.setBalance(tempBal);
            }
        }
        catch()
        {

        }
    }

    @Override
    public void deposit(double amount)
    {
        double tempBal = this.getBalance();
        tempBal += amount;
        this.setBalance(tempBal);
    }
}
