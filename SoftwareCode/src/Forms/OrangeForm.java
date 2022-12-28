package Forms;

import java.util.Scanner;

public class OrangeForm implements Iform{
    private String name;

    private int phonenum=0;
    private String schoolname;

    public void Fill()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your name:");
        name=obj.nextLine();
        System.out.println("Enter your phone number");
        phonenum=obj.nextInt();
        System.out.println("Enter the amount you want to pay");
        schoolname=obj.nextLine();
    }
    public void setPhoneNum(int phonenum) {
        this.phonenum=phonenum;
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

}
