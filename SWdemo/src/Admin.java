class Admin implements IUser {
    private String username;
    private String email;
    private String password;


    TransactionDataManager transactionDataManager = new TransactionDataManager();

    Admin(){};
    Admin(String username,String email,String password){
        SetUsername(username);
        SetEmail(email);
        SetPassword(password);
    }
    public void MakeOverAllDiscount( int discountAmount ,OverAllDiscount overAllDiscount)
    {
        overAllDiscount.setDiscountAmount(discountAmount);

    }
    public void MakeSpecificDiscount( int discountAmount, Iservice iservice ,SpecificDiscount specificDiscount)
    {
        specificDiscount.setDiscountAmount(discountAmount, iservice);

    }





    public void refundTransaction(Transaction transaction){

        if (transactionDataManager.transactionSearch(transaction) != null) {


            transaction.setRefundSuccessful(true);


        } else {

            System.out.println("Transaction not found.");
        }








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
