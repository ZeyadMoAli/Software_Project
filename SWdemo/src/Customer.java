class Customer implements IUser {
    private String username;
    private String email;
    private String password;
    private int discount_amount = 0;
    private CraditCard craditCard = new CraditCard();
    private Wallet wallet = new Wallet();

    Customer() {
    }

    Customer(String username, String email, String password) {
        SetUsername(username);
        SetEmail(email);
        SetPassword(password);
    }

    void AddToWallet(int balance) {
        wallet.AddBalance(craditCard, balance);
    }

    void upDateDiscount(int amount) {
        this.discount_amount = amount;
    }

    void apply_discount() {
        if (this.discount_amount == 0)
            System.out.println("You have No discount on this service");
        else {

            System.out.println("You have " + discount_amount + "% discount on this service");
        }
    }

    void Register(CustomerDataManager customerDataManager) {
        customerDataManager.addCustomer(this);
    }

    Boolean Login(CustomerDataManager customerDataManager) {
        if (customerDataManager.FindCustomer(this)) {
            return true;
        }
        return false;

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
    public void SetUsername(String Username) {
        username = Username;
    }

    @Override
    public void SetEmail(String Email) {
        email = Email;
    }

    @Override
    public void SetPassword(String Password) {
        password = Password;
    }

    public void refund(Transaction transaction) {

        TransactionDataManager transactionDataManager = new TransactionDataManager();


        if (transactionDataManager.transactionSearch(transaction) != null) {


            transaction.setIsRefunded(true);


        } else {

            System.out.println("Transaction not found.");
        }
    }
}
