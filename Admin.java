package org.pcap4j.Atm;

import java.util.*;

public class Admin {
    private Map<String, Long> bankDetails = new HashMap<>();
    private List<Customer> customers = new ArrayList<>();
    private Map<Long, List<String>> transactions = new HashMap<>();
    public long balance = 100000000;
    private long last;
    private Scanner scanner = new Scanner(System.in);

    public Admin() {

        bankDetails.put("Canara", 123456789L);
        bankDetails.put("Kvb", 987654321L);
        bankDetails.put("Icici", 987654321L);


        customers.add(new Customer("rd", 4, "Canara"));
        customers.add(new Customer("ak", 7, "Kvb"));
        customers.add(new Customer("rdx", 3, "Icici"));


        List<String> rd = new ArrayList<>();
        rd.add("Withdraw $100");
        List<String> ak = new ArrayList<>();
        ak.add("Deposit $500");
        transactions.put(4L, rd);
        transactions.put(7L, ak);
    }
    public void reduceBalance(long amount) {
        balance -= amount;
    }

    public void increaseBalance(long amount) {
        balance += amount;
    }


    public class AtmAdmin {
        public void addBank() {
            char ch = 'Y';
            while (ch != 'N') {
                System.out.println("Enter the Bank Name:");
                String bankName = scanner.next();
                System.out.println("Enter the IFSC Code:");
                Long ifsc = scanner.nextLong();

                bankDetails.put(bankName, ifsc);

                System.out.println("Do you want to continue (Y/N)");
                ch = scanner.next().charAt(0);
            }
        }

        public void showBankDetails() {
            for (Map.Entry<String, Long> entry : bankDetails.entrySet()) {
                System.out.println("Bank Name: " + entry.getKey() + " IFSC Code: " + entry.getValue());
            }
        }

        public void showCustomerDetails() {
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }
        }

        public void showTransactionDetails() {
            for (Map.Entry<Long, List<String>> entry : transactions.entrySet()) {
                System.out.println("Account number: " + entry.getKey());
                for (String transaction : entry.getValue()) {
                    System.out.println(transaction);
                }
            }
        }

        public void showBalance() {
            System.out.println("Balance: " + balance);
            System.out.println("Last Updated: " + last);
        }

        public void refillBalance(long amount) {
            last = balance;
            balance = amount;
            System.out.println("Refilled Successfully!!");
        }
    }

    public class BankAdmin {
        private String bankName;
        private long AccNo;

        public BankAdmin(String bankName) {
            this.bankName = bankName;
        }

        public void showCustomerDetails() {
            for (Customer customer : customers) {
                if (customer.getBankName().equals(bankName)) {
                    System.out.println(customer.toString());
                }
            }
        }

    }

    public  void Main() {
        Scanner in = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.println("Enter the choice:");
        System.out.println("1. Atm Admin");
        System.out.println("2. Bank Admin");
        int choice = admin.scanner.nextInt();
        switch (choice) {
            case 1:
                Admin.AtmAdmin atmAdmin = admin.new AtmAdmin();
                System.out.println("1. Add Bank ");
                System.out.println("2. Bank Details ");
                System.out.println("3. Customer Details");
                System.out.println("4. Transaction Details");
                System.out.println("5. Balance");
                System.out.println("6. Refill");
                int np = in.nextInt();
                switch (np) {
                    case 1:
                        atmAdmin.addBank();
                        break;
                    case 2:
                        atmAdmin.showBankDetails();
                        break;
                    case 3:
                        atmAdmin.showCustomerDetails();
                        break;
                    case 4:
                        atmAdmin.showTransactionDetails();
                        break;
                    case 5:
                        atmAdmin.showBalance();
                        break;
                    case 6:
                        System.out.println("Enter the amount to refill:");
                        long refillAmt = in.nextLong();
                        atmAdmin.refillBalance(refillAmt);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                break;
            case 2:
                System.out.println("Bank Name");
                System.out.println("1. Canara");
                System.out.println("2. KVB");
                System.out.println("3. ICICI");
                int ch = in.nextInt();
                switch (ch) {
                    case 1:
                        Admin.BankAdmin canaraBankAdmin = admin.new BankAdmin("Canara");
                            canaraBankAdmin.showCustomerDetails();

                        break;
                    case 2:
                        Admin.BankAdmin kvbBankAdmin = admin.new BankAdmin("KVB");

                            kvbBankAdmin.showCustomerDetails();

                        break;
                    case 3:
                        Admin.BankAdmin iciciBankAdmin = admin.new BankAdmin("ICICI");

                            iciciBankAdmin.showCustomerDetails();

                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}

