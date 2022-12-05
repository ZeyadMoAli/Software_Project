import java.util.ArrayList;
import java.util.Scanner;

public class TransactionDataManager implements IdataManger {
    ArrayList<Transaction> itransactions = new ArrayList<Transaction>();
    ArrayList<Transaction> Refund = new ArrayList<Transaction>();

    public Transaction transactionSearch(int id) {
        for(Transaction transaction: itransactions)
        {
            if(transaction.GetTransactionId()== id)
                return transaction;
        }
        return null;
    }
    public void Addtotransaction(Transaction transaction)
    {
        itransactions.add(transaction);
    }
    public void removefromtransaction(Transaction transaction)
    {
        itransactions.remove(transaction);
    }
    public void Addtorefund(Transaction transaction)
    {
        Refund.add(transaction);
    }
    public void removefromrefund(Transaction transaction)
    {
        Refund.remove(transaction);
    }

    void FromTransactiontoRefund( Transaction transaction)
    {
        this.removefromrefund(transaction);
        this.Addtorefund(transaction);

    }

    public void hadleRefund(){

        System.out.println("Transaction ID ,  Username   ");
        boolean state=false;
        Scanner scn = new Scanner(System.in);

        for (Transaction transaction : Refund){
            System.out.println("Transaction ID: "+  transaction.GetTransactionId() );
            System.out.println("Username: "+ transaction.Getcustomer().GetUsername());
            System.out.println("Enter State: ");
            state=scn.nextBoolean();
            transaction.seTrefundStatus(state);

        }
    }


}
