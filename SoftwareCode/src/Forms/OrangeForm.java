package Forms;

import java.util.Scanner;

public class OrangeForm implements Iform{
    private String name;

    private String phonenum ;


    public void Fill()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your phone number");
        phonenum=obj.nextLine();
    }
    public void setPhoneNum(String phonenum) {
        this.phonenum=phonenum;
    }


    public String GetPhoneNum() {
        return phonenum;
    }



    public void SetName(String name) {
        this.name=name;
    }


    public String GetName() {
        return name;
    }

}
