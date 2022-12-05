import java.util.ArrayList;

public class OverAllDiscount implements Idiscount{
    private int discountAmount=0;


    private ArrayList<Customer> customers=new ArrayList<Customer>();

    @Override
    public void subscribe(Customer user) {
        customers.add(user);
    }

    @Override
    public void unsubscribe(Customer user) {
        customers.remove(user);
    }

    @Override
    public void notifyall() {
        for(Customer customer : customers )
        {
            customer.upDateDiscount(discountAmount);
        }
    }

    @Override
    public int getDiscountAmount() {
        return this.discountAmount;
    }

    @Override
    public void setDiscountAmount(int amount) {
        this.discountAmount=amount;
    }
}
