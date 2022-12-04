import java.awt.DisplayMode;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerView implements UserView { //Boundry class for customer
	ServiceManager serviceManager = new ServiceManager();
	Service current_sevice;
	int FormCustomer() {
		int choice = -1;
	    Scanner in = new Scanner(System.in);
	    while (choice == -1) {
	    	System.out.println("1-Search For Service");
	    	System.out.println("2- ");
	    	System.out.println("3-Log Out ");	    	
	    	System.out.print("Enter number of your choice in range 1-2: ");
	    	choice = in.nextInt();
	    	if( !(choice>=1&&choice<=3)) {
		    	System.out.println("invalid choice");
	    		choice = -1;
	    	}
	    }
	    return choice;

		
	}
	public void Run(){
		while (true) {
			int choice = FormCustomer();
			if (choice==1) {
				String service_name=serviceManager.SearchForService();
				current_sevice = serviceManager.GetServiceByName(service_name);
			}
			if (choice == 3) {
				break;
			}
		}
	}
}
