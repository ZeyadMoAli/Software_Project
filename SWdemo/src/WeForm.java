public class WeForm implements Iform {


    private String name;
    private int amount=0;
    private int phonenum=0;
    @Override
    public void setPhoneNum(int phonenum) {
        this.phonenum=phonenum;
    }

    @Override
    public void setPhoneNum() {
        this.phonenum=phonenum;
    }

    @Override
    public int getPhoneNum() {
        return phonenum;
    }

    @Override
    public void SetName(String name) {
          this.name=name;
    }

    @Override
    public String GetName() {
        return name;
    }

    public void payamount(int amount)
    {
        this.amount=amount;
    }

}