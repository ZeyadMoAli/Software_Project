package com.fawrydemo.Fawry.Database;
import com.fawrydemo.Fawry.Service.*;
import java.util.*;

public class ServiceDataManger implements IdataManger{
    public ArrayList<Iservice> iservices= new ArrayList<Iservice>();
    public void Addservice(Iservice iservice)
    {
        iservices.add(iservice);
    }
    public Iservice Search(String  service)
    {
        for(Iservice iservice1 :iservices)
        {
            if(iservice1.getName().equals(service))
                return iservice1;
        }
        return null;
    }
}
