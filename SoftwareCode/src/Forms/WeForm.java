package Forms;

import java.util.Scanner;

public class WeForm implements Iform {
    private String name;

    private double phonenum=0;


    public void Fill()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your name:");
        name=obj.nextLine();
        System.out.println("Enter your phone number");
        phonenum=obj.nextInt();

    }




    public void setPhoneNum(int phonenum) {
        this.phonenum=phonenum;
    }


    public double GetPhoneNum() {
        return phonenum;
    }


    public void SetName(String Name) {
    this.name=name;
    }


    public String GetName() {
            return this.name;
    }
}