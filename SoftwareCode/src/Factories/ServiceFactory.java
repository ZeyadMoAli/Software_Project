package Factories;

import Service.*;

public class ServiceFactory implements IServiceFactory{

    @Override
    public   Iservice makeObj(int choice) {

        if(choice==1)
        {
            MobileRecharge mobileRecharge=new MobileRecharge();
            return mobileRecharge;
        }
        else if(choice==2)
        {
            InternetPayment internetPayment=new InternetPayment();
            return internetPayment;
        }
        else if(choice==3)
        {
            LandLine landLine =new LandLine();
            return landLine;
        }
        else if(choice==4) {
            Donations donations= new Donations();
            return donations;
        }
        return null;
    }
}
