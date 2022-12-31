package com.fawrydemo.Fawry.Controllers;

import com.fawrydemo.Fawry.Database.*;
import com.fawrydemo.Fawry.Transactions.AddtoWalltedTransaction;
import com.fawrydemo.Fawry.Transactions.PaymentTransaction;
import com.fawrydemo.Fawry.User.Admin;

import java.util.ArrayList;

public class AdminController {
    Admin admin = new Admin();
    public  void HandleRefund(int id, boolean state, TransactionDataManager transactionDataManager)
    {
        admin.HandleRefund(id, state,transactionDataManager);
    }
    public void MakeDiscount(double discountAmount ,CustomerDataManager customerDataManager ,int choice )
    {
        admin.MakeDiscount(discountAmount,customerDataManager,choice);
    }

    public ArrayList<PaymentTransaction> ListPaymentTransactions(TransactionDataManager transactionDataManager)
    {
       return admin.ListPaymentTransactions(transactionDataManager);
    }

    public ArrayList<PaymentTransaction> ListRefundTransactions(TransactionDataManager transactionDataManager)
    {
        return admin.ListRefundTransactions(transactionDataManager);
    }
    public ArrayList<AddtoWalltedTransaction> ListAddtoWalletTransactions(TransactionDataManager transactionDataManager)
    {
        return admin.ListAddtoWalletTransactions(transactionDataManager);
    }


    public String getAdminname() {
        return admin.getUsername();
    }

    public void setAdminname(String username) {
        admin.setUsername(username);
    }

    public String getEmail() {
        return admin.getEmail();
    }

    public void setEmail(String email) {
        admin.setEmail(email);
    }

    public String getPassword() {
        return admin.getPassword();
    }

    public void setPassword(String password) {
        admin.setPassword(password);
    }
}
