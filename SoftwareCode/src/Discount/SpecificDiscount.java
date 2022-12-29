package Discount;
import Database.ServiceDataManger;
import Factories.ServiceFactory;
import Factories.ServiceProviderFactory;
import Service.*;
import User.*;

import java.util.ArrayList;

public class SpecificDiscount implements Idiscount{

    ArrayList<Iservice> iservices ;
    public SpecificDiscount (Iservice iservice,  double amount)
    {
        subscribe(iservice);
        setDiscountAmount(amount);
    }

    public void subscribe(Iservice service) {
        iservices.add(service);
    }
    public void unsubscribe(Iservice service) {
        iservices.remove(service);
    }
    public void notifyall(double amount) {
        for(Iservice ser : iservices)
        {
            ser.setDiscount(amount);
        }
    }

    public void setDiscountAmount(double amount) {
        notifyall(amount);
    }

}
