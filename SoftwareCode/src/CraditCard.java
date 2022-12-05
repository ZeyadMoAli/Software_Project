public class CraditCard implements IpaymentOptions {
	 private double balance = 200000;



	@Override
	public Boolean pay(double amount) {
		if(balance>=amount)
		{

			balance-=amount;
			return true;
		}
		return false;
	}

	@Override
	public double GetBalance() {
		return this.balance;
	}
}
