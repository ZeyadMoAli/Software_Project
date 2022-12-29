package Database;
import Transactions.*;
import java.util.*;
public class TransactionDataManager implements IdataManger {
    ArrayList<PaymentTransaction> PaymentTransactions = new ArrayList<PaymentTransaction>();
    ArrayList<PaymentTransaction> Refund = new ArrayList<PaymentTransaction>();
    ArrayList<AddtoWalltedTransaction> WalletTransaction = new ArrayList<AddtoWalltedTransaction>();

    public void AddWalletTransaction(AddtoWalltedTransaction addtoWalltedTransaction)
    {
        this.WalletTransaction.add(addtoWalltedTransaction);
    }
    public PaymentTransaction transactionSearch(int TransactionId) {
        for(PaymentTransaction transaction: PaymentTransactions)
        {
            if(transaction.GetTransactionId()== TransactionId)
                return transaction;
        }
        return null;
    }
    public void AddtoPaymentTransaction(PaymentTransaction transaction)
    {
        PaymentTransactions.add(transaction);
    }
    public void RemoveFromPaymentTransaction(PaymentTransaction transaction) {
        PaymentTransactions.remove(transaction);}
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
    public void ListRefund(){

        boolean state=false;
        Scanner scn = new Scanner(System.in);

        for (PaymentTransaction transaction : Refund){
            System.out.println("Transaction ID: "+  transaction.GetTransactionId() );
            System.out.println("Customer Username: "+ transaction.getCustomerName());
            System.out.println("Enter State (true = Accepted, false = Rejected) :");
            state=scn.nextBoolean();
            transaction.setRefundStatus(state);
            if(state==true)
            {
                transaction.Getcustomer().AddToWallet(transaction.getNetAmount());
            }

        }
    }


}
