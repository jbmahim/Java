import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Manager {
    private Queue<Customer> customerQueue;
    private Queue<Parcel> parcelQueue;
    public Customer currentlyProcessing;
    public Manager() {
        customerQueue = new LinkedList<>();
        parcelQueue = new LinkedList<>();
        currentlyProcessing = null;
    }

    public void addCustomer(Customer customer) {
        customerQueue.add(customer);
    }

    public void addParcel(Parcel parcel) {
        parcelQueue.add(parcel);
    }

    // public void processNextCustomer() {
    //     if (!customerQueue.isEmpty()) {
    //         currentlyProcessing = customerQueue.poll();
    //         System.out.println("Processing: " + currentlyProcessing.getName());
    //     } else {
    //         currentlyProcessing = null; // No customers to process
    //         System.out.println("No customers in the queue.");
    //     }
    // }


    public void processNextCustomer() {
        if (!customerQueue.isEmpty()) {
            currentlyProcessing = customerQueue.poll();
            System.out.println("Processing: " + currentlyProcessing.getName());
    
            parcelQueue.stream()
                .filter(parcel -> parcel.getCustomerId().equals(currentlyProcessing.getId()))
                .forEach(parcel -> {
                    double fee = parcel.calculateFee(); 
                    Log.getInstance().addLog(
                        "Customer Processed: " + currentlyProcessing.getName() +
                        " (ID: " + currentlyProcessing.getId() + ")" +
                        " Parcel Fee: " + fee +
                        " Parcel ID: " + parcel.getId()
                    );
                });
    
            parcelQueue.removeIf(parcel -> parcel.getCustomerId().equals(currentlyProcessing.getId()));
        } else {
            currentlyProcessing = null; 
            System.out.println("No customers in the queue.");
        }
    }
    
    public String getProcessingInfo() {
        if (currentlyProcessing != null) {
            return "Currently Processing:\n"
                    + "ID: " + currentlyProcessing.getId() + "\n"
                    + "Name: " + currentlyProcessing.getName() + "\n"
                    + "Email: " + currentlyProcessing.getEmail();
        } else {
            return "No customer is being processed at the moment.";
        }
    }
    public List<Parcel> getParcelsForCustomer(String customerId) {
        List<Parcel> associatedParcels = new ArrayList<>();
        for (Parcel parcel : parcelQueue) {
            if (parcel.getCustomerId().equals(customerId)) {
                associatedParcels.add(parcel);
            }
        }
        return associatedParcels;
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
    public List<Customer> getCustomers() {
        return new ArrayList<>(customerQueue); 
    }
    public Object[][] getCustomerDataForTable() {
        List<Customer> customers = getCustomers();
        Object[][] data = new Object[customers.size()][3];
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            data[i][0] = c.getId();
            data[i][1] = c.getName();
            data[i][2] = c.getEmail();
        }
        return data;
    }
    public Object[][] getParcelDataForTable() {
        List<Parcel> parcels = new ArrayList<>(parcelQueue); 
        Object[][] data = new Object[parcels.size()][4];
        for (int i = 0; i < parcels.size(); i++) {
            Parcel p = parcels.get(i);
            data[i][0] = p.getId();
            data[i][1] = p.getWeight();
            data[i][2] = p.getDestination();
            data[i][3] = p.getCustomerId();
        }
        return data;
    }

}
