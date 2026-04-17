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

    public boolean Withdraw(double amount, bankAccount account)
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

    public boolean Deposit(double amount, bankAccount account)
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

    public boolean Transfer(double amount, bankAccount account1, bankAccount account2)
    {
        boolean success = false;

        try
        {
            Withdraw(amount,account1);
        }
        catch(Exception e)
        {
            System.out.println("Canceling Operation...");
            return success;
        }

        try 
        {
            Deposit(amount,account2);
            success = true;
        } 
        catch (Exception e) 
        {
            System.out.println("Canceling Operation...");
            Deposit(amount,account1);
        }

        return success;
    };

    public void DisplayInfo(bankAccount account)
    {
        System.out.println(account.toString());    
    };

    public bankAccount FindAccount(String name) throws Exception // replace
    {
        ArrayList<bankAccount> userAccounts = new ArrayList<bankAccount>();
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
                Scanner input = new Scanner(System.in);
                System.out.println("Account List:");

                for(int i = 0; i < userAccounts.size(); ++i)
                {
                    System.out.println(i + ": " + userAccounts.get(i).getHolder() + " - " + userAccounts.get(i).getAccountNumber());
                }

                System.out.println("Select the account you want to change:");

                try
                {
                    accountIndex = input.nextInt();
                    input.close();
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
        }

        return null;
    };

    public bankAccount getAccount(String accountNumber) throws Exception // replace
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

    public void DisplayAccounts()
    {
        System.out.println("All Accounts:");

        for(int i = 0; i < accounts.size(); ++i)
        {
            System.out.println(i + ": " + accounts.get(i).getHolder() + " - " + accounts.get(i).getAccountNumber());
        }
    };
}