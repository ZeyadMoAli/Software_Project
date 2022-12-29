package Database;
import Transactions.*;
import java.util.*;
public class TransactionDataManager implements IdataManger {
    ArrayList<PaymentTransaction> paymentTransactions = new ArrayList<PaymentTransaction>();
    ArrayList<PaymentTransaction> Refund = new ArrayList<PaymentTransaction>();
    ArrayList<AddtoWalltedTransaction> WalletTransaction = new ArrayList<AddtoWalltedTransaction>();
    ArrayList<PaymentTransaction> temp = new ArrayList<PaymentTransaction>();

    public void AddWalletTransaction(AddtoWalltedTransaction addtoWalltedTransaction)
    {
        this.WalletTransaction.add(addtoWalltedTransaction);
    }
    public PaymentTransaction transactionSearch(int TransactionId) {
        for(PaymentTransaction transaction: paymentTransactions)
        {
            if(transaction.GetTransactionId()== TransactionId)
                return transaction;
        }
        return null;
    }
    public void AddtoPaymentTransaction(PaymentTransaction transaction)
    {
        paymentTransactions.add(transaction);
    }
    public void RemoveFromPaymentTransaction(PaymentTransaction transaction) {
        paymentTransactions.remove(transaction);}
    public void Addtorefund(PaymentTransaction transaction)
    {
        Refund.add(transaction);
    }
    public void RemoveFromRefund(PaymentTransaction transaction)
    {
        Refund.remove(transaction);
    }

    public void FromPaymentTransactionToRefund(PaymentTransaction transaction)
    {
        this.RemoveFromPaymentTransaction(transaction);
        this.Addtorefund(transaction);

    }
    public void ListAddtoWalledTransactions ()
    {
        if(Refund.isEmpty())
        {
            System.out.println("There aren't any Add to wallet transactions");
            return;
        }
        for (AddtoWalltedTransaction transaction: WalletTransaction)
        {
            System.out.println("Transaction ID: "+  transaction.GetTransactionId() );
            System.out.println("Customer Username: "+ transaction.getCustomerName());
            System.out.println("Netamount: "+transaction.getAmount());
            System.out.println(" ");
        }
    }
    public void ListRefundTransactions()
    {
        if(Refund.isEmpty())
        {
            System.out.println("There aren't any refund transactions");
            return;
        }
        for (PaymentTransaction transaction: Refund)
        {
            System.out.println("Transaction ID: "+  transaction.GetTransactionId() );
            System.out.println("Customer Username: "+ transaction.getCustomerName());
            System.out.println("Netamount: "+transaction.getNetAmount());
            System.out.println("Discount: "+transaction.getDiscount());
            System.out.println(" ");
        }
    }

    public void ListPaymentTransactions()
    {
        if(paymentTransactions.isEmpty())
        {
            System.out.println("There aren't any Payment transactions");
            return;
        }
        for (PaymentTransaction transaction: paymentTransactions)
        {
            System.out.println("Transaction ID: "+  transaction.GetTransactionId() );
            System.out.println("Customer Username: "+ transaction.getCustomerName());
            System.out.println("Netamount: "+transaction.getNetAmount());
            System.out.println("Discount: "+transaction.getDiscount());
            System.out.println(" ");
        }
    }
    public void HandelRefund(){

        boolean state=false;
        Scanner scn = new Scanner(System.in);

        for (PaymentTransaction transaction : Refund){
            System.out.println("Transaction ID: "+  transaction.GetTransactionId() );
            System.out.println("Customer Username: "+ transaction.getCustomerName());
            System.out.println("Amount to be Refunded "+ transaction.getNetAmount());
            System.out.println("Enter State (true = Accepted, false = Rejected) :");
            state=scn.nextBoolean();
            transaction.setRefundStatus(state);
            if(state==true)
            {
                transaction.Getcustomer().AddToWallet(transaction.getNetAmount());
            }
            else
            {
                temp.add(transaction);
            }
            System.out.println(" ");

        }

        for(PaymentTransaction tran : temp)
        {
            paymentTransactions.add(tran);
        }
        Refund.clear();

    }


}
