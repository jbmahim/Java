public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Customer customer1 = new Customer("C001", "Alice", "alice@example.com");
        Customer customer2 = new Customer("C002", "Bob", "bob@example.com");

        Parcel parcel1 = new Parcel("P001", 5.5, "New York");
        Parcel parcel2 = new Parcel("P002", 2.3, "Los Angeles");

        manager.addCustomerToQueue(customer1);
        manager.addCustomerToQueue(customer2);

        manager.addParcelToMap(parcel1);
        manager.addParcelToMap(parcel2);

        manager.processNextCustomer("P001");
        manager.processNextCustomer("P002");

        Log.getInstance().displayLog();
    }
}
