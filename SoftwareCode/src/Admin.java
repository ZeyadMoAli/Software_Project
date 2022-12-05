class Admin implements IUser {
    private String username;
    private String email;
    private String password;
    Admin(){};
    Admin(String username,String email,String password){
        SetUsername(username);
        SetEmail(email);
        SetPassword(password);
    }
    void HandleRefund(TransactionDataManager transactionDataManager)
    {
        transactionDataManager.hadleRefund();

    }
    public void MakeOverAllDiscount( double discountAmount ,OverAllDiscount overAllDiscount)
    {
        overAllDiscount.setDiscountAmount(discountAmount);

    }
    public void MakeSpecificDiscount( double discountAmount, Iservice iservice ,SpecificDiscount specificDiscount)
    {
        specificDiscount.setDiscountAmount(discountAmount, iservice);

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
