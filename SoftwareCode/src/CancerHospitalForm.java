import java.util.Scanner;

public class CancerHospitalForm implements Iform{
    private String name;
    private int phonenum=0;
    private String hospitalName;
    private String roomnum;

    public void Fill()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your name:");
        name=obj.nextLine();
        System.out.println("Enter your phone number");
        phonenum=obj.nextInt();
        System.out.println("Enter hospital name");
        hospitalName=obj.nextLine();
        System.out.println("Enter room num");
        roomnum=obj.nextLine();

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
