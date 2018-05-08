package pl.waw.sgh.bank;

public class PlayWithBank {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer c1 = bank.createCustomer("Anne", "Brown", "anne@brown.com");
        Customer c2 = bank.createCustomer("James", "Black", "james@black.com");

        Account acc1 = bank.createAccount(c1, false);
        Account acc2 = bank.createAccount(c1, true);
        Account acc3 = bank.createAccount(c2, false);
        Account acc4 = bank.createAccount(c2, true);

        System.out.println(bank);
    }
}