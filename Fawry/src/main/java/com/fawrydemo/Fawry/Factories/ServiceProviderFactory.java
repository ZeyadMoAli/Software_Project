package com.fawrydemo.Fawry.Factories;
import com.fawrydemo.Fawry.ServiceProvider.*;
public class ServiceProviderFactory implements IserviceProviderFactory{

    @Override
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
        else if(choice ==5)
        {
            Schools schools=new Schools();
            return schools;
        }
        else if(choice ==6 )
        {
            NGOS ngos=new NGOS();
            return ngos;
        }

        else {
            CancerHospital cancerHospital=new CancerHospital();
            return cancerHospital;
        }

    }
}
