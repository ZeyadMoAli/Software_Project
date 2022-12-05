import java.util.ArrayList;

public class AdminDataManager implements IdataManger{
    ArrayList<Admin> admins= new ArrayList<Admin>();
    public void AddAdmin(Admin admin)
    {
        admins.add(admin);
    }

    boolean FindAdmin(Admin admin)
    {
        for(Admin admin1: admins)
        {
            if(admin1.GetUsername() == admin.GetUsername()  && admin1.GetEmail()==admin.GetEmail() )
                return true;
        }
        return false;
    }


}
