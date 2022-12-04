
public class Customer extends User {
	Wallet customer_wallet = new Wallet();
	Customer(){}
	Customer(String username,String email,String password){
		SetUsername(username);
		SetEmail(email); 
		SetPassword(password);
	}
}
