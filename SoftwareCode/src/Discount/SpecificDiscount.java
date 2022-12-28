package Discount;
import Factories.ServiceProviderFactory;
import Service.*;
import User.*;

import java.util.ArrayList;

public class SpecificDiscount implements Idiscount{

    ServiceProviderFactory iserviceProvider;
    private ArrayList<Customer> customers;

    public SpecificDiscount()
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

    public void setDiscountAmount(double amount, Iservice iservice) {
        iservice.setDiscount_amoutn(amount);
    }

}
