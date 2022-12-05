public class NGOsName implements Iform {
    private String name;
    private int amount=0;
    private int phonenum=0;
    private String NGOName;
    private String roomnum;

    @Override
    public void setPhoneNum(int phonenum) {
        this.phonenum=phonenum;
    }

    @Override
    public int GetPhoneNum() {
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
    public void NGOName(String NGOName) {
        this.NGOName=NGOName;
    }


    public String NGOName() {
        return NGOName;
    }
}
