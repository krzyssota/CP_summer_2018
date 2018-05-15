package pl.waw.sgh.bank;

import pl.waw.sgh.bank.exceptions.InvalidAmountException;
import pl.waw.sgh.bank.exceptions.NonExistantAccountException;

public class PlayWithBank {

    public static void main(String[] args) throws InvalidAmountException {
        Bank bank = new Bank();
        Customer c1 = bank.createCustomer("Anne","Brown","anne@brown.com");
        Customer c2 = bank.createCustomer("John","Smith","john@smith.com");

        Account acc1 = bank.createAccount(c1, false);
        Account acc2 = bank.createAccount(c1, true);
        Account acc3 = bank.createAccount(c2, false);
        Account acc4 = bank.createAccount(c2, true);

        acc1.deposit(100);

        try {
            bank.transfer(5, 1, -100);
            System.out.println(bank);
        } catch (InvalidAmountException | NonExistantAccountException e) {
            System.out.println(e.getMessage());
        }
       /* catch (InvalidAmountException e){
            System.out.println(e.getMessage());
        } catch (NonExistantAccountException e){
            System.out.println(e.getMessage());
        }*/
//Add code that will handle exceptions for cases:
//1. Negative amount passed to charge/deposit/transfer
//2. Account used in transfer does not exist


    }
}
