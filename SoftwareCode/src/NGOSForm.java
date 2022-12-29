import java.util.Scanner;

public class NGOSForm implements Iform{
    private String name;
    private int phonenum=0;
    private String NGOName;
    private String roomnum;

    public void Fill()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your phone number");
        phonenum=obj.nextInt();

        System.out.println("Enter NGO name");
        NGOName=obj.nextLine();

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

    public void NGOName(String NGOName) {
        this.NGOName=NGOName;
    }


    public String NGOName() {
        return NGOName;
    }

}
