public class DiscountFactory implements IDiscountFactory{
    Idiscount idiscount;
    @Override
    public Idiscount MakeObj(String DiscoutType) {
        if(DiscoutType== "Over All Discount")
        {
            idiscount= new OverAllDiscount();
            return idiscount;
        }

        idiscount= new SpecificDiscount();
        return idiscount;
    }
}
