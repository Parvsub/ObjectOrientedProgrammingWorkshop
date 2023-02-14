package com.objectOreientedProgrammes;
import java.util.Scanner;

class Bank {
    private String accountNumber;
    private String name;
    private long balance;

    Scanner scanner = new Scanner(System.in);


    void openAccount() {
        System.out.print("Enter Account No: ");
        accountNumber = scanner.next();
        System.out.print("Enter Name: ");
        name = scanner.next();
        System.out.print("Enter Balance: ");
        balance = scanner.nextLong();

    }


    void showAccount() {
        System.out.println(accountNumber+ "," + name + ","+ balance);
    }


    void deposit() {
        long amount;
        System.out.println("Enter Amount You Want to Deposit : ");
        amount = scanner.nextLong();
        balance = balance + amount;
    }


    void withdrawal() {
        long amount;
        System.out.println("Enter Amount You Want to withdraw : ");
        amount = scanner.nextLong();
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }


    boolean search(String accountNumber) {
        if (accountNumber.equals(accountNumber)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class BankAccountDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("How Many Customer You Want to Input : ");
        int n = scanner.nextInt();
        Bank[] detail = new Bank[n];
        for (int i = 0; i < detail.length; i++) {
            detail[i] = new Bank();
            detail[i].openAccount();
        }


        int choice;
        do {
            System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.E xit ");
            System.out.println("Ur Choice :"); choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (Bank bank : detail) {
                        bank.showAccount();
                    }
                    break;

                case 2:
                    System.out.print("Enter Account No. You Want to Search...: ");
                    String acn = scanner.next();
                    boolean found = false;
                    for (Bank bank : detail) {
                        found = bank.search(acn);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account No : ");
                    acn = scanner.next();
                    found = false;
                    for (Bank bank : detail) {
                        found = bank.search(acn);
                        if (found) {
                            bank.deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number : ");
                    acn = scanner.next();
                    found = false;
                    for (Bank bank : detail) {
                        found = bank.search(acn);
                        if (found) {
                            bank.withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 5:
                    System.out.println("Good Bye..");
                    break;
            }
        }
        while (choice != 5);
    }

}