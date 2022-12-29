package Forms;

import java.util.Scanner;

public class NGOSForm implements Iform{
    private String name;
    private String phonenum;
    private String NGOName;
    private String roomnum;

    public void Fill()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your phone number");
        phonenum=obj.nextLine();

        System.out.println("Enter NGO name");
        NGOName=obj.nextLine();

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

    public void NGOName(String NGOName) {
        this.NGOName=NGOName;
    }


    public String NGOName() {
        return NGOName;
    }

}
