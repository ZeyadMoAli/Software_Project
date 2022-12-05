public abstract class ServiceProvider {
    private int discount_amount=0;
    void upDateDiscount(int amount) {
        this.discount_amount=amount;
    }
    int getDiscount_amount()
    {
        return discount_amount;
    }


}
