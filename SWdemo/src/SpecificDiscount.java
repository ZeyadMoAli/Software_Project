import java.util.ArrayList;

public class SpecificDiscount implements Idiscount{
    private int discountAmount=0;

    private ArrayList<Customer> customers;
    SpecificDiscount()
    {
        customers=new ArrayList<Customer>();
    }
    @Override
    public void subscribe(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void unsubscribe(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public int getDiscountAmount() {
        return this.discountAmount;
    }

    @Override
    public void setDiscountAmount(int amount) {
        this.discountAmount=amount;


    }

    @Override
    public void notifyall() {

    }
}
