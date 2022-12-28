package ServiceProvider;
import Forms.*;
public class Etisalat implements IserviceProvider  {
    public EtisalatForm form;
    String name="Etisalat";
    Boolean cash=true;
    public Etisalat()
    {

        form =new EtisalatForm();
    }
    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public Boolean CashState() {
        return this.cash;
    }

    @Override
    public void FillForm() {
        form.Fill();
    }
}

