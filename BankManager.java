import java.util.*;

public class BankManager
{
    private ArrayList<BankAccount> accounts;

    public BankManager()
    {
        accounts = new ArrayList<>();
    };

    public boolean addAccount(BankAccount newAccount)
    {
        boolean success = false;

        try
        {
            accounts.add(newAccount);
            success = true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return success;
    };

    public boolean withdraw(double amount, BankAccount account)
    {
        boolean success = false;

        try
        {
            account.withdraw(amount);
            success = true;
        }
        catch(Exception e)
        {
            System.out.println("Canceling Operation...");
        }

        return success;
    };

    public boolean deposit(double amount, BankAccount account)
    {
        boolean success = false;

        try
        {
            account.deposit(amount);
            success = true;
        }
        catch(Exception e)
        {
            System.out.println("Canceling Operation...");
        }

        return success;
    };

    public boolean transfer(double amount, BankAccount account1, BankAccount account2)
    {
        boolean success = false;

        try
        {
            withdraw(amount,account1);
        }
        catch(Exception e)
        {
            System.out.println("Canceling Operation...");
            return success;
        }

        try 
        {
            deposit(amount,account2);
            success = true;
        } 
        catch (Exception e) 
        {
            System.out.println("Canceling Operation...");
            deposit(amount,account1);
        }

        return success;
    };

    public void displayInfo(BankAccount account)
    {
        System.out.println(account.toString());    
    };

    public BankAccount findAccount(String name, Scanner input) throws Exception // replace
    {
        ArrayList<BankAccount> userAccounts = new ArrayList<BankAccount>();
        int accountIndex = 0;

        try
        {
            for(int i = 0; i < accounts.size(); ++i)
            {
                if(accounts.get(i).getHolder().equals(name))
                {
                    userAccounts.add(accounts.get(i));
                    accountIndex = i;
                }
            }

            if(userAccounts.size() == 1)
            {
                return accounts.get(accountIndex);
            }
            else if(userAccounts.size() == 0)
            {
                throw new Exception("No account found.");
            }
            else
            {
                System.out.println("Account List:");

                for(int i = 0; i < userAccounts.size(); ++i)
                {
                    System.out.println(i + ": " + userAccounts.get(i).getHolder() + " - Account Num: " + userAccounts.get(i).getAccountNumber());
                }

                System.out.print("Select the account: ");

                try
                {
                    accountIndex = input.nextInt();
                }
                catch(Exception e)
                {
                    System.out.println("Exiting...");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

        return accounts.get(accountIndex);
    };

    public BankAccount getAccount(String accountNumber) throws Exception // replace
    {
        try
        {
            for(int i = 0; i < accounts.size(); ++i)
            {
                if(accounts.get(i).getAccountNumber().equals(accountNumber))
                {
                    return accounts.get(i);
                }
            }

            throw new Exception("Account not found.");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void displayAccounts()
    {
        System.out.println("\nAll Accounts:\n");

        for(int i = 0; i < accounts.size(); ++i)
        {
            System.out.println("  Holder: " + accounts.get(i).getHolder() + " - Account Num: " + accounts.get(i).getAccountNumber());
        }
    };

    public String getNewId()
    {
        return String.valueOf(accounts.size());
    }

    // Bank manager should be able to apply interest to a customer's accounts:
    public void applyInterest() {
    for (BankAccount acc : accounts) {
        if (acc instanceof InterestBearing) {
            ((InterestBearing) acc).applyInterest();
        }
    }
}
}
