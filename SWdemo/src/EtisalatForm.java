<<<<<<< HEAD
public class EtisalatForm implements Iform{
    private String name;
    private int amount=0;
    private int phonenum=0;

    @Override
    public void setPhoneNum(int phonenum) {
        this.phonenum=phonenum;
=======
public class EtisalatForm implements Iform {
    private String name;
    private int amount = 0;
    private int phonenum = 0;

    @Override
    public void setPhoneNum(int phonenum) {
        this.phonenum = phonenum;
    }

    public void setPhoneNum() {
        this.phonenum = phonenum;
>>>>>>> 62bed8aefa3e180dbabb4ae97509f48b1825e628
    }

    @Override
    public int GetPhoneNum() {
        return phonenum;
    }


    @Override
    public void SetName(String name) {
<<<<<<< HEAD
        this.name=name;

>>>>>>> 62bed8aefa3e180dbabb4ae97509f48b1825e628
    }

    @Override
    public String GetName() {
        return name;
    }
<<<<<<< HEAD

    public void payamount(int amount)
    {
        this.amount=amount;
    }
=======
>>>>>>> 62bed8aefa3e180dbabb4ae97509f48b1825e628
}
