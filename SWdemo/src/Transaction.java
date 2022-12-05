

public class Transaction implements Itransaction{


    private double amount ;

    private String transactionID;

    private String transactionUser;

    private String paymentMethod;

    private boolean is_Refunded = false;


    private boolean refund_successful = false;

    @Override
    public void setTransactionID(){

        this.transactionID = transactionID;

    }


    @Override
   public void setTransactionUser(){

        this.transactionUser = transactionUser;

    }


    @Override
   public void setPaymentMethod(){

        this.paymentMethod = paymentMethod;

    }


    @Override
   public void setAmount(){

        this.amount = amount;

    }


    @Override
   public void setIsRefunded(boolean status){

        this.is_Refunded = status;

    }




    public void setRefundSuccessful(boolean status){

        this.refund_successful = status ;

    }






    @Override
   public String getTransactionID(){

        return transactionID;

    }


    @Override
   public String getTransactionUser(){

        return transactionUser;

    }



    @Override
   public double getAmount(){

        return amount;

    }


    @Override
   public boolean getIsRefunded(){

        return is_Refunded;

    }


    public boolean getRefundSuccessful(){

        return refund_successful;
    }





}
