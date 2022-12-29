package Database;
import Service.*;
import java.util.*;

public class ServiceDataManger implements IdataManger{
    public ArrayList<Iservice> iservices= new ArrayList<Iservice>();
    public void Addservice(Iservice iservice)
    {
        iservices.add(iservice);
    }
    public Iservice Search(String  sevice)
    {
        for(Iservice iservice1 :iservices)
        {
            if(iservice1.getName().equals(sevice))
                return iservice1;
        }
        return null;

    }
}
