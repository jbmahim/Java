public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addCustomer(new Customer("C001", "Alice", "alice@example.com"));
        manager.addCustomer(new Customer("C002", "Bob", "bob@example.com"));

        manager.addParcel(new Parcel("P001", 5.5, "New York","C001"));
        manager.addParcel(new Parcel("P002", 2.3, "Los Angeles","C002"));

        MainView view = new MainView();
        new Controller(view, manager);
    }
}
