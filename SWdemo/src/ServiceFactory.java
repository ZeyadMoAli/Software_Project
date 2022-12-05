public class ServiceFactory implements IServiceFactory{

    @Override
    public Iservice makeObj(String s) {
        if(s.equals("MobileRecharge"))
        {
            MobileRecharge mobileRecharge=new MobileRecharge();
            return mobileRecharge;
        }
        else if(s.equals("InternetPayment"))
        {
            InternetPayment internetPayment=new InternetPayment();
            return internetPayment;
        }
        else if(s.equals("LandLine"))
        {
            LandLine landLine =new LandLine();
            return landLine;
        }
        else {
            Donations donations= new Donations();
            return donations;

        }
    }
}
