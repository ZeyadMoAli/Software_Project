package Factories;
import Database.CustomerDataManager;
import Database.ServiceDataManger;
import Discount.Idiscount;

public interface IDiscountFactory {
    public Idiscount MakeObj( int choice , double amount, CustomerDataManager customerDataManager);
}
