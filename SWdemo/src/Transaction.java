

public class Transaction implements Itransaction{


    static int count=0;
    static int  transactionID;
    public Customer customer;
    public Iservice iservice;
    public IserviceProvider iserviceProvider;
    public  PaymentForm paymentForm;

    private boolean is_refund = false;
    private boolean refund_successful = false;

    private boolean is_Refunded = false;





    @Override
    public void setIsRefunded(boolean status){

        this.is_Refunded = status;

    }



    @Override
    public void setIsRefund(boolean status){

        this.is_refund = status;

    }

    @Override
    public int GetTransactionId() {
        return this.transactionID;
    }


    @Override
    public boolean getIsRefunded(){

        return is_Refunded;

    }


    @Override
    public boolean getIsRefund(){

        return is_refund;

    }

    @Override
    public Customer Getcustomer() {
        return customer;
    }

    @Override
    public void SetCustomer(Customer customer) {
        this.customer=customer;
    }

    @Override
    public Iservice GetService() {
        return iservice;
    }

    @Override
    public void SetService(Iservice iservice) {
    this.iservice=iservice;
    }

    @Override
    public IserviceProvider GetServiceProvicer() {
        return iserviceProvider;
    }

    @Override
    public void SetServiceProvider(IserviceProvider iserviceProvider) {
        this.iserviceProvider=iserviceProvider;

    }

    @Override
    public PaymentForm GetPaymentForm() {
        return paymentForm;
    }

    @Override
    public void SetPaymentForm(PaymentForm paymentForm) {
        this.paymentForm=paymentForm;

    }


    public boolean getRefundSuccessful(){

        return refund_successful;
    }
    public void setRefundSuccessful(boolean status){

        this.refund_successful = status ;

    }
    Transaction(Customer c, Iservice is, IserviceProvider isp, PaymentForm pf)
    {
        customer=c;
        iservice=is;
        iserviceProvider=isp;
        count++;
        transactionID=count;
        paymentForm=pf;
    }
    Transaction()
    {
        count++;
        transactionID=count;

    }




}
