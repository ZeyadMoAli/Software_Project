package Forms;

import java.util.Scanner;

public class CancerHospitalForm implements Iform{
    private String name;
    private String phonenum;
    private String hospitalName;
    private String roomnum;

    public void Fill()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your phone number");
        phonenum=obj.nextLine();
        System.out.println("Enter hospital name");
        hospitalName=obj.nextLine();
        System.out.println("Enter room num");
        roomnum=obj.nextLine();

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

    public void SetHospitalName(String hospitalName) {
        this.hospitalName=hospitalName;
    }
    public String GetHospitalName() {
        return name;
    }
    public void RoomNum(String roomNum) {
        this.roomnum=roomNum;
    }


    public String roomNum() {
        return roomnum;
    }

}
