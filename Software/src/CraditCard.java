import java.util.TreeMap;

public class CraditCard implements Payment{
	 private double balance = 200000;
	 double GetBalance() {
		 return balance;
	 }


	@Override
	public Boolean pay(double amount) {
		if(balance>=amount)
		{

			balance-=amount;
			return true;
		}
		return false;
	}
}
