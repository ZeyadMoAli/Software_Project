package Transactions;

import Service.Iservice;
import User.Customer;
import ServiceProvider.*;

public class PaymentTransaction implements Itransaction{

    private double amount = 0;
    private double discount=0;
    private double NetAmount= amount - discount;
    private static int count=0;
    private  int  transactionID;
    private Customer customer;
    private Iservice iservice;
    private IserviceProvider iserviceProvider;
    private boolean refundStates = false;


    public PaymentTransaction(Customer c, Iservice is, IserviceProvider isp, double amount, double discount)
    {
        customer=c;
        iservice=is;
        iserviceProvider=isp;
        count++;
        transactionID=count;
        this.amount= amount;
        this.discount=discount;
        NetAmount= amount - (amount * (discount/100));
    }
    public PaymentTransaction()
    {
        count++;
        transactionID=count;

    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getNetAmount() {
        return NetAmount;
    }

    public void setNetAmount(double netAmount) {
        NetAmount = netAmount;
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


    public Iservice GetService() {
        return iservice;
    }


    public void SetService(Iservice iservice) {
    this.iservice=iservice;
    }


    public IserviceProvider GetServiceProvicer() {
        return iserviceProvider;
    }


    public void SetServiceProvider(IserviceProvider iserviceProvider) {
        this.iserviceProvider=iserviceProvider;

    }

    public String getCustomerName()
    {
        return customer.GetUsername();
    }

    public String getServiceProviderName()
    {
        return iserviceProvider.getname();
    }
    public String getServiceName()
    {
        return iservice.getName();
    }






}
