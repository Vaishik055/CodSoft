import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner sc) {
        switch (choice) {
            case 1:
                System.out.println("Current Balance: " + account.getBalance());
                break;

            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = sc.nextDouble();
                account.deposit(depositAmount);
                break;

            case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = sc.nextDouble();
                account.withdraw(withdrawAmount);
                break;

            case 4:
                System.out.println("Thank you for using ATM.");
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            BankAccount account = new BankAccount(1000.0);
            ATM atm = new ATM(account);

            int choice;

            do {
                atm.showMenu();
                System.out.print("Choose an option: ");
                choice = sc.nextInt();
                atm.performTransaction(choice, sc);
            } while (choice != 4);
        }
    }
}