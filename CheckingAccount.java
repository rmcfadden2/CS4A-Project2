public class CheckingAccount extends BankAccount
{
    private double withdrawFee;

    CheckingAccount()
    {
        super();
        this.withdrawFee = 100;
    }

    CheckingAccount(double balance, String accountHolder, String accountNumber, int accountType, double withdrawFee)
    {
        super(balance, accountHolder, accountNumber, accountType);
        this.withdrawFee = withdrawFee;
    }

    CheckingAccount(String accountHolder, String accountNumber, int accountType, double withdrawFee)
    {
        super(accountHolder, accountNumber, accountType);
        this.withdrawFee = withdrawFee;
    }
}