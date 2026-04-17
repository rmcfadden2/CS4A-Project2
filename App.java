import java.util.*;

public class App 
{
    public static void main(String[] args) throws Exception
    {
        BankManager manager = new BankManager();
        Scanner     input   = new Scanner(System.in);
        int         menuSelection;
        String      nameInput, nameInput2;
        double      amount;

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
                        
                    break;

                    case 2: // Withdraw
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        System.out.print("Enter amount: ");
                        amount = input.nextDouble();

                        manager.Withdraw(amount, manager.FindAccount(nameInput));
                    break;

                    case 3: // Deposit
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        System.out.print("Enter amount: ");
                        amount = input.nextDouble();

                        manager.Deposit(amount, manager.FindAccount(nameInput));
                    break;

                    case 4: // Transfer
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        System.out.print("Who will you transfer to?: ");
                        nameInput2 = input.nextLine();

                        System.out.print("Enter amount: ");
                        amount = input.nextDouble();

                        manager.Transfer(amount, manager.FindAccount(nameInput),manager.FindAccount(nameInput2));
                    break;

                    case 5: // View Account
                        input.nextLine(); 

                        System.out.print("Enter your name: ");
                        nameInput = input.nextLine();

                        manager.DisplayInfo(manager.FindAccount(nameInput));
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
