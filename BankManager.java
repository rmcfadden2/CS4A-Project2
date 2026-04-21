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
            if(amount <= 0)
            {
                throw new Exception("Cannot withdraw amount.");
            }

            account.withdraw(amount);
            success = true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return success;
    };

    public boolean deposit(double amount, BankAccount account)
    {
        boolean success = false;

        try
        {
            if(amount <= 0)
            {
                throw new Exception("Cannot deposit amount.");
            }

            account.deposit(amount);
            success = true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
        try
        {
            System.out.println(account.toString());    
        }
        catch(Exception e)
        {
            System.out.println("Canceling Operation...");
        }
    };

    public BankAccount findAccount(String name, Scanner input) throws AccountNotFoundException
    {
        ArrayList<BankAccount> userAccounts = new ArrayList<BankAccount>();
        int accountIndex = 0;
        // Doing too much
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
                throw new AccountNotFoundException("No account found.");
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
        catch(AccountNotFoundException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

        return accounts.get(accountIndex);
    };

    public BankAccount getAccount(String accountNumber) throws AccountNotFoundException
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

            throw new AccountNotFoundException("Account not found.");
        }
        catch(AccountNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void displayAccounts() throws AccountNotFoundException
    {
        try
        {
            if(accounts.size() == 0) 
            {
                throw new AccountNotFoundException("No accounts in system.");
            }

            System.out.println("\nAll Accounts:\n");

            for(int i = 0; i < accounts.size(); ++i)
            {
                System.out.println("  Holder: " + accounts.get(i).getHolder() + " - Account Num: " + accounts.get(i).getAccountNumber());
            }
        }
        catch(AccountNotFoundException e)
        {
            System.out.println(e.getMessage());
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
