import Database.CustomerDataManager;
import Database.ServiceDataManger;
import Database.TransactionDataManager;
import Service.*;
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
        Customer FirsCustomer =new Customer("zeyad", "zz", "123");
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
                    System.out.println("1.sign in");
                    System.out.println("2.sing up");
                    System.out.println("3.Sign out");
                    choice=scanner.nextInt();
                    Customer customer = new Customer();
                    if(choice==1)
                    {
                        customer.setUsername(stringtoEnter);
                        System.out.println("Enter Password");
                        stringtoEnter=  scannerStr.nextLine();
                        customer.setPassword(stringtoEnter);
                        System.out.println("Enter Email");
                        stringtoEnter=  scannerStr.nextLine();
                        customer.setEmail(stringtoEnter);
                        customer= customer.SignIn(customerDataManager);
                        System.out.println("You Signed in successfully");
                        System.out.println(" ");
                    }
                    else if(choice ==2)
                    {
                        System.out.println("Enter User Name");
                        stringtoEnter = scannerStr.nextLine();
                        customer.setUsername(stringtoEnter);
                        System.out.println("Enter Password");
                        stringtoEnter=  scannerStr.nextLine();
                        customer.setPassword(stringtoEnter);
                        System.out.println("Enter Email");
                        stringtoEnter=  scannerStr.nextLine();
                        customer.setEmail(stringtoEnter);
                        Customer temp= customer.SignUp(customerDataManager);
                        if(temp  == null)
                        {
                            System.out.println("Error");
                            break;
                        }
                        else
                        {
                            customer= temp;
                            System.out.println("Sign Up Completed");
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

                            if(choice <4)
                            {
                                System.out.println("Enter The number of your service provider");
                                System.out.println("1.We ");
                                System.out.println("2.Orange");
                                System.out.println("3.Etisalat ");
                                System.out.println("4.Vodafone");
                                int  ServicePro=scanner.nextInt();
                                System.out.println("Enter amount of money");
                                double amount= scanner.nextDouble();
                                PaymentTransaction paymentTransaction =customer.makeService(choice,ServicePro,amount,transactionDataManager);
                                if(paymentTransaction!=null)
                                {
                                    System.out.println("Service completed ");
                                    System.out.println("Your Wallet balance is "+customer.GetWalletBalance());
                                    System.out.println("Your Credit Card balance is "+ customer.GetCreditBalance());
                                    System.out.println("Your transaction Id is "+ paymentTransaction.getTransactionID());
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
                                int  ServicePro=scanner.nextInt();
                                System.out.println("Enter amount of money");
                                double amount= scanner.nextDouble();
                                PaymentTransaction paymentTransaction =customer.makeService(choice,ServicePro,amount,transactionDataManager);
                                if(paymentTransaction!=null)
                                {
                                    System.out.println("Service completed ");
                                    System.out.println("Your Wallet balance is "+customer.GetWalletBalance());
                                    System.out.println("Your Credit Card balance is "+ customer.GetCreditBalance());
                                    System.out.println("Your transaction Id is "+ paymentTransaction.getTransactionID());
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
                            if( customer.Search(stringtoEnter,serviceDataManger)  ==null)
                            {
                                System.out.println("Service doesn't exist");
                            }
                            else
                            {
                                System.out.println(stringtoEnter +" exist");
                            }
                        }
                        else if(choice==3)
                        {
                            System.out.println("Enter amount of money ");
                            double amount= scanner.nextDouble();
                            if(customer.AddToWallet(amount, transactionDataManager ) )
                            {
                                System.out.println("You added funds to walled successfully");
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
                            if(customer.checkServiceDiscount(choice) ==0)
                            {
                                System.out.println("this service don't have discount");
                            }
                            else
                            {
                                System.out.println("this service has "+ customer.checkServiceDiscount(choice) +"% discount");
                            }
                            System.out.println("");


                        }
                        else if(choice==5)
                        {
                            System.out.println("Enter transaction Id ");
                            int id= scanner.nextInt();
                            if(customer.RefundRequest(id , transactionDataManager) )
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
