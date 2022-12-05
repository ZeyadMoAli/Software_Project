import java.util.Scanner;

public class Main {
    static CustomerDataManager customers = new CustomerDataManager();
    static AdminDataManager admins = new AdminDataManager();
    static TransactionDataManager transactionDataManager= new TransactionDataManager();

    public static void main(String[] args) {
        Admin admin1= new Admin("Zeyad","Zeyad@gmail","1234");
        admins.AddAdmin(admin1);
        Customer customer1= new Customer("Ali","Ali@gmail","1234");
        Customer customer2= new Customer("Mohamed","Mohamed@gmail","1234");
        customers.addCustomer(customer1);
        customers.addCustomer(customer2);


        Customer customer3;
        Scanner scn = new Scanner(System.in);


            String username;
            String password;
            String email;
            System.out.println("Enter UserName: ");
            username=scn.nextLine();
            System.out.println("Enter Email: ");
            email=scn.nextLine();
            System.out.println("Enter Password: ");
            password=scn.nextLine();
            customer3=new Customer(username,email,password);
            if(customer3.Login(customers))
            {
                System.out.println("Login complete successfully");
            }
            else
            {
                System.out.println("Registration complete successfully");
                customer3.Register(customers);
            }


        String service;
        System.out.println("Enter Service: ");
        service=scn.nextLine();
        IServiceFactory serviceFactory= new ServiceFactory();
        Iservice iservice= serviceFactory.makeObj(service);
        System.out.println(iservice.getName());


        String sprovider;
        System.out.println("Enter Provider: ");
        IserviceProviderFactory iserviceProviderFactory=new ServiceProviderFactory();
        sprovider=scn.nextLine();
        IserviceProvider serviceProvider = iserviceProviderFactory.makeObj(sprovider);



        SpecificDiscount specificDiscount=new SpecificDiscount();
        admin1.MakeSpecificDiscount(10,iservice, specificDiscount);








    }
}