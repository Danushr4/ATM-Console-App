package org.pcap4j.Atm;

class Customer {
    private String name;
    private long accountNumber;
    private String bankName;

    private int pin;

    private long balance;

    public Customer(String name, long accountNumber, String bankName) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    public Customer(String name, long accountNumber, String bankName,int pin,long balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.pin=pin;
        this.balance=balance;
    }

    public String getName() {
        return name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public int getPin() {
        return pin;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long bal) {
        this.balance=bal;
    }

    public void setPin(int pin) {
        this.pin=pin;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Account Number: " + accountNumber + " Bank Name: " + bankName;
    }
}
