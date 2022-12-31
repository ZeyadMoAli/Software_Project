package com.fawrydemo.Fawry.Factories;
import com.fawrydemo.Fawry.Database.*;
import com.fawrydemo.Fawry.Discount.*;
import com.fawrydemo.Fawry.Service.*;

import java.util.Scanner;

public class DiscountFactory implements IDiscountFactory{

    @Override
    public Idiscount MakeObj( int choice , double amount, CustomerDataManager customerDataManager, int serviceChoice) {
        if(choice==1 )
        {
            OverAllDiscount overAllDiscount= new OverAllDiscount(customerDataManager, amount);
            return overAllDiscount;
        }
        else if (choice ==2)
        {
            ServiceFactory serviceFactory=new ServiceFactory();
            Iservice iservice = serviceFactory.makeObj(serviceChoice);
            SpecificDiscount specificDiscount =new SpecificDiscount(iservice, amount);
            return specificDiscount;

        }
        return  null;
    }
}
