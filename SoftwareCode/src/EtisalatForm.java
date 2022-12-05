import java.util.Scanner;

public class EtisalatForm implements Iform{
    private String name;
    private int amount=0;
    private int phonenum=0;


    public void Fill()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your name:");
        name=obj.nextLine();
        System.out.println("Enter your phone number");
        phonenum=obj.nextInt();
    }
    public void setPhoneNum(int phonenum) {
        this.phonenum = phonenum;
    }


    public int GetPhoneNum() {
        return phonenum;
    }



    public void SetName(String name) {
        this.name=name;

    }


    public String GetName() {
        return name;
    }

    public void payamount(int amount)
    {
        this.amount=amount;
    }
}
