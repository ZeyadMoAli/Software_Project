
public class Wallet  {
	double balance = 0;
	void AddBalance (CraditCard c,int num) {
		c.pay(num);
		balance+=num;
	}
}
