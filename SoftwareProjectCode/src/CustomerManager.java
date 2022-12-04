import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.lang.model.element.NestingKind;
import javax.security.auth.login.LoginContext;

public class CustomerManager extends UserManager {
    @Override
    void CreateNewUser(String username,String email,String password) {
    	Customer new_customer = new Customer(username,email,password);
    	mp_username_to_user_object.put(username, new_customer);
    	user = new_customer;    	
    }
    void LoadDataBase() {
    	Customer customer1 = new Customer();
    	customer1.SetUsername("hebaAbdelwahab");
    	customer1.SetEmail("h@gmail.com");
    	customer1.SetPassword("111");
    	mp_username_to_user_object.put("hebaAbdelwahab", customer1);
    	Customer customer2 = new Customer();
    	customer2.SetUsername("hassanEl");
    	customer2.SetEmail("El@gmail.com");
    	customer2.SetPassword("222");
    	mp_username_to_user_object.put("hassanEl", customer2);
    }



}
