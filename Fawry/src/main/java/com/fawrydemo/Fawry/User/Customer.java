package com.fawrydemo.Fawry.User;
import com.fawrydemo.Fawry.Database.*;
import com.fawrydemo.Fawry.Factories.*;
import com.fawrydemo.Fawry.Service.*;
import com.fawrydemo.Fawry.ServiceProvider.*;
import com.fawrydemo.Fawry.Transactions.*;
import com.fawrydemo.Fawry.PaymentOptions.*;
import java.util.*;

public class Customer implements IUser {
    private String username;
    private String email;
    private String password;
    private static double discount = 0;
    private Wallet wallet = new Wallet();

    private CraditCard craditCard = new CraditCard();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount_amount) {
        discount = discount_amount;
    }
    public Customer() {}



    public Customer(String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }
    public boolean AddToWallet(double balance , TransactionDataManager transactionDataManager) {
        if( wallet.AddBalance(craditCard, balance))
        {
            AddtoWalltedTransaction  addtoWalltedTransaction=new AddtoWalltedTransaction(balance,this);
            transactionDataManager.AddWalletTransaction(addtoWalltedTransaction);
            return true;
        }
        return false;
    }
    public double checkServiceDiscount(int choice)
    {
        ServiceFactory serviceFactory=new ServiceFactory();
        Iservice iservice= serviceFactory.makeObj(choice);
        return iservice.getDiscount();
    }
    public PaymentTransaction makeService(int serviceChoice,int serviceProviderChoice, double amount, TransactionDataManager transactionDataManager)
    {
        ServiceFactory serviceFactory=new ServiceFactory();
        Iservice iservice= serviceFactory.makeObj(serviceChoice);
        IserviceProviderFactory serviceProviderFactory = new ServiceProviderFactory();
        IserviceProvider iserviceProvider = serviceProviderFactory.makeObj(serviceProviderChoice);
        iserviceProvider.FillForm(this.getUsername());
        PaymentTransaction itransaction =new PaymentTransaction(this, iservice,iserviceProvider,amount,iservice.getDiscount()+ this.getDiscount());
        if(Pay(itransaction.getNetAmount(), iserviceProvider ))
        {
            transactionDataManager.AddtoPaymentTransaction(itransaction);
            return itransaction;
        }
        return null ;


    }

    public void upDateDiscount(double amount) {
        this.discount = amount;
    }
    public Customer SignUp(CustomerDataManager customerDataManager) {
        Customer customer =new Customer();
        customer=customerDataManager.FindCustomer(this);
        if(customer == null )
        {
            customerDataManager.addCustomer(this);
            return this;
        }
        return null;

    }

    public Customer SignIn(CustomerDataManager customerDataManager) {
        return customerDataManager.FindCustomer(this);

    }
    public Iservice Search(String serviceName, ServiceDataManger serviceDataManger)
    {
        return serviceDataManger.Search(serviceName);
    }

    public  boolean Pay(double amount, IserviceProvider iserviceProvider)
    {
        int  choice;
        Scanner scn=new Scanner(System.in);
        if (iserviceProvider.CashState())
        {
            System.out.println("Enter The number of your choice");
            System.out.println("1.Credit Card");
            System.out.println("2.Wallet");
            System.out.println("3.Cash");
            choice= scn.nextInt();
            if(choice==1)
            {
                return craditCard.pay(amount);
            }else if(choice==2)
            {
               return wallet.pay(amount);
            }
            else
                return true;
        }
        else {
            System.out.println("Enter The number of your choice");
            System.out.println("1.Credit Card");
            System.out.println("2.Wallet");
            choice= scn.nextInt();
            if(choice==1)
            {
                return craditCard.pay(amount);
            }else if(choice==2)
            {
                return wallet.pay(amount);
            }
        }
        return false;
    }

    public Boolean RefundRequest(int id, TransactionDataManager transactionDataManager) {
        PaymentTransaction transaction= transactionDataManager.transactionSearch(id);
        if(transaction==null)
            return false;
        else {
            transactionDataManager.FromPaymentTransactionToRefund(transaction);
            return true;

        }

    }
    public double GetWalletBalance()
    {
        return wallet.GetBalance();
    }
    public double GetCreditBalance()
    {
        return craditCard.GetBalance();
    }
}
