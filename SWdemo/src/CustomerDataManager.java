import java.util.ArrayList;

public class CustomerDataManager implements IdataManger{
    ArrayList<Customer> customers= new ArrayList<Customer>();
    void addCustomer(Customer customer)
    {
        customers.add(customer);
    }


    boolean FindCustomer(Customer customer)
    {
        for(Customer customer1: customers)
        {
            if(customer1.GetUsername() ==customer.GetUsername() && customer.GetEmail()==customer.GetEmail())
            {
                return true;
            }
        }
        return false;
    }

}
