package Factories;
import Discount.Idiscount;
import Discount.OverAllDiscount;
import Discount.SpecificDiscount;

public class DiscountFactory implements IDiscountFactory{

    @Override
    public Idiscount MakeObj(String DiscoutType) {
        if(DiscoutType.equals("Over All Discount") )
        {
            OverAllDiscount idiscount;
            idiscount= new OverAllDiscount();
            return idiscount;
        }
        else
        {
            SpecificDiscount idiscount;
            idiscount= new SpecificDiscount();
            return idiscount;
        }
    }
}
