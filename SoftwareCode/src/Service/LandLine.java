package Service;

public class LandLine implements Iservice {
    String name="Landline";
    static double discount=0;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public void setDiscount(double discount) {
    this.discount= discount;
    }


}
