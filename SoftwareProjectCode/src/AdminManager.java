
public class AdminManager extends UserManager {
  void CreateNewUser(String username,String email,String password) {
    	Admin new_admin = new Admin(username,email,password);
    	mp_username_to_user_object.put(username, new_admin);
    	user = new_admin;    	
    }
    void LoadDataBase() {
    	Admin Admin1 = new Admin("nohaEl","n@gmail","111");
    	mp_username_to_user_object.put("nohaEl", Admin1);
    	Admin Admin2 = new Admin("monaAhmed","m@gmail","333");

    	mp_username_to_user_object.put("monaAhmed", Admin2);
    }

}
