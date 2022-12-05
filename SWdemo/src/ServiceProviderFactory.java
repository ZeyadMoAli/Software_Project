public class ServiceProviderFactory implements IserviceProviderFactory{

    @Override
    public IserviceProvider makeObj(String s) {
        if(s.equals("We"))
        {
            We we =new We();
            return we;
        }
        else if(s.equals("Orange"))
        {
            Orange orange=new Orange();
            return orange;
        }
        else if(s.equals("Etisalat"))
        {
            Etisalat etisalat=new Etisalat();
            return etisalat;
        }
        else if(s.equals("Schools"))
        {
            Schools schools=new Schools();
            return schools;
        }
        else if(s.equals("NGOS"))
        {
            NGOS ngos=new NGOS();
            return ngos;
        }
        else if(s.equals("Vodafone"))
        {
            Vodafone vodafone=new Vodafone();
            return vodafone;
        }
        else {
            CancerHospital cancerHospital=new CancerHospital();
            return cancerHospital;
        }

    }
}
