package org.pcap4j.Atm;

import org.pcap4j.Atm.Admin;
import org.pcap4j.Atm.user;

import java.util.Scanner;

public class Atm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the choice:");
        System.out.println("1. Admin");
        System.out.println("2. User");
        int choice = in.nextInt();

        switch (choice) {
            case 1:

                System.out.println("Atm Panel");
                Admin ad = new Admin();
                ad.Main();
                break;
            case 2:
                System.out.println("User Panel");
                user user = new user();
                user.main();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
