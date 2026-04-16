public abstract class bankAccount {

    private double balance;
    private String accountHolder;
    private final String accountNumber;
    private final int accountType;

    protected bankAccount() {
        balance = 0;
        accountHolder = "John Doe";
        accountNumber = "00000000";
        accountType = -1;
    }

    protected bankAccount(double balance, String accountHolder, String accountNumber, int accountType) {
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    //Seperate constructor that doesn't set balance in order for balance to be set seperatly in child class constructors where needed
    protected bankAccount(String accountHolder, String accountNumber, int accountType) {
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
        return "\nAccount Holder: " + this.accountHolder + 
                "\nAccount Number: " + this.accountNumber + 
                "\nAccount Type: " + this.accountType +
                "\nAccount Balance" + this.balance + "\n";
    }

    //Abstract methods must be created in child classes, throws insufficientFunds commented out until exception is created
    public abstract void withdraw(double amount); //throws insufficientFunds;
    public abstract void deposit(double amount);

}