public class We implements IserviceProvider {
    String name="We";
    WeForm form;
    Boolean cash=true;
    We()
    {

       form =new WeForm();
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
