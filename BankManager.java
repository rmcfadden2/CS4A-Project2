import java.util.*;

public class BankManager
{
    private ArrayList<bankAccount> accounts;

    public BankManager()
    {
        accounts = new ArrayList<>();
    };

    public boolean AddAccount(bankAccount newAccount)
    {
        boolean success = false;

        return success;
    };

    public boolean Withdraw(double amount, bankAccount account) throws Exception // replace 
    {
        boolean success = false;

        return success;
    };

    public boolean Deposit(double amount, bankAccount account) throws Exception // replace 
    {
        boolean success = false;

        return success;
    };

    public boolean Deposit(double amount, bankAccount account1, bankAccount account2) throws Exception // replace 
    {
        boolean success = false;

        return success;
    };

    public void DisplayInfo(bankAccount account)
    {

    };

    public bankAccount FindAccount(String name) throws Exception // replace
    {

        return accounts.get(0);
    };

    public void DisplayAccounts()
    {

    };
}