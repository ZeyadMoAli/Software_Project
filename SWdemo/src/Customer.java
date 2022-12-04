public class Customer extends User {
    private int discount_amount=0;
    Customer(){}
    Customer(String username,String email,String password){
        SetUsername(username);
        SetEmail(email);
        SetPassword(password);
    }
    void upDateDiscount(int amount)
    {
        this.discount_amount= amount;
    }

    void apply_discount()
    {
        if(this.discount_amount==0)
            System.out.println("You have No discount on this service");
        else
        {

            System.out.println("You have "+ discount_amount +"% discount on this service");
        }
    }


}
