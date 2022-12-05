public class NGOSForm implements Iform{
    private String name;
    private int amount = 0;
    private int phonenum = 0;

    @Override
    public void setPhoneNum(int phonenum) {
        this.phonenum = phonenum;
    }

    public void setPhoneNum() {
        this.phonenum = phonenum;
    }

    @Override
    public int GetPhoneNum() {
        return phonenum;
    }


    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String GetName() {
        return name;
    }

}
