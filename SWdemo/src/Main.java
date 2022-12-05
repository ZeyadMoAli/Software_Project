public class Main {
    static CustomerDataManager customers = new CustomerDataManager();
    static AdminDataManager admins = new AdminDataManager();
    public static void main(String[] args) {
        Admin admin1= new Admin("Zeyad","Zeyad@gmail","1234");
        admins.AddAdmin(admin1);

    }
}