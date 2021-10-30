package com.bridgelabz.uc2_DebitAmount;

import java.util.Scanner;

public class Account {
    double accountBalance;

    /**
     * Constructor to initialize account balance
     * @param accountBalance fetch data from user
     */
    public Account(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * debit method is used to debit amount from the account balance
     * if debit amount exceed account balance, balance remains unchanged
     */
    public void debit() {
        Scanner sc = new Scanner(System.in);
        boolean toDebit = false;
        while (!toDebit) {
            System.out.println("Enter \n1.To debit amount \n2.To exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter amount to debit");
                    int debitAmount = sc.nextInt();
                    if (debitAmount < accountBalance) {
                        accountBalance -= debitAmount;
                        System.out.println("Debit amount is : " + debitAmount);
                        System.out.println("Updated Account balance is : " + accountBalance);
                    } else {
                        System.out.println("Debit amount exceeded Account balance");
                    }
                }
                case 2 -> toDebit = true;
            }
        }
    }

    /**
     * fetch account balance from user initially
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account balance : ");
        Account accountObj = new Account(sc.nextDouble());
        accountObj.debit();
    }
}
