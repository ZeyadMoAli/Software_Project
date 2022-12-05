import java.util.ArrayList;

public class OverAllDiscount implements Idiscount{


    private ArrayList<Customer> customers=new ArrayList<Customer>();

    @Override
    public void subscribe(Customer user) {
        customers.add(user);
    }

    @Override
    public void unsubscribe(Customer user) {
        customers.remove(user);
    }

    public void notifyall(int amount) {
        for(Customer customer : customers )
        {
            customer.upDateDiscount(amount);
        }
    }


    public void setDiscountAmount(int amount) {
        for(Customer customer: customers)
        {
            customer.upDateDiscount(amount);
        }
    }
}
