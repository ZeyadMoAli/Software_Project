public class Wallet  implements Payment{
	double balance = 0;
	void AddBalance (CraditCard c,int num) {
		c.pay(num);
		balance+=num;
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
