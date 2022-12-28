package Forms;

public class PaymentForm implements Iform{
    double amount = 0;
    double discount=0;
    public void Fill(double am ,double dis)
    {
        amount=am;
        discount=dis;

    }
    public  double GetNetamount()
    {
        return (amount-discount);
    }

}
