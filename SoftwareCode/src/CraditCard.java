public class CraditCard implements IpaymentOptions {
	 private double balance = 1000;
	@Override
	public Boolean pay(double amount) {
		if(balance>=amount)
		{

			balance-=amount;
			return true;
		}
		return false;
	}

	public double GetBalance() {
		return this.balance;
	}
}
