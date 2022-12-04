import java.util.ArrayList;

public class CustomerDataManager implements IdataManger{
    ArrayList<Customer> customers= new ArrayList<Customer>();
    void addCustomer(Customer customer)
    {
        customers.add(customer);
    }

}
