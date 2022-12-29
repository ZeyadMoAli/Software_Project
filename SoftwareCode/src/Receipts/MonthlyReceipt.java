package Receipts;

public class MonthlyReceipt implements Ireceipt{
    double receipt=100;
    public double getReceip() {
        return receipt;
    }

    public void setReceip(double receip) {
        this.receipt = receip;
    }
}
