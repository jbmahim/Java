public class Manager {
    private QueueOfCustomers customerQueue;
    private ParcelMap parcelMap;

    public Manager() {
        customerQueue = new QueueOfCustomers();
        parcelMap = new ParcelMap();
    }

    public void addCustomerToQueue(Customer customer) {
        customerQueue.addCustomer(customer);
    }

    public void addParcelToMap(Parcel parcel) {
        parcelMap.addParcel(parcel);
    }

    public void processNextCustomer(String parcelId) {
        Customer customer = customerQueue.removeCustomer();
        Parcel parcel = parcelMap.getParcel(parcelId);

        Worker worker = new Worker();
        worker.processCustomer(customer, parcel);
    }
}
