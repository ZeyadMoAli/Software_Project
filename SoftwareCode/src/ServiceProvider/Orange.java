package ServiceProvider;
import Forms.*;
public class Orange  implements IserviceProvider {
    OrangeForm form;
    String name="Orange";
    Boolean cash=false;
    public Orange()
    {


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

