package com.fawrydemo.Fawry.User;
import com.fawrydemo.Fawry.Database.*;
import com.fawrydemo.Fawry.Factories.*;
import com.fawrydemo.Fawry.Transactions.AddtoWalltedTransaction;
import com.fawrydemo.Fawry.Transactions.PaymentTransaction;

import java.util.ArrayList;

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
    public ArrayList<PaymentTransaction>  ListPaymentTransactions(TransactionDataManager transactionDataManager)
    {
        return transactionDataManager.ListPaymentTransactions();
    }
    public ArrayList<PaymentTransaction> ListRefundTransactions(TransactionDataManager transactionDataManager)
    {
        return transactionDataManager.ListRefundTransactions();
    }
    public ArrayList<AddtoWalltedTransaction> ListAddtoWalletTransactions(TransactionDataManager transactionDataManager)
    {
        return transactionDataManager.ListAddtoWalledTransactions();

    }




}
