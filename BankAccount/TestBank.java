// import javafx.application.Application;

public class TestBank {
    public static void main(String[] args) {

        BankAccount eloy = new BankAccount("eloy", 25.0, 5.5);

        eloy.accountCount();
        eloy.getCheckingAccountBalance();
        eloy.getSavingsAccountBalance();
        eloy.checkingDeposit(10000);
        eloy.savingsDeposit(99.9);
        eloy.getCheckingAccountBalance();
        eloy.getSavingsAccountBalance();
        eloy.checkingWithdraw(11000);
        eloy.checkingWithdraw(5000);
        eloy.getCheckingAccountBalance();
        eloy.savingsWithdraw(200);
        eloy.savingsWithdraw(50.75);
        eloy.getSavingsAccountBalance();
        eloy.myAccountsTotals();

        BankAccount vigil = new BankAccount("vigil", 250.0, 25.5);

        vigil.accountCount();
        vigil.allAccountsTotal();
    
    }
}