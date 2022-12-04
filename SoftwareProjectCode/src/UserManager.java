import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public abstract class UserManager  {
    Map<String, User> mp_username_to_user_object = new HashMap<>();
    User user;
    abstract void LoadDataBase();
    abstract void CreateNewUser(String username,String email,String password);
    void ValidateUsername (String username){
    	while(true) {
    		if (mp_username_to_user_object.containsKey(username))
    			return ;
    		else 
    	    	System.out.print(username +" :No User Has such Username ");   			
    	}
    	
    }
    
    String EnterUserNameInSignUp() {
    	String username;
        Scanner in = new Scanner(System.in);
        while(true) {
        	System.out.print("enter your username: ");
        	username = in.nextLine();
        	if(!mp_username_to_user_object.containsKey(username))
        		break;
        	else 
        		System.out.println(username +" :No User Has such Username Try again");   			        		
        }       
        return username;
    }
    String EnterUserNameInLogIn() {

   /*   for (Entry<String, User> entry : mp_username_to_user_object.entrySet()){
    	    	  System.out.print( entry.getValue().GetUsername());
      }*/

    	String username;
        Scanner in = new Scanner(System.in);
        while(true) {
        	System.out.print("enter your username: ");
        	username = in.nextLine();
        	if(mp_username_to_user_object.containsKey(username))
        		break;
        	else 
        		System.out.println(username +" :No User Has such Username Try again");   			        		
        }       
        return username;
    }
  boolean IsNewEmail(String email) {
      for (Entry<String, User> entry : mp_username_to_user_object.entrySet()){
    	  String another_user_email=entry.getValue().GetEmail();
          if (another_user_email.equals(email) )
        	  return false;
      }
      return true;
  }
  
   String EnterEmail() {
    	String email;
        Scanner in = new Scanner(System.in);

        while(true) {
        	System.out.print("enter Email: ");
        	email = in.nextLine();
        	if(IsNewEmail(email))
        		break;
        	else 
        		System.out.println("User already Has such email Try again");   			        		
        }
        return email;
    }
    
    void LogIn() {
        Scanner in = new Scanner(System.in);
        String  password;
        String username = EnterUserNameInLogIn();
        User originalCustomer = mp_username_to_user_object.get(username);
        while(true) {
        	System.out.print("enter your password: ");
        	 password = in.nextLine();
        	if(originalCustomer.GetPassword().equals(password))
        		break;
        	else 
        		System.out.println("Pasword Incorrect,Try again");   			        		
        }        
        user=originalCustomer;
    }
    void SignUp() {
        Scanner in = new Scanner(System.in);
        String password;
        String username = EnterUserNameInSignUp();
        String email=EnterEmail();
    	System.out.print("enter your password: ");
    	password = in.nextLine();
    	CreateNewUser(username, email, password);

    }
    
    void AccessToFawry(int choice) {
    	if (choice == 1)
    		LogIn();
    	else 
			SignUp();
		
    }  
}
