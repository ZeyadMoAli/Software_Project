
public abstract class User {
	private String username;
	private String email;
	private String password;


	User(){};
	String GetUsername() {
		return username;
	}
	String GetEmail() {
		return email;
	}
	String GetPassword() {
		return password;
	}
	void SetUsername(String username) {
		this.username = username;
	}
	void SetEmail(String email) {
		this.email = email;
	}
	void SetPassword(String password) {
		this.password = password;
	}
}
