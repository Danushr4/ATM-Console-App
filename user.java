package org.pcap4j.Atm;

import org.pcap4j.Atm.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class user {
    private List<Customer> users = new ArrayList<>();
    private Scanner in = new Scanner(System.in);

    public user() {

        users.add(new Customer("John Doe", 1234567890, "Canara", 1234, 5000));
        users.add(new Customer("Jane Smith", 987654210, "kvB", 5678, 10000));
    }

    void withdraw(Admin admin) {
        System.out.println("Enter the Account number:");
        long acc = in.nextLong();
        System.out.println("Enter the amount to withdraw:");
        long amt = in.nextLong();
        for (Customer cs : users) {
            if (cs.getAccountNumber() == acc) {
                long bal = cs.getBalance();
                if (bal >= amt) {
                    bal -= amt;
                    cs.setBalance(bal);
                    admin.reduceBalance(amt);
                    System.out.println("Withdrawn successfully. Updated balance: " + bal);
                } else {
                    System.out.println("Insufficient balance.");
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    void deposit(Admin admin) {
        System.out.println("Enter the Account number:");
        long acc = in.nextLong();
        System.out.println("Enter the amount to deposit:");
        long amt = in.nextLong();
        for (Customer cs : users) {
            if (cs.getAccountNumber() == acc) {
                long bal = cs.getBalance();
                bal += amt;
                cs.setBalance(bal);
                admin.increaseBalance(amt);
                System.out.println("Deposited successfully. Updated balance: " + bal);
                return;
            }
        }
        System.out.println("Account not found.");
    }


    void balance() {
        System.out.println("Enter the Account number:");
        long acc = in.nextLong();
        for (Customer cs : users) {
            if (cs.getAccountNumber() == acc) {
                System.out.println("Balance for account " + acc + " is: " + cs.getBalance());
                return;
            }
        }
        System.out.println("Account not found.");
    }

    void pin() {
        System.out.println("Enter the Account number:");
        long acc = in.nextLong();
        System.out.println("Enter new PIN:");
        int newPin = in.nextInt();
        for (Customer cs : users) {
            if (cs.getAccountNumber() == acc) {
                cs.setPin(newPin);
                System.out.println("PIN updated successfully for account " + acc);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void main() {

        System.out.println("Enter the choice:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Pin Set");

        Admin ad= new Admin();

        int choice = in.nextInt();

        switch (choice) {
            case 1:
                withdraw(new Admin());
                break;
            case 2:
                deposit(new Admin());
                break;
            case 3:
                balance();
                break;
            case 4:
                pin();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
