import java.util.Scanner;
public class main {
    private static Bank bank = new Bank("___ Bank");
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        AccountCreation accountCreation = new AccountCreation(bank);

        while (true){
            displayMenu();
            int choice = scnr.nextInt();
            scnr.nextLine();

            switch(choice){
                case 1:
                    accountCreation.createAccount(scnr);
                    break;
                case 2:
                    performDeposit(scnr);
                    break;
                case 3:
                    performWithdrawal(scnr);
                    break;
                case 4:
                    performTransfer(scnr);
                    break;
                case 5:
                    adminAccess(scnr);
                    break;
                case 6:
                    displayAccountDetails(scnr);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.err.println("Invalid choice, please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nWelcome to " + bank.getBankName() + "\n");
        System.out.println("1. Create an Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Admin Access");
        System.out.println("6. Display Account Details");
        System.out.println("7. Exit\n");
        System.out.print("Enter your choice: ");
    }

    private static void performDeposit(Scanner scnr){
        //Scanner scnr = new Scanner(System.in);

        System.out.println("Enter account number: ");
        String accountNum = scnr.nextLine();
        Account account = bank.getAccount(accountNum);
        
        if(account != null){
            System.out.println("Enter amount to deposit: ");
            double amount = scnr.nextDouble();

            if(account.deposit(amount)){
                System.out.println("Deposit complete. Updated account details: " + account);
            }
            else{
                System.out.println("Deposit failed.  Please try again. ");
                
            }
        }
        else{
            System.out.println("Account not found. Please check account number entered. ");
        }
        
    }
    
    private static void performWithdrawal(Scanner scnr){
        //Scanner scnr = new Scanner(System.in);

        System.out.println("Enter account number: ");
        String accountNum = scnr.nextLine();
        Account account = bank.getAccount(accountNum);

        if(account != null){
            System.out.println("Enter amount to withdraw: ");
            double amount = scnr.nextDouble();

            if(account.withdraw(amount)){
                System.out.println("Withdrawal succesful.  Updated account details: " + account);
            }
            else{
                System.out.println("Insufficient funds or invalid amount.  Please try again.");
            }

        }
        else{
            System.out.println("Account not found. Please check account number entered. ");
        }
      

    }

    private static void performTransfer(Scanner scnr){
        //Scanner scnr = new Scanner(System.in);

        System.out.println("Enter account number: ");
        String fromAccountNum = scnr.nextLine();
        Account fromAccount = bank.getAccount(fromAccountNum);

        if(fromAccount != null){
            System.out.println("Enter receiving account number: ");
            String toAccountNum = scnr.nextLine();
            Account toAccount = bank.getAccount(toAccountNum);

            if(toAccount != null){
                System.out.println("Enter amount to transfer: ");
                double amount = scnr.nextDouble();

                if(bank.transfer(fromAccountNum, toAccountNum, amount)){
                    System.out.println("Transfer successful.");
                    System.out.println("Updated account details - From Account: " + fromAccount);
                    System.out.println("Updated account details - To Account: " + toAccount);
                }

                else{
                    System.out.println("Transfer failed.  Please check account numbers");
                }
            }
            else{
                System.out.println("Transfer failed.  Please check account number");
            }
        }
        else{
            System.out.println("Account nt found, please check account number");
        }

    }

    private static void adminAccess(Scanner scnr){
        //Scanner scnr = new Scanner(System.in);
        Admin admin = new Admin("Admin", bank);
        System.out.println("Enter account number to view transactions: ");
        String accountNum = scnr.nextLine();
        admin.printAccountTransactions(accountNum);

    }

    private static void displayAccountDetails(Scanner scnr){
        System.out.println("Enter account number: ");
        String accountNum = scnr.nextLine();
        Account account = bank.getAccount(accountNum);

        if(account != null){
            System.out.println("\n=== Account Details ===");
            System.out.println("Account Holder: " + account.getAccountName());
            System.out.println("Account Number: " + account.getAccountNum());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("=======================\n");
        }
        else{
            System.out.println("Account not found.");
        }
    }

}
