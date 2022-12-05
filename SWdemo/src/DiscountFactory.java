public class DiscountFactory implements IDiscountFactory{

    @Override
    public Idiscount MakeObj(String DiscoutType) {
        if(DiscoutType== "Over All Discount")
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
