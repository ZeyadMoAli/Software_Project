package ServiceProvider;
import Forms.*;
public class CancerHospital implements IserviceProvider  {
    CancerHospitalForm form;
    String name="CancerHospital";

    Boolean cash=false;
    public CancerHospital()
    {

        form =new CancerHospitalForm();
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

