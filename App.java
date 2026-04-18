import java.util.*;

public class App 
{
    public static void main(String[] args) throws Exception
    {
        final double WITHDRAW_FEE = 2.5;
        final double CREDIT_LIMIT = 2000.0;

        BankManager manager = new BankManager();
        Scanner     input   = new Scanner(System.in);
        int         menuSelection, accountSelection;
        String      nameInput, nameInput2;
        double      amount;
        String      business;

        menuSelection = 0;

        do
        {
            System.out.println("Bank Menu:\n1. Create Account\n2. Withdraw Money\n3. Deposit Money\n4. Transfer Money to Another Account\n5. View Account Info\n6. Show All Account");
            
            try 
            {
                System.out.print("\nSelect Option (0 to exit): ");
                menuSelection = input.nextInt();

                switch (menuSelection) 
                {
                    case 1: // Add
                        input.nextLine();

                        System.out.print("Enter holder name: ");
                        nameInput = input.nextLine();

                        System.out.println("Account Types:\n1. Checking\n2. Savings\n3. Credit\n4. Business");
                        System.out.print("\nEnter type(1 - 4): ");
                        
                        accountSelection = input.nextInt();

                        switch(accountSelection)
                        {
                            case 1:
                                manager.AddAccount(new CheckingAccount(nameInput,manager.GetNewId(),accountSelection,WITHDRAW_FEE));
                            break;

                            case 2:
                                //manager.AddAccount(new SavingsAccount(nameInput,manager.GetNewId(),accountSelection,0.1));
                            break;

                            case 3:
                                manager.AddAccount(new CreditAccount(nameInput,manager.GetNewId(),accountSelection,CREDIT_LIMIT,WITHDRAW_FEE));
                            break;

                            case 4:
                                input.nextLine();
                                System.out.print("\nName of business: ");
                                business = input.nextLine();

                                manager.AddAccount(new BusinessAccount(nameInput,manager.GetNewId(),accountSelection,business));
                            break;

                            default:
                                throw new Exception("Exiting...");
                        }
                    break;

                    case 2: // Withdraw
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        System.out.print("Enter amount: ");
                        amount = input.nextDouble();

                        manager.Withdraw(amount, manager.FindAccount(nameInput,input));
                    break;

                    case 3: // Deposit
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        System.out.print("Enter amount: ");
                        amount = input.nextDouble();

                        manager.Deposit(amount, manager.FindAccount(nameInput,input));
                    break;

                    case 4: // Transfer
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        System.out.print("Who will you transfer to?: ");
                        nameInput2 = input.nextLine();

                        System.out.print("Enter amount: ");
                        amount = input.nextDouble();

                        manager.Transfer(amount, manager.FindAccount(nameInput,input),manager.FindAccount(nameInput2,input));
                    break;

                    case 5: // View Account
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        manager.DisplayInfo(manager.FindAccount(nameInput,input));
                    break;

                    case 6: // View All Accounts
                        manager.DisplayAccounts();
                    break;
                
                    default:
                        throw new Exception("Exiting...");
                }    
                
                System.out.println();
            } 
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
                continue;
            }
        }
        while(menuSelection > 0 && menuSelection < 7);

        input.close();
    }
}
