package Database;
import Service.*;
import java.util.*;

public class ServiceDataManger implements IdataManger{
    ArrayList<Iservice> iservices= new ArrayList<Iservice>();
    public void Addservice(Iservice iservice)
    {
        iservices.add(iservice);
    }
    public Iservice Search(String  s)
    {
        for(Iservice iservice1 :iservices)
        {
            String name=iservice1.getName();
            if(s.equals(name))
                return iservice1;
        }
        return null;

    }
}
