public class Worker {
    public void processCustomer(Customer customer, Parcel parcel) {
        if (customer != null && parcel != null) {
            Log.getInstance().addLog("Processed Parcel: " + parcel + " for Customer: " + customer);
        } else {
            Log.getInstance().addLog("Failed to process - Customer or Parcel missing.");
        }
    }
}
