package User;
import Database.*;
import Factories.DiscountFactory;
import Service.Iservice;

public class Admin implements IUser {
    private String username;
    private String email;
    private String password;

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

    public Admin(){};
    public Admin(String username,String email,String password){
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }
    public  void HandleRefund(TransactionDataManager transactionDataManager)
    {
        transactionDataManager.HandelRefund();

    }
    public void MakeDiscount(double discountAmount ,CustomerDataManager customerDataManager ,int choice )
    {
        DiscountFactory discountFactory =new DiscountFactory();
        discountFactory.MakeObj(choice,discountAmount,customerDataManager);
    }
    public void ListPaymentTransactions(TransactionDataManager transactionDataManager)
    {
        transactionDataManager.ListPaymentTransactions();
    }
    public void ListRefundTransactions(TransactionDataManager transactionDataManager)
    {
        transactionDataManager.ListRefundTransactions();
    }
    public void ListAddtoWalletTransactions(TransactionDataManager transactionDataManager)
    {
        transactionDataManager.ListAddtoWalledTransactions();
    }




}
