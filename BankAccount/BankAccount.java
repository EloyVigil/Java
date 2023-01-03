// import javafx.application.Application;

public class BankAccount {
    private String name;
    private double checkingBalance;
    private double savingsBalance; 
    private static int numOfAccounts = 0;
    private static double bankTotals = 0;

    public BankAccount(String name, double checkingBalance, double savingBalance){
        this.name = name;
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingBalance;
        numOfAccounts++;
        // bankTotals += checkingBalance + savingBalance;
    }

    public static int accountCount(){
        System.out.println(numOfAccounts);
        return numOfAccounts;
    }


    public double getCheckingAccountBalance(){
        System.out.println(checkingBalance);
        return checkingBalance;
    }

    public double getSavingsAccountBalance(){
        System.out.println(savingsBalance);
        return savingsBalance;
    }

    public void checkingDeposit(double deposit){
        checkingBalance += deposit;
        bankTotals += deposit;
    }

    public void savingsDeposit(double deposit){
        savingsBalance += deposit;
        bankTotals += deposit;
    }

    public void checkingWithdraw(double withdraw){
        if(this.checkingBalance - withdraw < 0){
            System.out.println("!Insufficient funds!");
        }
        else{
            this.checkingBalance -= withdraw;
            System.out.println("Your balance is now " + checkingBalance);
            bankTotals -= withdraw;
            }
    }

    public void savingsWithdraw(double withdraw){
        if(this.savingsBalance - withdraw < 0){
            System.out.println("!Insufficient funds!");
        }
        else{
            this.savingsBalance -= withdraw;
            System.out.println("Your balance is now " + savingsBalance);
            bankTotals -= withdraw;
            }
    }

    public void myAccountsTotals(){
        System.out.println("Your total from checking:$ " + checkingBalance);
        System.out.println("and your total savings:$ " + savingsBalance);
        double totalBalance = savingsBalance + checkingBalance;
        System.out.println("Your total balance is " + totalBalance);
    }

    public double allAccountsTotal(){
        System.out.println("The banks total is: " + bankTotals);
        return bankTotals;
    }

}