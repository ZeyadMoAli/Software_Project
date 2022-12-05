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
            String c1user=customer1.GetUsername();
            String c1mail= customer1.GetEmail();
            String cuser=customer.GetUsername();
            String cmail= customer.GetEmail();

            if(c1user.equals( cuser) && c1mail.equals(cmail))
            {
                return true;
            }
        }
        return false;
    }

}
