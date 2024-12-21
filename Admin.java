public class Admin {
    private String adminName;
    private Bank bank;

    public Admin(String adminName, Bank bank){
        this.adminName = adminName;
        this.bank = bank;
    }

    public void setAdminName(String name){
        adminName = name;
    }

    public String getAdminName(){
        return adminName;
    }

    public Bank getBank(){
        return bank;
    }

    public void setBank(Bank bank){
        this.bank = bank;
    }

    public void printAccountTransactions(String accountNum){
        Account account = bank.getAccount(accountNum);

        if(account != null){
            System.out.println("Transaction History for account: " + accountNum);
            for(Transaction transaction : account.getTransactionHistory()){
                System.out.println(transaction);
            }

        }
        else{
            System.out.println("Account not found");
        }
    }

    @Override
    public String toString(){
        return "Admin: " + adminName + '\'' +
                ", bank=" + bank;
    }


}
