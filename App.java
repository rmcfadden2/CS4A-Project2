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
            System.out.println("Bank Menu:\n1. Create Account\n2. Withdraw Money\n3. Deposit Money\n4. Transfer Money to Another Account\n5. View Account Info\n6. Show All Accounts\n7. End of Month Processing");
            
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
                                manager.addAccount(new CheckingAccount(nameInput,manager.getNewId(),accountSelection));
                            break;

                            case 2:
                                manager.addAccount(new SavingsAccount(nameInput,manager.getNewId(),accountSelection));
                            break;

                            case 3:
                                manager.addAccount(new CreditAccount(nameInput,manager.getNewId(),accountSelection,CREDIT_LIMIT,WITHDRAW_FEE));
                            break;

                            case 4:
                                input.nextLine();
                                System.out.print("\nName of business: ");
                                business = input.nextLine();

                                manager.addAccount(new BusinessAccount(nameInput,manager.getNewId(),accountSelection,business));
                            break;

                            default:
                                throw new Exception("Exiting...");
                        }
                    break;

                    case 2: // withdraw
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        System.out.print("Enter amount: ");
                        amount = input.nextDouble();

                        manager.withdraw(amount, manager.findAccount(nameInput,input));
                    break;

                    case 3: // deposit
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        System.out.print("Enter amount: ");
                        amount = input.nextDouble();

                        manager.deposit(amount, manager.findAccount(nameInput,input));
                    break;

                    case 4: // transfer
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        System.out.print("Who will you transfer to?: ");
                        nameInput2 = input.nextLine();

                        System.out.print("Enter amount: ");
                        amount = input.nextDouble();

                        manager.transfer(amount, manager.findAccount(nameInput,input),manager.findAccount(nameInput2,input));
                    break;

                    case 5: // View Account
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        manager.displayInfo(manager.findAccount(nameInput,input));
                    break;

                    case 6: // View All Accounts
                        manager.displayAccounts();
                    break; 
                    case 7:
                        manager.applyInterest();
                        System.out.println("Monthly interest applied.");
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
        while(menuSelection > 0 && menuSelection < 8);

        input.close();
    }
}
