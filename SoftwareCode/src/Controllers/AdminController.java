package Controllers;

import Database.*;
import User.Admin;

public class AdminController {
    public  void HandleRefund(Admin admin, TransactionDataManager transactionDataManager)
    {
        admin.HandleRefund(transactionDataManager);
    }
    public void MakeDiscount(Admin admin,double discountAmount ,CustomerDataManager customerDataManager ,int choice )
    {
        admin.MakeDiscount(discountAmount,customerDataManager,choice);
    }

    public void ListPaymentTransactions(Admin admin,TransactionDataManager transactionDataManager)
    {
        admin.ListPaymentTransactions(transactionDataManager);
    }

    public void ListRefundTransactions(Admin admin,TransactionDataManager transactionDataManager)
    {
        admin.ListRefundTransactions(transactionDataManager);
    }
    public void ListAddtoWalletTransactions(Admin admin,TransactionDataManager transactionDataManager)
    {
        admin.ListAddtoWalletTransactions(transactionDataManager);
    }


    public String getUsername(Admin admin) {
        return admin.getUsername();
    }

    public void setUsername(Admin admin,String username) {
        admin.setUsername(username);
    }

    public String getEmail(Admin admin) {
        return admin.getEmail();
    }

    public void setEmail(Admin admin,String email) {
        admin.setEmail(email);
    }

    public String getPassword(Admin admin) {
        return admin.getPassword();
    }

    public void setPassword(Admin admin,String password) {
        admin.setPassword(password);
    }
}
