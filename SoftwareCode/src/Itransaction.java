public interface Itransaction {
     double amount = 0;

    void setRefundStatus(Boolean state);
    boolean GetRefundStatus();
    public int GetTransactionId();


    public Customer Getcustomer();
    public  void SetCustomer(Customer customer);






}
