package PaymentOptions;

public class Wallet  implements IpaymentOptions {
	private double balance = 0;
	public boolean AddBalance (CraditCard c,double num) {
		if(c.pay(num) ==true)
		{
			balance+=num;
			return true;
		}
		return false;
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


	public double GetBalance() {
		return this.balance;
	}
}
