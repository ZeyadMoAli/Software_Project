public class WeForm implements Iform {
    private String name;
    private int amount=0;
    private int phonenum=0;

        public void payamount(int amount)
        {
            this.amount=amount;
        }


    @Override
    public void setPhoneNum(int phonenum) {
        this.phonenum=phonenum;
    }

    @Override
    public int GetPhoneNum() {
        return phonenum;
    }

    @Override
    public void SetName(String Name) {
    this.name=name;
    }

    @Override
    public String GetName() {
            return this.name;
    }
}