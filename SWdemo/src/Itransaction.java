public interface Itransaction {



    public void setIsRefunded(boolean status);
    public void setIsRefund(boolean status);
    public int GetTransactionId();

    public boolean getIsRefunded();

    public boolean getIsRefund();

    public Customer Getcustomer();
    public  void SetCustomer(Customer customer);


    public Iservice GetService();
    public void SetService(Iservice iservice);

    public IserviceProvider GetServiceProvicer();
    public void SetServiceProvider (IserviceProvider iserviceProvider);


    public PaymentForm GetPaymentForm();
    public void SetPaymentForm (PaymentForm paymentForm);

}
