public interface Idiscount {
    void subscribe(Customer customer);
    void unsubscribe(Customer customer);
    void notifyall();
    int getDiscountAmount();
    void setDiscountAmount(int amount);

}
