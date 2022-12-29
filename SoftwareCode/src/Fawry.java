import Database.CustomerDataManager;
import Database.ServiceDataManger;
import Database.TransactionDataManager;
import Discount.OverAllDiscount;
import Factories.IserviceProviderFactory;
import Factories.ServiceFactory;
import Factories.ServiceProviderFactory;
import Service.Iservice;
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
        int choice;
        String string;
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

                    }
                    else if(choice==3)
                    {

                    }
                    else if(choice ==4)
                    {
                        return;
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
                        string =scanner.nextLine();
                        customer.SetUsername(string);
                        System.out.println("Enter Password");
                        string= scanner.nextLine();
                        customer.setPassword(string);
                        System.out.println("Enter Email");
                        string= scanner.nextLine();
                        customer.setEmail(string);
                        customer = customer.Login(customerDataManager);
                        if(customer == null)
                        {
                            System.out.println("You Did not Registered Before");
                            customer= customer.Register(customerDataManager);
                            System.out.println("Registration Completed");

                        }
                        else
                        {
                            System.out.println("You loged in successfully");
                        }
                    }
                    else if(choice ==2)
                    {
                        System.out.println("Enter User Name");
                        string =scanner.nextLine();
                        customer.SetUsername(string);
                        System.out.println("Enter Password");
                        string= scanner.nextLine();
                        customer.setPassword(string);
                        System.out.println("Enter Email");
                        string= scanner.nextLine();
                        customer.setEmail(string);
                        customer= customer.Register(customerDataManager);
                        if(customer == null)
                        {
                            System.out.println("You Register before ");
                            customer= customer.Login(customerDataManager);
                            System.out.println("You loged in successfully");
                        }
                        else
                        {
                            System.out.println("Registration Completed");
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
                        System.out.println("6.Sign out");
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
                            if(choice <5)
                            {
                                System.out.println("Enter The number of your service provider");
                                System.out.println("1.We ");
                                System.out.println("2.Orange");
                                System.out.println("3.Etisalat ");
                                System.out.println("4.Vodafone");
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

                            }
                            else
                            {
                                System.out.println("Enter The number of your choice");
                                System.out.println("5.Schools ");
                                System.out.println("6.NGOs");
                                System.out.println("7.Cancer Hospital ");
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

                            }

                        }
                        else if(choice==2)
                        {
                            System.out.println("Enter service name ");
                            string= scanner.nextLine();
                            Iservice iservice=  serviceDataManger.Search(string);
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
