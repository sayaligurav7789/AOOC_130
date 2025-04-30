package Ex3;

import java.util.Scanner;

class BankAccount {
    double balance;

    void setBalance() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Initial balance: ");
        balance = sc.nextDouble();
    }

    void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Deposit amount: ");
        double amount = sc.nextDouble();
        balance += amount;
    }

    void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Withdraw amount: ");
        double amount = sc.nextDouble();
        balance -= amount;
    }
}

class SavingsAccount extends BankAccount {

    void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Withdraw amount: ");
        double amount = sc.nextDouble();
        if (balance - amount < 100) {
	    System.out.println("Insufficient balance! Minimum $100 required.");
        } else {
            balance -= amount;
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        SavingsAccount a = new SavingsAccount();

        a.setBalance();
        a.deposit();
        a.withdraw();

        System.out.println("Final Balance: $" + a.balance);
    }
}

