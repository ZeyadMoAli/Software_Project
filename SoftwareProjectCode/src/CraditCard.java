
public class CraditCard implements Payment{
	 private double balance = 200000;
	 double GetBalance() {
		 return balance;
	 }

     public void pay(double amount)
	 {
		 balance-=amount;
	 }

}
