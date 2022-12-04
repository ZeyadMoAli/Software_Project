import java.util.Scanner;

public class Fawry { //boundery class
	UserManager user_manager;
	int customer_admin;
	UserView userView;
	
	int FormAdminOrUser() {
		int choice = -1;
		while(choice == -1) {
			Scanner in = new Scanner(System.in);
			System.out.println("enter as Admin or Customer");
			System.out.println("1-Admin");
			System.out.println("2-Customer");
			System.out.println("enter number 1 or 2");
			choice = in.nextInt();
			if (!(choice >=1&&choice<=2)) {
				System.out.println("invalid choice try again");
				choice=-1;
			}
		}
		return choice;		
	}
	int FormEntering(){
		int choice = -1;
		while(choice == -1) {
			Scanner in = new Scanner(System.in);
			System.out.println("1-Log in");
			System.out.println("2-Sign up");
			System.out.println("enter number 1 or 2");
			choice = in.nextInt();
			if (!(choice >=1&&choice<=2)) {
				System.out.println("invalid choice try again");
				choice=-1;
			}
		}
		return choice; 
	}
	void run() {		
		while (true) {
			customer_admin = FormAdminOrUser();
			if (customer_admin==1)
				user_manager = new AdminManager();
			else 
				user_manager = new CustomerManager();
			int choice = FormEntering();
			user_manager.LoadDataBase();
			user_manager.AccessToFawry(choice);
			if (customer_admin==2) {
				userView = new CustomerView();
				userView.Run();
			}
				
				
		}
	
	}
}
