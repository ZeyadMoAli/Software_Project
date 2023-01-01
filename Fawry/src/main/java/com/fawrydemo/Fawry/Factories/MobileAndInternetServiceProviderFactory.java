package com.fawrydemo.Fawry.Factories;
import com.fawrydemo.Fawry.ServiceProvider.*;
public class MobileAndInternetServiceProviderFactory {


    public IserviceProvider makeObj(int choice) {
        if(choice ==1)
        {
            We we =new We();
            return we;
        }
        else if(choice ==2)
        {
            Orange orange=new Orange();
            return orange;
        }
        else if(choice ==3)
        {
            Etisalat etisalat=new Etisalat();
            return etisalat;
        }

        else if(choice ==4)
        {
            Vodafone vodafone=new Vodafone();
            return vodafone;
        }

        return null;

    }
}
