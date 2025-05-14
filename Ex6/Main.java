package Ex6;

import java.util.Scanner;

class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    void setBalance() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        balance = sc.nextDouble();
    }

    void deposit() throws NegativeNumberException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();

        if (amount < 0) {
            throw new NegativeNumberException("Cannot deposit a negative amount.");
        }

        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    void withdraw() throws LowBalanceException, NegativeNumberException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        if (amount < 0) {
            throw new NegativeNumberException("Cannot withdraw a negative amount.");
        }

        if (amount > balance) {
            throw new LowBalanceException("Insufficient balance.");
        }

        balance -= amount;
        System.out.println("Amount withdrawn successfully.");
    }

    void balanceEnquiry() {
        System.out.println("Current balance: ₹" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Scanner sc = new Scanner(System.in);
        account.setBalance();

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Balance Enquiry\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        account.deposit();
                        break;
                    case 2:
                        account.withdraw();
                        break;
                    case 3:
                        account.balanceEnquiry();
                        break;
                    case 4:
                        System.out.println("Thank you for banking with us!");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NegativeNumberException | LowBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
