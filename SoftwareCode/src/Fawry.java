import Database.CustomerDataManager;
import Database.ServiceDataManger;
import Database.TransactionDataManager;
import Discount.OverAllDiscount;
import Factories.IserviceProviderFactory;
import Factories.ServiceFactory;
import Factories.ServiceProviderFactory;
import Service.*;
import ServiceProvider.IserviceProvider;
import Transactions.AddtoWalltedTransaction;
import Transactions.PaymentTransaction;
import User.Admin;
import User.Customer;

import java.util.Scanner;

public class Fawry {
    private static CustomerDataManager customerDataManager = new CustomerDataManager();
    private static TransactionDataManager transactionDataManager= new TransactionDataManager();
    private static ServiceDataManger serviceDataManger=new ServiceDataManger();


    public void StartProgram()
    {
        Scanner scanner =new Scanner(System.in);
        Scanner scannerStr =new Scanner(System.in);
        int choice;
        String stringtoEnter= new String();
        Customer FirsCustomer =new Customer("zeyad", "gmail", "123");
        customerDataManager.addCustomer(FirsCustomer);
        Iservice service1 =new MobileRecharge();
        Iservice service2 =new InternetPayment();
        Iservice service3 =new LandLine();
        Iservice service4 =new Donations();
        serviceDataManger.Addservice(service1);
        serviceDataManger.Addservice(service2);
        serviceDataManger.Addservice(service3);
        serviceDataManger.Addservice(service4);
        while (true)
        {
            System.out.println("Enter The number of your choice");
            System.out.println("1.Admin");
            System.out.println("2.Costumer");
            System.out.println("3.Exit Program");
            choice=scanner.nextInt();
            System.out.println(" ");
            if(choice==1)
            {
                Admin admin = new Admin();
                while (true)
                {
                    System.out.println("Enter The number of your choice");
                    System.out.println("1.Add discount");
                    System.out.println("2.Handel refund requests");
                    System.out.println("3.List Transactions");
                    System.out.println("4.sign out");
                    choice=scanner.nextInt();
                    if(choice==1)
                    {
                        System.out.println("Enter The number of your choice");
                        System.out.println("1.OverAll Discount");
                        System.out.println("2.Specific Discount");
                        choice=scanner.nextInt();
                        System.out.println( "Enter discount ");
                        double discount =scanner.nextDouble();
                        admin.MakeDiscount(discount,customerDataManager,choice);

                    }
                    else if(choice==2)
                    {
                        admin.HandleRefund(transactionDataManager);

                    }
                    else if(choice==3)
                    {
                        System.out.println("Enter The number of your choice");
                        System.out.println("1.List payment Transactions");
                        System.out.println("2.List Refund Transactions");
                        System.out.println("3.List Add to wallet Transactions");
                        choice=scanner.nextInt();
                        if(choice==1)
                            admin.ListPaymentTransactions(transactionDataManager);
                        else if(choice==2)
                            admin.ListRefundTransactions(transactionDataManager);
                        else if(choice==3)
                            admin.ListAddtoWalletTransactions(transactionDataManager);
                    }
                    else if(choice ==4)
                    {
                        break;
                    }
                }

            }
            else if(choice==2)
            {
                while (true)
                {
                    System.out.println("Enter The number of your choice");
                    System.out.println("1.log in");
                    System.out.println("2.Register");
                    System.out.println("3.Sign out");
                    choice=scanner.nextInt();
                    Customer customer = new Customer();
                    if(choice==1)
                    {
                        System.out.println("Enter User Name");
                        stringtoEnter = scannerStr.nextLine();
                        customer.SetUsername(stringtoEnter);
                        System.out.println("Enter Password");
                        stringtoEnter=  scannerStr.nextLine();
                        customer.setPassword(stringtoEnter);
                        System.out.println("Enter Email");
                        stringtoEnter=  scannerStr.nextLine();
                        customer.setEmail(stringtoEnter);
                        Customer temp= customer.Login(customerDataManager);
                        if(temp == null)
                        {
                            System.out.println("You Did not Registered Before");
                            customer= customer.Register(customerDataManager);
                            System.out.println("Registration Completed");
                            System.out.println(" ");

                        }
                        else
                        {
                            customer= temp;
                            System.out.println("You loged in successfully");
                            System.out.println(" ");

                        }
                    }
                    else if(choice ==2)
                    {

                        System.out.println("Enter User Name");
                        stringtoEnter = scannerStr.nextLine();
                        customer.SetUsername(stringtoEnter);
                        System.out.println("Enter Password");
                        stringtoEnter=  scannerStr.nextLine();
                        customer.setPassword(stringtoEnter);
                        System.out.println("Enter Email");
                        stringtoEnter=  scannerStr.nextLine();
                        customer.setEmail(stringtoEnter);
                        Customer temp= customer.Register(customerDataManager);
                        if(temp  == null)
                        {
                            System.out.println("You Register before ");
                            customer= customer.Login(customerDataManager);
                            System.out.println("You loged in successfully");
                            System.out.println(" ");

                        }
                        else
                        {
                            customer= temp;
                            System.out.println("Registration Completed");
                            System.out.println(" ");

                        }
                    }
                    else if(choice ==3)
                    {
                        break;
                    }
                    while (true)
                    {
                        System.out.println("Enter The number of your choice");
                        System.out.println("1.Make Service");
                        System.out.println("2.Search For Service");
                        System.out.println("3.Add Funds to Wallet");
                        System.out.println("4.Check Discount");
                        System.out.println("5.Make refund request");
                        System.out.println("6.Exit");
                        choice=scanner.nextInt();
                        if(choice==1)
                        {
                            System.out.println("Enter The number of your choice");
                            System.out.println("1.Mobile Recharge ");
                            System.out.println("2.Internet Payment");
                            System.out.println("3.LandLine");
                            System.out.println("4.Donation");
                            choice=scanner.nextInt();
                            ServiceFactory serviceFactory=new ServiceFactory();
                            Iservice iservice= serviceFactory.makeObj(choice);
                            if(choice <4)
                            {
                                System.out.println("Enter The number of your service provider");
                                System.out.println("1.We ");
                                System.out.println("2.Orange");
                                System.out.println("3.Etisalat ");
                                System.out.println("4.Vodafone");
                                choice=scanner.nextInt();
                                IserviceProviderFactory serviceProviderFactory = new ServiceProviderFactory();
                                IserviceProvider iserviceProvider = serviceProviderFactory.makeObj(choice);
                                iserviceProvider.FillForm(customer.GetUsername());
                                if(customer.getDiscount()!=0)
                                {
                                    System.out.println("You have discount "+ customer.getDiscount()+"%");
                                }
                                if(iservice.getDiscount()!=0)
                                {
                                    System.out.println("there is "+ iservice.getDiscount()+ "% on this service");
                                }
                                System.out.println("Enter amount of money");
                                double amount= scanner.nextDouble();
                                PaymentTransaction itransaction =new PaymentTransaction(customer, iservice,iserviceProvider,amount,iservice.getDiscount()+ customer.getDiscount());
                                if(customer.Pay(itransaction.getNetAmount(), iserviceProvider ))
                                {
                                    System.out.println("Service completed ");
                                    System.out.println("Your Wallet balance is "+customer.GetWalletBalance());
                                    System.out.println("Your Credit Card balance is "+ customer.GetCreditBalance());
                                    System.out.println("Your transaction Id is "+ itransaction.GetTransactionId());
                                    transactionDataManager.AddtoPaymentTransaction(itransaction);

                                }
                                else
                                {
                                    System.out.println("there is no enough money transaction Canceled");
                                }
                                System.out.println("");
                            }
                            else
                            {
                                System.out.println("Enter The number of your choice");
                                System.out.println("5.Schools ");
                                System.out.println("6.NGOs");
                                System.out.println("7.Cancer Hospital ");
                                choice =scanner.nextInt();
                                IserviceProviderFactory serviceProviderFactory = new ServiceProviderFactory();
                                IserviceProvider iserviceProvider = serviceProviderFactory.makeObj(choice);
                                iserviceProvider.FillForm(customer.GetUsername());
                                System.out.println("Enter amount of money");
                                double amount= scanner.nextDouble();
                                PaymentTransaction itransaction =new PaymentTransaction(customer, iservice,iserviceProvider,amount,iservice.getDiscount()+ customer.getDiscount());
                                if(customer.Pay(itransaction.getNetAmount(), iserviceProvider ))
                                {
                                    System.out.println("Service completed ");
                                    System.out.println("Your Wallet balance is "+customer.GetWalletBalance());
                                    System.out.println("Your Credit Card balance is "+ customer.GetCreditBalance());
                                    System.out.println("Your transaction Id is "+ itransaction.GetTransactionId());
                                    transactionDataManager.AddtoPaymentTransaction(itransaction);
                                }
                                else
                                {
                                    System.out.println("there is no enough money transaction Canceled");
                                }
                                System.out.println("");

                            }

                        }
                        else if(choice==2)
                        {
                            System.out.println("Enter service name ");
                            stringtoEnter= scannerStr.nextLine();
                            Iservice iservice=  serviceDataManger.Search(stringtoEnter);
                            if(iservice==null)
                            {
                                System.out.println("this service doesn't exist");
                            }
                            else {
                                System.out.println(iservice.getName() +  " exist");
                            }
                        }
                        else if(choice==3)
                        {
                            System.out.println("Enter amount of money ");
                            double amount= scanner.nextDouble();
                            if(customer.AddToWallet(amount) == true)
                            {
                                System.out.println("You added funds to walled successfully");
                                AddtoWalltedTransaction  addtoWalltedTransaction=new AddtoWalltedTransaction(amount,customer);
                                transactionDataManager.AddWalletTransaction(addtoWalltedTransaction);
                            }
                            else
                            {
                                System.out.println("there is no enough money in your credit card");
                            }

                        }
                        else if(choice==4)
                        {
                            System.out.println("Enter number of service you want ot check");
                            System.out.println("1.Mobile Recharge ");
                            System.out.println("2.Internet Payment");
                            System.out.println("3.LandLine");
                            choice=scanner.nextInt();
                            ServiceFactory serviceFactory=new ServiceFactory();
                            Iservice iservice= serviceFactory.makeObj(choice);
                            if(iservice.getDiscount()==0)
                            {
                                System.out.println("this service don't have discount");
                            }
                            else
                            {
                                System.out.println("this service has "+ iservice.getDiscount()+"% discount");
                            }
                            System.out.println("");


                        }
                        else if(choice==5)
                        {
                            System.out.println("Enter transaction Id ");
                            int id= scanner.nextInt();
                            if(customer.RefundRequest(id , transactionDataManager) == true)
                            {
                                System.out.println("You request completed successfully");
                            }
                            else
                            {
                                System.out.println("this transaction doesn't exist");
                            }
                            System.out.println("");
                        }
                        else if(choice ==6)
                        {
                            break;
                        }
                    }

                }
            }
            else if(choice==3)
            {
                System.out.println("Thanks for using Fawry");
                return;
            }
        }

    }
}
