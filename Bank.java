import java.util.HashMap;
import java.util.Map;
public class Bank {
    private String bankName;
    private Map<String, Account> accounts;

    public Bank(String bankName){
        this.bankName = bankName;
        accounts = new HashMap<>();
    }

    public String getBankName(){
        return bankName;
    }

    public void addAccount(Account account){
        accounts.put(account.getAccountNum(), account);
    }

    public Account getAccount(String accountNum){
        return accounts.get(accountNum);
    }

    public boolean transfer(String fromAccountNum, String toAccountNum, double amount){
        Account fromAccount = getAccount(fromAccountNum);
        Account toAccount = getAccount(toAccountNum);
        if(fromAccount != null && toAccount != null){
            return fromAccount.transfer(toAccount, amount);
        }
        return false;
    }

    @Override
    public String toString(){
        return "Bank: " + bankName
        + "\nAccounts: {" + accounts + "}";
    }
}
