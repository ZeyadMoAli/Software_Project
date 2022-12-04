import java.util.ArrayList;

public class AdminDataManager implements IdataManger{
    ArrayList<Admin> admins= new ArrayList<Admin>();
    void AddAdmin(Admin admin)
    {
        admins.add(admin);
    }

}
