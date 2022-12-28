package Database;
import User.*;
import java.util.*;

public class AdminDataManager implements IdataManger{
    ArrayList<Admin> admins= new ArrayList<Admin>();
    public void AddAdmin(Admin admin)
    {
        admins.add(admin);
    }



}
