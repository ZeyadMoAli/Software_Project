import java.util.ArrayList;



public class TransactionDataManager implements IdataManger {
    ArrayList<Transaction> itransactions = new ArrayList<Transaction>();
//    ArrayList<Transaction> Refund = new ArrayList<Transaction>();

    public Transaction transactionSearch(Transaction transaction) {

        for (int i = 0; i < itransactions.size(); i++) {

            if (itransactions.contains(transaction.getTransactionID())) {


                return transaction;


            }
        }

        return null ;
    }


    public void displayTransactions(){

        System.Out.println("Transaction ID  Username  Amount  Payment Method");


        for (Transaction transaction : itransactions){

            System.Out.println(transaction.getTransactionID() + "  " + transaction.getTransactionUser() + "  " +
                    transaction.getAmount() + "  " + transaction.setPaymentMethod());

        }
    }
}
