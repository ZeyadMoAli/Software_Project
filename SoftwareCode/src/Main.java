import java.util.Scanner;

public class Main {
    static CustomerDataManager customers = new CustomerDataManager();
    static AdminDataManager admins = new AdminDataManager();
    static TransactionDataManager transactionDataManager= new TransactionDataManager();
    static ServiceDataManger serviceDataManger=new ServiceDataManger();

    public static void main(String[] args) {
        Admin admin1= new Admin("Zeyad","Zeyad@gmail","1234");
        admins.AddAdmin(admin1);
        Customer customer1= new Customer("Ali","Ali@gmail","1234");
        Customer customer2= new Customer("Mohamed","Mohamed@gmail","1234");
        customers.addCustomer(customer1);
        customers.addCustomer(customer2);
        MobileRecharge mobileRecharge = new MobileRecharge();
        serviceDataManger.Addservice(mobileRecharge);
        InternetPayment internetPayment=new InternetPayment();
        serviceDataManger.Addservice(internetPayment);
        LandLine landLine =new LandLine();
        serviceDataManger.Addservice(landLine);
        Donations donations=new Donations();
        serviceDataManger.Addservice(donations);




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
        System.out.println("Enter Service (LandLine, MobileRecharge, InternetPayment, Donations)");
        service=scn.nextLine();
        IServiceFactory serviceFactory= new ServiceFactory();
        Iservice iservice= serviceFactory.makeObj(service);
        System.out.println(iservice.getName());



        String sprovider;
        System.out.println("Enter Provider (We, Orange , Vodafone, NGOS, Schools, Etisalat, CancerHospital): ");
        IserviceProviderFactory iserviceProviderFactory=new ServiceProviderFactory();
        sprovider=scn.nextLine();
        IserviceProvider iserviceProvider = iserviceProviderFactory.makeObj(sprovider);
        System.out.println(iserviceProvider.getname());


        SpecificDiscount specificDiscount=new SpecificDiscount();
        admin1.MakeSpecificDiscount(0.1 ,iservice, specificDiscount);


        iserviceProvider.FillForm();


        PaymentForm paymentForm =new PaymentForm();
        double money;
        System.out.println("Enter amount of money");
        money =scn.nextDouble();
        paymentForm.Fill(money, (iservice.GetDiscount()+ customer3.Getdiscount())*100);

        customer3.Pay(paymentForm.GetNetamount(),iserviceProvider);
        System.out.println(customer3.GetCreditBalance());


        Transaction transaction=new Transaction(customer3,iservice,iserviceProvider,paymentForm);
        transactionDataManager.Addtotransaction(transaction);































    }
}