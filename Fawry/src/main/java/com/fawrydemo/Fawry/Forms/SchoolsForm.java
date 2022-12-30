package com.fawrydemo.Fawry.Forms;

import java.util.Scanner;

public class SchoolsForm implements Iform {

    private String name;
    private String phonenum;
    private String schoolname="";
    public void Fill()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your phone number");
        phonenum=obj.nextLine();
        System.out.println("Enter the amount you want to pay");
        schoolname=obj.nextLine();
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

void setSchoolname(String schoolname)
{
    this.schoolname=schoolname;
}
String getSchoolname()
{
    return schoolname;
}

}
