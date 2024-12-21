import java.util.List;
import java.util.ArrayList;

public class Account {
    private String accountNumber; //Identification number of account
    private String accountName; //Name of account holder
    private double balance;
    protected List<Transaction> transactionHistory; // withdrawels, deposits, transfers of account

    public Account(String accountNumber, String accountName, double Initialbalance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = Initialbalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNum(){
        return accountNumber;
    }

    public String getAccountName(){
        return accountName;
    }

    public double getBalance(){
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public boolean deposit(double amount){
        if(amount > 0){
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount, balance));
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount){
        if(amount < balance && amount > 0){
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount, balance));
            return true;
        }
        else{
            System.out.println("Insufficient Withdrawal Amount");
            return false;
        }

    }

    public boolean transfer(Account target, double amount){
        if(this.withdraw(amount)){
            target.deposit(amount);
            transactionHistory.add(new Transaction("Transfer to " + target.getAccountNum(), amount, balance));
            target.getTransactionHistory().add(new Transaction("Transfer from " + this.accountNumber, amount, target.getBalance()));
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Account Holder: " + accountName
        + "\nAccount Number: " + accountNumber
        + "\nBalance: " + balance;
    }
}
