package Transactions;

import Service.Iservice;
import User.Customer;
import ServiceProvider.*;
import Forms.*;

public class Transaction implements Itransaction{


    static int count=0;
    static int  transactionID;
    public Customer customer;
    public Iservice iservice;
    public IserviceProvider iserviceProvider;
    public  PaymentForm paymentForm;


    public boolean refundStates = false;


    @Override
    public void seTrefundStatus(Boolean state) {
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

    @Override
    public Iservice GetService() {
        return iservice;
    }

    @Override
    public void SetService(Iservice iservice) {
    this.iservice=iservice;
    }

    @Override
    public IserviceProvider GetServiceProvicer() {
        return iserviceProvider;
    }

    @Override
    public void SetServiceProvider(IserviceProvider iserviceProvider) {
        this.iserviceProvider=iserviceProvider;

    }

    @Override
    public PaymentForm GetPaymentForm() {
        return paymentForm;
    }

    @Override
    public void SetPaymentForm(PaymentForm paymentForm) {
        this.paymentForm=paymentForm;

    }



    public Transaction(Customer c, Iservice is, IserviceProvider isp, PaymentForm pf)
    {
        customer=c;
        iservice=is;
        iserviceProvider=isp;
        count++;
        transactionID=count;
        paymentForm=pf;
    }
    public Transaction()
    {
        count++;
        transactionID=count;

    }




}
