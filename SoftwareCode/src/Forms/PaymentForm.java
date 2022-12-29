package Forms;

public class PaymentForm implements Iform{
    private double amount = 0;
    private double discount=0;
    private double NetAmount= amount - discount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void Fill(double am , double dis)
    {
        amount=am;
        discount=dis;

    }
    public  double GetNetamount()
    {
        return NetAmount;
    }

}
