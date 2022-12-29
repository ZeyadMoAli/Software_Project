package Transactions;

import User.Customer;

public class AddtoWalltedTransaction implements Itransaction{

    private double amount  =0;
    private boolean refundStates = false;
    private int count=0;
    private  int  transactionID;
    private Customer customer;

    public AddtoWalltedTransaction(double amount,  Customer customer) {
        this.amount = amount;
        count++;
        this.transactionID = count;
        this.customer = customer;
    }

    @Override
    public void setRefundStatus(Boolean state) {
        this.refundStates=state;
    }

    @Override
    public boolean GetRefundStatus() {
        return refundStates;
    }

    @Override
    public int GetTransactionId() {
        return this.transactionID;
    }

    @Override
    public Customer Getcustomer() {
        return customer;
    }

    @Override
    public void SetCustomer(Customer customer) {
        this.customer=customer;
    }
}
