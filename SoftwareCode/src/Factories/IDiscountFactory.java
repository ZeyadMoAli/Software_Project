package Factories;
import Discount.Idiscount;

public interface IDiscountFactory {
    public Idiscount MakeObj(String DiscoutType);
}
