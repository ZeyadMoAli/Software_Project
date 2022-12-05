
public interface Itransaction {

    public void setTransactionID();

    public void setTransactionUser();

    public void setPaymentMethod();

    public void setAmount();

    public void setIsRefunded(boolean status);

    public void setIsRefund(boolean status);

    public String getTransactionID();

    public String getTransactionUser();

    public double getAmount();

    public boolean getIsRefunded();

    public boolean getIsRefund();

}
