public class Admin extends User {
    private  Idiscount idiscount;
    Admin(){};
    Admin(String username,String email,String password){
        SetUsername(username);
        SetEmail(email);
        SetPassword(password);
    }
    void MakeDiscount(String DiscountType, int discountAmount)
    {
        IDiscountFactory iDiscountFactory=new DiscountFactory();
        idiscount = iDiscountFactory.MakeObj(DiscountType);
        idiscount.setDiscountAmount(discountAmount);

    }

}
