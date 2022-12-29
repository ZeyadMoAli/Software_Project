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
        this.discount = discount_amount;
    }
    public Customer() {}



    public Customer(String username, String email, String password) {
        SetUsername(username);
        SetEmail(email);
        SetPassword(password);
    }
    public boolean AddToWallet(double balance) {
        return wallet.AddBalance(craditCard, balance);
    }

    public void upDateDiscount(double amount) {
        this.discount = amount;
    }
    public Customer Register(CustomerDataManager customerDataManager) {
        Customer customer =new Customer();
        customer=customerDataManager.FindCustomer(this);
        if(customer == null )
        {
            customerDataManager.addCustomer(this);
            return this;
        }
        return null;

    }

    public Customer Login(CustomerDataManager customerDataManager) {
        return customerDataManager.FindCustomer(this);

    }
    Iservice Search(String s, ServiceDataManger serviceDataManger)
    {
        return serviceDataManger.Search(s);
    }
    public double Getdiscount()
    {
        return this.discount;
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
