public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    public static int accounts = 0;
    public static double totalMoney; // refers to the sum of all bank account checking and savings balances
    // CONSTRUCTOR
    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.totalMoney = checkingBalance + savingsBalance;
        accounts += 1; 
    }
    // Be sure to increment the number of accounts
    // GETTERS
    // for checking, savings, accounts, and totalMoney

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public int getNumOfAccounts(){
        return accounts;
    }

    public double getTotalMoney(){
        return totalMoney;
    }
    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public String depositToCheckingAccount(double sum){
        this.checkingBalance += sum; 
        totalMoney += sum;
        return "Your deposit to Checkings Accounts operation is succesfull";
    }
    public String depositToSavingsAccount(double sum){
        this.savingsBalance += sum; 
        totalMoney += sum;
        return "Your deposit to the Savings Account operation is succesfull";
    }
    
    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    
    public void withdrawFromChecking(double sum){
        if (this.checkingBalance - sum >= 0 ){
            this.checkingBalance -= sum;
            totalMoney -= sum;
            System.out.println("Withdrawal from Checking account is succesfull");
        }
        else {
            System.out.println("Your funds are insufficient, try again later");
        }
    }

    public String withdrawFromSavings(double sum){
        if (this.savingsBalance - sum >= 0 ){
            this.savingsBalance -= sum;
            totalMoney = totalMoney - sum;
            return "Withdrawal from Savings account is succesfull";
        }
        else {
            return "Your funds are insufficient, try again later";
        }
    }
    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public void getBalance(){
        System.out.printf("Checking Balance of : %s %n", this.checkingBalance);
        System.out.printf("Savings Balance of : %s %n", this.savingsBalance);
        System.out.printf("Total Balance of : %s %n", totalMoney);
    }
    
}
