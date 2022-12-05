public interface Itransaction {



    void seTrefundStatus(Boolean state);
    boolean GetRefundStatus();
    public int GetTransactionId();


    public Customer Getcustomer();
    public  void SetCustomer(Customer customer);


    public Iservice GetService();
    public void SetService(Iservice iservice);

    public IserviceProvider GetServiceProvicer();
    public void SetServiceProvider (IserviceProvider iserviceProvider);


    public PaymentForm GetPaymentForm();
    public void SetPaymentForm (PaymentForm paymentForm);

}
