import java.util.Scanner;
public class main {
    private static Bank bank = new Bank("Goon Bank");
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        AccountCreation accountCreation = new AccountCreation(bank);

        while (true){
            displayMenu();
            int choice = scnr.nextInt();
            scnr.nextLine();

            switch(choice){
                case 1:
                    accountCreation.createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    adminAccess();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.err.println("Invalid choice, please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Welcome to " + bank.getBankName());
        System.out.println("1. Create an Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Admin Access");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void performDeposit(){
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter account number: ");
        String accountNum = scnr.nextLine();
        Account account = bank.getAccount(accountNum);
    }
    //Testing
}
