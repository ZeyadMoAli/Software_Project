package User;
import Database.*;
import PaymentOptions.*;
import Service.*;
import ServiceProvider.*;
import Transactions.*;

import java.util.*;

public class Customer implements IUser {
    private String username;
    private String email;
    private String password;
    private double discount_amount = 0;
    private CraditCard craditCard = new CraditCard();
    private Wallet wallet = new Wallet();

    Customer() {
    }

    public Customer(String username, String email, String password) {
        SetUsername(username);
        SetEmail(email);
        SetPassword(password);
    }

    public void AddToWallet(int balance) {
        wallet.AddBalance(craditCard, balance);
    }

    public void upDateDiscount(double amount) {
        this.discount_amount = amount;
    }
    public void Register(CustomerDataManager customerDataManager) {
        customerDataManager.addCustomer(this);
    }

    public Boolean Login(CustomerDataManager customerDataManager) {
        if (customerDataManager.FindCustomer(this)) {
            return true;
        }
        return false;

    }
    Iservice Search(String s, ServiceDataManger serviceDataManger)
    {
        return serviceDataManger.Search(s);
    }
    public double Getdiscount()
    {
        return this.discount_amount;
    }

    public  void Pay(double amount, IserviceProvider iserviceProvider)
    {
        String  s;
        Scanner scn=new Scanner(System.in);
        if (iserviceProvider.CashState())
        {
            System.out.println("Enter Payment option (Credit, Wallet ,Cash)");
            s = scn.nextLine();
            if(s.equals("Credit"))
            {
                craditCard.pay(amount);
            }else if(s.equals("Wallet"))
            {
                wallet.pay(amount);
            }
        }
        else {
            System.out.println("Enter Payment option (Credit, Wallet)");
            s = scn.nextLine();
            if(s.equals("Credit"))
            {
                craditCard.pay(amount);
            }else if(s.equals("Wallet"))
            {
                wallet.pay(amount);
            }

        }
    }

    @Override
    public String GetUsername() {
        return this.username;
    }

    @Override
    public String GetEmail() {
        return this.email;
    }

    @Override
    public String GetPassword() {
        return this.password;
    }

    @Override
    public void SetUsername(String Username) {
        username = Username;
    }

    @Override
    public void SetEmail(String Email) {
        email = Email;
    }

    @Override
    public void SetPassword(String Password) {
        password = Password;
    }

    public Boolean refund(int id, TransactionDataManager transactionDataManager) {
        Transaction transaction= transactionDataManager.transactionSearch(id);

        if(transaction==null)
            return false;
        else {
            transactionDataManager.FromTransactiontoRefund(transaction);
            return true;

        }

    }

    public double GetWalletBalance()
    {
        return wallet.balance;
    }
    public double GetCreditBalance()
    {
        return craditCard.GetBalance();
    }
}
