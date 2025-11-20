package com.Day4.lab;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Withdrawal failed! Insufficient funds. Available balance: $" + balance
            );
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
    }

    public double getBalance() {
        return balance;
    }
}

public class Banking {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Nyra", 1000.0);
        try {
            account.deposit(200);
            account.withdraw(1500); // triggers exception
        } catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        System.out.println("Final Balance: $" + account.getBalance());
    }
}
