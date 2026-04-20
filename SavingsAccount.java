public class SavingsAccount extends BankAccount implements InterestBearing {
    private final int withdrawLimit = 400;
    private double interestRate = 0.02;  // Bank defined value

    // Account type data type might need to be changed
    public SavingsAccount(String accountHolder, String accountNumber, int accountType)
    {
        super(accountHolder, accountNumber, accountType); // Initialize parent attributes
    }

    @Override
    public double calculateInterest()
    {
        return getBalance() * interestRate;
    }

    @Override
    public void applyInterest() {
        setBalance(getBalance() + calculateInterest());
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount > withdrawLimit)
        {
            throw new InsufficientFundsException("Exceeds withdraw limit.");
        }
        if(amount > getBalance())
        {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

}
