import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServiceManager {
    Map<String, Service> mp_servicename_to_servic_object = new HashMap<>();
    public ServiceManager() {
    	LoadDataBase();	
    }
    void LoadDataBase() {
    	Service mobileRecharge = new MobileRechargeServices();
    	Service internetPayment = new InternetPaymentServices();
    	mp_servicename_to_servic_object.put(mobileRecharge.GetServiceName(), mobileRecharge);
    	mp_servicename_to_servic_object.put(internetPayment.GetServiceName(), internetPayment);
    	
    }
    String SearchForService() {
    	String service_name;
        Scanner in = new Scanner(System.in);
    	while(true) {
    		System.out.print("Enter name of Service: ");
    		service_name =in.nextLine();
    		System.out.println(service_name);

    		if (mp_servicename_to_servic_object.containsKey(service_name)) {
        		System.out.println("Service:"+service_name+" is found");
        		break;
        	}
    		else {
        		System.out.println("Service isnot found , try again");
							}
    		  			
    			
    	}

    	return service_name;
    }
    Service GetServiceByName(String s_name){
    	   return mp_servicename_to_servic_object.get(s_name);
    }
    void ShowAllServiceName() {}
    
}
