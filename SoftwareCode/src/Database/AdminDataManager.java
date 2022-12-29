package Database;
import User.*;
import java.util.*;

public class AdminDataManager implements IdataManger{
    ArrayList<Admin> admins= new ArrayList<Admin>();
    public void AddAdmin(Admin admin)
    {
        admins.add(admin);
    }
    public Admin FindAdmin(Admin admin)
    {
        for(Admin admin1: admins)
        {
            if(admin1.getUsername().equals(admin.getUsername()) && admin1.getPassword().equals(admin.getPassword()))
            {
                return admin1;
            }
        }
        return null;

    }



}
