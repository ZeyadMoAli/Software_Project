public class Donations implements Iservice{
    String name="Donation";
    double discount_amoutn=0;
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setDiscount_amoutn(double discount_amoutn) {
        this.discount_amoutn=discount_amoutn;
    }

    @Override
    public double GetDiscount() {
        return this.discount_amoutn;
    }

}