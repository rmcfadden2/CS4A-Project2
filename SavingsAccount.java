public class SavingsAccount extends BankAccount implements InterestBearing {
    // AI ideas
    private int withdrawLimit = 400;
    private double interestRate = 0.02;  // Bank defined value

    public SavingsAccount(String holder, String accountNumber)
    {
        super(accountHolder, accountNumber, accountType);
    }

    public int getLimit()
    {
        return withdrawLimit;
    }

    // public SavingsAccount() {
    //     super();
    //     interestRate = 0.01f; // Default interest rate of 1%
    // }

    // public SavingsAccount(double balance, String accountHolder, String accountNumber, int accountType, float interestRate) {
    //     super(balance, accountHolder, accountNumber, accountType);
    //     this.interestRate = interestRate;
    // }

    // public SavingsAccount(String accountHolder, String accountNumber, int accountType, float interestRate) {
    //     super(accountHolder, accountNumber, accountType);
    //     this.interestRate = interestRate;
    // }
    @Override
    public double calculateInterest()
    {
        return balance * interestRate;
    }

    @Override
    public void applyInterest() {
        balance += calculateInterest();
    }
    
}
