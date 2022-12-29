package Database;
import User.*;
import java.util.*;

public class CustomerDataManager implements IdataManger{
    public ArrayList<Customer> customers= new ArrayList<Customer>();
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }


   public Customer FindCustomer(Customer customer)
    {
        for(Customer customer1: customers)
        {
            if( (customer1.getUsername().equals(customer.getUsername())) && (customer1.getPassword().equals(customer.getPassword())))
            {
                return customer1;
            }
        }
        return null;
    }

}
