package pl.waw.sgh.bank;

import pl.waw.sgh.bank.exceptions.InvalidAmountException;
import pl.waw.sgh.bank.exceptions.NonExistantAccountException;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<Customer> custList = new ArrayList<>();

    List<Account> accList = new ArrayList<>();

    private Integer lastCustID = 0;

    private Integer lastAccID = 0;

    public Customer createCustomer(String firstName,
                                   String lastName,
                                   String email) {
        Customer customer = new Customer(lastCustID++,firstName, lastName, email);
        custList.add(customer);
        return customer;
    }
    public Account createAccount(Customer customer, boolean isSavings) {
        Account account = (isSavings ?
                new SavingsAccount(lastAccID++, new BigDecimal(0), customer)
                :
                new DebitAccount(lastAccID++, new BigDecimal(0), customer)
        );
        accList.add(account);
        return account;
    }

    public void deleteCustomerAndHisHersAccounts (Integer custId) {
       deleteCustomer(custId);
        deleteAccounts(custId);
    }

    public void deleteCustomer (Integer custId) {
        Customer custToDel = findCustomerById(custId);
        custList.remove(custToDel);
    }

    public void deleteAccounts (Integer custId) {
        List<Account> accToDel = findAccountsByCustId(custId);
        int i=accToDel.size()-1;
        while (i>=0) {
            accList.remove(accToDel.get(i));
            i--;
        }
    }

    public List<Account> findAccountsByCustId(Integer custId){
        List<Account> allAccWithCustId= new ArrayList<>();
        for (Account acc : accList) {
           if ( custId.equals(acc.getCustomer().getCustomerID())) {
               allAccWithCustId.add(acc);
           }
        }
        return allAccWithCustId;
    }

    public Customer findCustomerById(int id) {
        for (Customer cust : custList) {
            if (id==cust.getCustomerID())
                return cust;
        }
        return null;
    }

    public void transfer(Integer fromAccId, Integer toAccId, double amount) throws InvalidAmountException, NonExistantAccountException {
        Account fromAcc = findAccountById(fromAccId);
        Account toAcc = findAccountById(toAccId);
        fromAcc.charge(amount);
        toAcc.deposit(amount);
    }

    public Account findAccountById(int id) throws NonExistantAccountException{
        // iterate through the account list and return the account with a given id
        for (Account acc : accList) {
            //if (id.equals(acc.getAccountID()))
            if (id == acc.getAccountID())
                return acc;
        }
        throw new NonExistantAccountException (
                "Chosen account does not exist.");
    }



    @Override
    public String toString() {
        return "Bank{" +
                "cust=" + custList +
                "\nacc=" + accList +
                '}';
    }
}
