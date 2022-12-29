package User;
import Database.*;
import Discount.OverAllDiscount;
import Discount.SpecificDiscount;
import Factories.DiscountFactory;
import Service.*;
public class Admin implements IUser {
    private String username;
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(){};
    public Admin(String username,String email,String password){
        SetUsername(username);
        SetEmail(email);
        SetPassword(password);
    }
    public  void HandleRefund(TransactionDataManager transactionDataManager)
    {
        transactionDataManager.ListRefund();

    }
    public void MakeDiscount(double discountAmount ,CustomerDataManager customerDataManager ,int choice )
    {
        DiscountFactory discountFactory =new DiscountFactory();
        discountFactory.MakeObj(choice,discountAmount,customerDataManager);
    }


    @Override
    public String GetUsername() {
        return this.username;
    }

    @Override
    public String GetEmail() {
        return this.email;
    }

    @Override
    public String GetPassword() {
        return this.password;
    }

    @Override
    public void SetUsername(String username) {
        this.username=username;
    }

    @Override
    public void SetEmail(String email) {
        this.email=email;
    }

    @Override
    public void SetPassword(String password) {
        this.password=password;
    }


}
