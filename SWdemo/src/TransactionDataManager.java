import java.util.ArrayList;

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

    public void displayTransactions(){

        System.out.println("Transaction ID ,  Username   ");


        for (Transaction transaction : itransactions){

            System.out.println( transaction.GetTransactionId()+ " " + transaction.Getcustomer().GetUsername()+ " "  );

        }
    }


}
