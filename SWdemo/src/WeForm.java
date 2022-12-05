public class WeForm implements Iform {
    private String name;
    private int amount=0;
    private int phonenum=0;


<<<<<<< HEAD
    @Override
    public void setPhoneNum(int phonenum) {
=======
    public void setPhoneNum() {
>>>>>>> 62bed8aefa3e180dbabb4ae97509f48b1825e628
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


}
