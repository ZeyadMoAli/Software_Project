

public class Transaction implements Itransaction{


    private double amount ;

    private String transactionID;

    private String transactionUser;

    private String paymentMethod;

    private boolean is_refund = false;

    private boolean is_Refunded = false;

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


    @Override
   public void setIsRefund(boolean status){

        this.is_refund = status;

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



    @Override
   public boolean getIsRefund(){

        return is_refund;

    }

}
