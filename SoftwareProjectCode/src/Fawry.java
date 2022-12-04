import java.util.Scanner;

public class Fawry {
	UserManager user_manager;
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
		int choice = FormAdminOrUser();
		if (choice==1)
			user_manager = new AdminManager();
		else 
			user_manager = new CustomerManager();
		choice = FormEntering();
		user_manager.LoadDataBase();
		user_manager.AccessToFawry(choice);
	
	}
}
