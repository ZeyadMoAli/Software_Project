public class InternetPayment implements Iservice{
    String name="InternetPayment";
    int discount_amoutn=0;
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setDiscount_amoutn(int discount_amoutn) {
        this.discount_amoutn=discount_amoutn;
    }

    @Override
    public int GetDiscount() {
        return this.discount_amoutn;
    }

}
