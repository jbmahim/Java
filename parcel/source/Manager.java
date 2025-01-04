import java.util.LinkedList;
import java.util.Queue;

public class Manager {
    private Queue<Customer> customerQueue;
    private Queue<Parcel> parcelQueue;

    public Manager() {
        customerQueue = new LinkedList<>();
        parcelQueue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        customerQueue.add(customer);
    }

    public void addParcel(Parcel parcel) {
        parcelQueue.add(parcel);
    }

    public String processNextCustomer() {
        if (customerQueue.isEmpty() || parcelQueue.isEmpty()) {
            return null;
        }
        Customer customer = customerQueue.poll();
        Parcel parcel = parcelQueue.poll();
        return "Processed Customer: " + customer + "\nParcel: " + parcel;
    }

    public String getCustomerQueueAsString() {
        StringBuilder sb = new StringBuilder();
        for (Customer customer : customerQueue) {
            sb.append(customer).append("\n");
        }
        return sb.toString();
    }

    public String getParcelListAsString() {
        StringBuilder sb = new StringBuilder();
        for (Parcel parcel : parcelQueue) {
            sb.append(parcel).append("\n");
        }
        return sb.toString();
    }
}
