public class Schools implements IserviceProvider  {
    SchoolsForm form;
    String name="Schools";
    Boolean cash=false;
    Schools()
    {

        form =new SchoolsForm();
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
