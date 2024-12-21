import java.util.Scanner;

public class AccountCreation {
    private Bank bank;

    public AccountCreation(Bank bank){
        this.bank = bank;
    }

    public void createAccount(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter Account Holder's name ");
        String accountName = scnr.nextLine();
        String accountNum = generateAccountNum();
        double Initialbalance = 0.0;
        Account account = new Account(accountNum, accountName, Initialbalance);
        bank.addAccount(account);
        System.out.println("Account successfully created: " + account);
        scnr.close();
    }

    //Generates random string of numbers
    private String generateAccountNum() {
        return String.format("%09d", (int)(Math.random() * 1_000_000_000));
    }

}
