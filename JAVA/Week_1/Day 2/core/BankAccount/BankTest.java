public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts

        BankAccount account1 = new BankAccount(0, 0);
        BankAccount account2 = new BankAccount(10, 0);
        BankAccount account3 = new BankAccount(0, 0);
        // Deposit Test

        account1.depositToCheckingAccount(10);
        account1.depositToSavingsAccount(30);
        account2.depositToCheckingAccount(20);
        account2.depositToSavingsAccount(70.5);
        account3.depositToCheckingAccount(11);
        account3.depositToSavingsAccount(100.5);
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        //account1.getBalance();
        //account2.getBalance();
        //account3.getBalance();
        // - each deposit should increase the amount of totalMoney
        // Withdrawal Test
        account1.withdrawFromChecking(10);
        account1.withdrawFromSavings(20);
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        account1.getBalance();
        
        // - each withdrawal should decrease the amount of totalMoney
        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println(BankAccount.accounts);
        System.out.println(BankAccount.totalMoney);

    }
}