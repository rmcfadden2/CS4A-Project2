public class CreditAccount extends BankAccount{
    private final double limit;
    private final double withdrawFee;

    CreditAccount()
    {
        super();
        this.limit = 1000;
        this.withdrawFee = 100;
    }

    CreditAccount(double balance, String accountHolder, String accountNumber, int accountType, double limit, double withdrawFee)
    {
        super(balance, accountHolder, accountNumber, accountType);
        this.limit = limit;
        this.withdrawFee = withdrawFee;
    }

    CreditAccount(String accountHolder, String accountNumber, int accountType, double limit, double withdrawFee)
    {
        super(accountHolder, accountNumber, accountType);
        this.limit = limit;
        this.withdrawFee = withdrawFee;
    }


    CreditAccount(String accountHolder, String accountNumber, int accountType)
    {
        super(accountHolder, accountNumber, accountType);
        this.limit = 1000;
        this.withdrawFee = 100;
    }

    public double getLimit()
    {
        return this.limit;
    }

    public double getWithdrawFee()
    {
        return this.withdrawFee;
    }

    @Override
    public void withdraw(double amount)//throws insufficientFunds;
    {
        try
        {
            double tempBal = this.getBalance();
            tempBal -= (amount + withdrawFee);
            if(tempBal < (limit * -1))
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
            // need exception class
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
