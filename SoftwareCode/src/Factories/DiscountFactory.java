package Factories;
import Database.CustomerDataManager;
import Database.ServiceDataManger;
import Discount.Idiscount;
import Discount.OverAllDiscount;
import Discount.SpecificDiscount;
import Service.Iservice;

import java.util.Scanner;

public class DiscountFactory implements IDiscountFactory{

    @Override
    public Idiscount MakeObj( int choice , double amount, CustomerDataManager customerDataManager) {
        if(choice==1 )
        {
            OverAllDiscount overAllDiscount= new OverAllDiscount(customerDataManager, amount);
            return overAllDiscount;
        }
        else if (choice ==2)
        {
            Scanner scanner= new Scanner(System.in);
            System.out.println("Enter The number of your choice");
            System.out.println("1.Mobile Recharge ");
            System.out.println("2.Internet Payment");
            System.out.println("3.LandLine");
            System.out.println("4.Donation");
            int choice2=scanner.nextInt();
            ServiceFactory serviceFactory=new ServiceFactory();
            Iservice iservice= serviceFactory.makeObj(choice);
            SpecificDiscount specificDiscount =new SpecificDiscount( iservice,amount);
            return specificDiscount;
        }
        return null;
    }
}
