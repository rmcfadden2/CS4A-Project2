public abstract class BankAccount {

    private double balance;
    private String accountHolder;
    private final String accountNumber;
    private final int accountType;

    protected BankAccount() {
        balance = 0;
        accountHolder = "John Doe";
        accountNumber = "00000000";
        accountType = -1;
    }

    protected BankAccount(double balance, String accountHolder, String accountNumber, int accountType) {
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    //Seperate constructor that doesn't set balance in order for balance to be set seperatly in child class constructors where needed
    protected BankAccount(String accountHolder, String accountNumber, int accountType) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    //Getters and setters
    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getHolder() {
        return this.accountHolder;
    }

    public void setHolder(String holder) {
        this.accountHolder = holder;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getAccountType() {
        return this.accountType;
    }

    @Override
    public String toString(){
        String accountType;

        switch (this.accountType) 
        {
            case 1:
                accountType = "Checking";
            break;

            case 2:
                accountType = "Savings";
            break;

            case 3:
                accountType = "Credit";
            break;

            case 4:
                accountType = "Business";
            break;
        
            default:
                accountType = "Null";
        }

        return "\nAccount Holder:  "  + this.accountHolder + 
                "\nAccount Number:  " + this.accountNumber + 
                "\nAccount Type:    " + accountType        +
                "\nAccount Balance: " + this.balance;
    }

    //Abstract methods must be created in child classes, throws insufficientFunds commented out until exception is created
    public abstract void withdraw(double amount); //throws insufficientFunds;
    public abstract void deposit(double amount);

}