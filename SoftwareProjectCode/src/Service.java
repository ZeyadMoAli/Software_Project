import java.util.Set;

import javax.management.loading.PrivateClassLoader;

public abstract class Service {
	private String service_name ;
	String GetServiceName(){
		return service_name;
	}
	void SetServiceName(String service_name) {
		this.service_name = service_name;
	}
}
