class Admin implements IUser {
    private String username;
    private String email;
    private String password;
    private static  OverAllDiscount overAllDiscount;
    private static SpecificDiscount specificDiscount;
    Admin(){};
    Admin(String username,String email,String password){
        SetUsername(username);
        SetEmail(email);
        SetPassword(password);
    }
    public void MakeOverAllDiscount( int discountAmount)
    {
        overAllDiscount = new OverAllDiscount();
        overAllDiscount.setDiscountAmount(discountAmount);

    }
    public void MakeSpecificDiscount( int discountAmount)
    {
        specificDiscount = new SpecificDiscount();
        specificDiscount.setDiscountAmount(discountAmount);
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
