public class SchoolsForm implements Iform {

    private String name;
    private int amount=0;
    private int phonenum=0;
    private String schoolname="";
    @Override
    public void setPhoneNum(int phonenum) {
        this.phonenum=phonenum;
    }



    @Override
    public int GetPhoneNum() {
        return phonenum;
    }


    @Override
    public void SetName(String name) {
        this.name=name;
    }

    @Override
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
